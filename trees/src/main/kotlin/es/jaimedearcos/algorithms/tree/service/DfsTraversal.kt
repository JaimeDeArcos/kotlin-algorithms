package es.jaimedearcos.algorithms.tree.service

import es.jaimedearcos.algorithms.tree.data.BinaryTreeNode

class DfsTraversal {

    fun preOrder(node: BinaryTreeNode?,
                 operation: (BinaryTreeNode) -> Unit){
        if (node == null) return;
        // Visit node
        operation.invoke(node)
        // Traverse left
        preOrder(node.left,operation);
        // Traverse right
        preOrder(node.right,operation);
    }

    fun inOrder(node: BinaryTreeNode?,
                operation: (BinaryTreeNode) -> Unit){
        if (node == null) return;
        // Traverse left
        inOrder(node.left,operation);
        // Visit node
        operation.invoke(node)
        // Traverse right
        inOrder(node.right,operation);
    }

    fun postOrder(node: BinaryTreeNode?,
                  operation: (BinaryTreeNode) -> Unit){
        if (node == null) return;
        // Traverse left
        postOrder(node.left,operation)
        // Traverse right
        postOrder(node.right,operation)
        // Visit node
        operation.invoke(node)
    }
}