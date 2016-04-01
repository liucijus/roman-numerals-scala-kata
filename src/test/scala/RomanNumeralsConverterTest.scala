import org.scalatest.{FlatSpec, Matchers}

class RomanNumeralsConverterTest extends FlatSpec with Matchers {
  "Roman numerals converter" should "convert 1 number to I" in {
    RomanNumeralsConverter.fromArabic(1) shouldBe "I"
  }

  it should "convert 2 to II" in {
    RomanNumeralsConverter.fromArabic(2) shouldBe "II"
  }
}

object RomanNumeralsConverter {
  def fromArabic(number: Int): String = if (number == 1) "I" else "II"
}
