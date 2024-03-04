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

let formBtn = document.querySelector('#form-btn')

console.log(document.querySelector('#petName').value);

function sendData() {
    let dateArray = []
    dateArray.push(document.querySelector('#petName').value, document.querySelector('#ownerName').value, document.querySelector('#species').value, document.querySelector('#breed').value,)
    let list = document.createElement('ul')
    for (let i = 0; i < dateArray.length; i++) {
        const element = dateArray[i];
        let list_item=document.createElement('li')
        list_item.innerText=element
        list.append(list_item)
    }
    console.log(list);
    document.body.append(list)
}

let newPet = new Pet (dateArray[0],dateArray[1],dateArray[2],dateArray[3])