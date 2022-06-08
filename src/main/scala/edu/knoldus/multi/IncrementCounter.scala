package edu.knoldus.multi

import java.util.concurrent.atomic.AtomicInteger

class IncrementCounter() extends Runnable {

	import IncrementCounter._

	override def run(): Unit = {
		count.incrementAndGet()
		println(s"Thread ${Thread.currentThread().getName} is running. Counter = $count")
	}
}

// Creating object
object IncrementCounter {
	// Main method
	private var count = new AtomicInteger(0)

	def main(args: Array[String]) {
		for (x <- 1 to 2000) {
			val th = new Thread(new IncrementCounter())
			th.setName(x.toString)
			th.start()
		}
	}
}
