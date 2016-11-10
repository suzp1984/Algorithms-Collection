#include <iostream>
#include "student.h"
#include "sort_help.h"
#include "element_sort.h"

using namespace std;

//template<typename T>
//void selectionSort(T arr[], int n) {
//    for (int i = 0; i < n; i ++) {
//        int min_index = i;
//        for (int j = i + 1; j < n; j++)
//            if (arr[j] < arr[min_index])
//                min_index = j;
//        swap(arr[i], arr[min_index]);
//    }
//}

int main() {
//    int a[10] = {1, 5, 4, 3, 2, 6, 9, 7, 8, 10};
//
//    element_sort::selection_sort(a, 10);
//    // selectionSort(a, 10);
//    for (int i = 0; i < 10; i++) {
//        cout << a[i] << " ";
//    }
//    cout << endl;
//
//    float f[4] = {4.2, 3.2, 5.1, 1.0};
//
//    element_sort::selection_sort(f, 4);
//    // selectionSort(f, 4);
//    for (int i = 0; i < 4; ++i) {
//        cout << f[i] << " ";
//    }
//    cout << endl;
//
//    string c[4] = {"B", "C", "A", "D"};
//    element_sort::selection_sort(c, 4);
//
//    for (int i = 0; i < 4; ++i) {
//        cout << c[i] << " ";
//    }
//    cout << endl;
//
//    student s[4] = {{"D", 23}, {"A", 11},  {"C", 49}, {"B", 41}};
//    selectionSort(s, 4);
//    for (int i = 0; i < 4; ++i) {
//        cout << s[i];
//    }
//    cout << endl;

    int n = 1000;
    int* arr = sort_helper::generateRandomArray(n, 0, n);
    element_sort::selection_sort(arr, n);
    for (int i = 0; i < n; ++i) {
        cout << arr[i] << " ";
    }
    cout << endl;

    delete[] arr;

    return 0;
}