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

    
}

#endif //IMOOC_ALGORITHM_ELEMENT_SORT_H_H
