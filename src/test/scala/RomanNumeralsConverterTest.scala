import org.scalatest.{FlatSpec, Matchers}

import scala.annotation.tailrec

class RomanNumeralsConverterTest extends FlatSpec with Matchers {
  val specs = Seq(
    1 -> "I",
    2 -> "II",
    3 -> "III",
    4 -> "IV",
    5 -> "V",
    6 -> "VI",
    9 -> "IX",
    10 -> "X",
    16 -> "XVI",
    20 -> "XX",
    40 -> "XL",
    50 -> "L",
    90 -> "XC",
    100 -> "C",
    400 -> "CD",
    500 -> "D",
    900 -> "DM",
    1000 -> "M",
    0 -> "",
    2546 -> "MMDXLVI"
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
    900 -> "DM",
    500 -> "D",
    400 -> "CD",
    100 -> "C",
    90 -> "XC",
    50 -> "L",
    40 -> "XL",
    10 -> "X",
    9 -> "IX",
    5 -> "V",
    4 -> "IV",
    1 -> "I"
  )

  def fromArabic(number: Int): String = fromArabic(number, Rules, "")

  @tailrec
  private def fromArabic(number: Int, rules: Seq[(Int, String)], accu: String): String = rules match {
    case Nil => accu
    case (arabic, roman) :: tail => fromArabic(number % arabic, tail, accu + roman * (number / arabic))
  }
}
