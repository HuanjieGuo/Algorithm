package hot100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class A0022_GenerateParenthesis {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        recur(new StringBuilder(),n,n);
        return res;
    }
    public void recur(StringBuilder str,int left,int right){
        // 左边数量大于右边数量，剪枝
        if(left>right) return;
        if(left==0&&right==0){
            // check
            res.add(str.toString());
            return;
        }
        if(left!=0){
            str.append('(');
            recur(str,left-1,right);
            str.deleteCharAt(str.length()-1);
        }
        if(right!=0){
            str.append(')');
            recur(str,left,right-1);
            str.deleteCharAt(str.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new A0022_GenerateParenthesis().generateParenthesis(3));
    }
}
