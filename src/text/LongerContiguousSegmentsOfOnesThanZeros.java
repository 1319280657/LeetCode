package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-26 15:50
 **/

/**
 * 给你一个二进制字符串 s 。如果字符串中由 1 组成的 最长 连续子字符串 严格长于 由 0 组成的 最长 连续子字符串，返回 true ；否则，返回 false 。
 * 例如，s = "110100010" 中，由 1 组成的最长连续子字符串的长度是 2 ，由 0 组成的最长连续子字符串的长度是 3 。
 * 注意，如果字符串中不存在 0 ，此时认为由 0 组成的最长连续子字符串的长度是 0 。字符串中不存在 1 的情况也适用此规则。
 * 示例 1：
 * 输入：s = "1101"
 * 输出：true
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："1101"
 * 由 0 组成的最长连续子字符串的长度是 1："1101"
 * 由 1 组成的子字符串更长，故返回 true 。
 * 示例 2：
 * 输入：s = "111000"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 3："111000"
 * 由 0 组成的最长连续子字符串的长度是 3："111000"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 示例 3：
 * 输入：s = "110100010"
 * 输出：false
 * 解释：
 * 由 1 组成的最长连续子字符串的长度是 2："110100010"
 * 由 0 组成的最长连续子字符串的长度是 3："110100010"
 * 由 1 组成的子字符串不比由 0 组成的子字符串长，故返回 false 。
 * 提示：
 * 1 <= s.length <= 100
 * s[i] 不是 '0' 就是 '1'
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longer-contiguous-segments-of-ones-than-zeros
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LongerContiguousSegmentsOfOnesThanZeros {

    class Solution {
        public boolean checkZeroOnes(String s) {
            int indexOnes = 0,indexZeros = 0;
            int longestOnes = 0,longestZeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1'){
                    longestOnes = Math.max(longestOnes,i-indexOnes+1);
                    indexZeros = i+1;
                }else {
                    longestZeros = Math.max(longestZeros,i-indexZeros+1);
                    indexOnes = i+1;
                }
            }

            return longestOnes>longestZeros;
        }
    }

    public void test() {
        String s = "11";
        boolean result;
        Solution solution = new Solution();
        result = solution.checkZeroOnes(s);
        System.out.println(result);
    }
}
