import org.scalatest.{FlatSpec, Matchers}

class RomanNumeralsConverterTest extends FlatSpec with Matchers {
  val specs = Seq(
    1 -> "I",
    2 -> "II",
    3 -> "III",
    5 -> "V",
    6 -> "VI",
    10 -> "X"
  )

  specs.foreach { case (arabic, roman) =>

    "Roman numerals converter" should s"convert $arabic to $roman" in {
      RomanNumeralsConverter.fromArabic(arabic) shouldBe roman
    }

  }
}

object RomanNumeralsConverter {
  def fromArabic(number: Int): String = {
    var remainder = number
    var accu = ""

    if (remainder == 10) {
      remainder -= 10
      accu += "X"
    }

    if (remainder >= 5) {
      remainder -= 5
      accu += "V"
    }

    accu += "I" * remainder

    accu
  }
}
