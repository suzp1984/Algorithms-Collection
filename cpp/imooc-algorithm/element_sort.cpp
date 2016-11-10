//
// Created by Jacob su on 11/10/16.
//

#include <cxxabi.h>
#include <iostream>
#include "element_sort.h"

using namespace std;

namespace element_sort {
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
