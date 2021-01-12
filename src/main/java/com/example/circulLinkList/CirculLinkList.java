package com.example.circulLinkList;


public class CirculLinkList {
    /**
     * 获取循环链表的长度
     *
     * @param headNode
     * @return
     */
    public int CirculLinkListLength(CLLNode headNode) {
        CLLNode tmpHead = headNode;
        int length = 0;
        while (tmpHead != null) {
            length++;
            tmpHead = tmpHead.getNext();
            if (tmpHead == headNode)
                break;
        }
        return length;
    }

    /**
     * 输出打印循环链表的内容
     *
     * @param headNode
     */
    public void PrintCirculLinkListData(CLLNode headNode) {
        CLLNode tmpHead = headNode;
        while (tmpHead != null) {
            System.out.print(tmpHead.getData() + " ");
            tmpHead = tmpHead.getNext();
            if (tmpHead == headNode)
                break;
        }
    }

    /**
     * 在循环链表的尾部插入一个节点
     *
     * @param headNode
     * @param nodeToInsert
     */
    public CLLNode InsertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        CLLNode tmpHead = headNode;
        while (tmpHead != null) {
            if (tmpHead.getNext() == headNode)
                break;
            else
                tmpHead = tmpHead.getNext();
        }
        tmpHead.setNext(nodeToInsert);
        nodeToInsert.setNext(headNode);

        return headNode;
    }

    /**
     * 在循环链表的表头插入元素
     * 注意: 表头变成为新插入的节点
     *
     * @param headNode
     * @param nodeToInsert
     * @return
     */
    public CLLNode InsertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert) {
        CLLNode tmpHead = headNode;

        return headNode;
    }
}
