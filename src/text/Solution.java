package text;


import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-23 14:50
 **/

/**
 * 给你一个由非负整数组成的数组 nums 。另有一个查询数组 queries ，其中 queries[i] = [xi, mi] 。
 * 第 i 个查询的答案是 xi 和任何 nums 数组中不超过 mi 的元素按位异或（XOR）得到的最大值。换句话说，答案是 max(nums[j] XOR xi) ，
 * 其中所有 j 均满足 nums[j] <= mi 。如果 nums 中的所有元素都大于 mi，最终答案就是 -1 。
 * 返回一个整数数组 answer 作为查询的答案，其中 answer.length == queries.length 且 answer[i] 是第 i 个查询的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,2,3,4], queries = [[3,1],[1,3],[5,6]]
 * 输出：[3,3,7]
 * 解释：
 * 1) 0 和 1 是仅有的两个不超过 1 的整数。0 XOR 3 = 3 而 1 XOR 3 = 2 。二者中的更大值是 3 。
 * 2) 1 XOR 2 = 3.
 * 3) 5 XOR 2 = 7.
 * 示例 2：
 * <p>
 * 输入：nums = [5,2,4,6,6,3], queries = [[12,4],[8,1],[6,3]]
 * 输出：[15,-1,5]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * queries[i].length == 2
 * 0 <= nums[j], xi, mi <= 109
 */
public class Solution {
// 使用常规思路总会超时，参考其他人解法之后转变为二进制的二叉树进行解决

    /**
     * public int[] maximizeXor(int[] nums, int[][] queries) {
     * int[] querie;
     * int[] results = new int[queries.length];
     * int maxNumber = 0;
     * int minNumber = nums[0];
     * Integer charge;
     * Set<Integer> numsInSet = new TreeSet<>();
     * for (int i = 0; i < nums.length; i++) {
     * if(minNumber > nums[i]){
     * minNumber = nums[i];
     * }
     * numsInSet.add(nums[i]);
     * }
     * //        先对 nums进行排序  时间太慢，所以换种思路
     * for (int i = 0; i < numsIn.length; i++) {
     * for (int j = i + 1; j < numsIn.length; j++) {
     * if (numsIn[i] > numsIn[j]) {
     * charge = numsIn[i];
     * numsIn[i] = numsIn[j];
     * numsIn[j] = charge;
     * }
     * }
     * }
     * for (int i = 0; i < queries.length; i++) {
     * querie = queries[i];
     * maxNumber = 0;
     * if (minNumber > querie[1]) {
     * maxNumber = -1;
     * } else {
     * //                换成set集合了，所以此处也需要进行队形的转换
     * for (int j = 0; j < numsIn.length; j++) {
     * //                如果大于了，就停止进行异或
     * if (numsIn[j] > querie[1]) {
     * break;
     * } else {
     * if (maxNumber < (numsIn[j] ^ querie[0])) {
     * maxNumber = (numsIn[j] ^ querie[0]);
     * }
     * }
     * }
     * //                从HashSet切换到TreeSet
     * for (Integer num:numsInSet
     * ) {
     * if (num > querie[1]) {
     * continue;
     * } else {
     * System.out.println((num ^ querie[0]));
     * if (maxNumber < (num ^ querie[0])) {
     * maxNumber = (num ^ querie[0]);
     * }
     * }
     * }
     * charge = ((TreeSet<Integer>) numsInSet).floor(querie[1]);
     * while(charge != null){
     * if (maxNumber < (charge ^ querie[0])) {
     * maxNumber = (charge ^ querie[0]);
     * }
     * charge = ((TreeSet<Integer>) numsInSet).lower(charge);
     * }
     * }
     * results[i] = maxNumber;
     * }
     * return results;
     * }
     */
//  转二叉树之后运行通过
//  执行用时：160 ms
//  内存消耗：100.5 MB
    public class Node {
        Node left = null;  //为0则是左节点
        Node right = null; //为1则是右节点
        int minNum = Integer.MAX_VALUE; //存储最小值（在此处就是存储以本节点为父节点的最小值）
    }

    public class Tree {
        public Node root;

        public Tree() {
            this.root = new Node();
        }

        public void add(int num) {
//            将输入的数字转换成二进制，并存储到二叉树上，
            Node node = this.root;
            node.minNum = Integer.min(node.minNum, num);
            Node newNode = null;
            for (int i = 30; i >= 0; i--) {
//                如果当前位是0，则前往左边节点，为1则前往右边节点
                if ((((1 << i) & num) == 0)) {
                    if (node.left == null) {
                        newNode = new Node();
                        node.left = newNode;
                    }
                    node = node.left;
                } else {
                    if (node.right == null) {
                        newNode = new Node();
                        node.right = newNode;
                    }
                    node = node.right;
                }
                node.minNum = Integer.min(node.minNum, num);
            }
        }
/*
*因为需要查找最大的异或值，所以按位判断异或数的值，找出最靠近根节点的小于限制值的差异节点
*如果当前异或数的位为0，就往右边找小于限制值的节点，如果右子节点不满足小于限制值的话，则移到当前节点的左子节点，然后继续判断下一位
*如果当前异或数的位为1，就往左边找小于限制值的节点，如果左子节点不满足小于限制值的话，则移到当前节点的右子节点，然后继续判断下一位
*
* */
        public int search(int[] querie) {
            int maximizeXor = 0;
            Node node = this.root;
            if (node.minNum > querie[1]) return -1;
            for (int i = 30; i >= 0; i--) {
                if (((1 << i) & querie[0]) == 0) {
                    if (node.right != null && node.right.minNum <= querie[1]) {
                        maximizeXor += (1 << i);
                        node = node.right;
                    } else if (node.left != null && node.left.minNum <= querie[1]) {
                        node = node.left;
                    } else return -1;
                } else {
                    if (node.left != null && node.left.minNum <= querie[1]) {
                        maximizeXor += (1 << i);
                        node = node.left;
                    } else if (node.right != null && node.right.minNum <= querie[1]) {
                        node = node.right;
                    } else return -1;
                }
            }
            return maximizeXor;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        Tree tree = new Tree();
        for (int i : nums
        ) {
            tree.add(i);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = tree.search(queries[i]);
        }
        return result;
    }

    public  void test(){

        int[] numsIn = {536870912,0,534710168,330218644,142254206};/*{5,2,4,6,6,3};*/
        int[][] queries =  {{214004,404207941}};/*{{12,4},{8,1},{6,3}};*/
        int[] resultNumbers ;
        //System.out.println("当期那时间为：" + (new Date().getTime()));
        resultNumbers = maximizeXor(numsIn,queries);
        //System.out.println("当期那时间为：" + (new Date().getTime()));
        for (int i:resultNumbers
        ) {
            System.out.println(i);
        }
    }
}
