    function uniteUnique(...arr) {
        const temp = arr.slice(0);
        const temp2 = temp.shift();

        for (let i = 0; i < temp.length; i++) {
            for (let j = 0; j < temp[i].length; j++) {
                let value = temp[i][j];
                if (!temp2.includes(value)) {
                    temp2.push(value);
                }
            }
        }

        return temp2;
    }

    console.log( uniteUnique([1, 3, 2], [5, 2, 1, 4], [2, 1]) );
/*
uniteUnique([1, 3, 2], [5, 2, 1, 4], [2, 1]) should return [1, 3, 2, 5, 4].
uniteUnique([1, 3, 2], [1, [5]], [2, [4]]) should return [1, 3, 2, [5], [4]].
*/
