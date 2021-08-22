package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-06-04 13:48
 **/

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 示例 1：
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * 提示：
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-missing-positive
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 使用集合的结果
 * 24 ms	99.1 MB
 *
 * 尝试只适用常数级别的辅助空间
 *
 */
public class FirstMissingPositive {

    class Solution {
        public int firstMissingPositive(int[] nums) {
            int result = 1;
            Set<Integer> numSet = new HashSet<>();
            int minNum = Integer.MAX_VALUE, maxNum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) continue;
                minNum = minNum > nums[i] ? nums[i] : minNum;
                maxNum = maxNum < nums[i] ? nums[i] : maxNum;
                numSet.add(nums[i]);
            }
            System.out.println(minNum + " + " + maxNum);
            if (minNum > 1)
                result = 1;
            else {
                maxNum = (maxNum+1) < maxNum ? maxNum: maxNum+1;
                for (int i = 2; i <= (maxNum); i++) {
                    if (!numSet.contains(i)) {
                        result = i;
                        break;
                    }
                }
            }
            return result;
        }
    }

    public void test() {
        int nums[] = {1, 2, 3, 10, 2147483647, 9};
        int result;
        Solution solution = new Solution();
        result = solution.firstMissingPositive(nums);
        System.out.println(result);

    }
}
