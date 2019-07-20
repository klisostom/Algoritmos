// the global Array
var s = [23, 65, 98, 5];

Array.prototype.myMap = function(callback){
    var newArray = [];

    for (let i = 0, len = this.length; i < len; i++) {
        newArray.push(callback(this[i]) );
    }

    return newArray;
};

var new_s = s.myMap(function(item){
    return item * 2;
});

console.log(new_s);
