import java.util.Scanner;
import java.util.Random;

class StepH {
    public static void main(String[] args) {
        StepH stepH = new StepH();
        stepH.h09();
    }

    void h01() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int answer = r.nextInt(100) + 1;
        int count = 0;
        int number_try;
        while (true) {
            System.out.print("Guess the number from 1 to 100 > ");
            number_try = s.nextInt();
            if (answer < number_try) {
                System.out.println("Down!");
            } else if (answer > number_try) {
                System.out.println("Up!");
            } else {
                break;
            }
            count++;
        }
        System.out.println("You figured out the number in " + count + " times");
    }

    void h02() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int lotto[] = new int[6];
        int count;
        String onemore;

        while (true) {
            System.out.print("The generated lotto numbers are ");
            for (int i = 0; i < 6; i++) {
                lotto[i] = r.nextInt(45) + 1;
                System.out.print(lotto[i] + " ");
            }
            System.out.println();
            System.out.print("Do you want to generate more lotto numbers? (Y/N) > ");
            onemore = s.next();
            if (onemore.equals("Y"))
                continue;
            else if (onemore.equals("N"))
                break;
        }
    }

    void h03() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int lotto_com[] = new int[6];
        int lotto_user[] = new int[6];
        int count = 0;
        int match_count = 0;
        boolean dup = false;
        int tmp;
        for (int i=0; i<6; ) {
            tmp = r.nextInt(45)+1;
            for (int j=0; j<i; j++) {
                if (lotto_com[j] == tmp) {
                    dup = true;
                    break;
                }
            }
            if (dup) {
                dup = false;
                continue;
            }
            lotto_com[i] = tmp;
            i++;
        }
        for (int i=0; i<6; ) {
            System.out.print("Enter your "+(i+1)+"th lotto number > ");
            tmp = s.nextInt();
            if (tmp > 45 || tmp < 1) {
                System.err.println("Invalid input!");
                continue;
            }
            for (int j=0; j<i; j++) {
                if (lotto_user[j] == tmp) {
                    dup = true;
                    break;
                }
            }
            if (dup) {
                dup = false;
                System.err.println("Invalid input!");
                continue;
            }
            for (int j=0; j<6; j++) {
                if (lotto_com[j] == tmp) {
                    match_count++;
                    break;
                }
            }
            lotto_user[i] = tmp;
            i++;
        }
        System.out.println();
        System.out.print("Lotto numbers of this week are ");
        for (int i=0; i<6; i++)
            System.out.print(lotto_com[i]+" ");
        System.out.println();
        System.out.println("There are "+match_count+" matching lotto numbers");
    }
    void h04() {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int com_finger;
        int my_finger;
        int score[][] = new int[2][3];

        while (true) {
            System.out.print("Enter Scissors(1) Rock(2) Paper(3) > ");
            my_finger = s.nextInt();
            if (my_finger == 0) break;
            com_finger = r.nextInt(3)+1;
            if (com_finger == 1) {
                System.out.print("What the computer has given out is Scissors ---> ");
                if (my_finger == 1) {
                    System.out.println("Draw!");
                    score[0][1]++;
                    score[1][1]++;
                }
                else if (my_finger == 2) {
                    System.out.println("You win!");
                    score[0][2]++;
                    score[1][0]++;
                }
                else if (my_finger == 3) {
                    System.out.println("Computer win..");
                    score[0][0]++;
                    score[1][2]++;
                }
            }
            else if (com_finger == 2) {
                System.out.print("What the computer has given out is Rock ---> ");
                if (my_finger == 1) {
                    System.out.println("Computer win..");
                    score[0][0]++;
                    score[1][2]++;
                }
                else if (my_finger == 2) {
                    System.out.println("Draw!");
                    score[0][1]++;
                    score[1][1]++;
                }
                else if (my_finger == 3) {
                    System.out.println("You win!");
                    score[0][2]++;
                    score[1][0]++;
                } 
            }
            else if (com_finger == 3) {
                System.out.print("What the computer has given out is Paper ---> ");
                if (my_finger == 1) {
                    System.out.println("You win!");
                    score[0][2]++;
                    score[1][0]++;
                }
                else if (my_finger == 2) {
                    System.out.println("Computer win..");
                    score[0][0]++;
                    score[1][2]++;
                }
                else if (my_finger == 3) {
                    System.out.println("Draw!");
                    score[0][1]++;
                    score[1][1]++;
                }
            }
        }
        System.out.println("Computer : win - "+score[0][0]+", lost - "+score[0][2]+", draw - "+score[0][1]);
        System.out.println("User : win - "+score[1][0]+", lost - "+score[1][2]+", draw - "+score[1][1]);
    }
    void h05(){
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int coins;
        int number[] = new int[3];
        int dummy;
        int count = 0;

        System.out.print("Enter number of coins > ");
        coins = s.nextInt();
        for(int i=0; ; i++) {
            for (int j=0; j<3; j++) 
                number[j] = r.nextInt(9)+1;
            System.out.print("Start "+(i+1)+"th game!!! (Enter three number from 1 to 9) > ");
            for (int j=0; j<3; j++) {
                dummy = s.nextInt();
                if (dummy == number[j]) count++;
            }
            System.out.print("Result of game : ");
            for (int j=0; j<3; j++)
                System.out.print(number[j]+" ");
            if (count == 0 || count == 1)
                System.out.println("---> Failed..");
            else if (count == 2) {
                System.out.println("---> match 2 numbers! got two more coins");
                coins += 2;
            }
            else if (count == 3) {
                System.out.println("---> match 3 numbers! got four more coins");
                coins += 4;
            }
            coins--;
            System.out.println("There are "+coins+" coins remaining.");
            if(coins == 0) break;
            count = 0;
        }
        System.out.println("Game over!");
    }
    void h06(){
        Scanner s = new Scanner(System.in);
        int number[] = new int[5];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int max_a = 0, max_b = 0;
        int min_a = 0, min_b = 0;
        System.out.print("Enter 5 numbers from 2 to 9 > ");
        for (int i=0; i<5; i++) {
            number[i] = s.nextInt();
        }
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (i!=j) {
                    if (min > Math.pow(number[i], number[j])) {
                        min = (int)Math.pow(number[i], number[j]);
                        min_a = number[i]; min_b = number[j];
                    }
                    if (max < Math.pow(number[i], number[j])) {
                        max = (int)Math.pow(number[i], number[j]);
                        max_a = number[i]; max_b = number[j];
                    }
                }
            }
        }
        System.out.println("Max number is "+ max + " which is "+max_b+" squared of "+max_a);
        System.out.println("Min number is "+ min + " which is "+min_b+" squared of "+min_a);
    }
    void h07(){
        Scanner s = new Scanner(System.in);
        String input;
        while (true) {
            System.out.println("===============================");
            System.out.print("=> Enter a sentence ('x' for exit) > ");
            input = s.nextLine();
            if (input.equals("x"))break;
            System.out.println("=> Number of character is "+ input.length());
            for (int i=0; i<input.length(); i++) {
                System.out.println("=> "+input.charAt(i));
            }
        }
        System.out.println("Exit program");
    }
    void h08(){
        Scanner s = new Scanner(System.in);
        String input;
        String findStr, replaceStr;
        int count=0, idx=-1;
        while (true) {
            System.out.println("===============================");
            System.out.print("=> Enter a sentence ('x' for exit) > ");
            input = s.nextLine();
            if (input.equals("x"))break;
            System.out.print("=> Enter a sentence to find > ");
            findStr = s.nextLine();
            System.out.print("=> Enter a sentence to replace > ");
            replaceStr = s.nextLine();
            while(true){
                idx = input.indexOf(findStr, idx+1);
                if (idx == -1) break;
                count++;
            }
            input = input.replace(findStr, replaceStr);
            System.out.println("=> The replacement occurred "+count+" times");
            System.out.println("=> "+input);
            count=0;
        }
        System.out.println("Exit program");
    }
    void h09(){
        Scanner s = new Scanner(System.in);
        String input;
        String userList[];
        String userInfo[];
        while (true) {
            System.out.println("=============================");
            System.out.print("Enter string ('x' for exit) > ");
            input = s.nextLine();
            if (input.equals("x"))break;
            userList = input.split("###");
            System.out.println("Total number of people is "+userList.length);
            for (int i=0; i<userList.length; i++) {
                userInfo = userList[i].split("\\|");
                System.out.println((i+1)+" "+userInfo[0]+" "+userInfo[1]);
            }
        }
        System.out.println("Exit program");
    }
}