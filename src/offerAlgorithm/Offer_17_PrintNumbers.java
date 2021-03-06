package offerAlgorithm;

import java.util.*;

/**
 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

 示例 1:

 输入: n = 1
 输出: [1,2,3,4,5,6,7,8,9]
  

 说明：

 用返回一个整数列表来代替打印
 n 为正整数
 */
public class Offer_17_PrintNumbers {
    public int[] printNumbers(int n) {
        int a[] =new int[(int)Math.pow(10,n)-1];
        for(int i=0;i<a.length;i++){
            a[i] = i+1;
        }
        return a;
    }

    public static void main(String[] args) {
        Vector<Integer> vec = new Vector<>();
        vec.add(1);
        Collection<Integer> unchange = Collections.unmodifiableCollection(vec);
        unchange.add(2);
        // Exception in thread "main" java.lang.UnsupportedOperationException
    }
}
