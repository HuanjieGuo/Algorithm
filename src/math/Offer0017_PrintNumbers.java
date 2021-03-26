package math;

/**
 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

 示例 1:

 输入: n = 1
 输出: [1,2,3,4,5,6,7,8,9]

 */
public class Offer0017_PrintNumbers {
    public int[] printNumbers(int n) {
        int max = (int)Math.pow(10,n)-1;
        int[] array = new int[max];
        for(int i=0;i<=max;i++){
            array[i] = i+1;
        }
        return array;
    }
}
