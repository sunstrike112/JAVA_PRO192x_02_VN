import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++){
                String s1=sc.next();
                int x=sc.nextInt();
                String x1 = String.format("%03d", x);
                System.out.printf("%-15s",s1);
                System.out.println(x1);
                //Complete this line
            }
            System.out.println("================================");

    }
}