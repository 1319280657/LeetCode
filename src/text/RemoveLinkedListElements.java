package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-06-07 16:05
 **/

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 * 提示：
 * 列表中的节点在范围 [0, 104] 内
 * 1 <= Node.val <= 50
 * 0 <= k <= 50
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-linked-list-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 1 ms	39.1 MB
 */
public class RemoveLinkedListElements {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) return head;
            ListNode result = head, preNode = head;
            while (preNode != null && preNode.val == val) {
                preNode = preNode.next;
            }
            if (preNode == null) return preNode;
            result = preNode;
            while (preNode.next != null) {
                if (val == preNode.next.val) {
                    preNode.next = preNode.next.next;
                } else {
                    preNode = preNode.next;
                }
            }
            return result;
        }
    }

    public void test() {
        ListNode head, result, preNode;
        int val = 6;
        head = preNode = result = null;
        int[] nums = {6, 6, 6, 6, 6, 6, 6};
        for (int i = 0; i < nums.length; i++) {
            if (head == null) {
                preNode = head = new ListNode(nums[i]);
                continue;
            }
            preNode.next = new ListNode(nums[i]);
            preNode = preNode.next;
        }
        Solution solution = new Solution();
        result = solution.removeElements(head, val);
        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

    }
}
