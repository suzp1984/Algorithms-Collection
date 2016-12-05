#ifndef BINARY_SEARCH_H
#define BINARY_SEARCH_H
#include <cxxabi.h>
#include <iostream>

using namespace std;

namespace binary_search {
    template <typename T>
    int binary_search(T arr[], int n, T target) {
        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int mid = (l+r) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            if (target < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }
}

#endif