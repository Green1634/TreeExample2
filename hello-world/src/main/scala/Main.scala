
import scala.reflect.runtime.universe.{ reify, showRaw }
import scala.reflect.runtime.universe._

//import scala.tools.nsc
// import nsc.Global
// import nsc.ast.Printers
// import nsc.Phase
// import nsc.plugins.Plugin
// import nsc.plugins.PluginComponent

object Main extends App {
  println("Hello, World!")
  //println( showRaw( reify{5}.tree ) )// prints Literal(Constant(5))
  //println( showRaw( reify{print "Hello World";}.tree ) )// prints Literal(Constant(5))
  val expr = reify{class Flower { def name = "Rose" }}
  val tree = showRaw(expr.tree)

  
  //println(showRaw(tree))
  

  class traverser extends Traverser {

    println (tree)
    var applies = List[Apply]()
    override def traverse (tree: Tree): Unit = tree match {
      case  app @ Apply(fun, args) =>
        applies = app :: applies
        super.traverse(fun)
        super.traverseTrees(args)
        println (tree)
      case _ => super.traverse(tree)
    }
  
  }

  new traverser().traverse(expr.tree)
  
}