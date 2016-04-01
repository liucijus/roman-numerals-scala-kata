import org.scalatest.{FlatSpec, Matchers}

class RomanNumeralsConverterTest extends FlatSpec with Matchers {
  "Roman numerals converter" should "convert 1 number to I" in {
    RomanNumeralsConverter.fromArabic(1) shouldBe "I"
  }
}

object RomanNumeralsConverter {
  def fromArabic(number: Int): String = "I"
}
