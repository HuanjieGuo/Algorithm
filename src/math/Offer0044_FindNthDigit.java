package math;

/**
 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

 请写一个函数，求任意第n位对应的数字。

 */
public class Offer0044_FindNthDigit {
    public static int findNthDigit(int n) {
        if(n==0) return 0;
        n -= 1;
        int base = 1;
        while (n-base*9*Math.pow(10,base-1)>0){
            n -= base*9*(int)Math.pow(10,base-1);
            base++;
        }
        // 第一个
        int start = (int)Math.pow(10,base-1);
        int idxOfNumber = n/base;
        int idxOfDigit = n%base;
        int number = start+idxOfNumber;
        return String.valueOf(number).charAt(idxOfDigit)-'0';
    }

    public static void main(String[] args) {
        findNthDigit(3);
    }
}
