package array.day4;

import java.util.HashMap;

public class NumberOfSubArrayXORK {
    public static void main(String[] args){
        int[] arr = {4, 2, 2, 6, 4};
        int k=6;
       // System.out.println(bruteFroce(arr,arr.length,k)); //O(n^2)

        System.out.println(betterSol(arr,arr.length,k));
    }

    private static int betterSol(int[] A, int length, int B) {
        HashMap<Integer,Integer> visited = new HashMap<Integer,Integer>();
        int c = 0;
        int cpx = 0;
        int n = A.length;
        for(int i = 0;i<n;i++) {
            cpx = cpx ^ A[i];
            if(visited.get(cpx^B) != null)
                c += visited.get(cpx ^ B);
            if(cpx == B) {
                c++;
            }
            if(visited.get(cpx) != null)
                visited.put(cpx, visited.get(cpx) + 1);
            else
                visited.put(cpx, 1);
        }
        return c;

    }

    private static int bruteFroce(int[] arr, int length,int k) {
        int count=0;

        for(int i=0;i<length;i++){
            int res=0;

            for(int j=i;j<length;j++){
                res = res^arr[j];
                if(res==k) count++;
            }
        }
        return count;
    }


}
