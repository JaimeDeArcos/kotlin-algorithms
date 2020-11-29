package es.jaimedearcos.algorithms.tree.service

import es.jaimedearcos.algorithms.tree.data.BinaryTreeNode
import kotlin.test.assertEquals
import org.junit.Test
import java.util.*
import kotlin.test.assertFalse

class BfsTraversalTest {

    private val classUnderTest = BfsTraversal()
    private val bfsExpectedResult = arrayOf(10,7,11,6,8,20,1,9,14,22)

    @Test
    fun testBfs() {

        println("BFS Traversal Test...")

        // Given :
        val tree = getBinarySearchTree()
        val linkedList = LinkedList<Int>()

        // When :
        classUnderTest.bfs(tree) { linkedList.add(it.data) }

        // Then:
        println("Expected: $bfsExpectedResult")
        println("Result:   $linkedList")
        assertEquals(linkedList.size, bfsExpectedResult.size)

        val areNotEqual = linkedList.asSequence()
                .zip(bfsExpectedResult.asSequence())
                .map { (fromThis, fromOther) ->  fromThis == fromOther }
                .contains(false)
        assertFalse(areNotEqual)
    }

    private fun getBinarySearchTree() : BinaryTreeNode {
        val node10 = BinaryTreeNode(22)
        val node9 = BinaryTreeNode(14)
        val node8 = BinaryTreeNode(20,node9,node10)
        val node7 = BinaryTreeNode(9)
        val node6 = BinaryTreeNode(1)
        val node5 = BinaryTreeNode(8, null, node7)
        val node4 = BinaryTreeNode(6, node6)
        val node3 = BinaryTreeNode(11, null, node8)
        val node2 = BinaryTreeNode(7,node4, node5)

        return BinaryTreeNode(10, node2, node3)
    }
}
