package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-06-04 12:14
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * <p>
 * 图示两个链表在节点 c1 开始相交：
 * 题目数据 保证 整个链式结构中不存在环。
 * 注意，函数返回结果后，链表必须 保持其原始结构 。
 * 示例 1：
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Intersected at '8'
 * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
 * 在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 示例 2：
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Intersected at '2'
 * 解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。
 * 从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。
 * 在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 * 示例 3：
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。
 * 由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 这两个链表不相交，因此返回 null 。
 *  
 * <p>
 * 提示：
 * <p>
 * listA 中节点数目为 m
 * listB 中节点数目为 n
 * 0 <= m, n <= 3 * 104
 * 1 <= Node.val <= 105
 * 0 <= skipA <= m
 * 0 <= skipB <= n
 * 如果 listA 和 listB 没有交点，intersectVal 为 0
 * 如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 * 进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoLinkedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
/*        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode result = null;
            ListNode nodeA = headA,nodeB = headB;
            //先使用常规思路，验证两个链表中是否有已存在的值
            Set<ListNode>  resultMap = new HashSet<>();
            while (nodeA!= null){
                resultMap.add(nodeA);
                nodeA = nodeA.next;
            }
            while (nodeB != null){
              if((resultMap.contains(nodeB))){
                    result = nodeB;
                    break;
                }
                else{
                    nodeB = nodeB.next;
                }
            }
            return result;
        }*/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode result = null;
    ListNode nodeA = headA,nodeB = headB;
    //尝试进阶思路，达到一次循环解决。

    return result;
}
    }


    public void test() {
        ListNode headA, headB, result,intersectionNodes;
        headA = headB = null;
        int[] numsA = {2,2};
        int[] numsB = {2,2};
        int[] numsC = {4,5,4};
        intersectionNodes =  new ListNode(numsC[0]);
        result = intersectionNodes;
        for (int i = 1; i < numsC.length; i++) {
            result.next = new ListNode(numsC[i]);
            result = result.next;
        }
        headA = new ListNode(numsA[0]);
        result = headA;
        for (int i = 1; i < numsA.length; i++) {
            result.next = new ListNode(numsA[i]);
            result = result.next;
        }
        result.next = intersectionNodes;
                headB = new ListNode(numsB[0]);
        result = headB;
        for (int i = 1; i < numsB.length; i++) {
            result.next = new ListNode(numsB[i]);
            result = result.next;
        }
        result.next = intersectionNodes;
        result = headA;
        while (result!= null){
            System.out.print(result.val + "\t");
            result = result.next;
        }
        System.out.println();
        result = headB;
        while (result!= null){
            System.out.print(result.val + "\t");
            result = result.next;
        }
        System.out.println();
        Solution solution = new Solution();
        result = solution.getIntersectionNode(headA, headB);
        if (result!= null) System.out.println(result.val);
        else System.out.println("NULL");

    }

}
