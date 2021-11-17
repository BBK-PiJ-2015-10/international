package com.hs.partnerservice.model

case class Partner(firstName: String, lastName: String, email: String, country: String, availableDates: List[String])
