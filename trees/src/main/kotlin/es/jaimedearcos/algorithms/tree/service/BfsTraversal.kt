package es.jaimedearcos.algorithms.tree.service

import es.jaimedearcos.algorithms.tree.data.BinaryTreeNode
import java.util.*

class BfsTraversal {

    fun bfs(node: BinaryTreeNode, operation: (BinaryTreeNode) -> Unit){

        val queue = LinkedList<BinaryTreeNode>() as Queue<BinaryTreeNode>
        queue.offer(node)
        var current : BinaryTreeNode

        while(!queue.isEmpty()){
            current = queue.poll()
            operation.invoke(current)

            if (current.left != null){
                queue.offer(current.left)
            }
            if (current.right != null){
                queue.offer(current.right)
            }
        }
    }

}