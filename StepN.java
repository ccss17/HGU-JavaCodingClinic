// 현재 102 문제 -> 120 문제까지 18 문제 
// 파일 IO : 7문제 
// 자바 데이터셋 (HashSet 같은) 연습 문제 
// 하드 알고리즘 
// StepA 에 next vs nextLine 의 차이를 이해할 수 있는 문제 + next().chatAt(0) 나 또 다른 방법으로 문자 하나를 입력받을 수 있는 방법을 이해할 수 있는 문제 

// https://www.tutorialspoint.com/java/java_data_structures.htm

/**
 * 자바 콜렉션 프레임워크 
 * 는 객체 그룹을 다룰 때 사용되며 이 프레임워크에 정의된 클래스들은 재사용가능한 데이터구조들이다.
 * 그리고 이 데이터구조들은 정렬이나 검색 같은 알고리즘도 제공한다.
 * 콜랙션 프레임워크에 익숙해지면 프로그래밍을 할 때 저레벨 수준의 구체적인 코드를 작성하지 않아도 되서 편리하다. 
 * 
 * Collection 인터페이스가 콜렉션 프레임워크의 모든 클래스들의 조상 클래스가 되고 모든 콜렉션 프레임워크의 클래스들의 기본동작을 정의한다. 
 * Collection 인터페이스는 add, clear, remove, contains, isEmpty, size, toArray 같은 메소드들이 정의되어 있는데 
 * 콜렉션 프레임워크의 클래스들은 이 메소드들을 구현해야 한다. 
 */

import java.util.Scanner;
import java.util.*;

class StepN {
    public static void main(String[] args) {
        StepN stepN = new StepN();
        stepN.n05();
    }

    void n01() {
        // HashSet 클래스는 객체를 집합으로 다룰 때 사용된다. 
        // 따라서 중복 요소를 허용하지 않는다. 
        // 이름이 HashSet 인 이유는 집합을 구현할 때 빠르고 효율적인 hash table 알고리즘이 사용되었기 때문이다. 
        // In
        // 1 8 3 2 4 9 4 8 3 3 1 5 2 2 9 9 1 7 5 5 6 -1
        // Out
        // 2 3 4 5 6 7 8 9 
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
        // Map 인터페이스는 객체를 순서쌍으로 다룰 때 사용된다. 
        // 순서쌍은 키와 값으로 되어 있는 자료구조이다.
        // 가령 키는 학번이 될 수 있고 값은 학생정보가 될 수 있다. 
        // HashMap 은 Map 인터페이스를 구현한 클래스이고 hash table 알고리즘을 사용하기 때문에 HashMap 이라 부른다. 
        // In
        /* 
Everest,8848
K2,8611
Annapurna,8091
Makalu,8463
eof
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
        // TreeSet 은 HashSet 과 달리 정렬을 해준다. 
        /* 
Everest,8848
K2,8611
Annapurna,8091
Makalu,8463
eof
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
            System.out.println(k + " : " + tm.get(k).doubleValue());
    }

    void n04() {
        // In
        // 9 3 4 5 6 7 8 1 2 -1
        // Out
        // [3, 5, 6, 7, 8, 1]
        LinkedList ll = new LinkedList();
        Scanner s = new Scanner(System.in);
        while(true) {
            int tmp = s.nextInt();
            if (tmp == -1)
                break;
            ll.add(tmp);
        }
        ll.remove(2);
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
    void n05() {
        // initial size is 3, increment is 2
        Vector v = new Vector(3, 2);
        v.addElement(new Integer(1));
        v.addElement(new Integer(2));
        v.addElement(new Integer(3));
        v.addElement(new Integer(4));
        v.addElement(new Double(5.45));
        v.addElement(new Double(6.08));
        v.addElement(new Integer(7));
        v.addElement(new Float(9.4));
        v.addElement(new Integer(10));
        v.addElement(new Integer(11));
        v.addElement(new Integer(12));
        for (int i=0; i<v.size(); i++)
            System.out.print(v.get(i)+" ");
        System.out.println();
    }
}
