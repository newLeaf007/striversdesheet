package linkedList.day5;

public class RemoveEndNthDelete {
    public static ListNode insert(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i=0;i<arr.length;i++){
            dummy.next = new ListNode(arr[i]);
            dummy = dummy.next;
        }
        return head.next;
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode();
        start.next = head;
        ListNode fast = start;
        ListNode slow = start;

        for(int i = 1; i <= n; ++i)
            fast = fast.next;

        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return start.next;


    }
    public static void printF(ListNode node){
        while(node!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int k = 2;
        ListNode head = insert(arr);
        ListNode ans = removeNthFromEnd(head,k);
        printF(ans);
    }
}
