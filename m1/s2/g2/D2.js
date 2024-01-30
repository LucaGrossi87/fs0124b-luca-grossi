/* ESERCIZIO 1
 Scrivi un algoritmo per trovare il più grande tra due numeri interi.
*/

let a = 8;
let b = 5;

if(a > b){
    console.log("Il numero " + a + " è maggiore del numero " + b);
  } else if(a < b){
    console.log("Il numero " + b + " è maggiore del numero " + a);
  } else {
    console.log("I numeri " + a + " e " + b + " sono equivalenti");
  }

/* ESERCIZIO 2
  Scrivi un algoritmo che mostri "not equal" in console se un numero intero fornito è diverso da 5.
*/

let c = 8;

if(c !== 5){
    console.log("not equal");
  }

/* ESERCIZIO 3
  Scrivi un algoritmo che mostri "divisibile per 5" in console se un numero fornito è perfettamente divisibile per 5 (suggerimento: usa l'operatore modulo)
*/

let d=25;

if(d % 5 === 0){
    console.log("divisibile per 5");
  }

/* ESERCIZIO 4
  Scrivi un algoritmo per verificare che, dati due numeri interi, il valore di uno di essi sia 8 oppure se la loro addizione/sottrazione sia uguale a 8.
*/

let e=5;
let f=3;

if(e === 8 || f === 8){
    console.log("Uno dei valori vale 8");
  } else if(e+f === 8){
    console.log("La somma dei valori è 8");
  } else if(e-f === 8 || f-e === 8){
    console.log("La sottrazione dei valori è 8");
  }

/* ESERCIZIO 5
  Stai lavorando su un sito di e-commerce. Stai salvando il saldo totale del carrello dell'utente in una variabile "totalShoppingCart".
  C'è una promozione in corso: se il totale del carrello supera 50, l'utente ha diritto alla spedizione gratuita (altrimenti la spedizione ha un costo fisso pari a 10).
  Crea un algoritmo che determini l'ammontare totale che deve essere addebitato all'utente per il checkout.
*/

let totalShoppingCart=80;
const SHIPPING_FEE=10;

if(totalShoppingCart > 50){
    console.log("Prezzo finale : " + totalShoppingCart);
  } else {
    console.log("Prezzo finale: " + (totalShoppingCart+SHIPPING_FEE));
  }

/* ESERCIZIO 6
  Stai lavorando su un sito di e-commerce. Oggi è il Black Friday e viene applicato il 20% su ogni prodotto.
  Modifica la risposta precedente includendo questa nuova promozione nell'algoritmo, determinando come prima se le spedizioni sono gratuite oppure no e e calcolando il totale.
*/

let discount=0.8;

if(totalShoppingCart > 50){
    console.log("Prezzo finale : " +  (totalShoppingCart*discount));
  } else {
    console.log("Prezzo finale: " + (totalShoppingCart*discount+SHIPPING_FEE));
  }


/* ESERCIZIO 7
  Crea tre variabili, e assegna un valore numerico a ciascuna di esse.
  Utilizzando un blocco condizionale, crea un algoritmo per ordinarle secondo il loro valore, dal più alto al più basso.
  Alla fine mostra il risultato in console.
*/

let g=3;
let h=5;
let i=7;

if(g > h && h> i){
    console.log(g, h, i);
  } else if(g > i && i> h){
    console.log(g, i, h);
  } else if(h > g && g> i){
    console.log(h, g, i);
  } else if(h > i && i> g){
    console.log(h, i, g);
  } else if(i > h && h> g){
    console.log(i, h, g);
  } else {
    console.log(i, g, h);
  }

let list=[g, h, i];
console.log(list);

list.reverse();
console.log(list);

/* ESERCIZIO 8
  Crea un algoritmo per verificare che un valore fornito sia un numero oppure no (suggerimento: cerca su un motore di ricerca "typeof").
*/


let l="parola";

if(typeof l === Number){
    console.log("la variabile è un numero");
  } else {
    console.log("la variabile non è un numero");
  }

/* ESERCIZIO 9
  Crea un algoritmo per controllare se un numero fornito sia pari o dispari (suggerimento: cerca l'operatore modulo su un motore di ricerca)
*/

let m=7;

if(d % 2 === 0){
    console.log("il numero è pari");
  } else {
    console.log("il numero è dispari");
  }

/* ESERCIZIO 10
  Modifica la logica del seguente algoritmo in modo che mostri in console il messaggio corretto in ogni circostanza.
  let val = 7
  if (val < 10) {
      console.log("Meno di 10");
    } else if (val < 5) {
      console.log("Meno di 5");
    } else {
      console.log("Uguale a 10 o maggiore");
    }
*/

let val = 7;

if (val < 5) {
    console.log("Meno di 5");
  } else if (val < 10) {
    console.log("Meno di 10");
  } else {
    console.log("Uguale a 10 o maggiore");
    }

/* ESERCIZIO 11
  Fornito il seguente oggetto, scrivi del codice per aggiungere una proprietà "city", il cui valore sarà "Toronto".
*/

const me = {
    name: 'John',
    lastName: 'Doe',
    skills: ['javascript', 'html', 'css'],
  }

me.city = 'Toronto';

console.log(me);

/* ESERCIZIO 12
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere la proprietà "lastName".
*/

delete me.lastName;

console.log(me);

/* ESERCIZIO 13
  Lavorando sempre sull'oggetto precedentemente fornito, scrivi del codice per rimuovere l'ultimo elemento della proprietà "skills".
*/

delete me.skills[me.skills.length - 1];

console.log(me);

/* ESERCIZIO 14
  Scrivi del codice per creare un array inizialmente vuoto. Riempilo successivamente con i numeri da 1 a 10.
*/

let array = []

console.log(array);

array.push(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
console.log(array);

/* ESERCIZIO 15
  Scrivi del codice per sostituire l'ultimo elemento dell'array, ovvero il valore 10, con il valore 100.
*/

array.splice(array.length - 1, 1, 100);
console.log(array);
