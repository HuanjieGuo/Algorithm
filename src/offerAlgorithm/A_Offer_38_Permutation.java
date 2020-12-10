package offerAlgorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 输入一个字符串，打印出该字符串中字符的所有排列。

  

 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

  

 示例:

 输入：s = "abc"
 输出：["abc","acb","bac","bca","cab","cba"]
  

 限制：

 1 <= s 的长度 <= 8

 */
public class A_Offer_38_Permutation {
    List<String> res = new LinkedList<>();
    char[] c;


    public String[] permutation(String s){
        c = s.toCharArray();
        perm(0,c.length-1);
        return res.toArray(new String[res.size()]);
    }

    void perm(int p,int q){
        if(p==q){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for(int i=p;i<=q;i++){
            // 剪枝
            if (set.contains(c[i])) continue;
            set.add(c[i]);

            // 选取队头
            swap(p,i);

            // 交换完成后，队尾继续交换
            perm(p+1,q);

            // 复位队头
            swap(p,i);
        }
    }

    void swap(int a,int b){
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        A_Offer_38_Permutation a_offer_38_permutation = new A_Offer_38_Permutation();
        a_offer_38_permutation.permutation("ABB");
        System.out.println(a_offer_38_permutation.res);
    }
}
