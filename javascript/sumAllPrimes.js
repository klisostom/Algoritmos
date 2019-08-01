function sumPrimes(n) {
    // Eratosthenes algorithm to find all primes under n
    let array = [];
    let upperLimit = Math.floor(Math.sqrt(n));
    let output = [];

    // Make an array from 2 to (n - 1)
    for (let i = 0; i <= n; i++) {
        array.push(true);
    }

    // Remove multiples of primes starting from 2, 3, 5,...
    for (let i = 2; i <= upperLimit; i++) {
        if (array[i]) {
            for (let j = i * i; j <= n; j += i) {
                array[j] = false;
            }
        }
    }

    // All array[i] set to true are primes
    for (let i = 2; i <= n; i++) {
        if(array[i]) {
            output.push(i);
        }
    }

    // Summing the primes
    let sum = 0;
    for (const z of output) {
        sum += z;
    }

    return sum;
}

console.log( sumPrimes(977) );

/*
sumPrimes(10) should return a number.
sumPrimes(10) should return 17.
sumPrimes(977) should return 73156.
*/
