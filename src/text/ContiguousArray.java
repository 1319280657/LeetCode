package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-06-03 13:14
 **/

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 * 示例 1:
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 * 提示：
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 分析： 因为数组中的值不是0就是1，所以要相同数量的0和1的数组，则前缀和等于当前数组长度的一半
 */
public class ContiguousArray {


    class Solution {
        public int findMaxLength(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            int perSums = 0;
            Map<Integer,Integer> perSumMap = new HashMap();
            int maxLength = 0;
            perSumMap.put(0,-1);
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i]==0?-1:1;
                perSums = perSums + num;
                if (perSumMap.containsKey(perSums)){
                    int preIndex = perSumMap.get(perSums);
                    maxLength = maxLength > (i - preIndex)? maxLength:(i - preIndex);
                }else {
                    perSumMap.put(perSums,i);
                }
            }
            return maxLength;
        }
    }

    public void test() {
        int s[] = /*{1,0,1};*/ {1,0,0,1,0,0,0,1,0,1,0,1,0,1,0,0,1,1,1,0,1,0,1,0,1,1,0,1,1,1,1,0,0,1,1,0,0,1,1,1,1,1,0,1,0,1,0,0,1,0,0,0,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,1,1,1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,1,0,1,1,1,1,1,1,0};
        int result;
        Solution solution = new Solution();
        result = solution.findMaxLength(s);
        System.out.println(result);

    }


}
