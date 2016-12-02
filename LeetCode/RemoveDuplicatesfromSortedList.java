/**
 * 【工程】: LeetCode 包名: PACKAGE_NAME 类名: RemoveDuplicatesfromSortedList
 * 【作者】: liuyang
 * 【时间】: 16/12/2 下午8:42
 * 【题目】: Remove Duplicates from Sorted List(移除有序链表中的重复元素)
 * 【内容】: 给定一个有序链表,删除所有重复节点,使得每个元素只出现一次
 * 【版本】: V1.0
 * 【运行时间】:
 * 【时间复杂度】:
 * 【空间复杂度】:
 * 【备注】:
 * 【思路】:
 * 对于每一个当前节点cur及其下一个节点next,若cur的值与next的值不等,则依次后移;若cur的值与next的值相等,则cur指向的下一个节点为next的下一个节点。
 */
public class RemoveDuplicatesfromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            if (cur.val == next.val)
                cur.next = next.next;
            else
                cur = next;
            next = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedList t = new RemoveDuplicatesfromSortedList();
        System.out.println();
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}