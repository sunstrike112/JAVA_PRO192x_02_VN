package asm1;
import java.util.Random;
import java.util.Scanner;

public class ASM1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int totalGames = 0;
        int totalGuesses = 0;
        int bestGame = 9999;
        int newGame = 0;
        boolean playAgain = false;
        do {
            newGame = play(scan, rand);
            //Tìm số lần chơi thấp nhất
            if (newGame < bestGame) {
                bestGame = newGame;
            }
            totalGuesses += newGame;
            totalGames++;
        //Kiểm tra biến nhập vào là YES,Yes,YEs,YeS,yES,yEs,yeS,yes,Y,y thì tiếp tục
            switch (scan.next().toUpperCase()) {
                case "YES":
                    playAgain = true;
                    break;
                case "Y":
                    playAgain = true;
                    break;               
                default:
                    playAgain = false;
                    break;
            }
            System.out.println();
        }while(playAgain);
        report(totalGames, totalGuesses, bestGame);
    }

    

    //Hàm điều khiển trò chơi
    //Bước 1 : Nhập giá trị MAX của số may mắn
    //Bước 2 : Sinh ra số may mắn ngẫu nhiên trong khoảng từ 1 - MAX
    //Bước 3 : Xét số may mắn và giá trị mà người chơi đoán để thông báo kết quả

    public static int play(Scanner scan, Random rand) {
        System.out.println("Please enter MAX value of lucky number : ");
        int max = scan.nextInt();
        int number = rand.nextInt(max+1);
        System.out.println("I'm thinking of a number between 0 and " + max + " ...");
        int guesses = 1;
        int guess = -1;
        while (guess != number) {
            System.out.print("Your guess? ");
            guess = scan.nextInt();
            if (guess > number) {
                System.out.println("The lucky number is lower.");
                guesses++;
            } else if (guess < number) {
                System.out.println("The lucky number is higher.");
                guesses++;
            } else if (guess == number) {
                if (guesses == 1) {
                    System.out.println("You got it right in 1 guess");
                } else {
                    System.out.println("You got it right in " + guesses + " guesses");
                }
                System.out.print("Do you want to play again? ");
                return guesses;
            }
        }
        return -1;
    }
 
    //Hàm thông báo hiển thị kết quả tổng hợp của trò chơi
    public static void report(int totalGames, int totalGuesses, int bestGame) {
        double avgGuesses = Math.round(10.0 * totalGuesses / totalGames) / 10.0;
        System.out.println("Overall results: ");
        System.out.println("    total games   = " + totalGames);
        System.out.println("    total guesses = " + totalGuesses);
        System.out.println("    guesses/game  = " + avgGuesses);
        System.out.println("    best game     = " + bestGame);
    }
}
