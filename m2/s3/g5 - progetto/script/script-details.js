fetch("https://striveschool-api.herokuapp.com/api/product/", {
    headers: {
        "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NWVhZmEyNjJkN2IxMTAwMTkwZTcyMGIiLCJpYXQiOjE3MDk4OTgyNzgsImV4cCI6MTcxMTEwNzg3OH0.ci2OKjqfEDMKBwm6O3iD18btmFgJkiZUPijDoehdgss",
        },
    }
)
.then(response => response.json())
.then(data => {
        
    for(let amp of data){

        console.log(data);

        document.querySelector('.amp-pic').src=data[0].imageUrl
        document.querySelector('.name').innerText=data[0].name
        document.querySelector('.description').innerText=data[0].description
        document.querySelector('.brand').innerText=data[0].brand
        document.querySelector('.price').innerText=data[0].price
    }
})
