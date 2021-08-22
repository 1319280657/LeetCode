package text;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-31 17:05
 **/
public class PowerOfTwo {

    class Solution {
        public boolean isPowerOfTwo(int n) {
            if (n <= 0) {
                return false;
            }
            /*String binaryNum = Integer.toBinaryString(n);
            if (binaryNum.indexOf('1') != binaryNum.lastIndexOf('1')) return false;
            return true;*/
            //            更简单的方法
            return (n&(n-1))==0;

        }
    }

    public void test() {
        int s = 1;
        boolean result;
        Set<Integer> results = new HashSet<>();

        for (int i = 0; i < 31; i++) {
            results.add(s);
            s *= 2;
        }
        Solution solution = new Solution();
        for (int i = 0; i < 2147483647; i++) {
            result = solution.isPowerOfTwo(i);
            if (result && !(results.contains(i))) {
                System.out.println("i = " + i);
            }

        }


        // System.out.println(result);
    }
}
