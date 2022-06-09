package edu.knoldus.multi

import java.util.concurrent.atomic.AtomicInteger
import scala.Console.println



object IncrementCounter extends App {

	private val count = new AtomicInteger(0)


	for (x <- 1 to 2000) {
		val th = new Thread(new Increment())
		th.setName(x.toString)
		th.start()
	}

	class Increment extends Runnable {


		override def run(): Unit = {
			count.incrementAndGet()
			println(s"Thread ${Thread.currentThread().getName} is running. Counter = $count")
		}
	}
}

