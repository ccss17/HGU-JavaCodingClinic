import java.util.Scanner;

class StepD {
    public static void main(String[] args) {
        StepD stepD = new StepD();
        stepD.d10();
    }

    void d01() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a number > ");
        int number = s.nextInt();
        if (number > 1) {
            int totalsum = 0;
            for (int i = 0; i <= number; i++)
                totalsum += i;
            System.out.println("The sum of all integer from 1 to the number entered is " + totalsum);
        } else {
            System.err.println("Invalid input");
        }
    }

    void d02() {
        Scanner s = new Scanner(System.in);
        int number = 0;
        int max_num = Integer.MIN_VALUE, min_num = Integer.MAX_VALUE;
        while (true) {
            System.out.print("Enter a number > ");
            number = s.nextInt();
            if (number <= 0 || number >= 100)
                break;
            if (max_num < number)
                max_num = number;
            if (min_num > number)
                min_num = number;
        }
        System.out.println("Max number is " + max_num + ", Min number is " + min_num);
    }

    void d03() {
        Scanner s = new Scanner(System.in);
        int number = 0;
        int count = 0;
        int totalsum = 0;
        double average = 0;
        while (true) {
            System.out.print("Enter a number from 0 to 100 > ");
            number = s.nextInt();
            if (number <= 0 || number >= 100)
                break;
            totalsum += number;
            count += 1;
        }
        average = (double) totalsum / count;
        System.out.println("The sum of " + count + " numbers is " + totalsum + ", average is " + average);
    }

    void d04() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of family members > ");
        int count_all = s.nextInt();
        int birthyear = 0;
        int age = 0;
        int count_young = 0;
        for (int i = 0; i < count_all; i++) {
            System.out.print("Enter a birth year > ");
            birthyear = s.nextInt();
            age = 2019 - birthyear + 1;
            if (age < 20)
                count_young++;
        }
        System.out.println("There are " + count_young + " youngs in the family.");
    }

    void d05() {
        Scanner s = new Scanner(System.in);
        int width = 0;
        int height = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        while (true) {
            System.out.print("Enter width, height of Rectangle > ");
            width = s.nextInt();
            height = s.nextInt();
            if (width <= 0 || height <= 0)
                break;
            if (width == height)
                count1++;
            else if (width >= height * 2)
                count2++;
            else if (height >= width * 2)
                count3++;
            else if (width > height)
                count4++;
            else if (height > width)
                count5++;
        }
        System.out.println("Count of square is " + count1);
        System.out.println("Count of an oblong rectangle from side to side is " + count2);
        System.out.println("Count of an oblong rectangle from top to bottom is " + count3);
        System.out.println("Count of a horizontal rectangle is " + count4);
        System.out.println("Count of a vertical rectangle is " + count5);
    }

    void d06() {
        Scanner s = new Scanner(System.in);
        double m2_area = 0;
        double pyung_area = 0;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter area of Apartment(m^2) > ");
            m2_area = s.nextDouble();
            pyung_area = m2_area / 3.305;
            System.out.printf("Area of Apartment(pyung) %.1f\n", pyung_area);

            if (pyung_area < 15)
                count1++;
            else if (pyung_area < 30)
                count2++;
            else if (pyung_area < 50)
                count3++;
            else
                count4++;
        }
        System.out.println("Count of small-sized apartment is " + count1);
        System.out.println("Count of small and medium-sized apartment is " + count2);
        System.out.println("Count of medium-sized apartment is " + count3);
        System.out.println("Count of big-sized apartment is " + count4);
    }

    void d07() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the coefficients a and b of linear function(y=ax+b) > ");
        int a = s.nextInt();
        int b = s.nextInt();
        System.out.print("Enter the start and end values of x coordinates > ");
        int x_begin = s.nextInt();
        int x_end = s.nextInt();
        for (int i = x_begin; i <= x_end; i++)
            System.out.println("coordinates (" + i + ", " + (i * a + b) + ")");
    }

    void d08() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the coefficients a and b of quadratic function(y=ax^2+bx+c) > ");
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        System.out.print("Enter the start and end values of x coordinates > ");
        int x_begin = s.nextInt();
        int x_end = s.nextInt();
        for (int i = x_begin; i <= x_end; i++)
            System.out.println("coordinates (" + i + ", " + (i * i * a + b * i + c) + ")");
    }

    void d09() {
        Scanner s = new Scanner(System.in);
        int dan = 0;
        while (true) {
            System.out.print("Enter number of gugudan(2~9) > ");
            dan = s.nextInt();
            if (dan < 2 || dan > 9)
                System.err.println("Invalid input");
            else
                break;
        }
        for (int i = 1; i <= 9; i++)
            System.out.println(dan + " X " + i + " = " + dan * i);
    }

    void d10() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers  > ");
        int num1 = s.nextInt();
        int num2 = s.nextInt();
        int lar = 0;
        int small = 0;
        int lcd = 0;

        if (num1 > num2) {
            lar = num1;
            small = num2;
        } else {
            lar = num2;
            small = num1;
        }
        for (int i = lar;; i += lar) {
            if (i % small == 0) {
                lcd = i;
                break;
            }
        }
        for (int i = 0; i <= 100; i++) {
            if ((i % num1 == 0 || i % num2 == 0) && i % lcd != 0)
                System.out.print(i + " ");
        }
    }
}