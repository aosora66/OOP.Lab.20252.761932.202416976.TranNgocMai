import java.util.Arrays;

public class Sort_Calculate{
    public static void main(String args[]){
        int[] arr = {6, 4, 10, 2, 11, 5, 3};
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    int tmp = arr[j];
                    arr[j]=arr[i];
                    arr[i]=tmp;
                }
            }
        }
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        double average=1.0*sum/arr.length;
        System.out.println("Day da sap xep: " + Arrays.toString(arr));
        System.out.println("Tong: "+sum);
        System.out.printf("Gia tri trung binh: %.2f", average);
    }
}