package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-31 14:50
 **/

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 * 示例 1：
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 * 输入：n = 1
 * 输出：true
 * 提示：
 * -231 <= n <= 231 - 1
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1 ms	35.6 MB
 */
public class PowerOfFour {

    class Solution {
        public boolean isPowerOfFour(int n) {
            if (n <= 0 || n == 2147483647) {
                return false;
            }
            int result = 0x55555555;
            /*for (int i = 0; i < 16; i++) {
                result += 1<<(i*2);
            }*/
            if ((n & result) == n) {
             /*   String binaryNum = Integer.toBinaryString(n);
                if (binaryNum.indexOf('1') != binaryNum.lastIndexOf('1')) return false;*/
             //更简单的方法
             return (n&(n-1)) ==0;
            } else {
                return false;
            }
        }
    }

    public void test() {
        int s = 1;
        boolean result;
        Set<Integer> results = new HashSet<>();

        for (int i = 0; i < 16; i++) {
            results.add(s);
            s *= 4;
        }
        Solution solution = new Solution();
        for (int i = 0; i < 2147483647; i++) {
            result = solution.isPowerOfFour(i);
            if (result && !(results.contains(i))) {
                System.out.println("i = " + i);
            }

        }


        // System.out.println(result);
    }
}
