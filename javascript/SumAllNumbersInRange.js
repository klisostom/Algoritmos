function sumAll(arr) {
    const first = arr[0];
    const end = arr[arr.length - 1];
    let sum = 0;
    let maior = 0;
    let menor = 0;

    if (first > end) {
        maior = first;
        menor = end;
    } else if (first < end) {
        maior = end;
        menor = first;
    }

    for (let i = menor+1; i < maior; i++) {
        sum += i;
    }

    return sum + (first + end);
}

console.log( sumAll([4, 1]) );
