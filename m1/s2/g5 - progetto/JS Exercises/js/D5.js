/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per visualizzare l'output, lancia il file HTML a cui è collegato e apri la console dagli strumenti di sviluppo del browser. 
- Utilizza dei console.log() per testare le tue variabili e/o i risultati delle espressioni che stai creando.
*/

/* ESERCIZIO 1
    Dato il seguente array, scrivi del codice per stampare ogni elemento dell'array in console.
*/
const pets = ['dog', 'cat', 'hamster', 'redfish']

for (i=0; i<pets.length; i++) {
  console.log(pets[i])
}

/* ESERCIZIO 2
    Scrivi del codice per ordinare alfabeticamente gli elementi dell'array "pets".
*/

let sortedPets = pets.sort()

console.log(sortedPets);

/* ESERCIZIO 3
    Scrivi del codice per stampare nuovamente in console gli elementi dell'array "pets", questa volta in ordine invertito.
*/

let reversePets = sortedPets.reverse()

console.log(reversePets)

/* ESERCIZIO 4
    Scrivi del codice per spostare il primo elemento dall'array "pets" in ultima posizione.
*/

let movedPet = pets.slice(0,1)
pets.shift()
pets.push(movedPet[0])

console.log(pets);

/* ESERCIZIO 5
    Dato il seguente array di oggetti, scrivi del codice per aggiungere ad ognuno di essi una proprietà "licensePlate" con valore a tua scelta.
*/
const cars = [
  {
    brand: 'Ford',
    model: 'Fiesta',
    color: 'red',
    trims: ['titanium', 'st', 'active'],
  },
  {
    brand: 'Peugeot',
    model: '208',
    color: 'blue',
    trims: ['allure', 'GT'],
  },
  {
    brand: 'Volkswagen',
    model: 'Polo',
    color: 'black',
    trims: ['life', 'style', 'r-line'],
  },
]

for (i=0;i<cars.length;i++){
  let licenseNumber = 'ABCD'+i.toString().padStart(4, 0)
  cars[i].licensePlate=licenseNumber
}

console.log(cars);

/* ESERCIZIO 6
    Scrivi del codice per aggiungere un nuovo oggetto in ultima posizione nell'array "cars", rispettando la struttura degli altri elementi.
    Successivamente, rimuovi l'ultimo elemento della proprietà "trims" da ogni auto.
*/

let newCar = {brand:'Brand', model:'Model', licensePlate:'Plate', color:'Color', trims:['Trim1', 'Trim2', 'Trim3']}
cars.push(newCar)

console.log(cars);

for (i=0;i<cars.length;i++){
  cars[i].trims.pop()
}

console.log(cars)

/* ESERCIZIO 7
    Scrivi del codice per salvare il primo elemento della proprietà "trims" di ogni auto nel nuovo array "justTrims", sotto definito.
*/
const justTrims = []

for (i=0;i<cars.length;i++){
  justTrims.push(cars[i].trims[0])
}

console.log(justTrims);

/* ESERCIZIO 8
    Cicla l'array "cars" e costruisci un if/else statament per mostrare due diversi messaggi in console. Se la prima lettera della proprietà
    "color" ha valore "b", mostra in console "Fizz". Altrimenti, mostra in console "Buzz".
*/

for (i=0;i<cars.length;i++){
  if (cars[i].color.charAt(0) === 'b'){
    console.log('Fizz')
  } else {
    console.log('Buzz')
  }
}

/* ESERCIZIO 9
    Utilizza un ciclo while per stampare in console i valori del seguente array numerico fino al raggiungimento del numero 32.
*/
const numericArray = [
  6, 90, 45, 75, 84, 98, 35, 74, 31, 2, 8, 23, 100, 32, 66, 313, 321, 105,
]

let x=0
while (x<numericArray.length){
  if (numericArray[x]!==32){
  console.log(numericArray[x]);
  } else {
    break
  }
  x++
}

/* ESERCIZIO 10
    Partendo dall'array fornito e utilizzando un costrutto switch, genera un nuovo array composto dalle posizioni di ogni carattere all'interno
    dell'alfabeto italiano.
    es. [f, b, e] --> [6, 2, 5]
*/
const charactersArray = ['g', 'n', 'u', 'z', 'd']
let numberChar = []
let position
for (i=0;i<charactersArray.length;i++){
    switch (charactersArray[i]){
      case charactersArray[i]='a':
        position = 1;
        numberChar.push(position)
        break;
      case charactersArray[i]='b':
        position = 2;
        numberChar.push(position)
        break;
      case charactersArray[i]='c':
        position = 3;
        numberChar.push(position)
        break;
      case charactersArray[i]='d':
        position = 4;
        numberChar.push(position)
        break;
      case charactersArray[i]='e':
        position = 5;
        numberChar.push(position)
        break;
      case charactersArray[i]='f':
        position = 6;
        numberChar.push(position)
        break;
      case charactersArray[i]='g':
        position = 7;
        numberChar.push(position)
        break;
      case charactersArray[i]='h':
        position = 8;
        numberChar.push(position)
        break;
      case charactersArray[i]='i':
        position = 9;
        numberChar.push(position)
        break;
      case charactersArray[i]='l':
        position = 10;
        numberChar.push(position)
        break;
      case charactersArray[i]='m':
        position = 11;
        numberChar.push(position)
        break;
      case charactersArray[i]='n':
        position = 12;
        numberChar.push(position)
        break;
      case charactersArray[i]='o':
        position = 13;
        numberChar.push(position)
        break;
      case charactersArray[i]='p':
        position = 14;
        numberChar.push(position)
        break;
      case charactersArray[i]='q':
        position = 15;
        numberChar.push(position)
        break;
      case charactersArray[i]='r':
        position = 16;
        numberChar.push(position)
        break;
      case charactersArray[i]='s':
        position = 17;
        numberChar.push(position)
        break;
      case charactersArray[i]='t':
        position = 18;
        numberChar.push(position)
        break;
      case charactersArray[i]='u':
        position = 19;
        numberChar.push(position)
        break;
      case charactersArray[i]='v':
        position = 20;
        numberChar.push(position)
        break;
      case charactersArray[i]='z':
        position = 21;
        numberChar.push(position)
        break;
    }
}
console.log(numberChar)