import java.util.Scanner;

class StepA {
  public static void main(String[] args) {
    StepA stepA = new StepA();
    stepA.a07();
  }

  void a01() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter a birth year > ");
    int birthyear = s.nextInt();
    int age = 2019 - birthyear + 1;
    System.out.println("You are " + age + " years old.");
  }

  void a02() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter Celsius temperature > ");
    double c_degree = s.nextDouble();
    double f_degree = c_degree * 1.8 + 32;
    System.out.println("Fahrenheit temperature is " + f_degree);
  }

  void a03() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter width of Rectangle > ");
    int width = s.nextInt();
    System.out.print("Enter height of Rectangle > ");
    int height = s.nextInt();
    int area = width * height;
    System.out.println("Area of Rectangle is " + area);
  }

  void a04() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter area of Apartment(m^2) > ");
    double m2_area = s.nextDouble();
    double pyung_area = m2_area / 3.305;
    System.out.printf("Area of Apartment(평수) %.1f\n", pyung_area);
  }

  void a05() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter number of days > ");
    int days = s.nextInt();
    int seconds = days * 24 * 60 * 60;
    System.out.println("Total seconds is " + seconds);
  }

  void a06() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter points of Korean > ");
    int kor = s.nextInt();
    System.out.print("Enter points of English > ");
    int eng = s.nextInt();
    System.out.print("Enter points of Math > ");
    int math = s.nextInt();
    int total = kor + eng + math;
    double average = (double) total / 3;
    System.out.println("Total point is " + total);
    System.out.printf("The average  is %.1f\n", average);
  }

  void a07() {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter file size as gigabytes > ");
    int gigabytes = s.nextInt();
    int megabytes = gigabytes * 1024;
    int kilobytes = megabytes * 1024;
    long bytes = (long) kilobytes * 1024;
    System.out.println("Your file size is");
    System.out.println(megabytes + " MB");
    System.out.println(kilobytes + " KB");
    System.out.println(bytes + " B");
  }
}