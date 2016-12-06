/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RemoveNthNodeFromEndofList
 * 【作者】: liuyang
 * 【时间】: 16/12/6 下午10:32
 * 【题目】: Remove Nth Node From End of List(移除链表中倒数第N个节点)
 * 【内容】: 给定一个链表，删除倒数第N个节点并返回新链表的头结点。例如：链表是1->2->3->4->5，n=2，则新链表是1->2->3->5.
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 * 首先，设置两个指针fast和slow，快指针先走n个节点。
 * 然后，两个指针一直后移直到fast!=null&&fast.next!=null。此时，slow指针移动到倒数第n+1个节点
 * 最后，令slow.next=slow.next.next,返回head即可。
 * 思考问题：while循环中的条件改为：fast.next!=null会大幅度提高运行时间
 */
public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //快指针先走n个节点
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        //处理特殊情况，删除头结点
        if (fast == null) {
            return head.next;
        }
        //得到倒数第n+1个节点
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //删除倒数第n个节点
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        RemoveNthNodeFromEndofList t = new RemoveNthNodeFromEndofList();
        ListNode head = t.removeNthFromEnd(n1, 1);
        System.out.println(head);
    }
}