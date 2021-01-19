/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradanator;
  
import java.util.Scanner;
/**
 *
 * @author HP
 */
public class ASM2 {
    
    public static int weightMidterm, weightFinal, weightHomework;
    
    
    //Hàm in ra tổng điểm
    private static void printScore(int score, int max, int weight, double weightedScore) {      
      System.out.println("Total points = " + score + " / " + max);
      System.out.printf("Weighted score = %.1f / " + weight + "\n", weightedScore);
   }
   
    //Hàm hiển thị kết quá tổng hợp và thông báo
   private static void printOverallScore(double overallPercentage) {
      System.out.printf("Overall percentage = %.1f\n", overallPercentage);
      System.out.print("Your grade will be at least: ");
      if (overallPercentage >= 85) {
         System.out.println("3.0");
         System.out.println("Amazing ! Good job guy ");
      } else if (overallPercentage >= 75) {
         System.out.println("2.0");
         System.out.println("It's OK, but i think you can do it better");
      } else if (overallPercentage >= 60) {
         System.out.println("0.7");
         System.out.println("Please try hard more and more");
      } else {
         System.out.println("0.0");
         System.out.println("Where are you now ? Are you studying ?");
      }  
   }

   //Hàm nhập điểm giữa kỳ 
   private static double getMidtermScore(Scanner console) {
      double weightedMidtermScore;
      System.out.println("Midterm :");
      boolean checkWeight = true;
      do {        
        System.out.print("Weight (0-100)? ");
        weightMidterm = console.nextInt();
        //Bảo đảm tổng trọng số điểm nhỏ hơn 100
        if (checkWeight(weightMidterm, weightFinal, weightHomework) == false){
            System.out.println("The total weight is larger than 100");
        }
        else {
            checkWeight = false;
        }
      }while (checkWeight);
      System.out.print("Score earned? ");
      int score = console.nextInt();
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      int shifted = console.nextInt();
      if (shifted == 1) {
         System.out.print("Shift amount? ");
         int shiftAmount = console.nextInt();
         score = Math.min(score + shiftAmount, 100);
      } 
      weightedMidtermScore = weightMidterm * (score/100.0);
      printScore(score, 100, weightMidterm, weightedMidtermScore);
      
      return weightedMidtermScore;
   }
   
       //Hàm nhập điểm cuối kỳ
   private static double getFinalScore(Scanner console) {
      double weightedFinalScore;
      System.out.println("Final :");
      boolean checkWeight = true;
      while (checkWeight){
        System.out.print("Weight (0-100)? ");
        weightFinal = console.nextInt();
        //Bảo đảm tổng trọng số điểm nhỏ hơn 100
        if (checkWeight(weightMidterm, weightFinal, weightHomework) == false){
            System.out.println("The total weight is larger than 100");
        }
        else {
            checkWeight = false;
        }
      }
      System.out.print("Score earned? ");
      int score = console.nextInt();
      System.out.print("Were scores shifted (1=yes, 2=no)? ");
      int shifted = console.nextInt();
      if (shifted == 1) {
         System.out.print("Shift amount? ");
         int shiftAmount = console.nextInt();
         score = Math.min(score + shiftAmount, 100);
      } 
      weightedFinalScore = weightFinal * (score/100.0);
      printScore(score, 100, weightFinal, weightedFinalScore);
      
      return weightedFinalScore;
   }
   
   //Hàm nhập điểm bài tập về nhà và điểm danh
   private static double getHomeworkScore(Scanner console) {
      double homeworkWeightedScore;
      System.out.println("Homework:");
      boolean checkWeight = true;
      while (checkWeight){
        System.out.print("Weight (0-100)? ");
        weightHomework = console.nextInt();
        //Bảo đảm tổng trọng số điểm bằng chính xác 100
        if ((weightMidterm + weightFinal + weightHomework) != 100){
            System.out.println("The total weight must be equal 100");
        }
        else {
            checkWeight = false;
        }
      }
      System.out.print("Number of assignments? ");
      int assignments = console.nextInt();
      int score = 0;
      int max = 0;
      for (int i = 1; i <= assignments; i++) {
         System.out.print("Assignment " + i + " score and max? ");
         score += console.nextInt();
         max += console.nextInt();
      }
      System.out.print("How many sections did you attend? ");
      int sections = console.nextInt();
      //Giá trị tối đa của điểm điểm danh là 30
      int sectionPoints = Math.min(sections * 5 , 30);
      //Giá trị tối đa điểm asignment là 150
      score = Math.min(score, 150);
      score += sectionPoints;
      max += 30;
      System.out.println("Section points = " + sectionPoints + " / 30");
      homeworkWeightedScore = 1.0 * weightHomework * score / max;
      printScore(score, max, weightHomework, homeworkWeightedScore);
      
      return homeworkWeightedScore;
   }
   
   //Hàm kiểm tra trọng số điểm 3 kiểm tra
   public static boolean checkWeight(int weightMidterm, int weightFinal, int weightHomework){
       if ((weightMidterm + weightFinal + weightHomework) > 100){
           return false;
       }
       return true;
   }
   
   //Hàm main điều khiển chương trình
   //Bước 1 : In thông báo về chương trình
   //Bước 2 : Nhập giá trị chi điểm giữa kì, cuối kì, bài tập
   //Bước 3 : In tổng điểm và thông báo xếp loại
   public static void main(String[] args) {     
      Scanner console = new Scanner(System.in);
      System.out.println("This program reads exam/homework scores");
      System.out.println("and reports your overall course grade.");
      System.out.println();
      double midtermWeightedScore = getMidtermScore(console);
      System.out.println();
      double finalWeightedScore = getFinalScore(console);
      System.out.println();
      double homeworkWeightedScore = getHomeworkScore(console);
      System.out.println();
      double overallPercentage = midtermWeightedScore + finalWeightedScore + homeworkWeightedScore;
      printOverallScore(overallPercentage);

   }
        
}
