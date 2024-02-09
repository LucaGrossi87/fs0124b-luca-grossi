/*
REGOLE
- Tutte le risposte devono essere scritte in JavaScript
- Se sei in difficoltà puoi chiedere aiuto a un Teaching Assistant
- Puoi usare Google / StackOverflow ma solo quanto ritieni di aver bisogno di qualcosa che non è stato spiegato a lezione
- Puoi testare il tuo codice in un file separato, o de-commentando un esercizio alla volta
- Per farlo puoi utilizzare il terminale Bash, quello di VSCode o quello del tuo sistema operativo (se utilizzi macOS o Linux)
*/

// JS Basics

/* ESERCIZIO A
  Crea una variabile chiamata "sum" e assegnaci il risultato della somma tra i valori 10 e 20.
*/

let sum = 10 + 20

console.log(sum);

/* ESERCIZIO B
  Crea una variabile chiamata "random" e assegnaci un numero casuale tra 0 e 20 (deve essere generato dinamicamente a ogni esecuzione).
*/

let random = Math.floor(Math.random() * 21)

console.log(random);

/* ESERCIZIO C
  Crea una variabile chiamata "me" e assegnaci un oggetto contenente le seguenti proprietà: name = il tuo nome, surname = il tuo cognome, age = la tua età.
*/

let me = {
name: 'Luca',
surname: 'Grossi',
age: 37
}

console.log(me);

/* ESERCIZIO D
  Crea del codice per rimuovere programmaticamente la proprietà "age" dall'oggetto precedentemente creato.
*/

delete me.age

console.log(me);

/* ESERCIZIO E
  Crea del codice per aggiungere programmaticamente all'oggetto precedentemente creato un array chiamato "skills", contenente i linguaggi di programmazione che conosci.
*/

me.skills = ['js']

console.log(me);

/* ESERCIZIO F
  Crea un pezzo di codice per aggiungere un nuovo elemento all'array "skills" contenuto nell'oggetto "me".
*/

let skills = me.skills
skills.push('newLang')

console.log(skills);

/* ESERCIZIO G
  Crea un pezzo di codice per rimuovere programmaticamente l'ultimo elemento dall'array "skills" contenuto nell'oggetto "me".
*/

skills.pop()

console.log(skills);

// Funzioni

/* ESERCIZIO 1
  Crea una funzione chiamata "dice": deve generare un numero casuale tra 1 e 6.
*/

function dice () {
  return Math.floor(Math.random() * 6)+1
}

console.log(dice());

/* ESERCIZIO 2
  Crea una funzione chiamata "whoIsBigger" che riceve due numeri come parametri e ritorna il maggiore dei due.
*/

function whoIsBigger (a,b) {
  if (typeof a !== 'number'&&typeof b !== 'number'){
    return
  }
  if (a>b) {
    return 'a è maggiore'
  } else {
    return 'b è maggiore'
  }
}

console.log(whoIsBigger(5,2));

/* ESERCIZIO 3
  Crea una funzione chiamata "splitMe" che riceve una stringa come parametro e ritorna un'array contenente ogni parola della stringa.

  Es.: splitMe("I love coding") => ritorna ["I", "Love", "Coding"]
*/

function splitMe (a) {
  if (typeof a !== 'string') {
    return
  }
    return a.split(" ")
}

console.log(splitMe('I love coding'));

/* ESERCIZIO 4
  Crea una funzione chiamata "deleteOne" che riceve una stringa e un booleano come parametri.
  Se il valore booleano è true la funzione deve ritornare la stringa senza il primo carattere, altrimenti la deve ritornare senza l'ultimo.
*/

function deleteOne (a,b) {
  if (typeof a !== 'string'&&typeof b !== 'boolean'){
    return
  }
  if (b===true){
    return a.split("").slice(1).join("")
  } else {
    return a.split("").slice(0,-1).join("")
  }
}

console.log(deleteOne('ciao',true));

/* ESERCIZIO 5
  Crea una funzione chiamata "onlyLetters" che riceve una stringa come parametro e la ritorna eliminando tutte le cifre numeriche.

  Es.: onlyLetters("I have 4 dogs") => ritorna "I have dogs"
*/

function onlyLetters (a) {
  if (typeof a !== 'string'){
    return
  }

  let splitString = a.split("")
  let noLet = []
  for (i=0;i<splitString.length;i++){
    if (isNaN(parseInt(splitString[i]))) {
      noLet.push(splitString[i])
    }
  }
  return noLet.join("")
}

console.log(onlyLetters ('ciao 1 casa 2'));

/* ESERCIZIO 6
  Crea una funzione chiamata "isThisAnEmail" che riceve una stringa come parametro e ritorna true se la stringa è un valido indirizzo email.
*/

function isThisAnEmail (a) {
  if (typeof a !== 'string'){
    return
  }

  return a.match(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/g) !== null
}

console.log(isThisAnEmail('luca@luca.it'));

/* ESERCIZIO 7
  Scrivi una funzione chiamata "whatDayIsIt" che ritorna il giorno della settimana corrente.
*/

//function whatDayIsIt () {
//  return new Date()
//}
//
//console.log(whatDayIsIt());

function whatDayIsIt () {
  const fullDate = new Date
  let dayNum = fullDate.getDay()
  let dayName = ''
  if (dayNum === 0) {
  dayName = 'Domenica' 
  } else 
  if (dayNum === 1) {
    dayName = 'Lunedì' 
  } else 
  if (dayNum === 2) {
    dayName = 'Martedì' 
  } else 
  if (dayNum === 3) {
    dayName = 'Mercoledì' 
  } else 
  if (dayNum === 4) {
    dayName = 'Giovedì' 
  } else 
  if (dayNum === 5) {
    dayName = 'Venerdì' 
  } else 
  if (dayNum === 6) {
    dayName = 'Sabato' 
  }
  return `Oggi è ${dayName}`
}

console.log(whatDayIsIt());

/* ESERCIZIO 8
  Scrivi una funzione chiamata "rollTheDices" che riceve un numero come parametro.
  Deve invocare la precedente funzione dice() il numero di volte specificato nel parametro, e deve tornare un oggetto contenente una proprietà "sum":
  il suo valore deve rappresentare il totale di tutti i valori estratti con le invocazioni di dice().
  L'oggetto ritornato deve anche contenere una proprietà "values", contenente un array con tutti i valori estratti dalle invocazioni di dice().

  Example:
  rollTheDices(3) => ritorna {
      sum: 10
      values: [3, 3, 4]
  }
*/

function rollTheDices(a) {
  if (typeof a !== 'number'){
    return
  }

  let total = {sum}
  let values = []

  for (i=0;i<a;i++){
    let num = dice()
    values.push(num)
  }

  total.sum = values.reduce((temp, curr) => temp + curr, 0)

  let results = {total, values}
  return results
}

console.log(rollTheDices(3));

/* ESERCIZIO 9
  Scrivi una funzione chiamata "howManyDays" che riceve una data come parametro e ritorna il numero di giorni trascorsi da tale data.
*/

function howManyDays (a) {
  let formattedDate = a.split("/").reverse().join("-");

  let oldDate = new Date(formattedDate)
  let today=new Date ()

  return Math.floor((today.getTime() - oldDate.getTime())/(1000 * 60 * 60 * 24))
}

console.log(howManyDays('07/02/2024'));

/* ESERCIZIO 10
  Scrivi una funzione chiamata "isTodayMyBirthday" che deve ritornare true se oggi è il tuo compleanno, falso negli altri casi.
*/

function isTodayMyBirthday (a) {

  let birthDay = a.split('/').shift()
  let birthMonth = a.split('/').pop()
  let todayDate = new Date

  return parseInt(birthDay)===todayDate.getDate()&&parseInt(birthMonth)===todayDate.getMonth() !==null

}

console.log(isTodayMyBirthday ('09/02'));

// Arrays & Oggetti

// NOTA: l'array "movies" usato in alcuni esercizi è definito alla fine di questo file

const movies = [
  {
    Title: 'The Lord of the Rings: The Fellowship of the Ring',
    Year: '2001',
    imdbID: 'tt0120737',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_SX300.jpg',
  },

  {
    Title: 'The Lord of the Rings: The Return of the King',
    Year: '2003',
    imdbID: 'tt0167260',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNzA5ZDNlZWMtM2NhNS00NDJjLTk4NDItYTRmY2EwMWZlMTY3XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings: The Two Towers',
    Year: '2002',
    imdbID: 'tt0167261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNGE5MzIyNTAtNWFlMC00NDA2LWJiMjItMjc4Yjg1OWM5NzhhXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of War',
    Year: '2005',
    imdbID: 'tt0399295',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTYzZWE3MDAtZjZkMi00MzhlLTlhZDUtNmI2Zjg3OWVlZWI0XkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'Lords of Dogtown',
    Year: '2005',
    imdbID: 'tt0355702',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDBhNGJlOTAtM2ExNi00NmEzLWFmZTQtYTZhYTRlNjJjODhmXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_SX300.jpg',
  },
  {
    Title: 'The Lord of the Rings',
    Year: '1978',
    imdbID: 'tt0077869',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGMyNWJhZmYtNGQxYi00Y2ZjLWJmNjktNTgzZWJjOTg4YjM3L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1990',
    imdbID: 'tt0100054',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOTI2NTQyODk0M15BMl5BanBnXkFtZTcwNTQ3NDk0NA@@._V1_SX300.jpg',
  },
  {
    Title: 'The Lords of Salem',
    Year: '2012',
    imdbID: 'tt1731697',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjA2NTc5Njc4MV5BMl5BanBnXkFtZTcwNTYzMTcwOQ@@._V1_SX300.jpg',
  },
  {
    Title: 'Greystoke: The Legend of Tarzan, Lord of the Apes',
    Year: '1984',
    imdbID: 'tt0087365',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM5MzcwOTg4MF5BMl5BanBnXkFtZTgwOTQwMzQxMDE@._V1_SX300.jpg',
  },
  {
    Title: 'Lord of the Flies',
    Year: '1963',
    imdbID: 'tt0057261',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BOGEwYTlhMTgtODBlNC00ZjgzLTk1ZmEtNmNkMTEwYTZiM2Y0XkEyXkFqcGdeQXVyMzU4Nzk4MDI@._V1_SX300.jpg',
  },
  {
    Title: 'The Avengers',
    Year: '2012',
    imdbID: 'tt0848228',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Infinity War',
    Year: '2018',
    imdbID: 'tt4154756',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMjMxNjY2MDU1OV5BMl5BanBnXkFtZTgwNzY1MTUwNTM@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Age of Ultron',
    Year: '2015',
    imdbID: 'tt2395427',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTM4OGJmNWMtOTM4Ni00NTE3LTg3MDItZmQxYjc4N2JhNmUxXkEyXkFqcGdeQXVyNTgzMDMzMTg@._V1_SX300.jpg',
  },
  {
    Title: 'Avengers: Endgame',
    Year: '2019',
    imdbID: 'tt4154796',
    Type: 'movie',
    Poster:
      'https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg',
  },
]

/* ESERCIZIO 11
  Scrivi una funzione chiamata "deleteProp" che riceve un oggetto e una stringa come parametri; deve ritornare l'oggetto fornito dopo aver eliminato
  in esso la proprietà chiamata come la stringa passata come secondo parametro.
*/

let obj = {
  prop1: 'prop1',
  prop2: 'prop2',
  prop3: 'prop3'
}

function deleteProp(a,b) {
  if (typeof a !== 'object'||typeof b !== 'string'){
    return
  }

  delete a[b]

  return a
  
}

console.log(deleteProp(obj,'prop2'));

/* ESERCIZIO 12
  Scrivi una funzione chiamata "newestMovie" che trova il film più recente nell'array "movies" fornito.
*/

function newestMovie() {
  let latestYear = 0
  let latestMovie = ''
  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    if (element.Year > latestYear) {
      latestYear=element.Year
      latestMovie=element.Title
    }
  }
  return latestMovie
}

console.log(newestMovie());

/* ESERCIZIO 13
  Scrivi una funzione chiamata countMovies che ritorna il numero di film contenuti nell'array "movies" fornito.
*/

function countMovies() {
  let movieList = 0
  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    if (element.Type==='movie') {
      movieList+=1
    }    
  }
  return movieList
}

console.log(countMovies());

/* ESERCIZIO 14
  Scrivi una funzione chiamata "onlyTheYears" che crea un array con solamente gli anni di uscita dei film contenuti nell'array "movies" fornito.
*/

function onlyTheYears() {
  let YeArr = []
  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    YeArr.push(element.Year)
  }
  return YeArr
}

console.log(onlyTheYears());

/* ESERCIZIO 15
  Scrivi una funzione chiamata "onlyInLastMillennium" che ritorna solamente i film prodotto nel millennio scorso contenuti nell'array "movies" fornito.
*/

function onlyInLastMillennium() {
  let millArr = []
  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    if (parseInt(element.Year) < 2000) {
      millArr.push(element.Title)
    }    
  }
  return millArr
}

console.log(onlyInLastMillennium());

/* ESERCIZIO 16
  Scrivi una funzione chiamata "sumAllTheYears" che ritorna la somma di tutti gli anni in cui sono stati prodotti i film contenuti nell'array "movies" fornito.
*/

function sumAllTheYears() {
  sumYear = 0
  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    sumYear+=parseInt(element.Year)
  }
  return sumYear
}

console.log(sumAllTheYears());

/* ESERCIZIO 17
  Scrivi una funzione chiamata "searchByTitle" che riceve una stringa come parametro e ritorna i film nell'array "movies" fornito che la contengono nel titolo.
*/

function searchByTitle(a) {
  if (typeof a !== 'string') {
    return
  }

  let searchMovie = []

  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    if (element.Title.toLowerCase().includes(a.toLowerCase())) {
      searchMovie.push(element.Title)
    }
  }
  return searchMovie
}

console.log(searchByTitle('rings'));

/* ESERCIZIO 18
  Scrivi una funzione chiamata "searchAndDivide" che riceve una stringa come parametro e ritorna un oggetto contenente due array: "match" e "unmatch".
  "match" deve includere tutti i film dell'array "movies" fornito che contengono la stringa fornita all'interno del proprio titolo, mentre "unmatch" deve includere tutti i rimanenti.
*/

function searchAndDivide(a) {
  if (typeof a !== 'string') {
    return
  }
  
  let match = []
  let unmatch = []
  let divide = {match,unmatch}

  for (let i = 0; i < movies.length; i++) {
    const element = movies[i];
    if (element.Title.toLowerCase().includes(a.toLowerCase())) {
      match.push(element.Title)
    } else {
      unmatch.push(element.Title)
    }
  }
  return divide
}

console.log(searchAndDivide('rings'));

/* ESERCIZIO 19
  Scrivi una funzione chiamata "removeIndex" che riceve un numero come parametro e ritorna l'array "movies" fornito privo dell'elemento nella posizione ricevuta come parametro.
*/

function removeIndex(n) {
  if (typeof n !== 'number') {
    return
  }

  let newArr = [...movies]
  
  delete newArr[n]
  return newArr
}

console.log(removeIndex(3));

// DOM (nota: gli elementi che selezionerai non si trovano realmente nella pagina)

/* ESERCIZIO 20
  Scrivi una funzione per selezionare l'elemento dotato di id "container" all'interno della pagina.
*/

function idPick() {
  return document.querySelector('#container')  
}

console.log(idPick());

/* ESERCIZIO 21
  Scrivi una funzione per selezionare ogni tag <td> all'interno della pagina.
*/

function tagPick() {
  return document.querySelectorAll('td')
}

console.log(tagPick());

/* ESERCIZIO 22
  Scrivi una funzione che, tramite un ciclo, stampa in console il testo contenuto in ogni tag <td> all'interno della pagina.
*/

function tdText() {
  const td = document.querySelectorAll('td')
  let tdInnerText = []
  for (let i = 0; i < td.length; i++) {
    const element = td[i];
    tdInnerText.push(element.innerText)
  }
  return console.log(tdInnerText);
}

tdText()

/* ESERCIZIO 23
  Scrivi una funzione per aggiungere un background di colore rosso a ogni link all'interno della pagina.
*/

function colorLink() {
  let links = document.querySelectorAll('a')
  for (let i = 0; i < links.length; i++) {
    const element = links[i];
    element.style.backgroundColor='red'
  }
}

colorLink()

/* ESERCIZIO 24
  Scrivi una funzione per aggiungere un nuovo elemento alla lista non ordinata con id "myList".
*/

function newLi() {
  let unLi = document.querySelector('#myList')
  let createLi = document.createElement('li')
  unLi.append(createLi)
}

newLi()

/* ESERCIZIO 25
  Scrivi una funzione per svuotare la lista non ordinata con id "myList".
*/

function emptyUl() {
  let unChild = document.querySelectorAll('#myList li')
  for (let i = 0; i < unChild.length; i++) {
    const element = unChild[i];
    element.remove()
  }
}

emptyUl()

/* ESERCIZIO 26
  Scrivi una funzione per aggiungere ad ogni tag <tr> la classe CSS "test"
*/

function addClass () {
  let allTr = document.querySelectorAll('tr')
  for (let i = 0; i < allTr.length; i++) {
    const element = allTr[i];
    element.classList.add('test')
  }
}

addClass ()

// [EXTRA] JS Avanzato

/* ESERCIZIO 27
  Crea una funzione chiamata "halfTree" che riceve un numero come parametro e costruisce un mezzo albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  halfTree(3)

  *
  **
  ***

*/

function halfTree(n) {
  if (typeof n !== 'number') {
    return
  }

  for (let i = 0; i <= n; i++) {
    console.log('*'.repeat(i));
  }
}

halfTree(4)

/* ESERCIZIO 28
  Crea una funzione chiamata "tree" che riceve un numero come parametro e costruisce un albero di "*" (asterischi) dell'altezza fornita.

  Esempio:
  tree(3)

    *
   ***
  *****

*/

function Tree(n) {
  if (typeof n !== 'number') {
    return
  }

  for (let i = 0; i <= n-1; i++) {
    console.log(' '.repeat(n-i)+'*'.repeat(i*2+1));
  }
}

Tree(4)

/* ESERCIZIO 29
  Crea una funzione chiamata "isItPrime" che riceve un numero come parametro e ritorna true se il numero fornito è un numero primo.
*/

function isItPrime(n) {
  if (typeof n !== 'number') {
    return
  }
  
  for (let i = 2; i < n; i++) {
    if (n%i===0) {
      return false
    } 
  }
  return true
}

console.log(isItPrime(5));

/* Questo array viene usato per gli esercizi. Non modificarlo. */

