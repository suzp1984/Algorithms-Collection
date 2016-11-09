#include <iostream>
#include "student.h"

using namespace std;

template<typename T>
void selectionSort(T arr[], int n) {
    for (int i = 0; i < n; i ++) {
        int min_index = i;
        for (int j = i + 1; j < n; j++)
            if (arr[j] < arr[min_index])
                min_index = j;
        swap(arr[i], arr[min_index]);
    }
}

int main() {
    int a[10] = {1, 5, 4, 3, 2, 6, 9, 7, 8, 10};

    selectionSort(a, 10);
    for (int i = 0; i < 10; i++) {
        cout << a[i] << " " << endl;
    }
    return 0;
}