function steamrollArray(arr) {
    
    let temp = arr.toString();
    temp = temp.split(',');

    return temp.map((i) => {
        if (i == '[object Object]') {
            return {};
        } else if (isNaN(i)) {
            return i;
        }else if (i == []) {
            return '';
        } else {
            return parseInt(i);
        }
    }).filter( (i) => i !== '');
}

console.log( steamrollArray( [1, [], [3, [[4]]]] ));


/*
steamrollArray([1, [2], [3, [[4]]]]) should return [1, 2, 3, 4].
steamrollArray([1, [], [3, [[4]]]]) should return [1, 3, 4].
steamrollArray([1, {}, [3, [[4]]]]) should return [1, {}, 3, 4].
*/
