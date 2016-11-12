//
// Created by Jacob su on 11/10/16.
//

#ifndef IMOOC_ALGORITHM_ELEMENT_SORT_H
#define IMOOC_ALGORITHM_ELEMENT_SORT_H
#include <cxxabi.h>
#include <iostream>

using namespace std;

namespace element_sort {
    template<typename T>
    void selection_sort(T arr[], int n);

    template<typename T>
    void selection_sort(T arr[], int n) {
        for (int i = 0; i < n; i++) {
            int min_index = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[min_index])
                    min_index = j;
            swap(arr[i], arr[min_index]);
        }
    }

    template <typename T>
    void insertion_sort(T arr[], int n) {
        for (int i = 1; i < n; ++i) {
            for (int j = i; j > 0; --j) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr[j], arr[j - 1]);
                } else {
                    break;
                }
            }
        }
    }

    template <typename T>
    void insertion_sort_improve(T arr[], int n) {
        for (int i = 1; i < n; i++) {
            T e = arr[i];
            int j;
            for (j = i; j > 0 && arr[j-1] > e; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }

    template <typename T>
    void bubble_sort(T arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j-1]) {
                    swap(arr[j], arr[j-1]);
                }
            }
        }
    }
}

#endif //IMOOC_ALGORITHM_ELEMENT_SORT_H_H
