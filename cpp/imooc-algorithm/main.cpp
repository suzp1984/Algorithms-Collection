#include <iostream>
#include "student.h"
#include "sort_help.h"
#include "element_sort.h"

using namespace std;

int main() {
//    int a[10] = {1, 5, 4, 3, 2, 6, 9, 7, 8, 10};
//    element_sort::selection_sort(a, 10);
//    sort_helper::printArray(a, 10);
//
//    float f[4] = {4.2, 3.2, 5.1, 1.0};
//    element_sort::selection_sort(f, 4);
//    sort_helper::printArray(f, 4);
//
//    string c[4] = {"B", "C", "A", "D"};
//    element_sort::selection_sort(c, 4);
//    sort_helper::printArray(c, 4);
//
//    student s[4] = {{"D", 23}, {"A", 11},  {"C", 49}, {"B", 41}};
//    sort_helper::test_sort("insertion sort", element_sort::insertion_sort, s, 4);
//    sort_helper::printArray(s, 4);
//
//    int n = 1000;
//    int* arr = sort_helper::generateRandomArray(n, 0, n);
//    sort_helper::test_sort("insertion sort", element_sort::insertion_sort, arr, n);
//    sort_helper::printArray(arr, n);
//    delete[] arr;
//
//    int* arr2 = sort_helper::generateRandomArray(n, 0, n);
//    sort_helper::test_sort("insertion sort improved", element_sort::insertion_sort_improve, arr2, n);
//    sort_helper::printArray(arr2, n);
//
//    delete[] arr2;
//
//    int* arr3 = sort_helper::generateRandomArray(n, 0, n);
//    sort_helper::test_sort("Bubble sort", element_sort::bubble_sort, arr3, n);
//    sort_helper::printArray(arr3, n);
//
//    delete[] arr3;
//
//    n = 10000;
//    int* merge_arr = sort_helper::generateRandomArray(n, 0, n);
//    int* merge2_arr = sort_helper::copy_array(merge_arr, n);
//    sort_helper::test_sort("merge sort", element_sort::merge_sort, merge_arr, n);
//    sort_helper::test_sort("insertion sort", element_sort::insertion_sort_improve, merge2_arr, n);
//    sort_helper::printArray(merge_arr, n);
//
//    delete[] merge2_arr;
//    delete[] merge_arr;
//
//    int* merge3_arr = sort_helper::generateRandomArray(n, 0, n);
//    int* merge4_arr = sort_helper::copy_array(merge3_arr, n);
//    sort_helper::test_sort("merge sort", element_sort::merge_sort, merge3_arr, n);
//    sort_helper::test_sort("improved merge sort", element_sort::merge_sort_improved, merge4_arr, n);
//    sort_helper::printArray(merge4_arr, n);
//
//    delete[] merge3_arr;
//    delete[] merge4_arr;
//
//    int* merge5_arr = sort_helper::generateRandomArray(n, 0, n);
//    int* merge6_arr = sort_helper::copy_array(merge5_arr, n);
//    sort_helper::test_sort("merge sort", element_sort::merge_sort, merge5_arr, n);
//    sort_helper::test_sort("bottom up merge sort", element_sort::merge_sort_bottom_up, merge6_arr, n);
//
//    delete[] merge5_arr;
//    delete[] merge6_arr;
//
//    int* quick_arr = sort_helper::generateRandomArray(n, 0, n);
//    sort_helper::test_sort("quick sork", element_sort::quick_sort, quick_arr, n);
//
//    delete[] quick_arr;

    int n = 10000;
    int* nearly_ordered_a = sort_helper::generateNearlyOrderedArray(n, 2);
    sort_helper::test_sort("random sort", element_sort::quick_sort_random, nearly_ordered_a, n);
    sort_helper::printArray(nearly_ordered_a, n);

    delete[] nearly_ordered_a;

    return 0;
}