package inter.patterns.sorting;

import ch.qos.logback.core.util.InvocationGate;
import com.google.protobuf.CodedInputStream;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

// https://last9.io/blog/heaps-in-java/
public class KthLargestNumber {

    private int getKthLargest(int[] numbers, int k) {
        heap = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (heap.size() < k) {
                insert(numbers[i]);
            } else {
                var kth = heap.getFirst();
                var number = numbers[i];
                if (number > kth) {
                    removeHead();
                    insert(number);
                }
            }
        }
        return heap.getFirst();
    }

    private ArrayList<Integer> heap;

    private void swap(int i, int k) {
        var temp = heap.get(i);
        heap.set(i, heap.get(k));
        heap.set(k, temp);
    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChildIndex(int i) {
        return 2 * i + 1;
    }

    private int getRightChildIndex(int i) {
        return 2 * i + 2;
    }

    private void insert(int element) {
        heap.add(element);
        int index = heap.size() - 1;
        while (index > 0 && heap.get(index) < heap.get(getParentIndex(index))) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private int removeHead() {
        var min = heap.get(0);
        // swap last element with head
        heap.set(0, heap.remove(heap.size() - 1));
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int position) {
        int smallest = position;
        int left = getLeftChildIndex(position);
        int right = getRightChildIndex(position);
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        if (smallest != position) {
            swap(position, smallest);
            heapifyDown(smallest);
        }

    }


}
