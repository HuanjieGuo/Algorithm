package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的数字可以无限制重复被选取。

 说明：

 所有数字（包括 target）都是正整数。
 解集不能包含重复的组合。 
 示例 1：

 输入：candidates = [2,3,6,7], target = 7,
 所求解集为：
 [
 [7],
 [2,2,3]
 ]
 示例 2：

 输入：candidates = [2,3,5], target = 8,
 所求解集为：
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]
  

 提示：

 1 <= candidates.length <= 30
 1 <= candidates[i] <= 200
 candidate 中的每个元素都是独一无二的。
 1 <= target <= 500

 */
public class A0039_CombinationSum {
    int[] candidates;
    int target;
    List<Integer> current;
    List<List<Integer>> resultLists;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序candidates 用于后面筛除重复项
        Arrays.sort(candidates);

        this.candidates = candidates;
        this.target = target;
        current = new ArrayList<>();
        resultLists = new ArrayList<>();
        backTrack();
        return resultLists;
    }

    void backTrack(){
        if(target==0){
            resultLists.add(new ArrayList<>(current));
            return;
        }
        for(int num:candidates){
            // 本处第一个判断剔除 [2,2,3],[2,3,2],[3,2,2]等重复项
            // 第二个判断剪枝
            if((current.size()!=0
                    &&current.get(current.size()-1)>num)
                    ||target<num)
                continue;

            target -= num;
            current.add(num);
            backTrack();
            target+=num;
            current.remove(current.size()-1);
        }
    }
}
