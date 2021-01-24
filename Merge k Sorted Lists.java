class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        for(ListNode head:lists)
        {
            while(head!=null)
            {
                minheap.add(head.val);
                head=head.next;
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!minheap.isEmpty())
        {
            head.next=new ListNode(minheap.remove());
            head=head.next;
        }
        return dummy.next;
    }
}