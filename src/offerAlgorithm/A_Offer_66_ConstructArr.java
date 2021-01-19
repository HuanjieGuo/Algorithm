package offerAlgorithm;

/**
 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

  

 示例:

 输入: [1,2,3,4,5]
 输出: [120,60,40,30,24]
  

 提示：

 所有元素乘积之和不会溢出 32 位整数
 a.length <= 100000
 */
public class A_Offer_66_ConstructArr {
    /**
      1 2 3 4 5
     120 60 40 30 24

     1 2 3 4 5
     1 1 3 4 5
     1 2 1 4 5
     1 2 3 1 5
     1 2 3 4 1
     */
    public static int[] constructArr(int[] a) {
        int b[] = new int[a.length];
        if(a.length==0) return b;
        b[0] = 1;
        // 下三角
        for(int i=1;i<a.length;i++)
            b[i] = b[i-1]*a[i-1];

        int culmulate = 1;
        // 上三角
        for(int i=a.length-2;i>=0;i--){
            culmulate *= a[i+1];
            b[i] *= culmulate;
        }
        return b;
    }

    public static void main(String[] args) {
        constructArr(new int[]{});
    }
}
