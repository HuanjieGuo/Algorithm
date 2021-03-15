package huawei;

import java.util.HashSet;
import java.util.Scanner;

public class StringSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            StringBuilder strNew = new StringBuilder();
            HashSet<Character> set = new HashSet<>();
            for (char ch : str.toCharArray()) {
                if (!set.contains(ch)) strNew.append(ch);
                set.add(ch);
            }
            System.out.println(strNew.toString());
        }
    }
}
