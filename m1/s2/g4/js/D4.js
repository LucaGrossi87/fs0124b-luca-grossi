/* ESERCIZIO 1
 Scrivi una funzione di nome "area", che riceve due parametri (l1, l2) e calcola l'area del rettangolo associato.
*/

let area = (l1, l2) => l1 * l2;

console.log(area(3,5))

/* ESERCIZIO 2
 Scrivi una funzione di nome "crazySum", che riceve due numeri interi come parametri.
 La funzione deve ritornare la somma dei due parametri, ma se il valore dei due parametri è il medesimo deve invece tornare
 la loro somma moltiplicata per tre.
*/

function crazySum (a,b){
    if (a === b){
            return((a+b)*3);
    } else {
            return(a+b)
    }
}

console.log (crazySum(3,5))

/* ESERCIZIO 3
 Scrivi una funzione di nome "crazyDiff" che calcola la differenza assoluta tra un numero fornito come parametro e 19.
 Deve inoltre tornare la differenza assoluta moltiplicata per tre qualora il numero fornito sia maggiore di 19.
*/

function crazyDiff (a){
    if (a>19) {
        return Math.abs(a-19)*3
    } else{
    return Math.abs(a-19);
    }
}

console.log(crazyDiff (25));

/* ESERCIZIO 4
 Scrivi una funzione di nome "boundary" che accetta un numero intero n come parametro, e ritorna true se n è compreso tra 20 e 100 (incluso) oppure
 se n è uguale a 400.
*/

function boundary (n) {
    if (n>20 && n<100 || n===400) {
        return true
    }
}

console.log(boundary (99))

/* ESERCIZIO 5
 Scrivi una funzione di nome "epify" che accetta una stringa come parametro.
 La funzione deve aggiungere la parola "EPICODE" all'inizio della stringa fornita, ma se la stringa fornita comincia già con "EPICODE" allora deve
 ritornare la stringa originale senza alterarla.
*/

function epify (a) {
    if (typeof(a) === 'string') {
        if (a==='EPICODE') {
            return a
        } else {
        return 'EPICODE ' + a
        }
    }
}

console.log(epify ('EPISODE'));

/* ESERCIZIO 6
 Scrivi una funzione di nome "check3and7" che accetta un numero positivo come parametro. La funzione deve controllare che il parametro sia un multiplo
 di 3 o di 7. (Suggerimento: usa l'operatore modulo)
*/

function check3and7 (p) {
    if (p>0) {
        if (p % 3 === 0) {
            return 'p è divisibile per 3'
        } else if (p % 7 === 0) {
            return 'p è divisibile per 7'
        }
    }
}

console.log(check3and7(7));

/* ESERCIZIO 7
 Scrivi una funzione di nome "reverseString", il cui scopo è invertire una stringa fornita come parametro (es. "EPICODE" --> "EDOCIPE")
*/

function reverseString(s) {
    if (typeof(s) === 'string') {
        return s.split("").reverse().join("");
    }
}

console.log(reverseString ('gianfranco'));

/* ESERCIZIO 8
 Scrivi una funzione di nome "upperFirst", che riceve come parametro una stringa formata da diverse parole.
 La funzione deve rendere maiuscola la prima lettera di ogni parola contenuta nella stringa.
*/

function upperFirst (a) {
    if (typeof(a) === 'string'){
        let wordPool = a.split(" ")
        for (let i=0; i<wordPool.length; i++){
            let wordLetters = wordPool[i].split("")
            let uppFirst = wordLetters[0].toUpperCase()
            wordLetters[0] = uppFirst
            wordPool[i] = wordLetters.join("")
            }
        return wordPool.join(" ")
    }
}

console.log(upperFirst ('parola amici ciao'));

/* ESERCIZIO 9
 Scrivi una funzione di nome "cutString", che riceve come parametro una stringa. La funzione deve creare una nuova stringa senza il primo e l'ultimo carattere
 della stringa originale.
*/

function cutString (a) {
    if (typeof(a) === 'string') {
        let wordLetters = a.split("").slice(1,length-1).join("")
        return wordLetters
    }
}

console.log(cutString('ambarabaciccicoccò'));


/* ESERCIZIO 10
 Scrivi una funzione di nome "giveMeRandom", che accetta come parametro un numero n e ritorna un'array contenente n numeri casuali inclusi tra 0 e 10.
*/

function giveMeRandom (n) {
    if (typeof(n)==='number'){
        let resultArray = []
            for (let i=0; i<n; i++){
            resultArray.push(Math.floor(Math.random() * 10))
        }
        return resultArray
    }
}

console.log(giveMeRandom(5))