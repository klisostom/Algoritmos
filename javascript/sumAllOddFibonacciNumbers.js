function sumFibs(num) {
    let sum = 0;

    for (let i = 1; i < num + 1; i++) {
        const element = fibonaci(i);
        if ( element > num) return sum;
        if (element % 2 !== 0) sum += element;
    }

    return sum;
}

function fibonaci(num) {
    if (num < 2) return num;
    return fibonaci(num - 1) + fibonaci(num - 2);
}

console.log( sumFibs(75025) );
// 1, 1, 2, 3, 5, 8, 13, 21, 34

/*
sumFibs(4) should return 5.
sumFibs(75024) should return 60696.
sumFibs(75025) should return 135721.
*/
