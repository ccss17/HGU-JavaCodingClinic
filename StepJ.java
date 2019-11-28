import java.util.Scanner;

class StepJ {
    public static void main(String[] args) {
        StepJ stepJ = new StepJ();
        stepJ.j10();
    }

    int j01_AskAge(int birthyear){
        int age = 2019 - birthyear + 1;
        System.out.println("This person is " + age + " years old.");
        if (age < 7)
            return 0;
        else if (age < 13)
            return 1;
        else if (age < 20)
            return 2;
        else if (age < 30)
            return 3;
        else if (age < 60)
            return 4;
        else
            return 5;
    }
    void j01(){
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
        int flag;
        while (i < 100) {
            System.out.print("Enter a birth year of " + (i + 1) + "th person > ");
            birthyear = s.nextInt();
            if (birthyear > 2019)
                break;
            flag = j01_AskAge(birthyear);
            if (flag == 0)
                count_baby++;
            else if (flag == 1)
                count_child++;
            else if (flag == 2)
                count_youth++;
            else if (flag == 3)
                count_young++;
            else if (flag == 4)
                count_adult++;
            else
                count_old++; i++;
        }
        System.out.println("There are " + count_baby + " babys.");
        System.out.println("There are " + count_child + " childs.");
        System.out.println("There are " + count_youth + " youths.");
        System.out.println("There are " + count_young + " youngs.");
        System.out.println("There are " + count_adult + " adults.");
        System.out.println("There are " + count_old + " olds.");
    }
    double j02_Min(double num[]){
        double minscore = Integer.MAX_VALUE;
        for (int i=0; i<10; i++) {
            if (minscore > num[i]) minscore = num[i];
        }
        return minscore;
    }
    double j02_Max(double num[]){
        double maxscore = Integer.MIN_VALUE;
        for (int i=0; i<10; i++) {
            if (maxscore < num[i]) maxscore = num[i];
        }
        return maxscore;
    }
    void j02(){
        Scanner s = new Scanner(System.in);
        double score[] = new double[10];
        double total = 0;
        double average;
        double newnum;
        double maxscore;
        double minscore;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter " + (i + 1) + "th score > ");
            newnum = s.nextDouble();
            score[i] = newnum;
            total += newnum;
        }
        maxscore = j02_Max(score);
        minscore = j02_Min(score);
        System.out.printf("Average is %.1f\n", (total - (maxscore + minscore)) / 8);
    }
    byte j03_AskWater(double degree){
        if (degree < 0) {
            return -1;
        }
        if (degree < 25)
            return 0;
        else if (degree < 40)
            return 1;
        else if (degree < 80)
            return 2;
        else
            return 3;
    }
    void j03(){
        Scanner s = new Scanner(System.in);
        double input_degree = 0;
        double degrees[] = new double[10];
        String degree_name[] = { "cold water", "warm water", "hot water", "boiling water" };
        int count[] = { 0, 0, 0, 0 };
        int sel = 0;
        int idx = 0;
        int flag = 0;
        while (idx < 10) {
            System.out.print("Enter "+(idx+1)+"th water temperature > ");
            input_degree = s.nextDouble();
            flag = j03_AskWater(input_degree);
            if (flag == -1){
                System.err.println("Invalid input!");
                continue;
            }
            else if (flag == 0)
                count[0]++;
            else if (flag == 1)
                count[1]++;
            else if (flag == 2)
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
    int j04_CalcDate(int month, int day) {
        if (month < 1 || month > 12 || day < 1 || day > 31) return -1;
        int day_count = day;

        switch(month) {
        case 12: day_count += 30;
        case 11: day_count += 31;
        case 10: day_count += 30;
        case 9: day_count += 31;
        case 8: day_count += 31;
        case 7: day_count += 30;
        case 6: day_count += 31;
        case 5: day_count += 30;
        case 4: day_count += 31;
        case 3: day_count += 28;
        case 2: day_count += 31;
        }
        return day_count;
    }
    void j04(){
        Scanner s = new Scanner(System.in);
        int day_count1, day_count2;
        System.out.print("Enter first day (month day) > ");
        day_count1 = j04_CalcDate(s.nextInt(), s.nextInt());
        System.out.print("Enter second day (month day) > ");
        day_count2 = j04_CalcDate(s.nextInt(), s.nextInt());

        if (day_count1 == -1 || day_count2 == -1)
        System.out.println("Invalid input!");
        else
        System.out.println("The interval between two dates is "+Math.abs(day_count2-day_count1)+" days.");
    }
    int j05_CalcParking(int start_h, int start_m, int end_h, int end_m){
        int start = start_h * 60 + start_m;
        int end = end_h * 60 + end_m;
        int price = ((end - start) / 10) * 500;
        if ((end - start) % 10 != 0) price += 500;
        return price;
    }
    void j05(){
        Scanner s = new Scanner(System.in);
        int idx = 0;
        int start_h, start_m, end_h, end_m;
        int price, total=0;
        char flag;
        while (true) {
            System.out.print("Enter parking start time of "+(idx+1)+"th car (H M) > ");
            start_h= s.nextInt();
            start_m= s.nextInt();
            System.out.print("Enter parking end time of "+(idx+1)+"th car (H M) > ");
            end_h= s.nextInt();
            end_m= s.nextInt();
            price = j05_CalcParking(start_h, start_m, end_h, end_m);
            total += price;
            System.out.println("Parking price : "+price);
            System.out.print("Do you want to enter more? (Y/N) > ");
            flag = s.next().charAt(0);
            if (flag == 'Y') {
                idx++;
                continue;
            }
            else if (flag == 'N') break;
        }
        System.out.println("Total price for "+(idx+1)+" cars is "+total);
    }

    int j06_fib(int n) {
        if (n <= 1)
            return n;
        return j06_fib(n - 1) + j06_fib(n - 2);
    }
    void j06(){
        System.out.println("Fibonacci numbers from 1 to 20 are as follows.");
        for (int i=0; i<20; i++) {
            System.out.println((i+1)+"th : "+j06_fib(i+1));
        }
    }
    int j07_poweroftwo(int n) {
        if (n == 0)
            return 1;
        return 2 * j07_poweroftwo(n - 1);
    }

    void j07(){
        Scanner s = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("Enter a number. (0 for exit) > ");
            num = s.nextInt();
            if (num == 0) break;
            System.out.println(num + " square of 2 is " + j07_poweroftwo(num));
        }
    }

    int j08_Ackermann(int m, int n) {
        if (m == 0)
            return n + 1;
        if (n == 0)
            return j08_Ackermann(m - 1, 1);
        return j08_Ackermann(m - 1, j08_Ackermann(m, n - 1));
    }

    void j08() {
        System.out.println("Ackermannonacci numbers from 1 to 20 are as follows.");
        for (int i = 0; i < 4; i++) 
        for (int j = 0; j < 4; j++) 
            System.out.println("Ackermann("+i+", "+j+") = "+j08_Ackermann(i, j));
    }
    int j09_power(int m, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return m;
        if (n%2 == 0)
            return j09_power(m, n/2) * j09_power(m, n/2);
        else
            return j09_power(m, n/2) * j09_power(m, n/2) * m;
    }

    void j09() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter two numbers > ");
        int m = s.nextInt();
        int n = s.nextInt();
        System.out.println(n +" square of "+m+" is "+j09_power(m, n));
    }
    int j10_fib(int n) {
        if (n <= 1)
            return n;
        return j10_fib(n - 1) + j10_fib(n - 2);
    }

    void j10(){
        double ratio = 0;
        double ratio2 = 0;
        int i=2;
        int n1, n2;
        while (true) {
            ratio2 = ratio;
            n1 = j10_fib(i+1);
            n2 = j10_fib(i);
            ratio = ((double)n1 / n2);
            System.out.printf("%dth ratio (%d / %d) : %.6f\n",i, n1, n2, ratio);
            if (Math.abs(ratio - ratio2) < (double)1/1000000) break;
            i++;
        }
    }
}