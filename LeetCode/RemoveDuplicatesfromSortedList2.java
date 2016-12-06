/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicatesfromSortedList2
 * 【作者】: liuyang
 * 【时间】: 16/12/2 下午9:05
 * 【题目】: Remove Duplicates from Sorted List2(移除有序链表中的重复元素2)
 * 【内容】: 给定一个有序链表,删除所有有重复值的节点,只留下没有重复值的节点。例如：1->2->3->3->4->4->5,返回：1->2->5.
 * 【版本】: V2.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 */
public class RemoveDuplicatesfromSortedList2 {
    //方法一：4个变量
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        //创建虚拟头结点head2，处理原头节点非法的情况
        ListNode head2 = new ListNode(head.val-1);
        head2.next = head;
        ListNode node = head2;//node为合法节点
        ListNode pre = head2;//pre为当前节点cur的前驱
        ListNode cur = pre.next;//cur为当前遍历的节点
        while (cur != null) {
            //cur为最后一个节点时，若cur与pre值相等，则cur无效
            if (cur.next == null && cur.val == pre.val){
                node.next = null;
            }
            //加入新链表的两种情况:(1)cur与pre、next的值均不相等(2)next为空的情况下，cur与pre不等
            if ((cur.next != null && cur.val != pre.val && cur.val != cur.next.val)||(cur.next == null && cur.val != pre.val)) {
                node.next = cur;
                node = node.next;
            }
            //每次遍历cur、pre依次后移
            pre = pre.next;
            cur = cur.next;
        }
        return head2.next;
    }

    //方法二：3个变量
    /*
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode head2 = new ListNode(head.val-1);
        head2.next = head;
        ListNode pre = head2;//pre为上一个不重复的节点
        ListNode cur = pre.next;//cur为当前遍历的节点
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            if (pre.next == cur) {
                pre = pre.next;
            } else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return head2.next;
    }
    */

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        RemoveDuplicatesfromSortedList2 t = new RemoveDuplicatesfromSortedList2();
        printListNode(t.deleteDuplicates(node1));
        System.out.println();
    }

    public static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}