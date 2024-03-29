package week6

import akka.actor.ActorSystem
import week6.actor.{MovieManager, TestBot}

object Boot extends App {

  val system = ActorSystem("movie-service")

  val movieManager = system.actorOf(MovieManager.props(), "movie-manager")

  val testBot = system.actorOf(TestBot.props(movieManager), "test-bot")



  // test create
  testBot ! TestBot.TestCreate

  // test conflict
  testBot ! TestBot.TestConflictCreate

  // test read
  testBot ! TestBot.TestRead

  //test delete
  testBot ! TestBot.TestDelete

  //test update
  testBot ! TestBot.TestUpdate

}