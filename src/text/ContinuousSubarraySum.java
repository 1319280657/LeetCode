package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-06-02 12:32
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 *
 * 子数组大小 至少为 2 ，且
 * 子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 * 如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。
 * 示例 1：
 *
 * 输入：nums = [23,2,4,6,7], k = 6
 * 输出：true
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6 。
 * 示例 2：
 *
 * 输入：nums = [23,2,6,4,7], k = 6
 * 输出：true
 * 解释：[23, 2, 6, 4, 7] 是大小为 5 的子数组，并且和为 42 。
 * 42 是 6 的倍数，因为 42 = 7 * 6 且 7 是一个整数。
 * 示例 3：
 *
 * 输入：nums = [23,2,6,4,7], k = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= sum(nums[i]) <= 231 - 1
 * 1 <= k <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/continuous-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 	22 ms	54.7 MB
 * */
public class ContinuousSubarraySum {

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            int sumNum = 0;
            if(nums.length<2) return false;
            //简单办法，直接进行暴力遍历，来计算结果
           /* for (int i = 0; i < nums.length; i++) {
                sumNum = nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    sumNum += nums[j];
                    if ((sumNum%k) ==0){
                        return true;
                    }
                }
            }*/
           //参考前缀和的思路,如果当前的取余数已存在了，则表明中间存在可以为K的整数倍的值，再判断这个值是否符合数组长度至少为2的要求
            Map<Integer,Integer> sumMap = new HashMap<>();
            sumMap.put(0,-1);
            Integer preIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                sumNum = (sumNum + nums[i])%k;
                if (sumMap.containsKey(sumNum)){
                    preIndex = sumMap.get(sumNum);
                    if (i-preIndex>1) return true;
                }else{
                    sumMap.put(sumNum,i);
                }

            }
            if (sumMap.containsKey(0)) return true;
            return false;
        }
    }

    public void test() {
        int s[] = {23,2,4,6,6};//{5,0,0,0};//{23,2,4,6,7};
        int k = 7;
        boolean result;
        Solution solution = new Solution();
        result = solution.checkSubarraySum(s,k);
        System.out.println( result);
    }

}
