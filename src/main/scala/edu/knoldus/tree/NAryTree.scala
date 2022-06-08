package edu.knoldus.tree

case class Tree(data: Int, children: Option[List[Tree]])



class NAryTreeCount {
	def countNodes(tree: Tree): Int = {
		tree.children match {
			case Some(child) => child.foldLeft(1)((x, y) => x + countNodes(y))
			case None => 1
		}
	}

	def countNodes2(tree: Tree): Int = {
		def countNodesWithChildrenGreaterThanTwo(tree: Tree): Option[Int] = {
			if (tree.children.getOrElse(List.empty[Int]).size > 2) {
				tree.children.map { child =>
					child.foldLeft(1)((x, y) => x + countNodesWithChildrenGreaterThanTwo(y).getOrElse(0))
				}
			}
			else {
				tree.children map { child =>
					child.foldLeft(0)((x, y) => x + countNodesWithChildrenGreaterThanTwo(y).getOrElse(0))
				}
			}
		}

		val count = countNodesWithChildrenGreaterThanTwo(tree)
		count.getOrElse(0)
	}
}


object TreeMain extends App {
	val tree = new NAryTreeCount()
	val treeThree = Tree(1, Some(List(Tree(2, Some(List(Tree(5, None), Tree(6, None), Tree(7, None)))), Tree(3, Some(List(Tree(8, None)))),
		Tree(4, Some(List(Tree(9, None), Tree(10, None), Tree(11, None)))))))

	println(tree.countNodes2(treeThree))
	println(tree.countNodes(treeThree))
}

