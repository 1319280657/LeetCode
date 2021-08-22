package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-24 20:43
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * 提示：
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 *
 * 执行用时：143 ms
 * 内存消耗：38.8 MB
 * ,
* */
public class SumOfTwoNumbers {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] result = new int[2];//因为明确说是只有一个有效解
            //Integer result1 = 0;
//          二次循环太慢了，使用集合（哈希表）来进行加快速度
           /* for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if (i!=j && nums[i]+nums[j]==target){
                        result[0] = i;
                        result[1] = j;
                        return result;
                    }
                }
            }*/
            Map<Integer,Integer> sumNumber = new HashMap();
            for (int i = 0; i < nums.length; i++) {
                if (sumNumber.containsKey(nums[i])) {
                    result[1] = i;
                    result[0] = (Integer) (sumNumber.get(nums[i]));
                    return result;
                }
                sumNumber.put(target-nums[i],i);
            }
            return result;
        }
    }

    public void test() {
        int[] nums1 = {3,2,4};
        int target = 6;
        int[] resultNumbers ;
        Solution solution = new Solution();
        resultNumbers = solution.twoSum(nums1,target);
        for (int i:resultNumbers
        ) {
            System.out.println(i);
        }
    }
}
