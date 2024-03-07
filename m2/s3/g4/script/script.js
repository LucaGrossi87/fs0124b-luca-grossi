document.getElementById('load-img').addEventListener('click', loadImages)
let apiKey = "rzhqwHTKWhdnRpCDUWmZYhhTBedgvAee5pXgnpcQEt9JdeunMveNfZoo"

async function loadImages() {
    let searchValue = document.getElementById('input-search').value
    let response = await fetch(`https://api.pexels.com/v1/search?query=${searchValue}`,{
        method: 'GET',
        headers: {
            "Authorization": apiKey,
        },
    })
    let data = await response.json();
    let picsArray = document.querySelectorAll('.card-img-top')
    for (let i = 0; i < picsArray.length; i++) {
        let pic = picsArray[i];
        pic.src = data.photos[i].src.original
    }
    for (let i = 0; i < picId.length; i++) {
        const el = picId[i];
        el.innerHTML = `Pic Id: ${data.photos[i].id}`
    }
}

document.getElementById('load-img-sec').addEventListener('click', loadImagesSec)

async function loadImagesSec() {
    let response = await fetch('https://api.pexels.com/v1/search?query=random',{
        headers: {
            "Authorization": apiKey,
        },
    })
    let data = await response.json();
    let picsArray = document.querySelectorAll('.card-img-top')
    for (let i = 0; i < picsArray.length; i++) {
        let pic = picsArray[i];
        pic.src = data.photos[i].src.original
    }
}

editBtn = document.querySelectorAll('.edit-btn')

for (let i = 0; i < editBtn.length; i++) {
    const el = editBtn[i];
    el.innerText = 'Hide'
    el.addEventListener ('click', function hide (){
        this.parentElement.parentElement.parentElement.parentElement.parentElement.remove()
    })
}

let picId = document.querySelectorAll('.pic-id')