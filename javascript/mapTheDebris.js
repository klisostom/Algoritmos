function orbitalPeriod(arr) {
    let GM = 398600.4418;
    let earthRadius = 6367.4447;
    let tempArray = [];
    let avgAltValue = 0;

    for (let i = 0, len = arr.length; i < len; i++) {        
        avgAltValue = arr[i].avgAlt;
        const T = 2 * Math.PI * Math.sqrt( Math.pow((earthRadius + avgAltValue), 3) / GM);
        arr[i].orbitalPeriod = Math.round(T);
        delete arr[i].avgAlt;
        tempArray = tempArray.concat(arr[i]);
    }

    return tempArray;
}

console.log(orbitalPeriod(
    [
        {name: "iss", avgAlt: 413.6}, 
        {name: "hubble", avgAlt: 556.7}, 
        {name: "moon", avgAlt: 378632.553}
    ])
);



/*
orbitalPeriod([{name : "sputnik", avgAlt : 35873.5553}]) should return [{name: "sputnik", orbitalPeriod: 86400}].

orbitalPeriod([{name: "iss", avgAlt: 413.6}, {name: "hubble", avgAlt: 556.7}, {name: "moon", avgAlt: 378632.553}]) should return [{name : "iss", orbitalPeriod: 5557}, {name: "hubble", orbitalPeriod: 5734}, {name: "moon", orbitalPeriod: 2377399}].
*/
