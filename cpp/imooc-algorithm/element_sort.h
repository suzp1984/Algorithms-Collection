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
    void insertion_sort(T arr[], int l, int r) {
        for (int i = l+1; i <= r; i++) {
            T e = arr[i];
            int j;
            for (j = i; j > l && arr[j-1] > e; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }

        return;
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

    template <typename T>
    void __merge(T arr[], int l, int mid, int r) {
        T aux[r-l+1];
        for (int i = l; i <= r; i++) {
            aux[i-l] = arr[i];
        }

        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j-l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i-l];
                i++;
            } else if (aux[i-l] < aux[j-l]) {
                arr[k] = aux[i-l];
                i++;
            } else {
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

    template <typename T>
    void __merge_sort(T arr[], int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = (l+r)/2;
        __merge_sort(arr, l, mid);
        __merge_sort(arr, mid+1, r);
        __merge(arr, l, mid, r);
    }

    template <typename T>
    void merge_sort(T arr[], int n) {
        __merge_sort(arr, 0, n-1);
    }

    template <typename T>
    void __merge_sort_improved(T arr[], int l, int r) {
        if (r - l <= 15) {
            insertion_sort(arr, l, r);
            return;
        }

        int mid = (l+r)/2;
        __merge_sort(arr, l, mid);
        __merge_sort(arr, mid+1, r);
        if (arr[mid] > arr[mid+1]) {
            __merge(arr, l, mid, r);
        }
    }

    template <typename T>
    void merge_sort_improved(T arr[], int n) {
        __merge_sort_improved(arr, 0, n-1);
    }

    template <typename T>
    void merge_sort_bottom_up(T arr[], int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                __merge(arr, i, i+sz-1, min(i+sz+sz-1, n-1));
            }
        }
    }

    template <typename T>
    int __partition(T arr[], int l, int r) {
        T v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr[++j], arr[i]);
            }
        }

        swap(arr[l], arr[j]);
        return j;
    }

    template <typename T>
    void __quick_sort(T arr[], int l, int r) {
        if (l >= r) {
            return;
        }

        int p = __partition(arr, l, r);
        __quick_sort(arr, l, p-1);
        __quick_sort(arr, p+1, r);
    }

    template<typename T>
    void quick_sort(T arr[], int n) {
        __quick_sort(arr, 0, n-1);
    }

    template <typename T>
    int __partition_random(T arr[], int l, int r) {
        swap(arr[l], arr[rand()%(r-l+1) + l]);

        T v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr[++j], arr[i]);
            }
        }

        swap(arr[l], arr[j]);
        return j;
    }

    template <typename T>
    void __quick_sort_random(T arr[], int l, int r) {
        if (l >= r) {
            return;
        }

        int p = __partition_random(arr, l, r);
        __quick_sort(arr, l, p-1);
        __quick_sort(arr, p+1, r);
    }

    template <typename T>
    void quick_sort_random(T arr[], int n) {
        srand(time(NULL));
        __quick_sort_random(arr, 0, n-1);
    }

}

#endif //IMOOC_ALGORITHM_ELEMENT_SORT_H_H
