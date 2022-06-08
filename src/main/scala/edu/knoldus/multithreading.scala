package edu.knoldus

object SimpleThreads { // Display a message, preceded by
	// the name of the current thread
	def threadMessage(message: String): Unit = {
		val threadName = Thread.currentThread.getName
		System.out.format("%s: %s%n", threadName, message)
	}

	private class MessageLoop extends Runnable {
		override def run(): Unit = {
			val importantInfo = Array("Mares eat oats", "Does eat oats", "Little lambs eat ivy", "A kid will eat ivy too")
			try for (i <- importantInfo.indices) { // Pause for 4 seconds
				Thread.sleep(4000)
				// Print a message
				threadMessage(importantInfo(i))
			}
			catch {
				case e: InterruptedException =>
					threadMessage("I wasn't done!")
			}
		}
	}

	@throws[InterruptedException]
	def main(args: Array[String]): Unit = { // Delay, in milliseconds before
		// we interrupt MessageLoop
		// thread (default one hour).
		var patience = 1000 * 60 * 60
		// If command line argument
		// present, gives patience
		// in seconds.
		if (args.length > 0) try patience = args(0).toInt * 1000
		catch {
			case e: NumberFormatException =>
				System.err.println("Argument must be an integer.")
				System.exit(1)
		}
		threadMessage("Starting MessageLoop thread")
		val startTime = System.currentTimeMillis
		val t = new Thread(new SimpleThreads.MessageLoop)
		t.start()
		threadMessage("Waiting for MessageLoop thread to finish")
		// loop until MessageLoop
		// thread exits
		while ( {
			t.isAlive
		}) {
			threadMessage("Still waiting...")
			// Wait maximum of 1 second
			// for MessageLoop thread
			// to finish.
			t.join(1000)
			if (((System.currentTimeMillis - startTime) > patience) && t.isAlive) {
				threadMessage("Tired of waiting!")
				t.interrupt()
				// Shouldn't be long now
				// -- wait indefinitely
				t.join()
			}
		}
		threadMessage("Finally!")
	}
}
