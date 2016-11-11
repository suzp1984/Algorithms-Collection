//
// Created by Jacob su on 11/10/16.
//

#ifndef IMOOC_ALGORITHM_SORT_HELP_H
#define IMOOC_ALGORITHM_SORT_HELP_H

#include <iostream>

using namespace std;

namespace sort_helper {
    int* generateRandomArray(int n, int range_l, int range_r);

    template<typename T>
    void printArray(T arr[], int n) {
        for (int i = 0; i < n; ++i) {
            cout << arr[i] << " ";
        }

        cout << endl;
    }
}
#endif //IMOOC_ALGORITHM_SORT_HELP_H_H
