import java.util.Scanner;
import java.util.Random;;

class StepI {
    public static void main(String[] args) {
        StepI stepI = new StepI();
        stepI.i04();
    }

    void i01_ShowMenu() {
        System.out.print("1. pizza(15,000) 2. spaghetti(10,000) 3. salad(7,000) 4. drink(2,000) 5. exit > ");
    }

    void i01() {
        Scanner s = new Scanner(System.in);
        int menu;
        int price = 0;

        while (true) {
            this.i01_ShowMenu();
            menu = s.nextInt();
            if (menu == 1)
                price += 15000;
            else if (menu == 2)
                price += 10000;
            else if (menu == 3)
                price += 7000;
            else if (menu == 4)
                price += 2000;
            else if (menu == 5)
                break;
            else
                continue;
            System.out.println("Order price from now on is " + price);
            System.out.println();
        }
        System.out.println("Total price is " + price);
    }

    void i02_PrintCharWithBlank(int blank, int size, char ch) {
        for (int i = 1; i <= size; i++) {
            for (int k = 0; k < blank; k++)
                System.out.print(" ");
            for (int j = size; j > 0; j--) {
                if (j <= i)
                    System.out.print(ch);
                else
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }

    void i02() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a character to draw triangle > ");
        char ch = s.next().charAt(0);
        System.out.print("Enter a height of right triangle and black > ");
        int height = s.nextInt();
        int blank = s.nextInt();
        i02_PrintCharWithBlank(blank, height, ch);
    }

    void i03_AskBiman(double height, int weight) {
        int bmi = (int) (weight / (height * height));
        if (bmi >= 30)
            System.out.println("You are high obesity");
        else if (bmi >= 25)
            System.out.println("You are obesity");
        else if (bmi >= 23)
            System.out.println("You are overweight");
        else if (bmi >= 18.5)
            System.out.println("You are normal weight");
        else
            System.out.println("You are low weight");

    }

    void i03() {
        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter height(cm) and weight ");
            double height = (double) s.nextInt() / 100;
            int weight = s.nextInt();
            i03_AskBiman(height, weight);
        }
    }
    void i04_T() {
        int total = 0;
        while (true) {
            int order = SelectMenu();
            if (order == -1)
                break;
            total += order;
            System.out.printf("Order price from now on is %d\n", total);
        }
        System.out.printf("Total price is %d\n", total);
    }
    int SelectMenu_T() {
        int[] price = { 15000, 10000, 7000, 2000, -1 };
        System.out.print("1. pizza(15,000) 2. spaghetti(10,000) " + "3. salad(7,000) 4. drink(2,000) 5. exit > ");

        return price[s.nextInt() - 1];
    }

    void i04_T2() {
        int total = 0;
        while (true) {
            int order = price[SelectMenu()];
            if (order == 1)
                price += 15000;
            else if (order == 2)
                price += 10000;
            else if (order == 3)
                price += 7000;
            else if (order == 4)
                price += 2000;
            else if (order == 5)
                break;
            else
                continue;
            if (order == -1)
                break;
            total += order;
            System.out.printf("Order price from now on is %d\n", total);
        }
        System.out.printf("Total price is %d\n", total);
    }
    int SelectMenu_T2() {
        System.out.print("1. pizza(15,000) 2. spaghetti(10,000) " + "3. salad(7,000) 4. drink(2,000) 5. exit > ");

        return s.nextInt() - 1;
    }

    int i04_SelectMenu() {
        Scanner s = new Scanner(System.in);
        System.out.print("1. pizza(15,000) 2. spaghetti(10,000) 3. salad(7,000) 4. drink(2,000) 5. exit > ");
        return s.nextInt();
    }

    void i04() {
        int menu;
        int price = 0;

        while (true) {
            menu = this.i04_SelectMenu();
            if (menu == 1)
                price += 15000;
            else if (menu == 2)
                price += 10000;
            else if (menu == 3)
                price += 7000;
            else if (menu == 4)
                price += 2000;
            else if (menu == 5)
                break;
            else
                continue;
            System.out.println("Order price from now on is " + price);
            System.out.println();
        }
        System.out.println("Total price is " + price);
    }

    int i05_MaxOfTen() {
        Scanner s = new Scanner(System.in);
        int maxnum = Integer.MIN_VALUE;
        int num;
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter " + (i + 1) + "th number > ");
            num = s.nextInt();
            if (maxnum < num)
                maxnum = num;
        }
        return maxnum;
    }

    void i05() {
        System.out.println("Find the maximum of 10 numbers");
        int maxnum = i05_MaxOfTen();
        System.out.println("Maximum value is " + maxnum);
    }

    byte i06_GetRandom() {
        Random r = new Random();
        int rnum = r.nextInt(100) + 1;
        System.out.println("Generated random number is " + rnum);
        if (rnum >= 70)
            return 0;
        else if (rnum >= 40)
            return 1;
        else
            return 2;
    }

    void i06() {
        System.out.println("Generating 10 numbers...");
        int count[] = new int[3];
        int tmp;
        for (int i = 0; i < 10; i++) {
            tmp = i06_GetRandom();
            if (tmp == 0)
                count[0]++;
            else if (tmp == 1)
                count[1]++;
            else
                count[2]++;
        }
        System.out.println();
        System.out.println("1. Big (>= 70) : " + count[0]);
        System.out.println("2. Normal (>= 40) : " + count[1]);
        System.out.println("3. Small (< 40) : " + count[2]);
    }

    int i07_SelectCan() {
        Scanner s = new Scanner(System.in);
        System.out.println("1. Cola(700) 2. coffee(300) 3. lemon tea(1000)");
        System.out.println("4. milk tea(500) 5. cocoa(600)");
        System.out.print("Please select menu > ");
        int menu = s.nextInt();
        if (menu == 1)
            return 700;
        else if (menu == 2)
            return 300;
        else if (menu == 3)
            return 1000;
        else if (menu == 4)
            return 500;
        else if (menu == 5)
            return 600;
        else
            return 0;
    }

    void i07() {
        Scanner s = new Scanner(System.in);
        int price = 0;
        int ct = 0;
        char ch;
        while (true) {
            price += i07_SelectCan();
            ct++;
            System.out.print("Do you need more menu? (Y/N) > ");
            ch = s.next().charAt(0);
            if (ch == 'N')
                break;
        }
        System.out.println("Total price for " + ct + " drinks is " + price);
    }
}