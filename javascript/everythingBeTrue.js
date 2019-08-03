function truthCheck(collection, pre) {
    let cont = 0;

    for (const i in collection) {
        if (collection[i].hasOwnProperty(pre)) {
            if (collection[i][pre]) {
                cont++;
            }
        }
    }

    return cont === collection.length ? true : false;
}

console.log(
    truthCheck([{"user": "Tinky-Winky", "sex": "male", "age": 0}, {"user": "Dipsy", "sex": "male", "age": 3}, {"user": "Laa-Laa", "sex": "female", "age": 5}, {"user": "Po", "sex": "female", "age": 4}], "age")
);

/*
truthCheck([{"single": "double"}, {"single": undefined}], "single") should return false
truthCheck([{"single": "double"}, {"single": NaN}], "single") should return false
*/
