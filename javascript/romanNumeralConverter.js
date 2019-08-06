function convertToRoman(num) {

    const arr = num.toString().split('');
    const len = arr.length;
    const centenaRomana = ["", "C","CC","CCC","CD","D","DC","DCC","DCCC","CM"];
    const dezenaRomana = ["","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"];
    const unidadeRomana = ["","I","II","III","IV","V","VI","VII","VIII","IX"];

    if (len > 3) {
        
        let M = ''; // para saber a quantidade de emes ('M')
        for (let i = 0; i < arr[0]; i++) {
            M += 'M';
        }
        
        const unidade = unidadeRomana[parseInt(arr[arr.length - 1])] === undefined ? '' : unidadeRomana[parseInt(arr[arr.length - 1])];
        const dezena = dezenaRomana[parseInt(arr[arr.length - 2])] === undefined ? '' : dezenaRomana[parseInt(arr[arr.length - 2])];
        const centena = centenaRomana[parseInt(arr[arr.length - 3])] === undefined ? '' : centenaRomana[parseInt(arr[arr.length - 3])];

        return '' + M + '' + centena + '' + dezena + '' + unidade;
    }

    if (len === 3) {
        const unidade = unidadeRomana[parseInt(arr[arr.length - 1])] === undefined ? '' : unidadeRomana[parseInt(arr[arr.length - 1])];
        const dezena = dezenaRomana[parseInt(arr[arr.length -  2])] === undefined ? '' : dezenaRomana[parseInt(arr[arr.length - 2])];
        const centena = centenaRomana[parseInt(arr[arr.length - 3])] === undefined ? '' : centenaRomana[parseInt(arr[arr.length - 3])];

        return '' + centena + '' + dezena + '' + unidade;
    }

    if (len == 2) {
        const unidade = unidadeRomana[parseInt(arr[arr.length -1])] === undefined ? '' : unidadeRomana[parseInt(arr[arr.length -1])];
        const dezena = dezenaRomana[parseInt(arr[arr.length - 2])] === undefined ? '' : dezenaRomana[parseInt(arr[arr.length - 2])];

        return '' + dezena + '' + unidade;
    }

    return unidadeRomana[parseInt(arr[0])];
}

console.log( convertToRoman(1004) ); // MIV

/*
convertToRoman(1023) should return "MXXIII"
convertToRoman(2014) should return "MMXIV"
convertToRoman(3999) should return "MMMCMXCIX"
*/
