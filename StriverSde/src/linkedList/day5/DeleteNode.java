package linkedList.day5;

public class DeleteNode {
    public static ListNode insert(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i=0;i<arr.length;i++){
            dummy.next = new ListNode(arr[i]);
            dummy=dummy.next;
        }
        return head.next;
    }
    public static void printF(ListNode node){
        while(node!=null){
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.print("null");
        System.out.println("");
    }
    public static void deleteNode(ListNode node) {
        if(node.next == null){
            return;
        }
        ListNode current = node;
        ListNode prev = null;
        while(current.next != null){
            current.val = current.next.val;
            prev = current;
            current = current.next;
        }
        prev.next = null;

    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        ListNode node = new ListNode(arr[2]);

        deleteNode(node);
    }
}
