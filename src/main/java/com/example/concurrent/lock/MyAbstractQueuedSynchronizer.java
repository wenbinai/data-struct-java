package com.example.concurrent.lock;

import java.util.concurrent.locks.AbstractOwnableSynchronizer;

public abstract class MyAbstractQueuedSynchronizer extends AbstractOwnableSynchronizer {
    protected MyAbstractQueuedSynchronizer() {
    }

    static final class Node {
        static final Node SHARED = new Node();

        static final Node EXCLUSIVE = null;

        static final int CANCELED = 1;

        static final int SIGNAL = -1;

        static final int CONDITION = -2;

        static final int PROPAGATE = -3;

        volatile int waitStatus;

        volatile Node prev;

        volatile Node next;

        volatile Thread thread;

        Node nextWaiter;

        final boolean isShared() {
            return nextWaiter == SHARED;
        }

        // Used to establish initial head or SHARED marker
        Node() {
        }

        // Used by addWaiter
        Node(Thread thread, Node mode) {
            this.nextWaiter = mode;
            this.thread = thread;
        }

        // Used by Condition
        Node(Thread thread, int waitStatus) {
            this.waitStatus = waitStatus;
            this.thread = thread;
        }
    }

    // Head of the wait queue, lazily initialized.
    // Except for initialization, it is modified only via method setHead.
    // Note: if head exists, its waitStatus is guaranteed not to be CANCELLED
    private volatile Node head;

    // Tail of the wait queue, lazily initialized.
    // Modified only via method enq to add new wait node.
    private volatile Node tail;
    // the synchronized state
    private volatile int state;

    protected final int getState() {
        return state;
    }

    protected final void setState(int newState) {
        state = newState;
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe
    }


}
