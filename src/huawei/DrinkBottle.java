package huawei;

public class DrinkBottle {
    public static int drink(int number){
        int eat = number;
        int bottle = number;
        while(bottle>=3){
            eat += bottle / 3;
            bottle = bottle / 3 + bottle%3;
        }
        if(bottle==2) eat++;
        StringBuilder stringBuilder = new StringBuilder("");
        stringBuilder.append(" ");
        return eat; }

    public static void main(String[] args) {
        System.out.println(drink(10));
    }
}
