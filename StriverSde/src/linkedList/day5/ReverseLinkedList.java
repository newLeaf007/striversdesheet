package linkedList.day5;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){this.val = val;}
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }
}

public class ReverseLinkedList {
    public static ListNode insert(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i=0;i<arr.length;i++){
            ListNode temp = new ListNode(arr[i]);
            dummy.next = temp;
            dummy = dummy.next;
        }
        return head.next;

    }
    public static void PrintLinkedList(ListNode head){
        ListNode current = head;
        while(current!=null){
            System.out.print(current.val+"->");
            current=current.next;
        }
        System.out.print("null");
        System.out.println("");
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        ListNode head = insert(arr);
        ListNode rehead = reverseList(head);
       PrintLinkedList(rehead);
    }



    private static ListNode reverseList(ListNode head) {
        ListNode prev=null;
        ListNode next = null;
        ListNode current = head;

        while(current!=null){
            next = current.next;
            current.next = prev;
            prev=current;
            current = next;
        }
        head = prev;
        return head;
    }
}
