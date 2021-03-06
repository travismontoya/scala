import scala.reflect.runtime.universe._
import scala.tools.reflect.ToolBox
import scala.tools.reflect.Eval

trait O { trait I }

class A extends O {
  val impl = new I {}
}

object Test extends App {
  val code = reify {
    val v: A#I = (new A).impl
    v
  }
  println(showRaw(code.tree))

  val v: A#I = code.eval
}
