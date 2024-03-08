class amplifier {
    constructor (name, description, brand, imageUrl, price) {
        this.name = name
        this.description = description
        this.brand = brand
        this.imageUrl = imageUrl
        this.price = price
    }
}

function generateAmp () {
    return new amplifier (`jcm800`,`brit_amp`,`marshall`,'./img/marshall.jpg',2000)
}

fetch("https://striveschool-api.herokuapp.com/api/product/65eb114b2d7b1100190e73e2", {
    method:"PUT",
    headers: {
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZmEyNjJkN2IxMTAwMTkwZTcyMGIiLCJpYXQiOjE3MDk4OTgyNzgsImV4cCI6MTcxMTEwNzg3OH0.ci2OKjqfEDMKBwm6O3iD18btmFgJkiZUPijDoehdgss",
    "Content-Type" : "application/json"
    },
    body: JSON.stringify(generateAmp()),
})

fetch("https://striveschool-api.herokuapp.com/api/product/", {
    headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZmEyNjJkN2IxMTAwMTkwZTcyMGIiLCJpYXQiOjE3MDk4OTgyNzgsImV4cCI6MTcxMTEwNzg3OH0.ci2OKjqfEDMKBwm6O3iD18btmFgJkiZUPijDoehdgss",
        },
    }
)
.then(response => response.json())
.then(data => {
        
    for(let amp of data){

        let template = document.getElementsByTagName('template')[0];

        document.querySelector('template').content.querySelector('.amp-pic').src=amp.imageUrl
        document.querySelector('template').content.querySelector('.name').innerHTML=amp.name
        document.querySelector('template').content.querySelector('.description').innerHTML=amp.description
        document.querySelector('template').content.querySelector('.price').innerHTML=`${amp.price} €`

        let clone = template.content.cloneNode(true);
        
        let column = document.createElement('div')
        column.classList.add("col-12", "col-md-6", "col-lg-4", "col-xl-3")
        column.appendChild(clone)
        document.querySelector('.main-body').appendChild(column)
    }
})

// ho lavorato su file script diversi per semplicità, l'idea era di riunirli in un file unico ma non avuto tempo, soprattutto di consultare la documentazione, per evitare che ci fossero problemi passando da una pagina all'altra