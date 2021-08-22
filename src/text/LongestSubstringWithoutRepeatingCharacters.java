package text;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-25 23:39
 **/
/**
 *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 * 输入: s = ""
 * 输出: 0
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 97ms   37.8MB
 * */
public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {

            Map<Character,Integer> characterIntegerMap = new HashMap<Character,Integer>();
            Character c;
            int longestLength = 0;
            int index = 0;
            for (int i = 0; i < s.length(); i++) {
                characterIntegerMap.clear();
                //建立循环窗口
                for (int j = i; j < s.length(); j++) {
                    c = s.charAt(j);
                    if (characterIntegerMap.containsKey(c)){
                        break;
                    }
                    characterIntegerMap.put(c,j);
                    longestLength = Math.max(longestLength, (j - i+1));
                }

            }
            return longestLength;
        }
    }

    public void test() {
        String s = "abcabcbb";/*"tmmzuxt";*//*"dcdf";*//*"abba";*//*"cdd";*//*" 1";*//*"abcabcbb";*/
        int result;
        Solution solution = new Solution();
        result = solution.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
