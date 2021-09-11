package shopify

class PostalValidator {

  val postalCodeMap : Map[String,String] =
    Map(
      "A"->"NL",
      "B"->"NS",
      "C"->"PE",
      "E"->"NB",
      "G"->"QC",
      "H"->"QC",
      "J"->"QC",
      "K"->"ON",
      "L"->"ON",
      "M"->"ON",
      "N"->"ON",
      "P"->"ON",
      "S"->"SK",
      "T"->"AB",
      "V"->"BC",
      "X0A"->"NU",
      "X0B"->"NU",
      "X0C"->"NU",
      "X0E"->"NT",
      "X0G"->"NT",
      "X1A"->"NT",
      "Y"->"YT"
    )

  def is_valid_postal_code(postalCode: String, providenceCode: String) : Boolean = {
    val regex = "[A-Z]"+"[0-9]"+"[A-Z]"+"[\\s]"+"[0-9]"+"[A-Z]"+"[0-9]"
    if (!postalCode.matches(regex)){
      return false
    }
    var key = postalCode.substring(0,1)
    if (key=="X"){
      key = postalCode.substring(0,3)
    }
    postalCodeMap.get(key).map(_==providenceCode).getOrElse(false)
  }


  def providenceForPostalCode(postalCode: String) : Option[String] = {
    val regex = "[A-Z]"+"[0-9]"+"[A-Z]"+"[\\s]"+"[0-9]"+"[A-Z]"+"[0-9]"
    if (!postalCode.matches(regex)){
      return None
    }
    var key = postalCode.substring(0,1)
    if (key=="X"){
      key = postalCode.substring(0,3)
    }
    postalCodeMap.get(key)
  }

  def generic[T](postalCode:String, f: Option[String] => Option[T]) : Option[T] = {
    val regex = "[A-Z]"+"[0-9]"+"[A-Z]"+"[\\s]"+"[0-9]"+"[A-Z]"+"[0-9]"
    if (!postalCode.matches(regex)){
      return None
    }
    var key = postalCode.substring(0,1)
    if (key=="X"){
      key = postalCode.substring(0,3)
    }
    f.apply(postalCodeMap.get(key))
  }


}
