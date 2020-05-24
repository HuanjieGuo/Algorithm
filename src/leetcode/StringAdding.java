package leetcode;

import java.util.ArrayList;
import java.util.List;

public class StringAdding {
    public static String stringAdding(String stringA,String stringB){
        String result = "";
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        for(int i=0;i<stringA.length();i++){
            listA.add(0,Integer.valueOf(stringA.substring(i,i+1)));
        }
        for(int i=0;i<stringB.length();i++){
            listB.add(0,Integer.valueOf(stringB.substring(i,i+1)));
        }
        boolean shouldAddOne = false;
        int index = 0;
        while (true){
            if(index>=listA.size()&&index>=listB.size()&&!shouldAddOne){
                break;
            }
            int number = (listA.size()-1>=index?listA.get(index):0)+(listB.size()-1>=index?listB.get(index):0)+(shouldAddOne?1:0);
            if (number>=10){
                shouldAddOne = true;
                number = number - 10;
            }else {
                shouldAddOne = false;
            }
            result = number + result;
            index += 1;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(StringAdding.stringAdding("31981","979999"));
    }
}
