package secondOffer.list;

import java.util.ArrayList;

public class Offer0062_LastRemain {

    public static int lastRemaining_list(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(i);
        int idx = -1;
        while (list.size()!=1){
            idx = (idx+m)%list.size();
            list.remove(idx);
            idx = idx-1;
        }
        return list.get(0);
    }
    public static int lastRemaining(int n, int m) {
        // 只有一个人时，是0
        int idx = 0;
        // 从倒数第二轮开始反推
        for(int i=2;i<=n;i++)
            idx = (idx+m)%i;
        return idx;
    }




    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }
}
