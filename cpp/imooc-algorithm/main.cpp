#include <iostream>
#include "student.h"
#include "sort_help.h"
#include "element_sort.h"

using namespace std;

int main() {
    int a[10] = {1, 5, 4, 3, 2, 6, 9, 7, 8, 10};
    element_sort::selection_sort(a, 10);
    sort_helper::printArray(a, 10);

    float f[4] = {4.2, 3.2, 5.1, 1.0};
    element_sort::selection_sort(f, 4);
    sort_helper::printArray(f, 4);

    string c[4] = {"B", "C", "A", "D"};
    element_sort::selection_sort(c, 4);
    sort_helper::printArray(c, 4);

    student s[4] = {{"D", 23}, {"A", 11},  {"C", 49}, {"B", 41}};
    sort_helper::test_sort("insertion sort", element_sort::insertion_sort, s, 4);
    sort_helper::printArray(s, 4);

    int n = 1000;
    int* arr = sort_helper::generateRandomArray(n, 0, n);
    sort_helper::test_sort("selection sort", element_sort::selection_sort, arr, n);
    sort_helper::printArray(arr, n);

    delete[] arr;

    return 0;
}