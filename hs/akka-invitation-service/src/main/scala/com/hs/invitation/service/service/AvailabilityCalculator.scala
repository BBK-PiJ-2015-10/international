package com.hs.invitation.service.service

import java.time.LocalDate

import com.hs.invitation.service.model.{Country, Partner}

import scala.collection.mutable.{HashMap, Map, TreeMap}
import org.slf4j.LoggerFactory

class AvailabilityCalculator {

  val logger = LoggerFactory.getLogger(getClass.getSimpleName)

  var countriesDatesEMailsMap : Map[String,Map[LocalDate,Seq[String]]] = HashMap.empty[String,Map[LocalDate,Seq[String]]]

  def processAvailability(partner: Partner): Unit = {
    val country = partner.country
    val availableDates = partner.availableDates.map(date => LocalDate.parse(date))
    for (i <- 0 to availableDates.size - 2) {
      val date: LocalDate = availableDates.lift(i).get
      val nextDate = availableDates.lift(i + 1).get
      // Use case that we want to add date
      if (date.plusDays(1).equals(nextDate)) {
        val countryDateEmailMap = countriesDatesEMailsMap.get(country)
        countryDateEmailMap match {
          // country has never been added, but a match exist
          case None =>
            val emails: Seq[String] = Seq(partner.email)
            val newCountryDateEmailMap: Map[LocalDate, Seq[String]] = TreeMap(date -> emails)
            countriesDatesEMailsMap.put(country, newCountryDateEmailMap)
            logger.info(s"Added participant ${partner.email} to newCountry $country on new date $date")
          // country has been added and a match exist
          case Some(existingCountryDateEmailMap) => {
            existingCountryDateEmailMap.get(date) match {
              // country exists, but List for that date does not exist
              case None => {
                val emails: Seq[String] = Seq(partner.email)
                existingCountryDateEmailMap.put(date, emails)
                logger.info(s"Added participant ${partner.email} to existing Country $country on new date $date")
              }
              //country exists, List for that date exist
              case Some(existingEmailListForDate) => {
                val emails : Seq[String] = existingEmailListForDate ++ Seq(partner.email)
                existingCountryDateEmailMap.put(date, emails)
                logger.info(s"Added participant ${partner.email} to existing Country $country on existing date $date")
              }
            }
          }
        }
      }
    }

    countriesDatesEMailsMap.get(country) match {
      case None => {
        val newCountryDateEmailMap: Map[LocalDate, Seq[String]] = TreeMap.empty
        countriesDatesEMailsMap.put(country, newCountryDateEmailMap)
        logger.info(s"Added new empty country ${country}")
      }
      case Some(_) =>
    }

  }


  def processCountries: List[Country] = {
    var countryList = Seq.empty[Country]
    for (country <- countriesDatesEMailsMap.keySet) {
      logger.info(s"Processing country $country")
      val countryName = country
      val dateMapForCountry = countriesDatesEMailsMap.get(country).get
      for (dateEvaluated <- dateMapForCountry.keySet){
        val participantsSize = dateMapForCountry.get(dateEvaluated).get.size
        logger.info(s"For country $countryName on $dateEvaluated there are $participantsSize interested participants")
      }
      val helper1 = dateMapForCountry.keySet.toSeq.sortWith((d1, d2) => dateMapForCountry.get(d1).get.size > dateMapForCountry.get(d2).get.size)
      val maybeSelectedDate= helper1.toList.lift(0)

      maybeSelectedDate match {
        case Some(selectedDate) => {
          val attendeesList: List[String] = dateMapForCountry.get(selectedDate).get.toList
          val attendeeCount = attendeesList.size
          val countryDto = Country(attendeeCount, attendeesList, countryName, selectedDate.toString)
          logger.info(s"Adding country $countryDto")
          countryList = countryList :+ countryDto

        }
        case None => {
          val attendeesList: List[String] = List.empty
          val attendeeCount = 0
          val countryDto = Country(attendeeCount, attendeesList, countryName, null)
          logger.info(s"Adding empty country $countryDto")
          countryList = countryList :+ countryDto
        }
      }
    }
    countryList.toList
  }

}
