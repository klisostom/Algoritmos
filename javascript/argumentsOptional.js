function addTogether() {
    let args = Array.from(arguments);
    let a = args[0];
    let b = args[1];

    if ( args.length > 1 ) {
        if (typeof a === 'number' && typeof b === 'number') {
            return a + b;
        } else {
            return undefined;
        }
    } else if (args.length == 1){

        if(typeof a !== 'number'){
            return undefined;
        } 
        
        return (b) => {
            return typeof b !=='number' ? undefined : a + b;
        }
    }
        
}

console.log( addTogether(3)(4) );

/*
addTogether("http://bit.ly/IqT6zt") should return undefined.
addTogether(2, "3") should return undefined.
addTogether(2)([3]) should return undefined.
*/
