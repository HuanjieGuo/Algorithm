package leetcode.structure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class KMP {
    private int[] back_step;
    private String pat;

    public KMP(String pat){
        this.pat = pat;
        if(pat.equals("")){
            return;
        }
        int lengthOfPat = pat.length();
        back_step = new int[lengthOfPat];
        // 第一个格子为0  JAVA默认为0  可不写
        back_step[0] = 0;
        // 初始化little指针
        int little = 0;
        // 从1开始
        for(int i=1;i<lengthOfPat;i++){
            while (true) {
                if (pat.charAt(i) == pat.charAt(little)) {
                    little = little + 1;
                    back_step[i] = little;
                    break;
                }else {
                    if(little==0){
                        break;
                    }
                    // 匹配指针回滚
                    little = back_step[little-1];
                }
            }
        }
    }
    public static void main(String[] args){
        KMP kmp = new KMP("abcaby");
        System.out.println(kmp.search("abxabcabcaby"));
        System.out.println(Arrays.toString(kmp.back_step));
    }

    public int search(String txt){
        if(txt.equals("")){
            return 0;
        }
        int lengthOfPat = pat.length();
        int indexOfpat = 0;
        for(int i=0;i<txt.length();i++){
            while (true) {
                if (txt.charAt(i) == pat.charAt(indexOfpat)) {
                    indexOfpat++;
                    if (indexOfpat == lengthOfPat) {
                        return i + 1 - lengthOfPat;
                    }
                    break;
                }else {
                    if(indexOfpat==0){
                        break;
                    }
                    indexOfpat = back_step[indexOfpat-1];
                }
            }
        }
        return -1;
    }
}
