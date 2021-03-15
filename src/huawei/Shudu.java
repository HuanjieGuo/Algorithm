package huawei;

import java.util.Scanner;

public class Shudu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[9][9];
        int i = 0;
        while (scanner.hasNext()) {
            String str = scanner.next();
            System.out.println(str);
            String[] nums = str.split(" ");
            for (int j = 0; j < nums.length; j++) {
                a[i][j] = Integer.parseInt(nums[j]);
            }
            i++;
            if(i==9) {
                for (int k = 0; k < a.length; k++) {
                    StringBuilder line = new StringBuilder();
                    for (int l = 0; l < a[0].length; l++)
                        if (l != a[0].length - 1) line.append(a[k][l]).append(" ");
                        else line.append(a[k][l]);
                    System.out.println(line.toString());
                }
                i=0;
            }
        }
    }
}
