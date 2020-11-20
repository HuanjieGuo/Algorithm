package offerAlgorithm;

import java.util.*;

/**
 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

  

 示例 1：

 输入：m = 2, n = 3, k = 1
 输出：3
 示例 2：

 输入：m = 3, n = 1, k = 0
 输出：1
 提示：

 1 <= n,m <= 100
 0 <= k <= 20

 */
public class A_Offer_13_MovingCountInMaxtrix {
    // for bfs

    int m;
    int n;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        int [][] matrix = new int[m][n];
        return bfs(matrix,m,n,k);
//        return dfs(matrix,0,0,k);
    }


    /**
     * 深度优先 ———— 递归实现
     * @param status
     * @param i
     * @param j
     * @param k
     * @return
     */
    int dfs(int[][] status,int i,int j,int k){
        // 边界和K判断
        if(i<0||i>m-1||j<0||j>n-1
                ||sumOfIndex(i)+sumOfIndex(j)>k
                ||status[i][j]==1)
            return 0;
        // 符合
        status[i][j] = 1;
        int step = 0;
        step = 1+dfs(status, i-1, j, k)
                +dfs(status, i+1, j, k)
                +dfs(status, i, j-1, k)
                +dfs(status, i, j+1, k);
        // 不需要复原
        return step;
    }

    /**
     * 广度优先 —— 队列实现
     */
    int bfs(int[][] status,int m,int n,int k){
        int count = 0;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {0,0});
        while (queue.size()!=0){
            int[] x = queue.poll();
            int i=x[0],j=x[1];
            if(i>=m||i<0||j>=n||j<0
                    ||status[i][j]==1
                    ||sumOfIndex(i)+sumOfIndex(j)>k)
                continue;
            count+=1;
            status[i][j] = 1;
            queue.add(new int[] {i-1, j});
            queue.add(new int[] {i+1, j});
            queue.add(new int[] {i, j-1});
            queue.add(new int[] {i, j+1});
        }
        return count;

    }
    /**
     * 本处不具备普遍性！ 需要结合题目范围！
     * @param number
     * @return
     */
    int sumOfIndex(int number){
        int sum = 0;
        while(number>0){
            sum += number % 10;
            number = number/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        //System.out.println(new A_Offer_13_MovingCountInMaxtrix().movingCount(1,2,1));
    }
}
