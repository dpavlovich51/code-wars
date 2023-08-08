package com.dpavlovich.codewars;

import java.util.Optional;

public class ProblemList {

    public static class ListNode {
        @Override
        public String toString() {
            return buildString(new StringBuilder(), this)
                    .toString();
        }

        private static StringBuilder buildString(StringBuilder string, ListNode node) {
            if (node != null) {
                string.append(node.val);
                buildString(string, node.next);
            }
            return string;
        }

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
        final ListNode result = createNode(l1, l2);

        ListNode resultNext = result;

        ListNode list1 = l1.next;
        ListNode list2 = l2.next;

        while (list1 != null || list2 != null) {
            if (resultNext.next == null) {
                resultNext.next = new ListNode(0);
            }
            resultNext = resultNext.next;

            mergeWith(resultNext, list1);
            mergeWith(resultNext, list2);

            list1 = Optional.ofNullable(list1).map(it -> it.next).orElse(null);
            list2 = Optional.ofNullable(list2).map(it -> it.next).orElse(null);
        }
        return result;
    }

    private static void mergeWith(ListNode main, ListNode addNode) {
        if (addNode != null) {
            ListNode node = createNode(main, addNode);

            if (main.next != null) {
                main.val = node.val;

                if (node.next != null) {
                    main.next.val += node.next.val;
                }
            } else {
                main.val = node.val;
                main.next = node.next;
            }
        }
    }

    private static ListNode createNode(ListNode l1, ListNode l2) {
        int firstVal = l1 == null ? 0 : l1.val;
        int secondVal = l2 == null ? 0 : l2.val;

        int sum = firstVal + secondVal;
        if (sum > 9) {
            ListNode listNode = new ListNode(sum % 10);
            listNode.next = new ListNode(sum / 10);
            return listNode;
        } else {
            return new ListNode(sum);
        }
    }

    static public void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);

        System.out.println(l1);
        System.out.println(l2);

        ListNode listNode = addTwoNumbers(l1, l2);

        System.out.println(listNode);
    }
}
