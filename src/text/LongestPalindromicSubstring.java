package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-26 16:10
 **/

/**
 *给你一个字符串 s，找到 s 中最长的回文子串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 2071ms  39.1MB
 * */
public class LongestPalindromicSubstring {

    class Solution {
        public String longestPalindrome(String s) {
            String result = new String();
            String s1;
            int lastIndex = 0;
            boolean flag;
            for (int i = 0; i < s.length(); i++) {
                lastIndex = s.lastIndexOf(s.charAt(i));
                s1 = s.substring(i,lastIndex+1);
                flag = true;
                if (lastIndex != i){
                    while (flag){
                        for (int j = 0; j < ((s1.length()+1)/2); j++) {
                            System.out.println(s1.charAt(j) + " + "+ s1.charAt(s1.length()-j-1));
                            if (s1.charAt(j)!= s1.charAt(s1.length()-j-1)){
                                flag = false;
                                break;
                            }
                        }
                        if (flag ||s1.length() <= 0 ) break; //如果是回文串或者已经没有当前字符了，则结束当前循环
                        s1 = s1.substring(0,s1.length()-1);
                        flag = true; // 字符串缩小之后重新进行验证是否是回文串
                    }
                }
                if(flag){
                    if (result.length() < (s1.length())) {

                        result = s1;
                        System.out.println("result = " + result);
                    }
                }
            }
            return result;
        }
    }

    public void test() {
        String s = "aacabdkacaa";//"bacabab";//"aacabdkacaa";
        String result;
        Solution solution = new Solution();
        result = solution.longestPalindrome(s);
        System.out.println(result);
    }
}
