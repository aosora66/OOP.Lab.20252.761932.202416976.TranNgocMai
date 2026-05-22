import java.util.Scanner;
public class DisplayDay{
    static int ChangeMonth(String month){
        if(month.equals("January")||month.equals("Jan.")||month.equals("Jan")||month.equals("1")) return 1;
        if(month.equals("February")||month.equals("Feb.")||month.equals("Feb")||month.equals("2")) return 2;
        if(month.equals("March")||month.equals("Mar.")||month.equals("Mar")||month.equals("3")) return 3;
        if(month.equals("April")||month.equals("Apr.")||month.equals("Apr")||month.equals("4")) return 4;
        if(month.equals("May")||month.equals("5")) return 5;
        if(month.equals("June")||month.equals("Jun")||month.equals("6")) return 6;
        if(month.equals("July")||month.equals("Jul")||month.equals("7")) return 7;
        if(month.equals("August")||month.equals("Aug")||month.equals("Aug.")||month.equals("8")) return 8;
        if(month.equals("September")||month.equals("Sept.")||month.equals("Sep")||month.equals("9")) return 9;
        if(month.equals("October")||month.equals("Oct.")||month.equals("Oct")||month.equals("10")) return 10;
        if(month.equals("November")||month.equals("Nov.")||month.equals("Nov")||month.equals("11")) return 11;
        if(month.equals("December")||month.equals("Dec.")||month.equals("Dec")||month.equals("12")) return 12;
        return 0;
    }
    static int NhapThang(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Nhap thang: ");
            String month = sc.nextLine();
            int month2 = ChangeMonth(month);
            if(month2==0) System.out.println("Nhap thang khong hop le, nhap lai!");
            else return month2;
        }
    }
    static int NhapNam(){
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("Nhap nam: ");
            int year = sc.nextInt();
            if(year < 0) System.out.println("Nhap nam khong hop le, nhap lai!");
            else return year;
        }
    }

    public static void main(String args[]){
        int month = NhapThang();
        int year = NhapNam();
        if((month<=7 && month%2!=0) || (month>7 && month%2==0)) System.out.println("So ngay trong thang "+month+" cua nam "+year+" la 31.");
        else if(month==2){
            if(year%4!=0 || (year%100==0 && year%400!=0)){System.out.println("So ngay trong thang 2 cua nam "+year+" la 28.");}
            else System.out.println("So ngay trong thang 2 cua nam "+year+" la 29.");
        }
        else System.out.println("So ngay trong thang "+month+" cua nam "+year+" la 30.");
    }
}