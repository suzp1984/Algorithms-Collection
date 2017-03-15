function generateRandomArray(n, left, right) {
    let r =  [...new Array(n)].map(() => {
        return Math.floor(Math.random() * (right - left + 1)) + left;
    });

    return r;
}

function generateDuplicatedItemsArray(n, times) {
    let a = [...new Array(n)].map((x, i) => i);
    for(let i = 0; i < times; i++) {
        let x = Math.floor(Math.random() * n);
        let y = Math.floor(Math.random() * n);
        a[x] = a[y];
    }

    return a;
}

function generateNearlyOrderedArray(n, times) {
    let a = [...new Array(n)].map((x, i) => i);
    for(let i = 0; i < times; i++) {
        let x = Math.floor(Math.random() * n);
        let y = Math.floor(Math.random() * n);
        swap(a, x, y);
    }

    return a;
}

function copyArray(arr) {
    return Array.from(arr);
}

function swap(arr, x, y) {
    let t = arr[x];
    arr[x] = arr[y];
    arr[y] = t;
}

export { generateRandomArray,
         generateDuplicatedItemsArray,
         generateNearlyOrderedArray,
         copyArray,
         swap};

