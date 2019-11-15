package factdb

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors
import factdb.ClusterListener.Event

object HelloWorld {

  def apply():  Behavior[String] = Behaviors.setup { ctx =>

    Behaviors.receiveMessage { msg =>
      msg match {
        case msg: String => ctx.log.info(s"${Console.RED_B}received msg ${msg}${Console.RESET}\n")
      }

      Behaviors.same
    }

  }

}
