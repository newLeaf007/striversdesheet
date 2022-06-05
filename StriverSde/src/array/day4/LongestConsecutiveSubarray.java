package array.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;



public class LongestConsecutiveSubarray {

    public static void main(String[] args){
        int[] arr = {100,300,1,2,3,4};

        System.out.println(bruteForce(arr)); //TC-> nlogn + n
        System.out.println(betterApproach(arr)); //TC- O(n)  // sc- O(n)
    }

    private static int betterApproach(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int count=1;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(set.contains(arr[i]-1)){
                count++;
                max = Math.max(count,max);
            }else{
                count=1;
            }
            set.add(arr[i]);
        }
        return max;
    }

    private static int bruteForce(int[] arr) {
        Arrays.sort(arr);
        int count=1;
        int max =0;
        for(int i=1;i<arr.length;i++){
            if(arr[i-1]+1 == arr[i]){
                count++;
                max = Math.max(count,max);
            }else {
                count=1;
            }
        }
        return max;
    }
}
