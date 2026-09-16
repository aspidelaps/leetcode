class Solution {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> arrayList = new ArrayList<>();
        List<ListNode> nodeList = new ArrayList<>();
        while (head != null) {
            arrayList.add(head.val);
            head = head.next;
        }
        arrayList.stream().distinct().forEach(val -> {
            nodeList.add(new ListNode(val, null));
        });

        for (int i = 0; i < nodeList.size() - 1; i++) {
            ListNode node = nodeList.get(i);
            node.next = nodeList.get(i+1);
        }
        return nodeList.getFirst();
    }
}