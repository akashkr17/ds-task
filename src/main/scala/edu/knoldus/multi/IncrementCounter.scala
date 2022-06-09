package edu.knoldus.multi

import java.util.concurrent.atomic.AtomicInteger


object IncrementCounter extends App {

	private var count = 0

	for (x <- 1 to 2000) {
		val th = new Thread(new Increment())
		th.setName(x.toString)
		th.start()
		th.join()
	}

	class Increment extends Runnable {

		override def run(): Unit = {
			synchronized {
				count += 1
				println(s"Thread ${Thread.currentThread().getName} is running. Counter = $count")
			}

		}
	}
}


