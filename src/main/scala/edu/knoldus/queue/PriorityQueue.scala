package edu.knoldus.queue

import scala.collection.mutable.ArrayBuffer

import scala.util.control._



object PriorityQueue { // Driver code
	def main(args: Array[String]): Unit = {
		val arr = ArrayBuffer[Int]()
		val s = arr.length
		val h = new Main(arr)
		h.insert( 1)
		h.insert(4)
		h.insert(2)
		h.insert(7)
		h.insert( 8)
		h.insert(5)
		h.insert(6)
		println("Max-Heap array: ")
		h.printArray()

		println("After deletion: ")

		h.printArray()
	}
}

class Main(arr: ArrayBuffer[Int]) {
	val loop = new Breaks

	def heapify(x: Int): Unit = {
		val s = arr.length
		// Find the largest among root, left child and right child
		var max = x
		val left = 2 * x + 1
		val right = 2 * x + 2
		if (left < s && arr(left) > arr(max)) max = left
		if (right < s && arr(right) > arr(max)) max = right
		// If root is not largest, swap and continue heapifying
		if (max != x) {
			val temp = arr(max)
			arr.update(max, arr(x))
			arr.update(x, temp)
			heapify( max)
		}
	}

	// To insert an element
	def insert(newN: Int): Unit = {
		val s = arr.length
		if (s == 0) {

arr += newN
		}
		else {

			arr += newN

			for (i <- s / 2 - 1 to 0 by -1) {
				heapify(i)
			}
		}
	}


	// To print the tree
	def printArray(): Unit = {

		arr.foreach(println)
	}
}


