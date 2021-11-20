import org.scalatest.funsuite.AnyFunSuite

import scala.collection.View.Empty
//import org.s

class TestHelper extends AnyFunSuite {

  test("An empty List should have size 0") {

    var mySeq : Seq[String] = Seq.empty
    mySeq = mySeq :+ "ale"

    println(mySeq.size)
    assert(List.empty.size == 0)
  }




}
