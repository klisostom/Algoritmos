function convertHTML(str) {
    // &colon;&rpar;

    for (const i of str) {
        switch (i) {
            case '&':
                str = str.replace(i, '&amp;');
                break;
            case '<':
                // '&lt;';
                str =str.replace(i, '&lt;');
                break;
            case '>':
                // '&gt';
                str =str.replace(i, '&gt;');
                break;
            case '"':
                // '&bdquo;';
                str = str.replace(i, '&quot;');
                break;
            case "'":
                // '&sbquo;';
                str = str.replace(i, '&apos;');
                break;
        }
    }
        
    return str;
}

console.log( convertHTML('Stuff in "quotation marks"') );

/* 
convertHTML("Dolce & Gabbana") should return Dolce &​amp; Gabbana.
convertHTML("Hamburgers < Pizza < Tacos") should return Hamburgers &​lt; Pizza &​lt; Tacos.
convertHTML("Sixty > twelve") should return Sixty &​gt; twelve.
*/
