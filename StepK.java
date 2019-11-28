import java.util.Scanner;

class StepK {
    public static void main(String[] args) {
        StepK stepK = new StepK();
        stepK.k07();
    }
    void k01() {
        k01_MenuPan k01class = new k01_MenuPan();
        k01class.input();
        System.out.println("================================================");
        System.out.println("num\tname\torigin\tprice");
        k01class.print();
    }

    void k02() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number of menu > ");
        int menu_num = s.nextInt();
        k01_MenuPan k02class[] = new k01_MenuPan[menu_num];
        for (int i=0; i<menu_num; i++) {
            System.out.print((i+1)+": ");
            k02class[i] = new k01_MenuPan();
            k02class[i].input();
        }
        System.out.println("================================================");
        System.out.println("num\tname\t\torigin\t\tprice");
        for (int i=0; i<menu_num; i++) 
            k02class[i].print();
    }
    void k03() {
        Scanner s = new Scanner(System.in);
        int quadrants[] = new int[4];
        System.out.print("Enter coordinate (X, Y) > ");
        k03_Point k03class = new k03_Point(s.nextDouble(), s.nextDouble());
        System.out.println("================================================");
        System.out.print("Coordinate is located on ");
        if (k03class.get_area(k03class.x, k03class.y) == 0)
            System.out.println("the axis");
        else if (k03class.get_area(k03class.x, k03class.y) == 1) {
            quadrants[0]++;
            System.out.println("first quadrants");
        }
        else if (k03class.get_area(k03class.x, k03class.y) == 2) {
            quadrants[1]++;
            System.out.println("second quadrants");
        }
        else if (k03class.get_area(k03class.x, k03class.y) == 3) {
            quadrants[2]++;
            System.out.println("third quadrants");
        }
        else if (k03class.get_area(k03class.x, k03class.y) == 4) {
            quadrants[3]++;
            System.out.println("fourth quadrants");
        }
        for (int i=0; i<4; i++) {
            System.out.println("Number of coordinates on " + (i+1)+"th quadrants is "+ quadrants[i]);
        }
    }
    void k04() {
        Scanner s = new Scanner(System.in);
        int quadrants[] = new int[4];
        int num;
        System.out.print("Enter a number of coordinate > ");
        num = s.nextInt();
        int flag;
        k03_Point k03class[] = new k03_Point[num];
        for (int i=0; i<num; i++) {
            System.out.print("Enter "+(i+1)+"th coordinate (X, Y) > ");
            k03class[i] = new k03_Point(s.nextDouble(), s.nextDouble());
        }
        System.out.println("================================================");
        for (int i=0; i<num; i++) {
            System.out.print((i+1)+"th coordinate is located on ");
            flag = k03class[i].get_area(k03class[i].x, k03class[i].y);
            if (flag == 0)
                System.out.println("the axis");
            else if (flag == 1) {
                quadrants[0]++;
                System.out.println("first quadrants");
            }
            else if (flag == 2) {
                quadrants[1]++;
                System.out.println("second quadrants");
            }
            else if (flag == 3) {
                quadrants[2]++;
                System.out.println("third quadrants");
            }
            else if (flag == 4) {
                quadrants[3]++;
                System.out.println("fourth quadrants");
            }
        }
        for (int i=0; i<4; i++) {
            System.out.println("Number of coordinates on " + (i+1)+"th quadrants is "+ quadrants[i]);
        }
    }
    void k05() {
        k05_UserInfo k05class = new k05_UserInfo();
        System.out.print("Enter id, password > ");
        k05class.input();
        System.out.println("================================================");
        System.out.println("Registered students list are as follows");
        System.out.println("------------------------------------------------");
        System.out.println("num\tname\tpassword");
        k05class.print(1);
    }
    void k06() {
        Scanner s = new Scanner(System.in);
        int num;
        System.out.print("Enter a number of students > ");
        num = s.nextInt();
        k05_UserInfo k06class[] = new k05_UserInfo[num];
        for (int i=0; i<num; i++) {
            System.out.print("Enter id, password of "+(i+1)+"th student > ");
            k06class[i] = new k05_UserInfo();
            k06class[i].input();
        }
        System.out.println("================================================");
        System.out.println("Registered "+num+" students list are as follows");
        System.out.println("------------------------------------------------");
        System.out.println("num\tname\tpassword");
        for (int i=0; i<num; i++)
            k06class[i].print(i+1);
    }

    void k07() {
        Scanner s = new Scanner(System.in);
        int num;
        System.out.print("Enter a number of students > ");
        num = s.nextInt();
        k07_Student k07class[] = new k07_Student[num];
        for (int i=0; i<num; i++) {
            System.out.print("Enter score of korean, english, math of "+(i+1)+"th student > ");
            k07class[i] = new k07_Student();
            k07class[i].input();
        }
        System.out.println("================================================");
        System.out.println("Registered "+num+" students list are as follows");
        System.out.println("------------------------------------------------");
        System.out.println("num\tKorean\tEnglish\tMath\tTotal\tAverage\tGrade");
        for (int i=0; i<num; i++)
            k07class[i].print(i+1);
    }
}

class k01_MenuPan {
    String name;
    String origin;
    int price;
    int num;

    void input() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter number, name, origin, price > ");
        this.num = s.nextInt();
        this.name = s.next();
        this.origin = s.next();
        this.price = s.nextInt();
    }

    void print() {
        System.out.println(this.num + "\t" + this.name + "\t\t" + this.origin + "\t\t" + this.price);
    }
}

class k03_Point {
    double x, y;

    k03_Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    int get_area(double x, double y) {
        int quadrants=0;
        if (x > 0 && y > 0) quadrants = 1;
        else if (x < 0 && y > 0) quadrants = 2;
        else if (x < 0 && y < 0) quadrants = 3;
        else if (x > 0 && y < 0) quadrants = 4;
        return quadrants;
    }
}

class k05_UserInfo {
    String id;
    String password;

    void input() {
        Scanner s = new Scanner(System.in);
        id = s.next();
        password = s.next();
    }
    void print(int index) {
        System.out.println(index+"\t"+id+"\t"+password);
    }
}

class k07_Student {
    int score[];
    int total;
    double average;
    String grade;
    void input() {
        Scanner s = new Scanner(System.in);
        score = new int[3];
        score[0] = s.nextInt();
        score[1] = s.nextInt();
        score[2] = s.nextInt();
        total = score[0] + score[1] + score[2]; 
        average = (double)total / 3;
        if (average < 60)
            grade = "F";
        else if (average < 65)
            grade = "D";
        else if (average < 70)
            grade = "D+";
        else if (average < 75)
            grade = "C";
        else if (average < 80)
            grade = "C+";
        else if (average < 85)
            grade = "B";
        else if (average < 90)
            grade = "B+";
        else if (average < 95)
            grade = "A";
        else
            grade = "A+";
    }
    void print(int index) {
        System.out.println(index+"\t"+score[0]+"\t"+score[1]+"\t"+score[2]+"\t"+total+"\t"+average+"\t"+grade);
    }
}