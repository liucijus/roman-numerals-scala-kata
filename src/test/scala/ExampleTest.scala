import org.scalatest.{FlatSpec, Matchers}

class ExampleTest extends FlatSpec with Matchers {
  "Test example" should "demonstrate simple test with a matcher" in {
    1 shouldBe 1
  }
}
