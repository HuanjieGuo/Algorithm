package niuke;

/**
 题目描述
 实现函数 int sqrt(int x).
 计算并返回x的平方根（向下取整）
 示例1
 输入
 复制
 2
 返回值
 复制
 1
 */
public class Sqrt {
    public static int sqrt (int x) {
        if(x<=1) return 1;
        int left = 0;
        int right = x;
        while (left<right){
            int pivot = (left+right)/2;
            if(Math.pow(pivot,2)>x)
                right=pivot;
            else {
                if (Math.pow(pivot+1,2)>x) return pivot;
                left = pivot;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(1));
    }
}
