package secondOffer.dfs;

public class Offer0013_MovingCount {
    boolean[][] matrix;
    int k;
    int m;
    int n;
    int count;
    public int movingCount(int m, int n, int k) {
        if(m==0||n==0) return 0;
        matrix= new boolean[m][n];
        this.k = k;
        this.m = m;
        this.n = n;
        dfs(0,0);

        return count;
    }
    void dfs(int i,int j){
        if(i<0||j<0||i>=m||j>=n) return;
        if(sumOfAllBit(i)+sumOfAllBit(j)>k) return;
        if(matrix[i][j]) return;
        matrix[i][j] = true;
        count++;
        dfs(i-1,j);
        dfs(i+1,j);
        dfs(i,j-1);
        dfs(i,j+1);
    }
    static int sumOfAllBit(int num){
        if(num==100) return 1;
        int ten = num/10;
        int one = num-ten*10;
        return ten+one;
    }

    public static void main(String[] args) {
        System.out.println(sumOfAllBit(9));
    }
}
