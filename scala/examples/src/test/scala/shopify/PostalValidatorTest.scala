package shopify

import org.scalatest._
import org.scalatest.flatspec._
import org.scalatest.matchers.should.Matchers

class PostalValidatorTest extends AnyFlatSpec with Matchers {

  val postalValidator : PostalValidator= new PostalValidator

  "A validator" should "test 1" in {

    val postalCode = "B0P 1X0"
    val providenceCode = "NS"

    val result = postalValidator.is_valid_postal_code(postalCode, providenceCode)

    result should be (true)

  }

  "A validator" should "test 2" in {

    val postalCode = "b0P 1x0"
    val providenceCode = "NS"

    val result = postalValidator.is_valid_postal_code(postalCode, providenceCode)

    result should be (false)

  }

  "A validator" should "test 3" in {

    val postalCode = "M5W 1E6"
    val providenceCode = "QC"

    val result = postalValidator.is_valid_postal_code(postalCode, providenceCode)

    result should be (false)

  }

  "A validator" should "test 4" in {

    val postalCode = "X0A 0H0"
    val providenceCode = "NU"

    val result = postalValidator.is_valid_postal_code(postalCode, providenceCode)

    result should be (true)

  }

  "A validator" should "test 5" in {

    val postalCode = "V0F G5A"
    val providenceCode = "BC"

    val result = postalValidator.is_valid_postal_code(postalCode, providenceCode)

    result should be (false)

  }

  "A validator" should "test 6" in {

    val postalCode = "X0A0H0"
    val providenceCode = "NU"

    val result = postalValidator.is_valid_postal_code(postalCode, providenceCode)

    result should be (false)

  }

}
