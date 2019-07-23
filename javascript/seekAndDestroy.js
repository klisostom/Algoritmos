
function destroyer(arr, ...args) {
    const t = arr.slice(0);
    
    for (let i = 0, len = args.length; i < len; i++) {
        for (let j = 0, len = arr.length; j < len; j++) {
            if (args[i] === arr[j]) {
                t.splice(t.indexOf(arr[j]), 1) 
            }
        }
    }
    
    return t;
}

console.log( destroyer([3, 5, 1, 2, 2], 2, 3, 5) );
