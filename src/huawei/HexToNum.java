package huawei;

import java.util.Scanner;

public class HexToNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String hex = scanner.nextLine();
            char[] ch = hex.toCharArray();
            int number = 0;
            for(int i=ch.length-1;i>=2;i--){
                if(ch[i]-'0'<10) {
                    number += (ch[i] - '0') * Math.pow(16, ch.length - 1 - i);
                }else {
                    number += (ch[i] - 'A' +10)* Math.pow(16, ch.length - 1 - i);
                }
            }
            System.out.println(number);
        }
    }
}
