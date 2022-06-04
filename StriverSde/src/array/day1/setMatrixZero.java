package array.day1;

import java.util.ArrayList;

//Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}
public class setMatrixZero {
    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){

        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        int rows= matrix.length;
        int cols=matrix[0].length;

        //brute force approach- create a arrayList to save the rows and cols which have matrix value as 0

        ArrayList<Pair> storeValue = new ArrayList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(matrix[i][j]==0){
                    storeValue.add(new Pair(i,j));
                }
            }
        }

        //storing will take time of o(n^2) + space complexity of O(n)

        for(int i=0;i< storeValue.size();i++){
            int row = storeValue.get(i).row;
            int col = storeValue.get(i).col;
            for(int t=0;t<cols;t++) matrix[row][t] = 0;
            for(int j=0;j<rows;j++) matrix[j][col] =0;
        }

        // changing the value will also take O(n^2) + space complexity of O(1)
        //total TC - o(n^2) // SC - O(n)

        //printMatrix(matrix);

        //better solution
        //aproach :-

      int[][]  mat = {{1,1,1},{1,0,1},{1,1,1}};
        int col0 = 1;

        for (int i = 0; i < rows; i++) {
            if (mat[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++)
                if (mat[i][j] == 0)
                    mat[i][0] = mat[0][j] = 0;
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 1; j--)
                if (mat[i][0] == 0 || mat[0][j] == 0)
                    mat[i][j] = 0;
            if (col0 == 0) mat[i][0] = 0;
        }

        printMatrix(mat);
    }
}
