import java.util.Scanner;

public class GiaiPhuongTrinh{
    static void PTBacNhat1An (double a, double b) {
        if(a==0) System.out.println("Khong phai phuong trinh bac nhat 1 an do a=0!");
        else {
            System.out.println("Nghiem la: " + -b/a);
        }
    }
    static void PTBacNhat2An (double a11, double a12, double b1, double a21, double a22, double b2) {
        double D = a11*a22 - a21*a12;
        double D1 = b1*a22 - b2*a12;
        double D2 = b2*a11 - b1*a21;
        if(D != 0){
            System.out.println("Nghiem thu nhat: " + D1/D +"\nNghhiem thu hai: " + D2/D);
        }
        else{
            if(D1==0 && D2==0){
                System.out.println("He vo so nghiem!");
            }
            else System.out.println("He vo nghiem!");
        }
    }
    static void PTBacHai1An (double a, double b, double c) {
        if(a==0)  System.out.println("Khong phai phuong trinh bac hai 1 an do a=0!");
        else{
            double d=b*b-4*a*c;
            if(d==0){
                System.out.println("Phuong trinh co nghiem kep: " + -b/(2*a));
            }
            else if(d<0){
                System.out.println("Phuong trinh vo nghiem!");
            }
            else{
                System.out.println("Phuong trinh co 2 nghiem phan biet: " + (-b-Math.sqrt(d))/(2*a) + " va " + (-b+Math.sqrt(d))/(2*a));
            }
        }
    }

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap:\n1.Giai phuong trinh bac nhat 1 an\n2.Giai he phuong trinh bac nhat 2 an\n3.Giai phuong trinh bac hai 1 an");
        int n=sc.nextInt();
        switch(n){
            case 1:
                System.out.print("Nhap he so: ");
                double a=sc.nextDouble(), b=sc.nextDouble();
                PTBacNhat1An(a, b);
                break;
            case 2:
                System.out.print("Nhap he so PT1: ");
                double a11=sc.nextDouble(), a12=sc.nextDouble(), b1=sc.nextDouble();
                System.out.print("Nhap he so PT2: ");
                double a21=sc.nextDouble(), a22=sc.nextDouble(), b2=sc.nextDouble();
                PTBacNhat2An(a11, a12, b1, a21, a22, b2);
                break;
            case 3:
                System.out.print("Nhap he so: ");
                double x=sc.nextDouble(), y= sc.nextDouble(), z=sc.nextDouble();
                PTBacHai1An(x, y, z);
                break;
        }
    }
}
