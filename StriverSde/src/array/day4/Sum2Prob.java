package array.day4;

import java.util.Arrays;
import java.util.HashSet;

public class Sum2Prob {

    public static void main(String[] args){
        int[] arr = {2,7,11,5};
        int target =9;

        System.out.println(naiveSol(arr,target)); //O(n^2)
        System.out.println(betterApproach(arr,target)); //nlogn + n
        System.out.println(bestApproach(arr,target));
    }

    private static boolean bestApproach(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
            int temp = target-arr[i];
            if(set.contains(temp)) return true;
        }
        return false;
    }

    private static boolean betterApproach(int[] arr, int target) {
        Arrays.sort(arr);
        int start=0;
        int end = arr.length-1;
        while(end>start){
            if(arr[start]+arr[end]>target){
                end--;
            }else if(arr[start]+arr[end]<target){
                start++;
            }else{
                return true;
            }
        }
        return false;
    }

    private static boolean naiveSol(int[] arr, int target) {
        for(int i=0;i<arr.length;i++){
            int temp = target-arr[i];
            for(int j=i+1;j< arr.length;j++){
                if(temp-arr[j]==0) return true;
            }
        }
        return false;
    }
}
