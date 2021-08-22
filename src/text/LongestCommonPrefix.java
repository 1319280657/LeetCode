package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-30 17:13
 **/
/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 *
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *  
 *
 * 提示：
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class LongestCommonPrefix {
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String result;
            int j = 0;
            int resultLength = (strs[0]).length();
            for (int i = 1; i < strs.length; i++) {
                j=0;
                for ( ;j < strs[0].length(); j++) {
                    if (j==strs[i].length()) break;
                    if (strs[0].charAt(j) != strs[i].charAt(j)){
                        break;
                    }
                }
                resultLength = resultLength < j ? resultLength:j;
            }
            result = strs[0].substring(0,resultLength);
            return result;
        }
    }

    public void test() {
        String s[] = {"dog","racecar","car"};
        String result;
        Solution solution = new Solution();
        result = solution.longestCommonPrefix(s);
        System.out.println( result);
    }
}
