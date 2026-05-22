import java.util.Arrays;
import java.util.Scanner;

public class AddMatrix{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Nhap kich thuoc m x n: ");
        int m=sc.nextInt(), n=sc.nextInt();
        int[][] arr1=new int[m][n];
        int[][] arr2=new int[m][n];
        int[][] arrSum=new int[m][n];
        System.out.println("Nhap ma tran 1:");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) arr1[i][j]=sc.nextInt();
        }
        System.out.println("Nhap ma tran 2:");
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) arr2[i][j]=sc.nextInt();
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) arrSum[i][j]=arr1[i][j]+arr2[i][j];
        }
        System.out.println("Tong 2 ma tran:");
        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(arrSum[i]));
        }
    }
}