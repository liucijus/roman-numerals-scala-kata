import org.scalatest.{FlatSpec, Matchers}

class RomanNumeralsConverterTest extends FlatSpec with Matchers {
  val specs = Seq(
    1 -> "I",
    2 -> "II",
    3 -> "III",
    5 -> "V",
    6 -> "VI",
    10 -> "X",
    16 -> "XVI",
    20 -> "XX"
  )

  specs.foreach { case (arabic, roman) =>

    "Roman numerals converter" should s"convert $arabic to $roman" in {
      RomanNumeralsConverter.fromArabic(arabic) shouldBe roman
    }

  }
}

object RomanNumeralsConverter {
  val Rules = Seq(
    10 -> "X",
    5 -> "V"
  )
  def fromArabic(number: Int): String = {
    var remainder = number
    var accu = ""

    Rules.foreach { case (arabic, roman) =>
      while (remainder >= arabic) {
        remainder -= arabic
        accu += roman
      }
    }

    accu += "I" * remainder

    accu
  }
}
