package stripe


class Processor {

  def process(acceptedLanguages: String, supportedLanguages: List[String]): List[String] = {
    acceptedLanguages.replace(" ", "").split(",").toStream
      .filter(supportedLanguages.contains(_))
      .distinct
      .toList
  }

}
