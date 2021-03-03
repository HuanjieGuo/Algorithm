package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

  

 示例 1：

 输入：nums = [1,1,2]
 输出：
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 示例 2：

 输入：nums = [1,2,3]
 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
  

 提示：

 1 <= nums.length <= 8
 -10 <= nums[i] <= 10

 */
public class A0046_Permute {
    List<List<Integer>> lists;
    List<Integer> currentList;
    public List<List<Integer>> permute(int[] nums) {
        lists = new ArrayList<>();
        currentList = new ArrayList<>();
        if (nums.length==0) return lists;
        recur(nums);
        return lists;
    }
    void recur(int[] nums){
        if(currentList.size()==nums.length) {
            lists.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==-10000) continue;
            int num = nums[i];
            currentList.add(nums[i]);
            nums[i] = -10000;
            recur(nums);
            // 复位
            nums[i] = num;
            // 删除
            currentList.remove(currentList.size()-1);
        }
    }

    public static void main(String[] args) {
        A0046_Permute permute = new A0046_Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }
}
