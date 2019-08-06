function rot13(str) {
    const alphabet = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];
    const arrFinal = [];
    
    for (let i = 0, len = str.length; i < len; i++) {
        let special = true;

        for (let j = 0, lenJ = alphabet.length; j < lenJ; j++){
            if (str[i] === alphabet[j]) {
                arrFinal.push(alphabet[(j + 13) % 26]);
                special = false;
            }  
        }
        
        if (special) {
            arrFinal.push(str[i]);
        }
    }

    return arrFinal.join('');
}

console.log( rot13("SERR PBQR PNZC") );

/*
rot13("SERR YBIR?") should decode to FREE LOVE?
rot13("GUR DHVPX OEBJA SBK WHZCF BIRE GUR YNML QBT.") should decode to THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG.
*/
