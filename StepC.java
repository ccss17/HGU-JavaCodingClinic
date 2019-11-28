import java.util.Scanner;

class StepC {
  public static void main(String[] args) {
    StepC stepC = new StepC();
    stepC.c11();
  }
  void c01(){
  	Scanner s = new Scanner(System.in);
  	System.out.print("Enter a birth year > ");
  	int birthyear = s.nextInt();
    int age = 2019 - birthyear + 1;
    if (age < 7)
        System.out.println("You are baby");
    else if (age < 13)
        System.out.println("You are child");
    else if (age < 20)
        System.out.println("You are teenage");
    else if (age < 30)
        System.out.println("You are youth");
    else if (age < 60)
        System.out.println("You are middle-age");
    else 
        System.out.println("You are old age");
  }
  void c02() {
  	Scanner s = new Scanner(System.in);
  	System.out.print("Enter water temperature > ");
  	double input_degree = s.nextDouble();
    if (input_degree < 0)
        System.out.println("Invalid input!");
    else if (input_degree < 25)
        System.out.println("It's cold water");
    else if (input_degree < 40)
        System.out.println("It's warm water");
    else if (input_degree < 80)
        System.out.println("It's hot water");
    else 
        System.out.println("It's boiling water");
  }
  void c03() {
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter width of Rectangle > ");
    int width = s.nextInt();
    System.out.print("Enter height of Rectangle > ");
    int height = s.nextInt();
    if (width == height) 
        System.out.println("it is square");
    else if (width >= height * 2)
        System.out.println("It is an oblong rectangle from side to side.");
    else if (height >= width * 2)
        System.out.println("It is an oblong rectangle from top to bottom.");
    else if (width > height )
        System.out.println("It is a horizontal rectangle.");
    else if (height > width)
        System.out.println("It is a vertical rectangle.");
  }
  void c04(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter area of Apartment(m^2) > ");
    double m2_area = s.nextDouble();
    double pyung_area = m2_area / 3.305;
    System.out.printf("Area of Apartment(pyung) %.1f\n",pyung_area);
    if (pyung_area < 15)
        System.out.println("It is small-sized apartment");
    else if (pyung_area < 30)
        System.out.println("It is small and medium-sized apartment");
    else if (pyung_area < 50)
        System.out.println("It is medium-sized apartment");
    else 
        System.out.println("It is big-sized apartment");
  }
  void c05(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter a month > ");
    int month = s.nextInt();
    System.out.print("Enter a day > ");
    int day = s.nextInt();
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
    System.out.println("This date is "+day_count+"th of the year");
  }
  void c06(){
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
    if (average >= 90)
        System.out.println("Your grade is A");
    else if(average >= 80)
        System.out.println("Your grade is B");
    else if(average >= 70)
        System.out.println("Your grade is C");
    else if(average >= 60)
        System.out.println("Your grade is D");
    else
        System.out.println("Your grade is F");
  }
  void c07() {
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter file size as megabytes > ");
    int megabytes = s.nextInt();
    long bytes = (long)megabytes * 1024* 1024;
    System.out.print("Enter transfer method (1. WiFi, 2. Bluetooth, 3. LTE, 4. USE)");
    byte kind = (byte)s.next().charAt(0);
    double time = 0;
    if (kind == '1') 
      time = (double)bytes/1500000;
    else if (kind == '2') 
      time = (double)bytes/300000;
    else if (kind == '3') 
      time = (double)bytes/1000000;
    else if (kind == '4') 
      time = (double)bytes/60000000;
    System.out.printf("File transfer time is %.1f",time);
  }
  void c08(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter first number ");
    int num1 = s.nextInt();
    System.out.print("Enter second number ");
    int num2 = s.nextInt();
    System.out.print("Enter third number ");
    int num3 = s.nextInt();
    int max_num = Integer.MIN_VALUE, min_num = Integer.MAX_VALUE;
    if (max_num < num1)
    max_num = num1;
    if (max_num < num2)
    max_num = num2;
    if (max_num < num3)
    max_num = num3;

    if (min_num > num1)
    min_num = num1;
    if (min_num > num2)
    min_num = num2;
    if (min_num > num3)
    min_num = num3;
    System.out.println("Max number is "+max_num+", Min number is "+min_num);
  }
  void c09(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter your income ");
    int income = s.nextInt();
    int tax = 0;
    if (income < 10000000)
        tax = (int)(income * 0.095);
    else if (income < 40000000)
        tax = (int)(income * 0.19);
    else if (income < 80000000)
        tax = (int)(income * 0.28);
    else 
        tax = (int)(income * 0.37);

    System.out.println("Income tax on salary is  "+tax);
  }
  void c10(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter number 1 ");
    int num1 = s.nextInt();
    System.out.print("Enter number 2 ");
    int num2 = s.nextInt();
    int result=0;

    System.out.print("Enter a math symbol('+', '-', '*', '/') ");
    String operator = s.next();
    if (operator.compareTo("+") == 0)
        result = num1 + num2;
    else if (operator.compareTo("-") == 0)
        result = num1 - num2;
    else if (operator.compareTo("*") == 0)
        result = num1 * num2;
    else if (operator.compareTo("/") == 0)
        result = num1 / num2;
    System.out.println("Result is "+result);
  }
  void c11(){
  	Scanner s = new Scanner(System.in);
    System.out.print("Enter a year ");
    int year = s.nextInt();

    if (year % 4 == 0) 
        if (year % 100 == 0) 
            if (year % 400 == 0)
                System.out.println("This year is leap year");
            else
                System.out.println("This year is not leap year");
        else 
            System.out.println("This year is leap year");
    else
        System.out.println("This year is not leap year");
  }
}
