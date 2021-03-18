package secondOffer.array;

public class Offer0029_SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0) return new int[0];
        int l = 0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        int x = 0;
        int[] result = new int[(r+1)*(b+1)];
        while (true){
            for(int i=l;i<=r;i++) result[x++] = matrix[t][i];
            if(++t>b) break;
            for(int i=t;i<=b;i++) result[x++] = matrix[i][r];
            if(--r<l) break;
            for(int i=r;i>=l;i--) result[x++] = matrix[b][i];
            if(--b<t) break;
            for(int i=b;i>=t;i--) result[x++] = matrix[i][l];
            if(++l>r) break;
        }
        return result;
    }
}
