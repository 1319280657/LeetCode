package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-25 21:16
 **/

import java.util.Arrays;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 示例 1：
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 * 输入：s = ""
 * 输出：0
 * 提示：
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 * 2 ms	38.3 MB
 * */


public class LongestValidParentheses {

    class Solution {
        public int longestValidParentheses(String s) {
//            使用栈的思想来进行处理，但是我们并不需要具体的数据，只需要左右括号的数量，故不建立栈，只使用一个变量来代替匹配括号的数量,并建立一个数组来存储左括号的下标，用于计算长度
            int validParentheses = 0;
            int startIndex =  s.indexOf('(');
            int endIndex =  s.lastIndexOf(')');
            int longest = 0;
            if (startIndex == -1 || endIndex == -1){
                return longest;
            }
            int[] leftIndex = new int[s.length()];
            Arrays.fill(leftIndex,0);
            for (int i = startIndex; i <= endIndex; i++) {
                if (s.charAt(i) =='('){
                    leftIndex[validParentheses] = i; //保存左括号的位置
                    validParentheses++;
                }else{
//                    如果为0了，且还是右括号，说明有效括号中断了，则跳过，并从新位置开始
                    if (validParentheses == 0){
//                        需要重新更换起点了,获取剩下字符串中左括号的起始位置，加上当前位置
                        startIndex = (s.substring(i,endIndex)).indexOf('(') + i;
//                        如果后续不存在左括号了，则退出循环
                        if (startIndex <= i){
                            break;
                        }
//                        定位当前位置到新起点位置（减一是为了循环+1）
                        i = startIndex -1;
                        continue;
                    }
                    validParentheses--;
//                  获取与当前有括号匹配的左括号的位置，并计算到最近一次未匹配的左括号的长度（使用MAX函数来排除 validParentheses自减后为0的情况）
                    if (longest <=(i - leftIndex[Math.max(validParentheses,1)-1])){
                        longest =(i - leftIndex[Math.max(validParentheses,1)-1]);
                    }
                    System.out.println(longest);
                }
                if (validParentheses == 0){
                    if (longest <= i - startIndex){
                        longest = (i - startIndex)+1;
                    }
                }
            }
            if (validParentheses != 0 && longest != 0 ){
                validParentheses--; //退到上一层
                if (longest <=(endIndex - leftIndex[validParentheses])){
                    longest =(endIndex - leftIndex[validParentheses]);
                }
            }
            return longest;
        }
    }

    public void test() {
       String s =/* "((()()(()((()";*/ "(()()"; /*"()(()";*/
        int result;
        Solution solution = new Solution();
        result = solution.longestValidParentheses(s);
        System.out.println(result);
    }
}
