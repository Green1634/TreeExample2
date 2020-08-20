
import scala.reflect.runtime.universe.{ reify, showRaw }
import scala.reflect.runtime.universe._
import scala.io.Source._
import java.nio.file.Paths
import scala.reflect.runtime.currentMirror
import scala.tools.reflect.ToolBox

import scala.tools.nsc.{Global, Settings}
import scala.tools.nsc.reporters.ConsoleReporter



object Main extends App {
  

  val tb = runtimeMirror(this.getClass.getClassLoader).mkToolBox()

  val sourceCode = scala.io.Source.fromFile("../test.scala").mkString

  val myTree = tb.parse(sourceCode)

  var rawTree = showRaw(myTree)

  println(myTree) //printing original tree
  println(rawTree)  //printing raw tree

  

//   //Eval[Unit]("println(\"Hi\")")

//   //println(lines)
//   //println(Paths.get(".").toAbsolutePath)
//   val expr = reify{toolbox.eval(toolbox.parse(lines))}

//   val expr2 = reify{object Test {
//   def main(args: Array[String]): Unit = {
//     println("Hello World!");
//   }
// }}

//   //print(expr.getClass)
//   val tree = showRaw(expr.tree)
//   val tree2 = showRaw(expr2.tree)

//   // println(tree)
//   // println(tree2)
//   val program = """object Main extends App { print("Hello!") }"""
//   val tree1 = program.parse[Source].get  

  
//   //println(showRaw(tree))
  

  class traverser extends Traverser {

    //Sprintln (tree)
    //var applies = List[Apply]()
    override def traverse (tree: Tree): Unit = 
      tree match {
            
            
            case AppliedTypeTree(tq"$tpt",List(tq"$tpe")) => {
              println("AppliedTypeTree")
              super.traverse(tree)
//AppliedTypeTree(Select(Select(Ident(termNames.ROOTPKG), scala), TypeName("<byname>")), List(Ident(TypeName("Int"))))
              
            }
            
            case trt: TermTree => {
              println("TermTree")
              super.traverse(tree)
            }
            case smt: SymTree => {
              println("SymTree")
              super.traverse(tree)
            }
            // case s: Star => {
            //   println("Star")
            //   super.traverse(tree)
            // }
            
    
    }
  }

  new traverser().traverse(myTree)
  
}


// object ApplyExample01 extends App {

//   class Greeter1(var message: String) {
//     println("A greeter-1 is being instantiated with message " + message)

//   }

//   class Greeter2 {

//     def apply(message: String) = {
//       println("A greeter-2 is being instantiated with message " + message)
//     }
//   }

//   val g1: Greeter1 = new Greeter1("hello")
//   val g2: Greeter2 = new Greeter2()

//   g2("world")

// }