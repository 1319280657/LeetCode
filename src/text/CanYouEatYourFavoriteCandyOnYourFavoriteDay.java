package text;

import java.util.Arrays;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-06-02 15:43
 **/

/**
 * 给你一个下标从 0 开始的正整数数组 candiesCount ，其中 candiesCount[i] 表示你拥有的第 i 类糖果的数目。同时给你一个二维数组 queries ，其中 queries[i] = [favoriteTypei, favoriteDayi, dailyCapi] 。
 * <p>
 * 你按照如下规则进行一场游戏：
 * <p>
 * 你从第 0 天开始吃糖果。
 * 你在吃完 所有 第 i - 1 类糖果之前，不能 吃任何一颗第 i 类糖果。
 * 在吃完所有糖果之前，你必须每天 至少 吃 一颗 糖果。
 * 请你构建一个布尔型数组 answer ，满足 answer.length == queries.length 。answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false 。注意，只要满足上面 3 条规则中的第二条规则，你就可以在同一天吃不同类型的糖果。
 * <p>
 * 请你返回得到的数组 answer 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
 * 输出：[true,false,true]
 * 提示：
 * 1- 在第 0 天吃 2 颗糖果(类型 0），第 1 天吃 2 颗糖果（类型 0），第 2 天你可以吃到类型 0 的糖果。
 * 2- 每天你最多吃 4 颗糖果。即使第 0 天吃 4 颗糖果（类型 0），第 1 天吃 4 颗糖果（类型 0 和类型 1），你也没办法在第 2 天吃到类型 4 的糖果。换言之，你没法在每天吃 4 颗糖果的限制下在第 2 天吃到第 4 类糖果。
 * 3- 如果你每天吃 1 颗糖果，你可以在第 13 天吃到类型 2 的糖果。
 * 示例 2：
 * <p>
 * 输入：candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
 * 输出：[false,true,true,false,false]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= candiesCount.length <= 105
 * 1 <= candiesCount[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 3
 * 0 <= favoriteTypei < candiesCount.length
 * 0 <= favoriteDayi <= 109
 * 1 <= dailyCapi <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 11 ms	75.2 MB
 */
public class CanYouEatYourFavoriteCandyOnYourFavoriteDay {

    class Solution {
        public boolean[] canEat(int[] candiesCount, int[][] queries) {
            boolean[] result = new boolean[queries.length];
            //计算前缀和的糖果总量
            long[] candiesSum = new long[candiesCount.length];
            Arrays.fill(result, false);
            candiesSum[0] = 0;
            for (int i = 1; i < candiesSum.length; i++) {
                candiesSum[i] = candiesCount[i - 1] + candiesSum[i - 1];
            }
            for (int i = 0; i < result.length; i++) {
                long x1 = queries[i][1];
                long y1 = (x1+1) * queries[i][2];
                long x2 = ((long) (candiesSum[queries[i][0]]));
                long y2 = ((long) x2) + candiesCount[queries[i][0]];
                result[i] = x2 < y1 && y2 > x1;
            }
            return result;
        }
      /* public boolean[] canEat(int[] candiesCount, int[][] queries) {
           int n = candiesCount.length;

           // 前缀和
           long[] sum = new long[n];
           sum[0] = candiesCount[0];
           for (int i = 1; i < n; ++i) {
               sum[i] = sum[i - 1] + candiesCount[i];
           }

           int q = queries.length;
           boolean[] ans = new boolean[q];
           for (int i = 0; i < q; ++i) {
               int[] query = queries[i];
               int favoriteType = query[0], favoriteDay = query[1], dailyCap = query[2];

               long x1 = favoriteDay + 1;
               long y1 = (long) (favoriteDay + 1) * dailyCap;
               long x2 = favoriteType == 0 ? 1 : sum[favoriteType - 1] + 1;
               long y2 = sum[favoriteType];

               ans[i] = !(x1 > y2 || y1 < x2);
               ans[i] = x1<=y2 && y1>=x2;
           }
           return ans;
       }*/
    }

    public void test() {
        int s[] = {46,5,47,48,43,34,15,26,11,25,41,47,15,25,16,50,32,42,32,21,36,34,50,45,46,15,46,38,50,12,3,26,26,16,23,1,4,48,47,32,47,16,33,23,38,2,19,50,6,19,29,3,27,12,6,22,33,28,7,10,12,8,13,24,21,38,43,26,35,18,34,3,14,48,50,34,38,4,50,26,5,35,11,2,35,9,11,31,36,20,21,37,18,34,34,10,21,8,5};
        int k[][] = {{85, 54, 42}};
        // System.out.println(s[k[0][0]] +  " + "+ k[0][0]);
        boolean[] result;
        Solution solution = new Solution();
        result = solution.canEat(s, k);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i] + ",");
        }

    }
}
