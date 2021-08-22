package text;


import java.util.*;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-30 21:25
 **/

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 示例 1：
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * 提示：
 *
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 1ms  38.84MB
 * */
public class LetterCombinationsOfAPhoneNumber {

    class Solution {
        public List<String> letterCombinations(String digits) {
            //1.计算可能性，并将字符集合初始化
            if (digits.length() == 0) {
                return new ArrayList<String>();
            }
            int possibleNum = 1;
            int letterNum;
            Map lettersMap = new HashMap();
            String lettersAray;
            for (int i = 0; i < digits.length(); i++) {
                switch (digits.charAt(i)) {
                    case '2':
                        letterNum = 3;
                        lettersAray = "abc";
                        break;
                    case '3':
                        letterNum = 3;
                        lettersAray = "def";
                        break;
                    case '4':
                        letterNum = 3;
                        lettersAray = "ghi";
                        break;
                    case '5':
                        letterNum = 3;
                        lettersAray = "jkl";
                        break;
                    case '6':
                        letterNum = 3;
                        lettersAray = "mno";
                        break;
                    case '7':
                        letterNum = 4;
                        lettersAray = "pqrs";
                        break;
                    case '8':
                        letterNum = 3;
                        lettersAray = "tuv";
                        break;
                    case '9':
                        letterNum = 4;
                        lettersAray = "wxyz";
                        break;
                    default:
                        return null;
                }
                possibleNum *= letterNum;
                lettersMap.put(digits.charAt(i), lettersAray);
            }
            String[] result = new  String[possibleNum];
            Arrays.fill(result,"");
            letterNum = possibleNum;
            for (int i = 0; i < digits.length(); i++) {
                lettersAray = (String) lettersMap.get(digits.charAt(i));
                letterNum = letterNum / lettersAray.length();
                for (int j = 0, letterIndex = 0; j < possibleNum; j++) {
                    result[j] = result[j] + String.valueOf(lettersAray.charAt(letterIndex));
                    if ( (j+1)%(letterNum) == 0) {
                        letterIndex++;
                        if (letterIndex == lettersAray.length()){
                            letterIndex =0;
                        }
                    }
                }
            }
            return Arrays.asList(result);
        }
    }


    public void test() {
        String s = "789";
        List<String> result;
        Solution solution = new Solution();
        result = solution.letterCombinations(s);
        for (String letter:result
             ) {
            System.out.print(letter+"\t");
        };
    }
}
