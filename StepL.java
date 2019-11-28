import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

class StepL {
    public static void main(String[] args) {
        StepL stepL = new StepL();
        stepL.l04();
    }

    void l01_print(ArrayList<l01_MenuPan> u){
        System.out.println("================================================");
        System.out.println("num\tname\t\torigin\t\tprice");
        for (int i=0; i<u.size();i++) {
            System.out.print((i+1)+"\t");
            u.get(i).print();
        }
    }

    void l01() {
        String name;
        String origin;
        int price;
        int command=0, idx;
        ArrayList<l01_MenuPan> u = new ArrayList<l01_MenuPan>();
        Scanner s = new Scanner(System.in);
        while (command != 6) {
            System.out.print("1) add, 2) modify, 3) remove, 4) list, 5) total number, 6) exit > ");
            command = s.nextInt();
            switch (command) {
            case 1:
                System.out.print("Enter name, origin, price > ");
                name = s.next();
                origin = s.next();
                price = s.nextInt();
                u.add(new l01_MenuPan(name, origin, price));
                break;
            case 2:
                l01_print(u);
                System.out.print("Enter a number to modify > ");
                idx = s.nextInt();
                System.out.print("Enter name, origin, price > ");
                name = s.next();
                origin = s.next();
                price = s.nextInt();
                u.set(idx-1, new l01_MenuPan(name, origin, price));
                break;
            case 3:
                l01_print(u);
                System.out.print("Enter a number to remove > ");
                idx = s.nextInt();
                u.remove(idx-1);
                System.out.println("Removed");
                break;
            case 4:
                l01_print(u);
                break;
            case 5:
                System.out.println("Number of registered menu is "+ u.size());
                break;
            case 6:
                System.out.println("Ended");
                break;
            }
        }
    }
    void l02_print(ArrayList<l02_Parking> u){
        System.out.println("================================================");
        System.out.println("num\t\ttype\t\ttime");
        for (int i=0; i<u.size();i++)  {
            System.out.print("["+(i+1)+"] ");
            u.get(i).print();
        }
    }

    void l02() {
        Scanner s = new Scanner(System.in);
        SimpleDateFormat f = new SimpleDateFormat("YYYYMMdd HHmm", Locale.KOREA);
        String num, type, time;
        int command=0, size;
        ArrayList<l02_Parking> u = new ArrayList<l02_Parking>();
        System.out.print("Enter number of available parking lots > ");
        size = s.nextInt();
        while (command!=6) {
            System.out.print("1) enter, 2) departure, 3) list, 4) total, 5) Remaining, 6) exit > ");
            command = s.nextInt();
            switch(command) {
            case 1:
                System.out.print("Enter number, type > ");
                num = s.next();
                type = s.next();
                time = f.format(new Date()); 
                
                u.add(new l02_Parking(num, type, time));
                break;
            case 2:
                l02_print(u);
                System.out.print("Enter number to departure > ");
                int dtmp = s.nextInt();
                Date tmp = new Date();
                try {
                    tmp = f.parse(u.get(dtmp-1).time);
                } catch (ParseException ex) {
                    System.out.println("Failed to parse");
                }
                Date now = new Date();
                int h = now.getHours() - tmp.getHours() ;
                int m = now.getMinutes() - tmp.getMinutes() ;
                long interval = h * 60 + m;
                System.out.println("Parking fee is "+(interval/10)*500+" because current time is "+now);
                u.remove(dtmp-1);
                break;
            case 3:
                l02_print(u);
                System.out.println((size - u.size())+" parking lots available");
                break;
            case 4:
                System.out.println("Current number of car is "+u.size());
                break;
            case 5:
                System.out.println((size - u.size())+" parking lots available");
                break;
            case 6:
                break;
            }
        }
    }
    void l03_print(ArrayList<l03_Customer> u){
        System.out.println("no\tnum\tsteak\tspaghetti\tpasta\tmembership\tentry-time");
        for(int i=0; i<u.size(); i++) {
            System.out.print("["+(i+1)+"]");
            u.get(i).print();
        }
    }
    void l03(){
        Scanner s = new Scanner(System.in);
        ArrayList<l03_Customer> u = new ArrayList<l03_Customer>();
        int command=0;
        int num, price;
        double price_tmp;
        int menu[] = new int[3];
        boolean membership;
        Date now;
        while (command!=4) {
            System.out.println("------------------------------------------------------------------ ");
            System.out.print("1) order, 2) pay, 3) list, 4) exit > ");
            command = s.nextInt();
            System.out.println("------------------------------------------------------------------ ");
            switch(command) {
            case 1:
                System.out.print("Enter number of customer > ");
                num = s.nextInt();
                System.out.print("Enter number of menu(steak, spaghetti, pasta) > ");
                menu[0] = s.nextInt();
                menu[1] = s.nextInt();
                menu[2] = s.nextInt();
                System.out.print("Enter whether you have a membership card (Y/N) > ");
                char tmp = s.next().charAt(0);
                if (tmp == 'Y') membership = true;
                else membership = false;
                now = new Date();
                System.out.println("Entery time is : "+now);
                price_tmp = menu[0] * 25000 + menu[1] * 15000 + menu[2] * 17000;
                if (membership) price_tmp = price_tmp * (1 - 0.1);
                if (price_tmp < 100000) price_tmp = price_tmp * (1+0.07);
                else price_tmp = price_tmp * (1+0.1);
                price_tmp = price_tmp * (1+0.1);
                price = (int) price_tmp;
                System.out.println("Total price is : "+price);
                u.add(new l03_Customer(num, menu, membership, now, price));
                break;
            case 2:
                l03_print(u);
                System.out.print("Enter the number you wish to pay > ");
                int pay = s.nextInt();
                u.remove(pay-1);
                break;
            case 3:
                l03_print(u);
                break;
            case 4:
                System.out.println("Ended");
                break;
            }
        }
    }
    void l04_print_addresssearch(ArrayList<l04_UserInfo> u, String searchaddress){
        System.out.println("no\tname\tstdit\t\tgender\taddress\t\tphone number\treturn student");
        for(int i=0; i<u.size(); i++) {
            l04_UserInfo tmp = u.get(i);
            if (tmp.address.contains(searchaddress)) {
                System.out.print((i+1)+"\t");
                tmp.print();
            }
        }
    }
    void l04_print_namesearch(ArrayList<l04_UserInfo> u, String searchname){
        System.out.println("no\tname\tstdit\t\tgender\taddress\t\tphone number\treturn student");
        for(int i=0; i<u.size(); i++) {
            l04_UserInfo tmp = u.get(i);
            if (tmp.name.contains(searchname)) {
                System.out.print((i+1)+"\t");
                tmp.print();
            }
        }
    }
    void l04_print_returnstd(ArrayList<l04_UserInfo> u){
        System.out.println("no\tname\tstdit\t\tgender\taddress\t\tphone number\treturn student");
        for(int i=0; i<u.size(); i++) {
            l04_UserInfo tmp = u.get(i);
            if (tmp.return_std) {
                System.out.print((i+1)+"\t");
                tmp.print();
            }
        }
    }
    void l04_print(ArrayList<l04_UserInfo> u){
        System.out.println("no\tname\tstdit\t\tgender\taddress\t\tphone number\treturn student");
        for(int i=0; i<u.size(); i++) {
            System.out.print((i+1)+"\t");
            u.get(i).print();
        }
    }
    l04_UserInfo l04_add(){
        Scanner s = new Scanner(System.in);
        String name, gender, address, phone, stdid;
        boolean return_std;

        System.out.print("Enter name, stdid, gender > ");
        name = s.next();
        stdid = s.next();
        gender = s.next();
        System.out.print("Enter address > ");
        address = s.next();
        System.out.print("Enter phone number > ");
        phone = s.next();
        System.out.print("Enter whether or not you are a return student (Y/N) > ");
        char tmp = s.next().charAt(0);
        if (tmp == 'Y') return_std = true;
        else return_std = false;
        return new l04_UserInfo(name, gender, address, stdid, phone, return_std);
    }
    void l04(){
        Scanner s = new Scanner(System.in);
        ArrayList<l04_UserInfo> u = new ArrayList<l04_UserInfo>();
        int command=0;
        String search;
        while (command!=8) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("1) register, 2) modify, 3) remove, 4) list, 5) search name");
            System.out.print("6) list (return student), 7) search address, 8) exit > ");
            command = s.nextInt();
            System.out.println("------------------------------------------------------------------");
            switch(command) {
            case 1:
                u.add(l04_add());
                System.out.println("A total of "+u.size()+" people were registered");
                break;
            case 2:
                l04_print(u);
                System.out.print("Enter number to modify > ");
                int modify = s.nextInt();
                u.set(modify-1, l04_add());
                break;
            case 3:
                l04_print(u);
                System.out.print("Enter number to remove > ");
                int remove = s.nextInt();
                u.remove(remove-1);
                break;
            case 4:
                l04_print(u);
                break;
            case 5:
                System.out.print("Enter name to search > ");
                search = s.next();
                System.out.println("Searched");
                l04_print_namesearch(u, search);
                break;
            case 6:
                l04_print_returnstd(u);
                break;
            case 7:
                System.out.print("Enter address to search > ");
                search = s.next();
                System.out.println("Searched");
                l04_print_namesearch(u, search);
                break;
            case 8:
                System.out.print("Ended");
                break;
            }
        }
    }
}


class l01_MenuPan {
    String name;
    String origin;
    int price;

    l01_MenuPan(String name, String origin, int price) {
        this.name = name;
        this.origin = origin;
        this.price = price;
    }

    void print() {
        System.out.println(this.name + "\t\t" + this.origin + "\t\t" + this.price);
    }
}
class l02_Parking {
    String num;
    String type;
    String time;

    l02_Parking(String num, String type,String time){
        this.type = type;
        this.num = num;
        this.time = time;
    }

    void print() {
        System.out.println(this.num + "\t" + this.type + "\t\t" + this.time);
    }
}
class l03_Customer {
    int num;
    int menu[];
    boolean membership;
    Date entrytime;
    int price;

    l03_Customer(int num, int menu[],boolean membership, Date entrytime, int price){
        this.num = num;
        this.menu = menu;
        this.membership = membership;
        this.entrytime = entrytime;
        this.price = price;
    }

    void print() {
        if (this.membership)
        System.out.println("\t"+this.num+"\t"+this.menu[0]+"\t"+this.menu[1]+"\t\t"+this.menu[2]+"\tY\t\t"+this.entrytime);
        else
        System.out.println("\t"+this.num+"\t"+this.menu[0]+"\t"+this.menu[1]+"\t\t"+this.menu[2]+"\tN\t\t"+this.entrytime);
    }
}
class l04_UserInfo {
    String name, gender, address, phone, stdid;
    boolean return_std;

    l04_UserInfo(String name, String gender, String address, String stdid, String phone, boolean return_std){
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.stdid = stdid;
        this.phone = phone;
        this.return_std = return_std;
    }

    void print() {
        if (this.return_std)
        System.out.println(this.name+"\t"+this.stdid+"\t"+this.gender+"\t"+this.address+"\t"+this.phone+"\tY");
        else
        System.out.println(this.name+"\t"+this.stdid+"\t"+this.gender+"\t"+this.address+"\t"+this.phone+"\tN");
    }
}