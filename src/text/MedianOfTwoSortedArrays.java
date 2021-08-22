package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-24 17:04
 **/

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 * <p>
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 * <p>
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *  
 * <p>
 * 提示：
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 **/
public class MedianOfTwoSortedArrays {
    //    思路1： 计算出中位数的位置，然后有序合并两个数组，直到对应的位时
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length1 = nums1.length;
            int length2 = nums2.length;
            int index1 = 0;
            int index2 = 0;
            boolean flag1 = false;
            boolean flag2 = false;
            int midLength = (length1 + length2) / 2;
//          排除一方为空集的情况
            if (length1 == 0 || length2 == 0) {
                if (length1 == 0) {
                    if ((length2) % 2 == 0) {
                        return (nums2[midLength - 1] + nums2[midLength]) / 2.0;
                    } else {
                        return nums2[midLength];
                    }
                } else {
                    if ((length1) % 2 == 0) {
                        return (nums1[midLength - 1] + nums1[midLength]) / 2.0;
                    } else {
                        return nums1[midLength];
                    }
                }
            }

//           建立一个数组，用于存储合并后的有序数组
           // int[] sortArray = new int[midLength + 1];
            int sortArray1 =0;
            int sortArray2 =0;
            for (int i = 0; i < (midLength+1); i++) {
                if (!flag1 && !flag2) {
                    sortArray1 = sortArray2;
                    sortArray2 = nums1[index1] <= nums2[index2] ? nums1[index1++] : nums2[index2++];
                } else {
                    if (flag1) {
                        sortArray1 = sortArray2;
                        sortArray2 = nums2[index2++];
                    } else {
                        sortArray1 = sortArray2;
                        sortArray2 = nums1[index1++];
                    }
                }
//                如果任意一个数组合并完了，则
                if (index1 == length1) flag1 = true;
                if (index2 == length2) flag2 = true;
            }
            if ((length1 + length2) % 2 == 0) {
//               是偶数，则回顾两个
                return (sortArray2+sortArray1)/2.0;
            }else{
                return sortArray2;
            }

        }

    }

    public void test() {
        int[] nums1 = {};/*{5,2,4,6,6,3};*/
        int[] nums2 = {3, 4};/*{5,2,4,6,6,3};*/
        double midNumber = 0;
        Solution solution = new Solution();
        midNumber = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(midNumber);
    }

}
