function dropElements(arr, func) {
    // Drop them elements.

    let result = 0;

    for (let i = 0, len = arr.length; i < len; i++) {
        let value = func(arr[i]);

        if (value) {
            result = (arr.slice(i) );
            break;
        } 
    }

    return result !== 0 ? result: new Array(0);
}

console.log( dropElements([1, 2, 3, 4], function(n) {return n > 5;}) );


/*
dropElements([0, 1, 0, 1], function(n) {return n === 1;}) should return [1, 0, 1].
dropElements([1, 2, 3], function(n) {return n > 0;}) should return [1, 2, 3].
dropElements([1, 2, 3, 4], function(n) {return n > 5;}) should return [].
*/
