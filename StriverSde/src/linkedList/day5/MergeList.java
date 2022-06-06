package linkedList.day5;

import java.util.List;

public class MergeList {
    public static ListNode insert(int[] arr){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(int i=0;i<arr.length;i++){
            dummy.next = new ListNode(arr[i]);
            dummy=dummy.next;
        }
        return head.next;
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null) return null;
        if(list1!=null && list2==null) return list1;
        if(list1==null && list2!=null) return list2;

        ListNode mergeList = new ListNode(0);
        ListNode mergeListHead = mergeList;
        while(list1!=null && list2!=null){
            if(list1.val>list2.val){
                mergeList.next = list2;
                list2 = list2.next;
            }else{
                mergeList.next = list1;
                list1 = list1.next;
            }
            mergeList= mergeList.next;
        }

        while(list1!=null){
            mergeList.next = list1;
            break;
        }

        while(list2!=null) {
            mergeList.next = list2;
            break;
        }
        return mergeListHead.next;

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
        int[] arrA = {1,2,6,8};
        int[] arrB = {3,6,9,11};

        ListNode headA = insert(arrA);
        ListNode headB = insert(arrB);

        ListNode merge = mergeTwoLists(headA,headB);

        printF(merge);




    }
}
