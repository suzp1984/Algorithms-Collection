function generateRandomArray(n, left, right) {
    let r =  [...new Array(n)].map(() => {
        return Math.floor(Math.random() * (right - left + 1)) + left;
    });

    return r;
}

export { generateRandomArray };

