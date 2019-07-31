function pairElement(str) {
    str = str.split('');
    
    const arr = [];
    
    str.map( (i) => {
        switch (i) {
            case 'A':
                arr.push(new Array("A", "T"));
                break;
            case 'T':
                arr.push(new Array("T", "A"));
                break;
            case 'G':
                arr.push(new Array("G", "C"));
                break;
            case 'C':
                arr.push(new Array("C", "G"));
                break;
        }
    });

    return arr;
}

    
console.log( pairElement("ATCGA") );
