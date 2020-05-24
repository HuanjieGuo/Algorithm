package week1.unionFind;

public class QuickUnionUF {
    private int[] id;
    private int[] sz;
    /**
     * 复杂度N
     * @param N
     */
    public QuickUnionUF(int N){
        id = new int[N];
        for(int i=0;i<N;i++){
            id[i] = i;
            sz[i] = 1;
        };
    }

    /**
     * 复杂度N  if tree get too tall
     * @param i
     * @return
     */
    private int root(int i){
        // while faster than loop
        while (i != id[i]) i = id[i];
        return i;
    }

    /**
     * 复杂度N
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        return root(p) == root(q);
    }

    /**
     * 复杂度N
     * @param p
     * @param q
     */
    public void union(int p,int q){
        // change root of p point to root of q
        int i = root(p);
        int j = root(q);
        if(i==j) return;


        /**
         *  次处优化后， 复杂度约为 lg N
         */
        if(sz[i]<sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }


    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(1,2);
        quickUnionUF.union(1,5);
        quickUnionUF.union(5,8);
        System.out.println(quickUnionUF.connected(2,8));
    }
}
