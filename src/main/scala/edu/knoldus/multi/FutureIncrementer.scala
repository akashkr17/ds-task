package edu.knoldus.multi

import java.util.concurrent.Executors
import scala.concurrent.{Await, ExecutionContext, ExecutionContextExecutor, Future}
import scala.concurrent.duration.DurationInt

object FutureIncrementer extends App {
var count = 0
	implicit val ec: ExecutionContextExecutor = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(2000))
	val tasks: Seq[Future[Unit]] = for (i <- 1 to 2000) yield Future {
		synchronized {
			count += 1
			println(s"Thread ${Thread.currentThread().getName} is running. Counter = $count")
		}
	}
	println(s"Counter = $count")
}
