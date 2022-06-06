package linkedList.day5;

public class AddTwoNumber {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;
        while( l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            temp.next = node;
            temp = temp.next;
        }
        return dummy.next;
    }
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
    public static void main(String[] args){
        int[] arrA = {1,2,3};
        int[] arrB = {1,2,0};

        ListNode l1 = insert(arrA);
        ListNode l2 = insert(arrB);

        ListNode ans = addTwoNumbers(l1,l2);
        printF(ans);

    }
}
