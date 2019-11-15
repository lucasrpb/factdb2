package factdb

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorSystem
import akka.actor.typed.Behavior
import com.typesafe.config.ConfigFactory

object App {

  object RootBehavior {
    def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
      // Create an actor that handles cluster domain events
      context.spawn(ClusterListener(), "ClusterListener")

      Behaviors.empty
    }
  }

  def startup(port: Int): Unit = {
    // Override the configuration of the port
    val config = ConfigFactory.parseString(s"""
      akka.remote.artery.canonical.port=$port
      """).withFallback(ConfigFactory.load())

    // Create an Akka system
    val system = ActorSystem[Nothing](RootBehavior(), "ClusterSystem", config)

    def main(args: Array[String]): Unit = {
      val ports =
        if (args.isEmpty)
          Seq(2551, 2552, 0)
        else
          args.toSeq.map(_.toInt)
      ports.foreach(startup)
    }
  }

}
