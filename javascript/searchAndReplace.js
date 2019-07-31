function myReplace(str, before, after) {
    if (before[0].match(/[A-Z]/)) {
        const letter = after[0].toUpperCase();
        after = after.replace(after[0], letter);
    }

    return str.replace(before, after);
}
    
console.log( myReplace("A quick brown fox jumped over the lazy dog",
"jumped", 
"leaped") );
