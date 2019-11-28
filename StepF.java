import java.util.Scanner;

class StepF {
    public static void main(String[] args) {
        StepF stepF = new StepF();
        stepF.f08();
    }

    void f01() {
        Scanner s = new Scanner(System.in);
        int num[] = new int[10];
        int newnum;
        int second = Integer.MIN_VALUE;
        int second_max_index = 0;
        int first_max_index = 0;
        int first = Integer.MIN_VALUE;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter " + (i + 1) + "th number > ");
            newnum = s.nextInt();
            num[i] = newnum;
            if (first < newnum) {
                second = first;
                second_max_index = first_max_index;
                first = newnum;
                first_max_index = i + 1;
            }
        }
        System.out.println("Second largest number is " + second_max_index + "th number " + second);
    }

    void f02() {
        Scanner s = new Scanner(System.in);
        double score[] = new double[10];
        double maxscore = Integer.MIN_VALUE, minscore = Integer.MAX_VALUE;
        double total = 0;
        double average;
        double newnum;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter " + (i + 1) + "th score > ");
            newnum = s.nextDouble();
            score[i] = newnum;
            if (maxscore < newnum)
                maxscore = newnum;
            else if (minscore > newnum)
                minscore = newnum;
            total += newnum;
        }
        System.out.printf("Average is %.1f\n", (total - (maxscore + minscore)) / 8);
    }

    void f03() {
        Scanner s = new Scanner(System.in);
        int jumsu[][] = new int[5][3];
        int sum[] = new int[3];
        double average[] = new double[3];
        int kor, eng, mat;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Korean, English, Math score of " + (i + 1) + "th student > ");
            jumsu[i][0] = s.nextInt();
            jumsu[i][1] = s.nextInt();
            jumsu[i][2] = s.nextInt();
            sum[0] += jumsu[i][0];
            sum[1] += jumsu[i][1];
            sum[2] += jumsu[i][2];
        }
        average[0] = (double) sum[0] / 5;
        average[1] = (double) sum[1] / 5;
        average[2] = (double) sum[2] / 5;
        System.out.printf("Total Korean score is %d, average is %.1f\n", sum[0], average[0]);
        System.out.printf("Total English score is %d, average is %.1f\n", sum[1], average[1]);
        System.out.printf("Total Math score is %d, average is %.1f\n", sum[2], average[2]);
    }

    void f04() {
        Scanner s = new Scanner(System.in);
        int jumsu[][] = new int[5][3];
        int sum[] = new int[5];
        double average[] = new double[5];
        int kor, eng, mat;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Korean, English, Math score of " + (i + 1) + "th student > ");
            jumsu[i][0] = s.nextInt();
            jumsu[i][1] = s.nextInt();
            jumsu[i][2] = s.nextInt();
            sum[i] = jumsu[i][0] + jumsu[i][1] + jumsu[i][2];
            average[i] = (double) sum[i] / 3;
        }
        for (int i = 0; i < 5; i++)
            System.out.printf("Total score of %dth student is %d, average if %.1f\n", (i + 1), sum[i], average[i]);
    }

    void f05() {
        int bmilist[][] = new int[10][3];
        Scanner s = new Scanner(System.in);
        int iter_ct = 10;
        for (int i = 0; i < iter_ct; i++) {
            System.out.print("Enter height(cm) and weight(kg) ");
            bmilist[i][0] = s.nextInt();
            bmilist[i][1] = s.nextInt();
            bmilist[i][2] = (int) (bmilist[i][1] / (((double) bmilist[i][0] / 100) * ((double) bmilist[i][0] / 100)));
        }
        int count = 0;
        for (int i = 0; i < iter_ct; i++) {
            if (bmilist[i][2] >= 25) {
                System.out.println((i + 1) + "th person is obesity");
                count++;
            }
        }
        System.out.println(count + " people is obesity");
    }

    void f06() {
        Scanner s = new Scanner(System.in);
        int number[][] = new int[5][3];
        int newnum;
        int total = 0, ho = 0;

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of people in room " + (i + 1) + "0" + (j + 1) + " > ");
                number[i][j] = s.nextInt();
                total += number[i][j];
            }
        System.out.println("Number of people living in this apartment is " + total);
    }

    void f07() {
        Scanner s = new Scanner(System.in);
        int number[][] = new int[5][3];
        int floor_total[] = new int[5];
        int line_total[] = new int[3];
        int newnum;
        int total = 0, ho = 0;

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of people in room " + (i + 1) + "0" + (j + 1) + " > ");
                number[i][j] = s.nextInt();
                total += number[i][j];
            }
        for (int j = 0; j < 3; j++)
            for (int i = 0; i < 5; i++)
                line_total[j] += number[i][j];
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 3; j++)
                floor_total[i] += number[i][j];

        for (int i = 0; i < 5; i++)
            System.out.println("Number of people living in " + (i + 1) + " floor is " + floor_total[i]);

        System.out.println();

        for (int i = 0; i < 3; i++)
            System.out.println("Number of people living in " + (i + 1) + " line is " + line_total[i]);

        System.out.println();
        System.out.println("Number of people living in this apartment is " + total);
    }

    void f08() {
        Scanner s = new Scanner(System.in);
        int number[] = new int[10];
        int newnum;
        int count = 0;
        boolean dup = false;
        System.out.println("Enter a number from 1 to 100");
        while (count < 10) {
            System.out.print("Enter " + (count + 1) + "th number > ");
            newnum = s.nextInt();
            if (newnum < 1 || newnum > 100) {
                System.err.println("Invalid input!");
            } else {
                for (int j = 0; j < 10; j++) {
                    if (number[j] == newnum) {
                        dup = true;
                        break;
                    }
                }
                if (dup)
                    System.err.println("Invalid input!");
                else {
                    number[count] = newnum;
                    count++;
                }
                dup = false;
            }
        }
        for (int i = 0; i < 10; i++)
            System.out.println((i + 1) + "th number is " + number[i]);
    }
}