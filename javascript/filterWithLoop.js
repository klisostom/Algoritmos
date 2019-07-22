// the global Array
let s = [23, 65, 98, 5];

Array.prototype.myFilter = function(callback){
    let newArray = [];

    for (let i = 0, len = this.length; i < len; i++) {
        if (callback(this[i])) {
            newArray.push( this[i] );
        } 
    }
    
    return newArray;

};

let new_s = s.myFilter(function(item){
    return item % 2 === 1;
});

console.log(new_s);
