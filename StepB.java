import java.util.Scanner;

class StepB {
  public static void main(String[] args) {
    StepB stepB = new StepB();
    stepB.b06();
  }
  void b01(){
  	Scanner s = new Scanner(System.in);
  	System.out.print("Enter a birth year > ");
  	int birthyear = s.nextInt();
    int age = 2019 - birthyear + 1;

    if (age < 20)
        System.out.println("You are not adult");
    else 
        System.out.println("You are adult");
  }
  void b02(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter temperature > ");
    double input_degree = s.nextDouble();
    System.out.print("Enter type of temperature('C' for Celsius, 'F' for Fahrenheit)");
    char type = s.next().charAt(0);
    double output_degree;
    if (type == 'C' || type == 'c') {
        output_degree = input_degree * 1.8 + 32;
        System.out.println("Fahrenheit temperature is "+output_degree);
    } else if (type == 'F' || type == 'f') {
        output_degree = (input_degree - 32) / 1.8;
        System.out.println("Celsius temperature is "+output_degree);
    }
  }
  void b03(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter width of Rectangle > ");
    int width = s.nextInt();
    System.out.print("Enter height of Rectangle > ");
    int height = s.nextInt();
    int area = width * height;
    System.out.println("Area of Rectangle is "+area+" and");
    if (width == height) 
        System.out.println("it is square");
    else
        System.out.println("it is not square");
  }
  void b04(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter area of Apartment(m^2) > ");
    double m2_area = s.nextDouble();
    double pyung_area = m2_area / 3.305;
    System.out.printf("Area of Apartment(Æò¼ö) %.1f\n",pyung_area);
    if (pyung_area >= 30)
        System.out.println("It is big apartment");
    else 
        System.out.println("It is small apartment");
  }
  void b05(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter number of days > ");
    int days = s.nextInt();
    int seconds = days * 24 * 60 * 60;
    System.out.println("Total seconds is "+seconds);
    if (seconds > 1000000)
        System.out.println("It includes million seconds "+seconds/1000000+" times");
  }
  void b06(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter points of Korean > ");
    int kor = s.nextInt();
    System.out.print("Enter points of English > ");
    int eng = s.nextInt();
    System.out.print("Enter points of Math > ");
    int math = s.nextInt();
    int total = kor + eng + math;
    double average = (double)total / 3;
    System.out.println("Total point is "+total);
    System.out.printf("The average  is %.1f\n",average);
    if (kor >= 90)
        System.out.println("Korean grade is outstanding!");
    if (eng >= 90)
        System.out.println("English grade is outstanding!");
    if (math >= 90)
        System.out.println("Math grade is outstanding!");
  }
  void b07(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter file size as megabytes > ");
    int megabytes = s.nextInt();
    long bytes = (long)megabytes * 1024* 1024;
    System.out.print("Enter 'Y' if USB type is 2.0 or 'N' > ");
    char usb2 = s.next().charAt(0);
    if (usb2 == 'Y') {
      System.out.println("File transfer time is "+bytes/60000000);
    }
    else if (usb2 == 'N') {
      System.out.println("File transfer time is "+bytes/1500000);
    }
  }
  void b08(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter first number ");
    int num1 = s.nextInt();
    System.out.print("Enter second number ");
    int num2 = s.nextInt();
    System.out.print("Enter third number ");
    int num3 = s.nextInt();
    if (num1 == num2 || num2 == num3 || num1 == num3)
      System.out.println("Satisfies the first condition");
    if ((num1 > 50 && num2 > 50) ||
        (num1 > 50 && num3 > 50) ||
        (num2 > 50 && num3 > 50))
      System.out.println("Satisfies the second condition");
    if ((num1 + num2 == num3) ||
        (num1 + num3 == num2) ||
        (num2 + num3 == num1))
      System.out.println("Satisfies the third condition");
    if ((num1 % num2 == 0) ||
        (num1 % num3 == 0) ||
        (num2 % num1 == 0) ||
        (num2 % num3 == 0) ||
        (num3 % num1 == 0) ||
        (num3 % num2 == 0))
      System.out.println("Satisfies the fourth condition");
  }
  void b09() {
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter height(cm) ");
    double height = (double)s.nextInt()/100;
    System.out.print("Enter weight(kg) ");
    int weight = s.nextInt();
    int bmi = (int)(weight / (height * height));
    if (bmi >= 25)
      System.out.println("You are obesity");
    else
      System.out.println("You are not obesity");
  }
}