package com.oolong.oil.algori.sort;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
public class MaxPQ<Key> implements Iterable<Key> {
    private Key[] pq;                    // store items at indices 1 to n
    private int n;                       // number of items on priority queue
    private Comparator<Key> comparator;  // optional comparator

    //MaxPQ支持对max对象进行删除操作，对任意对象进行插入操作，
    //这些操作最终会转化为上浮swim和下沉sink两个操作，以维持二叉堆的特性。

    //swim和sink的循环不变量：元素k的值比其父元素都小，这也是二叉堆的特性。
    private void swim(int k) {
        //上浮条件：非根节点和父元素比子元素小
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private void sink(int k) {
        //下沉条件：具有至少一个子节点
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;//如果左子节点比右子节点小，则选择下沉到右子节点，否则下沉到左子节点。即下沉到大的节点。
            if (!less(k, j)) break;//如果比子节点都大，那么已经是符合二叉堆的特性了，直接结束。
            exch(k, j);
            k = j;
        }
    }

    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }

    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key x) {
        if (n == pq.length - 1) resize(2 * pq.length);
        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loitering and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }


    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    // is pq[1..n] a max heap?
    private boolean isMaxHeap() {
        for (int i = 1; i <= n; i++) {
            if (pq[i] == null) return false;
        }
        for (int i = n+1; i < pq.length; i++) {
            if (pq[i] != null) return false;
        }
        if (pq[0] != null) return false;
        return isMaxHeapOrdered(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeapOrdered(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
    }

    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {

        // create a new pq
        private MaxPQ<Key> copy;

        // add all items to copy of heap
        // takes linear time since already in heap order so no keys move
        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<Key>(size());
            else                    copy = new MaxPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }

    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        pq.insert("F");
        pq.insert("A");
        pq.insert("S");
        pq.insert("T");
        pq.insert("O");
        pq.insert("Q");

        while(!pq.isEmpty()) {
            String max = pq.delMax();
            System.out.println(max + ",");
        }
    }

}
