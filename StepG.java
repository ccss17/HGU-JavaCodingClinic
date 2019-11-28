import java.util.Scanner;

class StepG {
    public static void main(String[] args) {
        StepG stepG = new StepG();
        stepG.g01();
    }

    void g01() {
        Scanner s = new Scanner(System.in);
        int birthyear = 0;
        int count_person = 0;
        int count_baby = 0;
        int count_child = 0;
        int count_youth = 0;
        int count_young = 0;
        int count_adult = 0;
        int count_old = 0;
        int age[] = new int[100];
        int i = 0;
        while (i < 100) {
            System.out.print("Enter a birth year of " + (i + 1) + "th person > ");
            birthyear = s.nextInt();
            if (birthyear > 2019)
                break;
            age[i] = 2019 - birthyear + 1;
            if (age[i] < 7)
                count_baby++;
            else if (age[i] < 13)
                count_child++;
            else if (age[i] < 20)
                count_youth++;
            else if (age[i] < 30)
                count_young++;
            else if (age[i] < 60)
                count_adult++;
            else
                count_old++;
            i++;
        }
        for (int j = 0; j < i; j++)
            System.out.println((j + 1) + "th person are " + age[j] + " years old.");
        System.out.println("There are " + count_baby + " babys.");
        System.out.println("There are " + count_child + " childs.");
        System.out.println("There are " + count_youth + " youths.");
        System.out.println("There are " + count_young + " youngs.");
        System.out.println("There are " + count_adult + " adults.");
        System.out.println("There are " + count_old + " olds.");
    }

    void g02() {
        Scanner s = new Scanner(System.in);
        double input_degree = 0;
        double degrees[] = new double[10];
        String degree_name[] = { "cold water", "warm water", "hot water", "boiling water" };
        int count[] = { 0, 0, 0, 0 };
        int sel = 0;
        int idx = 0;
        while (idx < 10) {
            System.out.print("Enter water temperature > ");
            input_degree = s.nextDouble();
            if (input_degree < 0) {
                System.err.println("Invalid input!");
                continue;
            }
            if (input_degree < 25)
                count[0]++;
            else if (input_degree < 40)
                count[1]++;
            else if (input_degree < 80)
                count[2]++;
            else
                count[3]++;
            degrees[idx] = input_degree;
            idx++;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + "th water temperature is " + degrees[i] + " ");
            if (degrees[i] < 25)
                System.out.println(degree_name[0]);
            else if (degrees[i] < 40)
                System.out.println(degree_name[1]);
            else if (degrees[i] < 80)
                System.out.println(degree_name[2]);
            else
                System.out.println(degree_name[3]);
        }
        System.out.println("Count of " + degree_name[0] + " is " + count[0]);
        System.out.println("Count of " + degree_name[1] + " is " + count[1]);
        System.out.println("Count of " + degree_name[2] + " is " + count[2]);
        System.out.println("Count of " + degree_name[3] + " is " + count[3]);
    }

    void g03() {
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

        System.out.println();
        System.out.println("1) Total score and average for each subjects");
        System.out.printf("Total Korean score is %d, average is %.1f\n", sum[0], average[0]);
        System.out.printf("Total English score is %d, average is %.1f\n", sum[1], average[1]);
        System.out.printf("Total Math score is %d, average is %.1f\n", sum[2], average[2]);
        System.out.println();
        System.out.println("2) Total score and average for each students");
        for (int i = 0; i < 5; i++) {
            int std_total = jumsu[i][0] + jumsu[i][1] + jumsu[i][2];
            double std_average = (double) std_total / 3;
            char grade = '\0';
            if (std_average < 60)
                grade = 'F';
            else if (std_average < 70)
                grade = 'D';
            else if (std_average < 80)
                grade = 'C';
            else if (std_average < 90)
                grade = 'B';
            else
                grade = 'A';
            System.out.printf((i + 1) + "th student score: Total - %d, average - %.1f, grade - %c\n", std_total,
                    std_average, grade);
        }
    }

    void g04() {
        Scanner s = new Scanner(System.in);
        int kind = 0;
        int money = 0;
        int charge = 0;
        int total_charge = 0;
        while (true) {
            System.out.print("Enter the type of real estate transaction(1:Trading, 2:Lease, 0:exit) > ");
            kind = s.nextInt();
            if (kind == 1) {
                System.out.print("Enter the amount of real estate transaction. > ");
                money = s.nextInt();
                if (money < 50000000) {
                    charge = (int) (money * 0.006);
                    if (charge > 250000)
                        charge = 250000;
                } else if (money < 200000000) {
                    charge = (int) (money * 0.005);
                    if (charge > 8000000)
                        charge = 800000;
                } else
                    charge = (int) (money * 0.004);
            } else if (kind == 2) {
                System.out.print("Enter the amount of real estate transaction. > ");
                money = s.nextInt();
                if (money < 20000000) {
                    charge = (int) (money * 0.005);
                    if (charge > 70000)
                        charge = 70000;
                } else if (money < 50000000) {
                    charge = (int) (money * 0.005);
                    if (charge > 200000)
                        charge = 200000;
                } else if (money < 100000000) {
                    charge = (int) (money * 0.004);
                    if (charge > 300000)
                        charge = 300000;
                } else
                    charge = (int) (money * 0.003);
            } else if (kind == 0) {
                break;
            }
            System.out.println("The charge is " + charge);
            total_charge += charge;
        }
        System.out.println("Total charge is " + total_charge);
    }

    void g05() {
        Scanner s = new Scanner(System.in);
        int hour, minute;
        int charge = 0, total_charge = 0;
        int total_minutes = 0;
        while (true) {
            System.out.print("Enter hours and minutes of use > ");
            hour = s.nextInt();
            minute = s.nextInt();
            if (hour == 0 && minute == 0)
                break;
            total_minutes = hour * 60 + minute;
            charge = (total_minutes / 30) * 1000;
            if (total_minutes % 30 != 0)
                charge += 1000;
            if (total_minutes < 120) {
            } else if (total_minutes < 180)
                charge *= (1 - 0.05);
            else if (total_minutes < 300)
                charge *= (1 - 0.1);
            else if (total_minutes >= 300)
                charge *= (1 - 0.2);
            total_charge += charge;
            System.out.println("Your charge is " + charge);
        }
        System.out.println();
        System.out.println("Your total charge is " + total_charge);
    }

    void g06() {
        Scanner s = new Scanner(System.in);
        int order[] = { 0, 0, 0 };
        int sale;
        int total_sale = 0;
        int total_order;
        int price[] = { 10000, 6000, 3000 };

        System.out.println("There are three type of products");
        System.out.println("(1. Leather gloves, 2. Wool gloves, 3. Vinyl gloves)");
        System.out.println();

        while (true) {
            System.out.print("How many first products do you want to buy? > ");
            order[0] = s.nextInt();
            System.out.print("How many second products do you want to buy? > ");
            order[1] = s.nextInt();
            System.out.print("How many third products do you want to buy? > ");
            order[2] = s.nextInt();
            if (order[0] == 0 && order[1] == 0 && order[2] == 0)
                break;
            total_order = price[0] * order[0] + price[1] * order[1] + price[2] * order[2];
            System.out.println("The price is " + total_order);
            total_sale += total_order;
        }
        System.out.println("Total price from now on is " + total_sale);
    }

    void g07() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of team > ");
        int team_count = s.nextInt();
        int count[] = new int[4];
        int v_count[] = new int[4];
        int charge[] = {5000, 10000, 15000, 3000};
        int sum=0, total_sum=0, membership;
        for (int i=0; i<team_count; i++) {
            System.out.print("Enter a number of "+(i+1)+" th team member (child, youth, adult, old) > ");
            count[0] = s.nextInt();
            count[1] = s.nextInt();
            count[2] = s.nextInt();
            count[3] = s.nextInt();
            v_count[0] += count[0];
            v_count[1] += count[1];
            v_count[2] += count[2];
            v_count[3] += count[3];
            sum = count[0] * charge[0] + count[1] * charge[1] + count[2] * charge[2] + count[3] * charge[3]; 
            System.out.print("Enter a discount membership type of "+(i+1)+" th team (no membership:0 , normal:1 , VIP:2) > ");
            membership = s.nextInt();
            if(membership==1) sum = (int)(sum * (1-0.1));
            else if(membership==2) sum = (int)(sum * (1-0.2));

            System.out.println("Admission fees of "+(i+1)+"th team is "+sum);
            total_sum += sum;
        }
        System.out.println();
        System.out.println("Total number of visitors "+(v_count[0]+v_count[1]+v_count[2]+v_count[3]));
        System.out.println("Total number of child "+v_count[0]);
        System.out.println("Total number of youth "+v_count[1]);
        System.out.println("Total number of adult "+v_count[2]);
        System.out.println("Total number of old "+v_count[3]);
        System.out.println();
        System.out.println("Total free is "+total_sum);
    }
}