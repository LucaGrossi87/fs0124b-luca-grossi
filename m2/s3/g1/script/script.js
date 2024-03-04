class User {
    constructor (firstName, lastName, age, location) {
        this.firstName=firstName
        this.lastName=lastName
        this.age=age
        this.location=location
    }
    isOlder(other) {
        if (this.age > other.age){
            return `${this.firstName} ${this.lastName} è più vecchio di ${other.firstName} ${other.lastName}`
        } else if (this.age < other.age){
            return `${this.firstName} ${this.lastName} è più giovane di ${other.firstName} ${other.lastName}`
        } else {
            return `${this.firstName} ${this.lastName} ha la stessa età di ${other.firstName} ${other.lastName}`
        }
    }
}

let MarioRossi=new User ('Mario', 'Rossi', 42, 'Roma')
let FabioBianchi=new User ('Fabio', 'Bianchi', 38, 'Firenze')
let CarloBrambilla=new User ('Carlo', 'Brambilla', 42, 'Milano')

console.log(MarioRossi.isOlder(FabioBianchi));
console.log(FabioBianchi.isOlder(MarioRossi));
console.log(MarioRossi.isOlder(CarloBrambilla));

// --------------------------

class Pet {
    constructor (petName,ownerName,species,breed) {
        this.petName=petName
        this.ownerName=ownerName
        this.species=species
        this.breed=breed
    }
    isSameOwner(other) {
        return this.ownerName === other.ownerName
    }
}

function sendData(event) {
    event.preventDefault()
    let newPet = new Pet (document.querySelector('#petName').value, document.querySelector('#ownerName').value, document.querySelector('#species').value, document.querySelector('#breed').value,)
    let list = document.createElement('ul')
    let itemNamePet = document.createElement('li')
    itemNamePet.innerText=newPet.petName
    let itemNameOwn = document.createElement('li')
    itemNameOwn.innerText=newPet.ownerName
    let itemSpecies = document.createElement('li')
    itemSpecies.innerText=newPet.species
    let itemBreed = document.createElement('li')
    itemBreed.innerText=newPet.breed
    list.appendChild(itemNamePet)
    list.appendChild(itemNameOwn)
    list.appendChild(itemSpecies)
    list.appendChild(itemBreed)
    document.body.appendChild(list)
}

// let newPet = new Pet (dateArray[0],dateArray[1],dateArray[2],dateArray[3])