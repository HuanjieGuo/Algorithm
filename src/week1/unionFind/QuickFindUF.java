package week1.unionFind;

/**
 * quadratic algorithm
 */
public class QuickFindUF {
    private int[] id;

    /**
     * 复杂度N
     * @param N
     */
    public QuickFindUF(int N){
        id = new int[N];
        for(int i = 0;i<N;i++) {
            id[i] = i;
        }
    }

    /**
     * 复杂度1
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q){
        return id[p]==id[q];
    }

    /**
     * 复杂度N  too long
     * @param p
     * @param q
     */
    public void union(int p,int q){
        int pid = id[p];
        int qid = id[q];
        // N
        for (int i = 0;i<id.length;i++){
            if(id[i]==pid){
                id[i] = qid;
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF quickFindUF = new QuickFindUF(10);
        quickFindUF.union(1,2);
        quickFindUF.union(1,5);
        quickFindUF.union(5,8);
        System.out.println(quickFindUF.connected(2,7));
    }
}
