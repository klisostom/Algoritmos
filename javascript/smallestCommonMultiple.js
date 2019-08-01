function smallestCommons(arr) {
    // get a range
    let a = Math.min.apply(null, arr);
    let b = Math.max.apply(null, arr);

    let smallest = mmc(a, a + 1);

    while(a < b) {
        a++;
        smallest = mmc(smallest, a);
    }

    // greatest common divider
    function mdc(a, b){
        while(b !== 0){
            let r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // lowest common divisor
    function mmc(a, b) {
        return (a * b / mdc(a, b));
    }

    return smallest;
}

console.log( smallestCommons([1,3]) );

/*
smallestCommons([2, 10]) should return 2520.
smallestCommons([1, 13]) should return 360360.
smallestCommons([23, 18]) should return 6056820.
*/
