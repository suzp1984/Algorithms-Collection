//
// Created by Jacob su on 11/20/16.
//

#ifndef IMOOC_ALGORITHM_HEAP_H
#define IMOOC_ALGORITHM_HEAP_H
#include <cxxabi.h>
#include <iostream>
#include <assert.h>

using namespace std;

template <typename Item>
class MaxHeap {
private:
    Item* data;
    int count;
    int capacity;

    void swim(int k) {
        while (k > 1 && data[k/2] < data[k]) {
            swap(data[k/2], data[k]);
            k /= 2;
        }
    }

    void sink(int k) {
        while (2*k <= count) {
            int j = 2*k;
            if (j + 1 <= count && data[j+1] > data[j]) {
                j++;
            }

            if (data[k] > data[j]) {
                break;
            }

            swap(data[k], data[j]);

            k = j;
        }
    }

public:
    MaxHeap(int capacity) {
        data = new Item[capacity+1];
        this->capacity = capacity;
        count = 0;
    }

    MaxHeap(Item arr[], int n) {
        data = new Item[n+1];
        this->capacity = n;
        for (int i = 0; i < n; i++) {
            data[i+1] = arr[i];
        }
        count = n;

        for (int i = count/2; i >= 1; i--) {
            sink(i);
        }
    }

    ~MaxHeap() {
        delete[] data;
    }

    int size() {
        return count;
    }

    bool is_empty() {
        return count == 0;
    }

    void insert(Item item) {
        assert(count + 1  <= capacity);
        data[count+1] = item;
        count++;
        swim(count);
    }

    Item pop_max() {
        assert(count > 0);
        Item ret = data[1];

        swap(data[1], data[count]);
        count--;
        sink(1);

        return ret;
    }
};

#endif //IMOOC_ALGORITHM_HEAP_H
