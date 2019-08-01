    function fearNotLetter(str) {
        const alphabet = "abcdefghijklmnopqrstuvwxyz";
        let key = undefined;
        const arr = str.slice(0);
        let cont = 0;

        for (let j = alphabet.indexOf(arr[0]); j < alphabet.indexOf(arr.charAt(str.length-1)); j++) {
            if (arr[cont] !== alphabet[j]) {
                return alphabet[j];
            }
            cont++;
        }

        return key;
    }

        
    console.log( fearNotLetter("stvwx") );
