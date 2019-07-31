function translatePigLatin(str) {
    const reg = /[aeiou]/i;

    if (str[0].match(reg)) {
        return str.concat('way');
    }

    const arrC = [];
    
    for (let i = 0; i < str.length && str[i].match(/[^aeiou]/ig) !== null; i++) {
        arrC.push(str[i]);
    }

    let novoStr = '';
    novoStr = novoStr.concat(str.slice(arrC.length));
    novoStr += arrC.join('');
    novoStr += 'ay';

    return novoStr;
}
    
console.log( translatePigLatin("california") );
