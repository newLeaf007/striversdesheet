package array.day4;

import java.util.HashMap;

public class LongestSubArrayWithZeroSum {
    public static void main(String[] args){
        int[] arr = {9, -3, 3, -1, 6, -5};

        System.out.println(bruteForce(arr,arr.length)); //o(n^2)
        System.out.println(betterApproach(arr,arr.length)); //Tc-> O(n) // sc->O(n)
    }

    private static int betterApproach(int[] A, int n) {
        HashMap<Integer, Integer> mpp = new HashMap<Integer, Integer>();

        int maxi = 0;
        int sum = 0;

        for(int i = 0;i<n;i++) {

            sum += A[i];

            if(sum == 0) {
                maxi = i + 1;
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    private static int bruteForce(int[] arr, int length) {
        int max=0;
        for(int i=0;i<length;i++){
            int sum = arr[i];
            for(int j=i+1;j<length;j++){
                sum = sum+arr[j];
                if(sum==0){
                    max = Math.max(max,j-i+1);
                }
            }
        }
        return max;
    }
}
