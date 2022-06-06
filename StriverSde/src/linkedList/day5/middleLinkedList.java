package linkedList.day5;

public class middleLinkedList {
    public static ListNode insert(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i=0;i<arr.length;i++){
            dummy.next = new ListNode(arr[i]);
            dummy = dummy.next;
        }
        return head.next;
    }
    public static void main(String[] args){
        int[] arr ={1,2,3,4,5};
        ListNode head = insert(arr);
        ListNode middle = middleF(head);
        printF(middle);
    }

    private static void printF(ListNode middle) {
        while(middle!=null){
            System.out.print(middle.val+"->");
            middle=middle.next;
        }
        System.out.println("null");
        System.out.println();
    }

    private static ListNode middleF(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
