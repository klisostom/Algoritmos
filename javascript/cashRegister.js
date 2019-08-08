function checkCashRegister(price, cash, cid) {
    let change_ = [];
    const unidades = [
        {unit: "PENNY", amount: 0.01},
        {unit: "NICKEL", amount: 0.05},
        {unit: "DIME", amount: 0.1}, 
        {unit: "QUARTER", amount: 0.25},
        {unit: "ONE", amount: 1},
        {unit: "FIVE", amount: 5}, 
        {unit: "TEN", amount: 10},
        {unit: "TWENTY", amount: 20},
        {unit: "ONE HUNDRED", amount: 100},
    ];
    const TROCO = Number((cash - price).toFixed(2) );

    // CashRegister Currently Value
    function calcCashRegister() {
        let value = 0;

        for (let i = 0, len = cid.length; i < len; i++) {
            value += cid[i][1];
        }

        return value;
    }

    const cashRegister = Number(calcCashRegister().toFixed(2) );
    // End CashRegister Currently Value

    if (cashRegister < TROCO ) {
        return { status: 'INSUFFICIENT_FUNDS', change: [] };
    } else if (cashRegister === TROCO) {
        return { status: 'CLOSED', change: cid };// devo retornar as moedas de troco
    } else {
        let tempTROCO = TROCO;
        let nota = 0;
        let quantoFalta = tempTROCO;

        //============== INSUFFICIENT_FUNDS ================
        let arr = [];
        for (let i = unidades.length - 1; i > -1 && Number(quantoFalta).toFixed(2) > 0.00; i--) {
            if (cid[i][1] !== 0 && unidades[i].amount <= quantoFalta) {
                quantoFalta -= cid[i][1];
            };
        }

        if (quantoFalta > 0.00) return { status: 'INSUFFICIENT_FUNDS', change: [] };
        //=============== END INSUFFICIENT_FUNDS ===============

        quantoFalta = tempTROCO;
        for (let i = unidades.length - 1; i > -1 && Number(quantoFalta).toFixed(2) > 0.00; i--) { // Começando do maior para o menor cash
            
            // subtrair o troco
            if (unidades[i].amount <= tempTROCO) {//encontrei a moeda certa

                if (cid[i][1] < Number(quantoFalta).toFixed(2) && cid[i][1] > 0.00) {// O que diabos faz isso???
                    quantoFalta -= cid[i][1];
                    nota = [cid[i][0], cid[i][1]];
                    change_.push(nota);
                    cid[i][1] = 0;
                } else { 
                    let count = 0;
                    let trocoAtual = quantoFalta;
                    let moeda = unidades[i].amount;
                    
                    if (Number(trocoAtual).toFixed(2) >= moeda) {
                        while (Number(trocoAtual).toFixed(2) >= moeda) {
                            trocoAtual -= moeda;
                            count += moeda;
                        }

                        quantoFalta = trocoAtual;
                        cid[i][1] -= count;

                        nota = [cid[i][0], count];
                        change_.push(nota);
                    }
                }
            }
        }

        return {status: "OPEN", change: change_};
    }
}


console.log( 
checkCashRegister(19.5, 20, [
    ["PENNY", 0.01], 
    ["NICKEL", 0], 
    ["DIME", 0], 
    ["QUARTER", 0], 
    ["ONE", 1], 
    ["FIVE", 0], 
    ["TEN", 0], 
    ["TWENTY", 0], 
    ["ONE HUNDRED", 0]
]) 
);




/*
checkCashRegister(19.5, 20, [["PENNY", 0.01], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 1], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]]) should return {status: "INSUFFICIENT_FUNDS", change: []}.
Passed
checkCashRegister(19.5, 20, [["PENNY", 0.5], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]]) should return {status: "CLOSED", change: [["PENNY", 0.5], ["NICKEL", 0], ["DIME", 0], ["QUARTER", 0], ["ONE", 0], ["FIVE", 0], ["TEN", 0], ["TWENTY", 0], ["ONE HUNDRED", 0]]}.
*/
