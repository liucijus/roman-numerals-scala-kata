import org.scalatest.{FlatSpec, Matchers}

class RomanNumeralsConverterTest extends FlatSpec with Matchers {
  val specs = Seq(
    1 -> "I",
    2 -> "II",
    3 -> "III",
    4 -> "IV",
    5 -> "V",
    6 -> "VI",
    10 -> "X",
    16 -> "XVI",
    20 -> "XX",
    50 -> "L",
    100 -> "C",
    500 -> "D",
    1000 -> "M"
  )

  specs.foreach { case (arabic, roman) =>

    "Roman numerals converter" should s"convert $arabic to $roman" in {
      RomanNumeralsConverter.fromArabic(arabic) shouldBe roman
    }

  }
}

object RomanNumeralsConverter {
  val Rules = Seq(
    1000 -> "M",
    500 -> "D",
    100 -> "C",
    50 -> "L",
    10 -> "X",
    5 -> "V",
    4 -> "IV",
    1 -> "I"
  )

  def fromArabic(number: Int): String = {
    var remainder = number

    Rules.map { case (arabic, roman) =>
      var accu = ""
      while (remainder >= arabic) {
        remainder -= arabic
        accu += roman
      }
      accu
    }.mkString
  }
}
