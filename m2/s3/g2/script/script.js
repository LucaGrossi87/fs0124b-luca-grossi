let nameString = document.querySelector('#name')

function sendToStorage(event) {
    event.preventDefault()
    localStorage.setItem('nome',nameString.value)
    document.querySelector('.lastName').innerHTML=''
    document.querySelector('.lastName').append(nameString.value)
}

function deleteFromStorage(event) {
    event.preventDefault()
    localStorage.removeItem('nome')
    document.querySelector('.lastName').innerHTML=''
}

document.querySelector('#submit').addEventListener('click',sendToStorage)
document.querySelector('#delete').addEventListener('click',deleteFromStorage)

//-------------------------------------------------

let counter = document.querySelector('.counter')

function keepCount () {
    if (sessionStorage.getItem('conteggio')){
    counter.innerHTML=sessionStorage.getItem('conteggio')
    }
}
window.addEventListener ("load", keepCount())

function counterAdd() {
    counter.innerHTML=parseInt(counter.innerHTML)+1
    sessionStorage.setItem('conteggio', counter.innerHTML)
}

setInterval(counterAdd, 1000)