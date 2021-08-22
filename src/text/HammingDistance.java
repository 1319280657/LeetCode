package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-27 14:05
 **/
/**
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 231.
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 0ms   35.4MB
 * */
public class HammingDistance {
//直接异或，然后找1的个数就好了
    class Solution {
        public int hammingDistance(int x, int y) {
            int xorNumber = x^y;
            int result = 0;
            for (int i=0;i<=31;i++){
                if ((xorNumber & 1<<i)!=0){
                    result++;
                }
            }
            return result;

        }
    }

    public void test() {
      int x = 1;
        int y = 4;
        int result;
        Solution solution = new Solution();
        result = solution.hammingDistance(x, y);
        System.out.println(result);
    }
}
