package com.dpavlovich.codewars.codewars.onecompany;


import com.dpavlovich.codewars.codewars.onecompany.BranchCreator.Node;
import com.dpavlovich.codewars.codewars.onecompany.BranchCreator.NodeBuilder;

import java.util.ArrayList;
import java.util.Collection;

public class FindAllSumsInTreeAndCollectThemTask {

    public static void main(String[] args) {
        Node root = NodeBuilder.root(1, (right, left) -> {
                    right.newNode(2, (right1, left1) -> {
                        right1.newNode(2, (right2, left2) -> {
                            right2.newNode(5);
                        });
                        left1.newNode(4);
                    });

                    left.newNode(3);

                })
                .getParent();

        show(root);

        int sum = 0;
        Collection<Integer> sums = new ArrayList<>();
        calculateSum(root, sum, sums);
        System.out.println(sums);
    }

    private static void calculateSum(Node node, int sum, Collection<Integer> sums) {
        if (node == null) return;
        sum += node.getValue();
        if (isLeaf(node)) {
            sums.add(sum);
        }
        if (node.getLeft() != null) {
            calculateSum(node.getLeft(), sum, sums);
        }
        if (node.getRight() != null) {
            calculateSum(node.getRight(), sum, sums);
        }
    }

    private static boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private static void show(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getValue());

        Node right = node.getRight();
        Node left = node.getLeft();

        if (right != null) {
            show(right);
        }
        if (left != null) {
            show(left);
        }
    }

}
