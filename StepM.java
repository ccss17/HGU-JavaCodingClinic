import java.util.Scanner;
import java.io.*;

class StepM {
    public static void main(String[] args) {
        StepM stepM = new StepM();
        stepM.m07();
    }

    void m01() {
        // 단순한 데이터를 쓰고 읽는 문제
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }
        outputStream.println("This is line 1");
        outputStream.println("This is line 2");
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
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(filename);
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }

        Scanner s = new Scanner(System.in);
        for (int i = 0; i < 3; i++)
            outputStream.println(s.nextLine());
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
        createFile("This is line 1\n" + "This is line 2");
        String filename = "out.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(new FileOutputStream(filename, true));
        } catch (FileNotFoundException e) {
            System.err.println("Error opening the file " + filename);
            System.exit(1);
        }

        outputStream.println("This is line 1");
        outputStream.println("This is line 2");
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