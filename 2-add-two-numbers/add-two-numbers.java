/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursiveTwoNumbers(l1, l2, 0);
    }

    private static ListNode recursiveTwoNumbers(ListNode l1, ListNode l2, int adding) {
        if (l1 == null || l2 == null) {
            if (l1 != null) {
                if (adding != 0) {
                    int summing = (l1.val + adding) % 10;
                    int whole = (l1.val + adding) / 10;
                    return new ListNode(summing, recursiveTwoNumbers(l1.next, null, whole));
                } else return l1;
            } else if (l2 != null) {
                if (adding != 0) {
                    int summing = (l2.val + adding) % 10;
                    int whole = (l2.val + adding) / 10;
                    return new ListNode(summing, recursiveTwoNumbers(null, l2.next, whole));
                } else return l2;
            } else {
                if (adding != 0) {
                    return new ListNode(adding, null);
                } else return null;
            }
        }
        int summing = (l1.val + l2.val + adding) % 10;
        int whole = (l1.val + l2.val + adding) / 10;
        return new ListNode(summing, recursiveTwoNumbers(l1.next, l2.next, whole));
    }
}