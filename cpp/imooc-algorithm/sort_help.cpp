//
// Created by Jacob su on 11/10/16.
//

#include <cstdlib>
#include <ctime>
#include <cassert>
#include "sort_help.h"

namespace sort_helper {

    int* generateRandomArray(int n, int range_l, int range_r) {
        assert(range_l < range_r);

        int *arr = new int[n];

        srand(time(NULL));
        for (int i = 0; i < n; ++i) {
            arr[i] = rand() % (range_r - range_l + 1) + range_l;
        }

        return arr;
    }
}

