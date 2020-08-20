// package com.example

// import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
// import com.example.Greeter.Greet
// import com.example.Greeter.Greeted
// import org.scalatest.wordspec.AnyWordSpecLike

//#definition
// class AkkaQuickstartSpec extends ScalaTestWithActorTestKit with AnyWordSpecLike {
// //#definition

//   "A Greeter" must {
//     //#test
//     "reply to greeted" in {
//       val replyProbe = createTestProbe[Greeted]()
//       val underTest = spawn(Greeter())
//       underTest ! Greet("Santa", replyProbe.ref)
//       replyProbe.expectMessage(Greeted("Santa", underTest.ref))
//     }
//     //#test
//   }

// }



def lazy_method(n: => Int) {
  println("lazy method")
  println(n)
}

// def eager_method(n: Int) {
//   println("eager method")
//   println(n)
// }

