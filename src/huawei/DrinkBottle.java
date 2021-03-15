package huawei;

import java.io.InputStream;
import java.util.Scanner;

public class DrinkBottle {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()){
            int number = cin.nextInt();
            if(number>=3) System.out.println(drink(number));
        }
    }
    public static int drink(int number){
        int eat = 0;
        int bottle = number;
        while(bottle>=3){
            eat += bottle / 3;
            bottle = bottle / 3 + bottle%3;
        }
        if(bottle==2) eat++;
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(" ");
        return eat;
    }

}
