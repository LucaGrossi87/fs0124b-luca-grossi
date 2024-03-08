document.querySelector('.save-btn').addEventListener('click', function addAmp(event) {
    event.preventDefault()
    let addAmp = {
        "name" : document.querySelector('#edit-name').value,
        "brand" : document.querySelector('#edit-brand').value,
        "price" : parseInt(document.querySelector('#edit-price').value),
        "imageUrl" : document.querySelector('#edit-imgUrl').value,
        "description" : document.querySelector('#edit-description').value
    }
    console.log(document.querySelector('#edit-name').value);
    fetch("https://striveschool-api.herokuapp.com/api/product/", {
        method:"POST",
        headers: {
            "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZmEyNjJkN2IxMTAwMTkwZTcyMGIiLCJpYXQiOjE3MDk4OTgyNzgsImV4cCI6MTcxMTEwNzg3OH0.ci2OKjqfEDMKBwm6O3iD18btmFgJkiZUPijDoehdgss",
            "Content-Type" : "application/json"
        },
        body: JSON.stringify(addAmp),
    })
    document.querySelector('#edit-name').value=""
    document.querySelector('#edit-brand').value=""
    document.querySelector('#edit-price').value=""
    document.querySelector('#edit-imgUrl').value=""
    document.querySelector('#edit-description').value=""
})

fetch("https://striveschool-api.herokuapp.com/api/product/", {
    headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZmEyNjJkN2IxMTAwMTkwZTcyMGIiLCJpYXQiOjE3MDk4OTgyNzgsImV4cCI6MTcxMTEwNzg3OH0.ci2OKjqfEDMKBwm6O3iD18btmFgJkiZUPijDoehdgss",
        },
    }
    )
    .then(response => console.log(response.json()))