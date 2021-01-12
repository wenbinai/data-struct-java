package com.example.linklist;


/**
 * 单链表的常用操作
 */
public class LinkList {
    /**
     * 遍历链表, 获取链表长度
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param headNode
     * @return
     */
    public static int ListLength(ListNode headNode) {
        int length = 0;
        ListNode tmpHead = headNode;
        while (tmpHead != null) {
            length++;
            tmpHead = tmpHead.getNext();
        }

        return length;
    }

    /**
     * 在position位置上插入一个节点
     * 注意: 头节点的position为1
     * 1. 判断头节点是否为空
     * 2. 判断position是否上溢或下溢
     * 3. 获取positon的上个节点
     * 4. 获取position节点
     * 5. insertNode.next = positionNode
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
    public ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {
            headNode = nodeToInsert;
            headNode.setNext(null);
        }
        int length = ListLength(headNode);
        if (position < 1 || position > length) {
            // 提醒或抛出异常
            System.out.println("position not current");
            return null;
        }
        if (position == 1) {
            nodeToInsert.setNext(headNode);
        }
        ListNode tmpHead = headNode;
        int i = 1;
        while (i < position - 1) {
            tmpHead = tmpHead.getNext();
            i++;
        }
        // 获得position 前一个
        ListNode preNode = tmpHead;
        preNode.setNext(nodeToInsert);
        // 获得position当前
        ListNode currentNode = tmpHead.getNext();
        nodeToInsert.setNext(currentNode);

        return headNode;
    }

    /**
     * 删除指定位置的节点
     * 1. 判断head是否为null
     * 2. 考虑删除一般节点的逻辑
     * 获取pos的前一个节点pre
     * pre.next = pre.next.next
     * 3. 考虑特殊情况
     * 删除头节点: headNode = headNode.next
     * 删除尾节点: pre.next = null
     * <p>
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     *
     * @param headNode
     * @param position
     * @return
     */
    public ListNode DeleteNodeFromLinkedList(ListNode headNode, int position) {
        if (headNode == null) {
            System.out.println("linklist not exist");
            return null;
        }
        int length = ListLength(headNode);
        if (position < 1 || position > length) {
            System.out.println("position is not current");
            return null;
        }
        if (position == 1) {
            headNode = headNode.getNext();
            return headNode;
        }
        int i = 1;
        ListNode tmpHead = headNode;
        while (i < position - 1) {
            tmpHead = tmpHead.getNext();
        }
        tmpHead.setNext(tmpHead.getNext().getNext());
        return null;
    }

    /**
     * 删除整个链表
     * (Java当中, 垃圾回收器会自动回收)
     * 主要是模拟作用
     *
     * @param headNode
     */
    public void DeleteLinkedList(ListNode headNode) {
        ListNode tmpNode, tmpHead = headNode;
        while (tmpHead != null) {
            tmpNode = tmpHead.getNext();
            tmpHead = null;
            tmpHead = tmpNode;
        }
    }
}
