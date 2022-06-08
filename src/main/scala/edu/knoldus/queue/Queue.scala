package edu.knoldus.queue
class Queue[A] {

    private class Item[A](val value:A) {
	 	var next:Option[Item[A]]= None
		def append(n:Item[A]): Unit = next = Some(n)
	}


	private var head:Option[Item[A]]= None

	private var tail:Option[Item[A]]= None

	def isEmpty: Boolean = head.isEmpty

	def enqueue(item:A): Unit ={
		val elem = new Item(item)
		if(isEmpty) head = Some(elem) else {tail.get.append(elem)}
			tail = Some(elem)
	}


	def dequeue: Option[A] = head match {
		case Some(item) =>
			head = item.next
			Some(item.value)
		case None => None
	}

	def front: Option[A] =head match {
		case Some(item) => Some(item.value)
		case None => None
	}

}

object  QueueMain extends App{
	val q=new Queue[Int]()

	println(s"Queue is empty : ${q.isEmpty} ")


	q.enqueue(1)
	q.enqueue(2)
	q.enqueue(3)
	q.enqueue(4)
	q.enqueue(5)
	q.enqueue(6)

	println(s"Queue :  $q")

	println(s"Front element of Queue : ${q.front} ")


	println(s"Remove element ${q.dequeue} from Queue")
	println(s"Remove element ${q.dequeue} from Queue")

	println(s"Queue :  ${q}")


	println(s"Queue is empty : ${q.isEmpty} ")
}


//class MyQueue[T](maxSize: Int) {
//	private val queue: Array[T] = new Array[T](maxSize)
//	private var front: Int = 0
//	private var rear: Int = -1
//	private var numOfItems: Int = 0
//
//	def insert(data: T): Unit = {
//		if(rear == maxSize - 1) {
//			rear = -1
//		}
//		rear += 1
//		queue(rear) = data
//		numOfItems += 1
//	}
//	def remove: T = {
//		val tempData: T = queue(front)
//		front += 1
//		if(front == maxSize) {
//			front = 0
//		}
//		numOfItems -= 1
//		tempData
//	}
//	def peekFront: T = {
//		queue(front)
//	}
//	def isEmpty: Boolean = {
//		numOfItems == 0
//	}
//	def isFull: Boolean = {
//		numOfItems == maxSize
//	}
//}