package com.dpavlovich.codewars.onecompany;

public interface BranchCreator {
    void createNewBranches(NodeBuilder right, NodeBuilder left);

    class Node {
        private final int value;
        private Node left;
        private Node right;

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }

    class NodeBuilder {

        private Node currentNode;

        public NodeBuilder(Node node) {
            this.currentNode = node;
        }

        public static NodeBuilder root(int value, BranchCreator newBranches) {
            Node node = new Node(value);
            NodeBuilder nodeBuilder = new NodeBuilder(node);

            NodeBuilder rightBuilder = new NodeBuilder(null);
            NodeBuilder leftBuilder = new NodeBuilder(null);

            newBranches.createNewBranches(rightBuilder, leftBuilder);

            nodeBuilder.currentNode.right = rightBuilder.currentNode;
            nodeBuilder.currentNode.left = leftBuilder.currentNode;

            return nodeBuilder;
        }

        public void newNode(int value) {
            newNode(value, (right, left) -> {

            });
        }

        public void newNode(int value, BranchCreator newBranches) {
            currentNode = new Node(value);

            NodeBuilder rightBuilder = new NodeBuilder(null);
            NodeBuilder leftBuilder = new NodeBuilder(null);

            newBranches.createNewBranches(rightBuilder, leftBuilder);

            currentNode.right = rightBuilder.currentNode;
            currentNode.left = leftBuilder.currentNode;

        }

        public Node getParent() {
            return currentNode;
        }
    }
}
