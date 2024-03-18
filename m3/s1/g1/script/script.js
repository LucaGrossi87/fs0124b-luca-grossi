"use strict";
class User {
    constructor(_nome, _cognome, _credito, _numeroChiamate) {
        this.nome = _nome;
        this.cognome = _cognome;
        this.credito = _credito;
        this.numeroChiamate = _numeroChiamate;
    }
    ricarica(recharge) {
        this.credito += recharge;
    }
    chiamata(minutes) {
        if (this.credito > minutes * 0.2) {
            this.credito -= minutes * 0.2;
            this.numeroChiamate += minutes;
        }
        else {
            console.log(`No money, no call! Yvan eht nioj!`);
        }
    }
    chiama404() {
        return `il credito residuo di ${this.nome} ${this.cognome} è di ${this.credito} €`;
    }
    getNumeroChiamata() {
        return `le chiamate totali di ${this.nome} ${this.cognome} ammontano a ${this.numeroChiamate}`;
    }
    azzeraChiamate() {
        this.numeroChiamate = 0;
    }
}
let gianniPinotto = new User('Gianni', 'Pinotto', 20, 30);
console.log(gianniPinotto);
gianniPinotto.ricarica(12);
gianniPinotto.chiamata(30);
console.log(gianniPinotto.chiama404());
console.log(gianniPinotto.getNumeroChiamata());
gianniPinotto.azzeraChiamate();
let arnoldoFogazzari = new User('Arnoldo', 'Fogazzari', 2, 40);
console.log(arnoldoFogazzari);
arnoldoFogazzari.ricarica(3);
arnoldoFogazzari.chiamata(25);
console.log(arnoldoFogazzari.chiama404());
console.log(arnoldoFogazzari.getNumeroChiamata());
arnoldoFogazzari.azzeraChiamate();
