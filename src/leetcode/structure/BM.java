package leetcode.structure;

public class BM {
    private boolean[] isGoodEnd;
    private String pat;
    public BM(String pat){
        this.pat = pat;
        isGoodEnd = new boolean[pat.length()];

        int length = pat.length();
        // 判断是否是好的
        for(int i=0;i<length-1;i++){
            if(pat.charAt(length-1-i)==pat.charAt(i)){
                if(i==0){
                    isGoodEnd[length-1-i] = true;
                }else {

                }

            }
        }
    }
}
