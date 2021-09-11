package stripe

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers


class  ProcessorTest extends AnyFlatSpec with Matchers {

  val processor = new Processor

  "A processor" should "test 1" in {

    val acceptedLanguages = "en-US, fr-CA, fr-FR"
    val supportedLanguages = List("fr-FR","en-US")

    val result = processor.process(acceptedLanguages, supportedLanguages)

    result.size should be (2)
    result(0) should be ("en-US")
    result(1) should be ("fr-FR")

  }

  "A processor" should "test 2" in {

    val acceptedLanguages = "en-US, fr-CA, fr-FR,fr-CA"
    val supportedLanguages = List("fr-CA","en-US")

    val result = processor.process(acceptedLanguages, supportedLanguages)

    result.size should be (2)
    result(0) should be ("en-US")
    result(1) should be ("fr-CA")

  }


  "A processor" should "test 3" in {

    val acceptedLanguages = "     "
    val supportedLanguages = List("fr-CA","en-US")

    val result = processor.process(acceptedLanguages, supportedLanguages)

    result.size should be (0)

  }


  "A processor" should "test 4" in {

    val acceptedLanguages = "en-US, fr-CA, fr-FR"
    val supportedLanguages = List()

    val result = processor.process(acceptedLanguages, supportedLanguages)

    result.size should be (0)

  }

}
