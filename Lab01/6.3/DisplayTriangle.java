import java.util.Scanner;
public class DisplayTriangle {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("h = ");
        int h=sc.nextInt();
        if(h<0) System.out.println("Invalid Input");
        else{
            for (int i = 0; i < h; i++) {
                for(int j=1; j<h-i; j++) System.out.print(" ");
                for(int j=1; j<=1+2*i; j++) System.out.print("*");
                System.out.println(" ");
            }
        }
    }
}

