
function diffArray(arr1, arr2) {
    let newArr = [];
    let A1 = arr1.slice(0);
    let A2 = arr2.slice(0);
    // Same, same; but different.

    for (let i = 0, len = arr1.length; i < len; i++) {
        for (let j = 0, len = arr2.length; j < len; j++) {
            if (arr1[i] === arr2[j]) {
                A1[i] = -1;
                A2[j] = -1;
            }
        }
    }

    newArr = A1.filter( (i) => i !== -1);
    newArr = newArr.concat( A2.filter( (j) => j !== -1) );

    return newArr;
}

console.log( diffArray([1, 2, 3, 5], [1, 2, 3, 4, 5]) );
