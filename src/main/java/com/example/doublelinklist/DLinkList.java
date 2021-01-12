package com.example.doublelinklist;

public class DLinkList {
    /**
     * 向双链表指定位置插入一个节点nodeToInsert
     *
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
    public DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position) {
        if (headNode == null) {
            headNode = nodeToInsert;
        }
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            headNode = nodeToInsert;
        }
        int i = 1;
        DLLNode tmpHead = headNode;
        while (i < position - 1) {
            tmpHead = tmpHead.getNext();
            i++;
        }
        DLLNode preNode = tmpHead;
        DLLNode curNode = tmpHead.getNext();
        preNode.setNext(nodeToInsert);
        nodeToInsert.setNext(curNode);
        nodeToInsert.setPrevious(preNode);
        curNode.setPrevious(nodeToInsert);

        return headNode;
    }

    /**
     * 在双链表中删除指定位置的节点
     *
     * @param headNode
     * @param position
     * @return
     */
    public DLLNode DLLDelete(DLLNode headNode, int position) {
        return null;
    }
}
