package text;

/**
 * @program: LeetCode
 * @description: ${description}
 * @author: 13192
 * @create: 2021-05-24 23:37
 **/
/**
 *给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 *
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 *
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 *  
 *
 * 提示：
 *
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 2 ms	38.7 MB
 * */
public class AddTwoNumber {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode resultListNode = new ListNode();
            ListNode lastNode = resultListNode;
            ListNode newNode;
            int val = 0;
            while (l1 != null && l2!= null) {
                val = l1.val + l2.val + (val / 10);
                newNode = new ListNode((val % 10));
                lastNode.next = newNode;
                lastNode = newNode;
                l1 = l1.next;
                l2 = l2.next;
            }
            if (l2 != null) {
                lastNode.next = l2;
            } else if (l1 != null)
                lastNode.next = l1;
            while ((val / 10)>0){
                //表明需要进位，判断是否需要新增节点
                if (lastNode.next ==null){
                    newNode = new ListNode(0);
                    lastNode.next = newNode;
                }
                lastNode = lastNode.next;
                val = lastNode.val  + (val / 10);
                lastNode.val = val%10; //加上之前的进位

            }
            return resultListNode.next;
        }
    }

    public void test() {
       int[] l1Array = {9};
        int[] l2Array = {9};
        ListNode newNode ;
        ListNode lastNode = new ListNode(l1Array[0]);
        ListNode l1 = lastNode;
        for (int i = 1; i < l1Array.length; i++) {
            newNode = new ListNode(l1Array[i]);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        lastNode = new ListNode(l2Array[0]);
        ListNode l2 = lastNode;
        for (int i = 1; i < l2Array.length; i++) {
            newNode = new ListNode(l2Array[i]);
            lastNode.next = newNode;
            lastNode = newNode;
        }


        ListNode listNode;
        Solution solution = new Solution();
        listNode = solution.addTwoNumbers(l1, l2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
