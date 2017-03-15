function generateRandomArray(n, left, right) {
    let r =  [...new Array(n)].map(() => {
        return Math.floor(Math.random() * (right - left + 1)) + left;
    });

    return r;
}

function copyArray(arr) {
    return Array.from(arr);
}

export { generateRandomArray, copyArray };

