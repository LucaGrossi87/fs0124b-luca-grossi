document.querySelector('.edit-btn').addEventListener('click', function editAmp() {
    fetch("https://striveschool-api.herokuapp.com/api/product/", {   //devo mettere l'id del prodotto
        method:"PUT",
        headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZmEyNjJkN2IxMTAwMTkwZTcyMGIiLCJpYXQiOjE3MDk4OTgyNzgsImV4cCI6MTcxMTEwNzg3OH0.ci2OKjqfEDMKBwm6O3iD18btmFgJkiZUPijDoehdgss",
        "Content-Type" : "application/json"
        },
        body: JSON.stringify(),
    })
})