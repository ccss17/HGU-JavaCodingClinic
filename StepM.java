import java.util.Scanner;
import java.io.*;

class StepM {
    public static void main(String[] args) {
        StepM stepM = new StepM();
        stepM.m06();
    }

    void m01() {
        // 단순한 데이터를 쓰고 읽는 문제
        // 문제설명 
        /**
"out.txt" 라는 파일에 문자열 "Hello World" 을 쓰고 저장하라.
그리고 다시 파일을 읽어서 출력하라 
         */
        // In 
        // (null)
        // Out
        // Hello World
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        outputStream.println("Hello World");
        outputStream.close();

        // 읽기
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        while (inputStream.hasNextLine()) {
            System.out.println(inputStream.nextLine());
        }
        inputStream.close();
    }

    void m02() {
        // 사용자 입력을 받아서 데이터를 쓰고 읽는 문제
        // 문제설명 
        /**
"out.txt" 라는 파일에 사용자의 입력을 받아서 저장하라. 
사용자가 "eof" 를 입력하면 입력을 중단하라. 
그리고 다시 파일을 읽어서 출력하라.
         */
        // In 
        /*
Hello World!
Hello World!
Hello World!
eof
        */
        // Out
        /*
Enter a string and 'eof' to indicate the end of string.
Hello World!
Hello World!
Hello World!
        */
        // In 
        /*
ABCDEFG
HIJKLMN
OPQR
eof
        */
        // Out
        /*
Enter a string and 'eof' to indicate the end of string.
ABCDEFG
HIJKLMN
OPQR
        */
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a string and 'eof' to indicate the end of string.");
        while (true) {
            String line = s.nextLine();
            if (line.equals("eof"))
                break;
            outputStream.println(s.nextLine());
        }
        outputStream.close();

        // 읽기
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        while (inputStream.hasNextLine()) {
            System.out.println(inputStream.nextLine());
        }
        inputStream.close();
    }

    void createFile(String content) {
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        outputStream.println(content);
        outputStream.close();
    }

    void m03() {
        // 이미 존재하는 파일에 데이터를 덧붙히는 방법
        // 문제설명 
        /**
"out.txt" 라는 파일이 다음과 같은 내용으로 저장되어 있다. 

This is line 1
This is line 2

이 파일의 내용에 다음의 내용을 덧붙히고 전체 파일 내용을 출력하라. 

This is line 3
This is line 4
         */
        // In 
        /*
        */
        // Out
        /*
This is line 1
This is line 2
This is line 3
This is line 4
        */
        createFile("This is line 1\n" + "This is line 2");
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(filename, true));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }

        outputStream.println("This is line 3");
        outputStream.println("This is line 4");
        outputStream.close();
        // 읽기
        Scanner inputStream = null;
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        while (inputStream.hasNextLine()) {
            System.out.println(inputStream.nextLine());
        }
        inputStream.close();
    }

    void m04() {
        // CSV(Comma-Separated Values) 파일을 읽고 파싱하기
        // 문제설명 
        /**
"out.txt" 라는 파일이 다음과 같은 내용으로 저장되어 있다. 각각 상품번호, 남은 수량, 가격(원), 상품명을 뜻한다. 

1,100,1500,Cola
2,200,400,Candy
3,80,5000,Sandwich

이처럼 콤마(,) 로 구분된 파일을 CSV(Comma-Separated Values) 파일이라 한다. 
이 파일을 읽고 다음과 같은 형식으로 출력하라. 

[1] Cola 1500 Won (100 left)
[2] Candy 400 Won (200 left)
[3] Sandwich 5000 Won (80 left)
         */
        // In 
        /*
        */
        // Out
        /*
[1] Cola 1500 Won (100 left)
[2] Candy 400 Won (200 left)
[3] Sandwich 5000 Won (80 left)
        */
        createFile(
                // 번호, 수량, 가격, 제품명
                "1,100,1500,Cola\n" + "2,200,400,Candy\n" + "3,80,5000,Sandwich");
        // 읽기
        Scanner inputStream = null;
        String filename = "out.txt";
        try {
            inputStream = new Scanner(new File(filename));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        while (inputStream.hasNextLine()) {
            String[] items = inputStream.nextLine().split(",");
            System.out.println('[' + items[0] + "] " + items[3] + ' ' + items[2] + " Won (" + items[1] + " left)");
        }
        inputStream.close();
    }

    void m05() {
        // 바이너리 파일 입출력 
        // 문제설명 
        /**
"number.dat" 라는 파일에 텍스트 형식이 아니라 바이너리 형식으로 다음과 같은 내용을 써라. 

One year is 365 days.
One week is 7 days.

저장된 파일은 바이너리 형식이기 때문에 일반적인 텍스트 에디터로 읽을 수 없다. 
바이너리 파일을 읽고 쓰기 위해서는 ObjectOutputStream 를 사용해야 한다. 
파일을 다시 읽어서 출력하라.

One year is 365 days.
One week is 7 days
         */
        // In 
        /*
        */
        // Out
        /*
One year is 365 days.
One week is 7 days.
        */
        String filename = "numbers.dat";
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename));

            outputStream.writeUTF("One year is ");
            outputStream.writeInt(365);
            outputStream.writeUTF(" days.");
            outputStream.writeUTF("One week is ");
            outputStream.writeInt(7);
            outputStream.writeUTF(" days.");
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename));
            System.out.println(inputStream.readUTF() + inputStream.readInt() + inputStream.readUTF());
            System.out.println(inputStream.readUTF() + inputStream.readInt() + inputStream.readUTF());
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void m06() {
        // 인스턴스 객체를 파일로 읽고 쓰기 
        // 문제설명 
        /**
Fruit 클래스는 과일상품의 번호와 이름, 가격을 저장할 수 있는 데이터 클래스이다.
이 클래스의 인스턴스를 다음과 같이 3개 생성하자.

new Fruit(1, "apple", 2000);
new Fruit(2, "cherry", 4000);
new Fruit(3, "melon", 5000);

그러면 "Fruits.dat" 파일에 생성된 3개의 인스턴스를 쓰자. 
ObjectOutputStream 클래스의 writeObject 메소드를 사용하면 생성된 인스턴스를 파일에 쓸 수 있다. 
그리고 다시 "Fruits.dat" 을 읽고 다음과 같은 형식으로 출력하라. 
읽을 때 readObject 메소드를 사용해야 하는데 Fruit 클래스로 형변환을 해주어야 한다. 

[1] apple : 2000.0 Won
[2] cherry : 4000.0 Won
[3] melon : 5000.0 Won
         */
        // In 
        /*
        */
        // Out
        /*
[1] apple : 2000.0 Won
[2] cherry : 4000.0 Won
[3] melon : 5000.0 Won
        */
        String filename = "Fruits.dat";
        Fruit fruit1 = new Fruit(1, "apple", 2000);
        Fruit fruit2 = new Fruit(2, "cherry", 4000);
        Fruit fruit3 = new Fruit(3, "melon", 5000);
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream.writeObject(fruit1);
            outputStream.writeObject(fruit2);
            outputStream.writeObject(fruit3);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream inputStream = null;
        Fruit readFruit1;
        Fruit readFruit2;
        Fruit readFruit3;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            readFruit1 = (Fruit)inputStream.readObject();
            readFruit2 = (Fruit)inputStream.readObject();
            readFruit3 = (Fruit)inputStream.readObject();
            inputStream.close();
            System.out.println(readFruit1);
            System.out.println(readFruit2);
            System.out.println(readFruit3);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    void m07() {
        // 인스턴스 객체를 파일로 읽고 쓰기 
        // 문제설명 
        /**
Fruit 클래스는 과일상품의 번호와 이름, 가격을 저장할 수 있는 데이터 클래스이다.
이 클래스의 배열을 길이 3 으로 생성하고 다음 3 개의 인스턴스를 차례대로 배열에 대입하라.  

new Fruit(1, "apple", 2000);
new Fruit(2, "cherry", 4000);
new Fruit(3, "melon", 5000);

그리고 "Fruits.dat" 파일에 클래스 배열을 써라. 
다시 "Fruits.dat" 을 읽고 다음과 같은 형식으로 출력하라. 
이때 readObject 메소드를 사용해야 하는데 Fruit[] 로 형변환을 해주어야 한다. 

[1] apple : 2000.0 Won
[2] cherry : 4000.0 Won
[3] melon : 5000.0 Won
         */
        // In 
        /*
        */
        // Out
        /*
[1] apple : 2000.0 Won
[2] cherry : 4000.0 Won
[3] melon : 5000.0 Won
        */
        String filename = "FruitsArray.dat";
        Fruit[] fruits = new Fruit[3];
        fruits[0] = new Fruit(1, "apple", 2000);
        fruits[1] = new Fruit(2, "cherry", 4000);
        fruits[2] = new Fruit(3, "melon", 5000);
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream.writeObject(fruits);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream inputStream = null;
        Fruit[] readFruits;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename));
            readFruits = (Fruit[])inputStream.readObject();
            inputStream.close();
            for (int i=0; i<readFruits.length; i++)
                System.out.println(readFruits[i]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Fruit implements Serializable
{
    private String name;
    private double price;
    private int id;

    public Fruit(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString()
    {
        return ("["+id+"]"+" "+name+" : "+price+" Won");
    }
}