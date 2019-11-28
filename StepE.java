import java.util.Scanner;

class StepE {
    public static void main(String[] args) {
        StepE stepE = new StepE();
        stepE.e06();
    }

    void e01() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a length of rectangle > ");
        int length = s.nextInt();
        for(int i=0; i<length; i++) {
            for(int j=0; j<length; j++)
            System.out.print("# ");
            System.out.println("");
        }
    }
    void e02() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a height of right triangle and black > ");
        int height = s.nextInt();
        int blank = s.nextInt();
        for(int i=1; i<=height; i++) {
            for(int k=0; k<blank; k++) System.out.print(" ");
            for (int j=height; j>0; j--) {
                if (j <= i)
                System.out.print("*");
                else
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    void e03() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a height of right triangle and black > ");
        int height = s.nextInt();
        for(int i=1; i<=height; i++) {
            for (int j=height; j>=0; j--) {
                if (j!=0)
                    if (j <= i)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                else{
                    for (int k=0; k<i-1; k++)
                        System.out.print("*");
                }
            }
            System.out.println("");
        }
    }
    void e04() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a type of gugudan (1: odd, 2: even) > ");
        int mode = s.nextInt();

        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (mode == 1) {
                    if (i%2 == 1) {
                        System.out.print(i + " X " + j + " = " + i * j + "\t");
                        if (j % 3 == 0) System.out.println();
                    }
                }
                else if (mode == 2) {
                    if (i%2 == 0) {
                        System.out.print(i + " X " + j + " = " + i * j + "\t");
                        if (j % 3 == 0) System.out.println();
                    }
                }
            }
            if (i%2 == 1) System.out.println();
        }
    }
    void e05() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a type of gugudan (1: odd, 2: even) > ");
        int mode = s.nextInt();
        System.out.print("Enter a numbers of column > ");
        int column = s.nextInt();

        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (mode == 1) {
                    if (i%2 == 1) {
                        System.out.print(i + " X " + j + " = " + i * j + "\t");
                        if (j % column == 0) System.out.println();
                    }
                }
                else if (mode == 2) {
                    if (i%2 == 0) {
                        System.out.print(i + " X " + j + " = " + i * j + "\t");
                        if (j % column == 0) System.out.println();
                    }
                }
            }
            if (i%2 == 1) System.out.println();
        }
    }
    void e06() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter a rows and columns > ");
        int rows = s.nextInt();
        int columns = s.nextInt();

        for (int i=1; i<=columns; i++) {
            for (int j=1; j<=rows; j++) {
                System.out.printf("%3d ", i*j);
            }
            System.out.println();
        }
    }
}
