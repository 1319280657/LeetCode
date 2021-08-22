package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-30 15:51
 **/

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= x <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 	18 ms	38.1 MB
 * */
public class PalindromeNumber {
    class Solution {
        public boolean isPalindrome(int x) {
            if(x<0){
                return  false;
            }
            if (x>=0 && x <=9){
                return true;
            }
//            1.普通方案，使用字符串进行判断数据
            String nums = ""+x;
            boolean result = true;
            int length = (nums.length()+1)/2,index = nums.length()-1;
            for (int i = 0; i < length; i++,index--) {
                if (nums.charAt(i) != nums.charAt(index)){
                    result = false;
                    break;
                }
            }
//            1.end
            return result;
        }
    }

    public void test() {
        int s = -125621;
        boolean result;
        Solution solution = new Solution();
        result = solution.isPalindrome(s);
        System.out.println( s + " + " + result);
    }
}
