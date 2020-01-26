/**
자바 콜렉션 프레임워크는 객체 그룹을 다룰 때 사용되며 이 프레임워크에 정의된 클래스들은 재사용가능한 데이터구조들이다. 그리고 이 데이터구조들은 정렬이나 검색 같은 알고리즘도 제공한다. 콜랙션 프레임워크에 익숙해지면 프로그래밍을 할 때 저레벨 수준의 구체적인 코드를 작성하지 않아도 되서 편리하다. 

Collection 인터페이스가 콜렉션 프레임워크의 모든 클래스들의 조상 클래스가 되고 모든 콜렉션 프레임워크의 클래스들의 기본동작을 정의한다. Collection 인터페이스는 add, clear, remove, contains, isEmpty, size, toArray 같은 메소드들이 정의되어 있는데 콜렉션 프레임워크의 클래스들은 이 메소드들을 구현해야 한다. 
 */

import java.util.Scanner;
import java.util.*;

class StepN {
    public static void main(String[] args) {
        StepN stepN = new StepN();
        stepN.n06();
    }

    void n01() {
        // HashSet
        // 문제설명 
        /**
HashSet 클래스는 객체를 집합으로 다룰 때 사용된다. 따라서 중복 요소를 허용하지 않는다. 이름이 HashSet 인 이유는 집합을 구현할 때 빠르고 효율적인 hash table 알고리즘이 사용되었기 때문이다. 

HashSet 의 Java API(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashSet.html) 를 참조하여 HashSet 을 사용해보자. API 를 참조하는 능력을 기르는 것이 진짜 프로그래머가 되는 가장 빠른 길이다.  

HashSet 을 사용하여 정수형 데이터의 사용자 입력을 받고 -1 을 받으면 입력을 중단하라.
그리고 1 을 제거한 후 HashSet 에 저장되어 있는 데이터를 출력하라. 
         */
        // In 
        /*
        1 8 3 2 4 9 4 8 3 3 1 5 2 2 9 9 1 7 5 5 6 -1
        */
        // Out
        /*
        2 3 4 5 6 7 8 9 
        */
        Scanner s = new Scanner(System.in);
        HashSet<Integer> intSet = new HashSet<Integer>();
        while (true) {
            int tmp = s.nextInt();
            if (tmp < 0) 
                break;
            intSet.add(tmp);
        }
        intSet.remove(1);
        for (Integer n : intSet) 
            System.out.print(n.intValue()+" ");
        System.out.println();
    }

    void n02() {
        // HashMap  
        // 문제설명 
        /**
Map 인터페이스는 객체를 순서쌍으로 다룰 때 사용된다. 순서쌍은 키와 값으로 되어 있는 자료구조이다. 가령 키는 학번이 될 수 있고 값은 학생정보가 될 수 있다. HashMap 은 Map 인터페이스를 구현한 클래스이고 hash table 알고리즘을 사용하기 때문에 HashMap 이라 부른다. 

HashMap 의 Java API(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html) 를 참조하여 HashMap 을 사용해보자.

세상에서 가장 높은 산들의 이름과 높이를 사용자가 콤마로 구분하여 입력 한다. 사용자 입력이 끝나면 eof 를 전달한다.

Input:
Everest,8848
K2,8611
Annapurna,8091
Makalu,8463
eof

이 입력을 HashMap 에 Key, Value 형태(String, Integer)로 저장하고 다음과 같이 출력하라. 

Output:
Everest : 8848 m
Annapurna : 8091 m
K2 : 8611 m
Makalu : 8463 m
         */
        // In
        /* 
Everest,8848
K2,8611
Annapurna,8091
Makalu,8463
eof
        */
        // Out
        /*
Everest : 8848 m
Annapurna : 8091 m
K2 : 8611 m
Makalu : 8463 m
        */
        Scanner s = new Scanner(System.in);
        HashMap<String, Integer> mountains = new HashMap<String, Integer>();
        while (true) {
            String line = s.nextLine();
            if (line.equals("eof"))
                break;
            String[] kv = line.split(",");
            mountains.put(kv[0], new Integer(kv[1]));
        }
        for (String k : mountains.keySet())
            System.out.println(k + " : " + mountains.get(k).intValue() + " m");
    }

    void n03() {
        // TreeMap 
        // 문제설명 
        /**
TreeMap 은 HashMap 과 달리 정렬을 해준다. 

세상에서 가장 높은 산들의 이름과 높이를 사용자가 콤마로 구분하여 입력 한다. 사용자 입력이 끝나면 eof 를 전달한다.

Input:
Everest,8848
K2,8611
Annapurna,8091
Makalu,8463
eof

이 입력을 TreeMap 에 Key, Value 형태(String, Double)로 저장하고 다음과 같이 출력하라. 

Output:
Annapurna : 8091.0
Everest : 8848.0
K2 : 8611.0
Makalu : 8463.0
         */
        // In
        /* 
Everest,8848
K2,8611
Annapurna,8091
Makalu,8463
eof
        */
        // Out
        /*
Annapurna : 8091.0 m
Everest : 8848.0 m
K2 : 8611.0 m
Makalu : 8463.0 m
        */
        TreeMap<String, Double> tm = new TreeMap<String, Double>();
        Scanner s = new Scanner(System.in);
        while (true) {
            String line = s.nextLine();
            if (line.equals("eof"))
                break;
            String[] kv = line.split(",");
            tm.put(kv[0], new Double(kv[1]));
        }
        for (String k : tm.keySet())
            System.out.println(k + " : " + tm.get(k).doubleValue() + " m");
    }

    void n04() {
        // LinkedList 
        // 문제설명 
        /*
LinkedList 의 Java API(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html) 를 참조하여 LinkedList 을 사용해보자.

정수형 데이터 사용자 입력을 받아 LinkedList 에 저장하라. 사용자 입력은 -1 로 끝난다.
맨 처음 데이터를 출력 후 삭제하고 맨 마지막 데이터를 출력 후 삭제하라. 그리고 이것을 LinkedList 가 텅 빌 때까지 반복하라.

Input:
9 3 4 5 6 7 8 1 2 -1
Output:
9 2 3 1 4 8 5 7 6 
Input:
1 2 3 4 5 6 7 8 -1
Output:
1 8 2 7 3 6 4 5 
        */
        // In
        /*
9 3 4 5 6 7 8 1 2 -1
        */
        // Out
        /*
9 2 3 1 4 8 5 7 6 
        */
        // In
        /*
1 2 3 4 5 6 7 8 -1
        */
        // Out
        /*
1 8 2 7 3 6 4 5 
        */
        LinkedList<Integer> ll = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        while(true) {
            int tmp = s.nextInt();
            if (tmp == -1)
                break;
            ll.add(new Integer(tmp));
        }
        for (int i=0; !ll.isEmpty(); i++) {
            if (i%2==0) {
                System.out.print(ll.getFirst() + " ");
                ll.removeFirst();
            }
            else {
                System.out.print(ll.getLast() + " ");
                ll.removeLast();
            }
        }
        System.out.println();
    }
    void n05() {
        // Vector 
        // 문제설명 
        /*
Vector 의 Java API(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Vector.html) 를 참조하여 Vector 을 사용해보자.

정수형 데이터 사용자 입력을 받아 Vector 에 저장하라. 사용자 입력은 -1 로 끝난다.
그리고 입력받은 정수형 데이터를 Character 나 String 으로 변환하여 출력하라. 

Input:
72 101 108 108 111 32 87 111 114 108 100 33 -1
Output:
Hello World!
Input:
73 116 101 114 97 116 111 114 32 105 116 32 61 32 118 46 105 116 101 114 97 116 111 114 40 41 59 10 119 104 105 108 101 40 105 116 46 104 97 115 78 101 120 116 40 41 41 32 10 32 32 32 32 83 121 115 116 101 109 46 111 117 116 46 112 114 105 110 116 40 105 116 46 110 101 120 116 40 41 41 59 -1
Output:
Iterator it = v.iterator();
while(it.hasNext()) 
    System.out.print(it.next());
        */
        // In
        /*
72 101 108 108 111 32 87 111 114 108 100 33 -1
        */
        // Out
        /*
Hello World!
        */
        // In
        /*
73 116 101 114 97 116 111 114 32 105 116 32 61 32 118 46 105 116 101 114 97 116 111 114 40 41 59 10 119 104 105 108 101 40 105 116 46 104 97 115 78 101 120 116 40 41 41 32 10 32 32 32 32 83 121 115 116 101 109 46 111 117 116 46 112 114 105 110 116 40 105 116 46 110 101 120 116 40 41 41 59 -1
        */
        // Out
        /*
Iterator it = v.iterator();
while(it.hasNext()) 
    System.out.print(it.next());
        */
        Scanner s = new Scanner(System.in);
        Vector<Character> v = new Vector<Character>();
        while(true) {
            int tmp = s.nextInt();
            if (tmp == -1)
                break;
            v.addElement(new Character((char)tmp));
        }
        Iterator it = v.iterator();
        while(it.hasNext()) 
            System.out.print(it.next());
        System.out.println();
    }

    void n06() {
        // Stack 
        // 문제설명 
        /*
Stack 은 LIFO(last-in-first-out) 의 원칙을 지키는 자료구조이다. Stack 자료구조에 가장 처음 저장된 데이터는 가장 나중에 꺼내게 되고, 가장 마지막에 저장된 데이터를 가장 먼저 꺼낼 수 있다. 

Stack 의 Java API(https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Stack.html) 를 참조하여 Stack 을 사용해보자.

문자열을 입력 받아 Stack 에 저장하라. 그리고 입력받은 데이터를 거꾸로 출력하라. 

Input:
abcd
Output:
dcba
Input:
Hello world!
Output:
!dlrow olleH
        */
        // In
        /*
abcd
        */
        // Out
        /*
dcba
        */
        // In
        /*
Hello world!
        */
        // Out
        /*
!dlrow olleH
        */
        Stack<Character> st = new Stack<Character>();
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        for(int i=0; i<input.length(); i++) 
            st.push(input.charAt(i));
        while(!st.empty()) 
            System.out.print(st.pop());
        System.out.println();
    }
    void n07() {
        // LinkedList 
        // 문제설명 
        /*
문자열을 입력을 받아 char 로 분해하여 LinkedList 에 저장하라. 
입력받은 데이터가 거꾸로 해도 똑같은 데이터인지 검증하라. 만약 똑같으면 데이터를 문자열로 출력해주고 똑같지 않으면 "It is not Palindrome!" 을 출력하라. LinkedList 의 getFirst, getLast 메소드를 사용하라. 

Input:
abcba
Output:
abcba
Input:
Hello World!
Output:
It is not Palindrome!
        */
        // In
        /*
abcba
        */
        // Out
        /*
abcba
        */
        // In
        /*
Hello World!
        */
        // Out
        /*
It is not Palindrome!
        */
        LinkedList<Character> ll = new LinkedList<Character>();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        for (int i=0; i<str.length(); i++) {
            ll.add(str.charAt(i));
        }
        boolean isPalindrome = true;
        for (int i=0; !ll.isEmpty() && ll.size() > 1; i++) {
            if (ll.getFirst() != ll.getLast()) {
                isPalindrome = false;
                break;
            }
            ll.removeFirst();
            ll.removeLast();
        }
        if (isPalindrome) 
            System.out.println(str);
        else
            System.out.println("It is not Palindrome!");
    }
}
