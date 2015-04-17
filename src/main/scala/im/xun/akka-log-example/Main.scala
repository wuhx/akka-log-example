package im.xun.logging

import akka.actor.{ActorLogging, Actor, ActorSystem, Props}
import akka.event.Logging
import org.slf4j.LoggerFactory

object Main extends App {

  val slfLogger = LoggerFactory.getLogger(getClass)
  slfLogger.debug("slfLogger: Hello world!")
  slfLogger.info("slfLogger: Hello world!")
  val system = ActorSystem("actorSystem")

  val akkaEventLogger = Logging(system.eventStream, "my log!!")
  akkaEventLogger.debug("akkaEventLogger: start actor system!!!!")
  akkaEventLogger.info("akkaEventLogger: start actor system!!!!")
	val master = system.actorOf(Props[MasterActor])
  master ! "hello"
}

class MasterActor extends Actor with ActorLogging{
  def receive = {
    case _ =>
      log.debug("debug log")
    	log.info("info log")
    	log.warning("warning log")
    	log.error("error log")
  }

}

