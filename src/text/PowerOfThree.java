package text;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-31 17:34
 **/
public class PowerOfThree {

    class Solution {
        public boolean isPowerOfThree(int n) {
            if (n <= 0) {
                return false;
            }
            String binaryNum = Integer.toString(n,3);
            //System.out.println(binaryNum);
            if (binaryNum.indexOf('1') != binaryNum.lastIndexOf('1') /*|| binaryNum.indexOf('1') ==-1 */|| binaryNum.indexOf('2') >=0) return false;
            return true;
        }
    }

    public void test() {
        int s = 1;
        boolean result;
        Set<Integer> results = new HashSet<>();

        for (int i = 0; i < 31; i++) {
            results.add(s);
            s *= 3;
        }
        Solution solution = new Solution();
        for (int i = 0; i < 2147483647; i++) {
            result = solution.isPowerOfThree(i);
            if (result && !(results.contains(i))) {
                System.out.println("i = " + i);
            }

        }


        // System.out.println(result);
    }
}
