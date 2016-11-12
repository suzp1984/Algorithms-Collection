//
// Created by Jacob su on 11/10/16.
//

#ifndef IMOOC_ALGORITHM_SORT_HELP_H
#define IMOOC_ALGORITHM_SORT_HELP_H

#include <iostream>

using namespace std;

namespace sort_helper {
    int* generateRandomArray(int n, int range_l, int range_r);
    int* generateNearlyOrderedArray(int n, int swap_times);
    int* copy_array(int arr[], int n);

    template<typename T>
    void printArray(T arr[], int n) {
        for (int i = 0; i < n; ++i) {
            cout << arr[i] << " ";
        }

        cout << endl;
    }

    template<typename T>
    void test_sort(string sort_name, void(*sort)(T[], int), T arr[], int n) {
        clock_t start = clock();

        sort(arr, n);

        clock_t end = clock();

        cout << sort_name << " : " << double(end - start)/CLOCKS_PER_SEC << " s" << endl;
    }
}
#endif //IMOOC_ALGORITHM_SORT_HELP_H_H
