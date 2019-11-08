package factdb

import akka.actor.typed.ActorSystem
import org.scalatest.FlatSpec

class MainSpec extends FlatSpec {

  "sum of money " should "be the same" in {

    val system: ActorSystem[HelloWorldMain.Start] =
      ActorSystem(HelloWorldMain(), "hello")

    system ! HelloWorldMain.Start("World")

  }

}
