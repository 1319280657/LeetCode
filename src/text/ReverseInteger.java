package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-26 19:40
 **/
/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 *
 * 示例 1：
 *
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 *
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 *
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 *
 * 输入：x = 0
 * 输出：0
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *14 ms	37 MB
 * */
public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            boolean flag = Math.abs(x) == x;
            if (x== -2147483648) return 0;
            String numStr = "" + Math.abs(x);
            long result1 = 0;
            int result = 0;
            for (int i = numStr.length() - 1; i >= 0; i--) {
                result1 = result1 * 10 + (Integer.parseInt(String.valueOf(numStr.charAt(i))));
            }
            if (((result1 > ((1<<31)-1)))) return 0;
            result = Integer.parseInt(""+result1);
            if (!flag) result = result * -1;

            return result;
        }
    }

    public void test() {
        int nums = -2147483648; //2147483647
        int result;
        Solution solution = new Solution();
        result = solution.reverse(nums);
        System.out.println(result);
    }
}
