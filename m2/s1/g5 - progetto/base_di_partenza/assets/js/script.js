let header = document.querySelector('header');
let btn = document.querySelector('#header-btn');
document.addEventListener ('scroll', colorFade)

let check = false

function colorFade () {
    let scrollPoint=document.documentElement.scrollTop;
    if (scrollPoint < 400 && check) {
        header.style.animation="changeColorUp 1s 1 forwards"
        btn.style.animation="changeBtnUp 1s 1 forwards"
        check = false
    } else if (scrollPoint >= 400) {
        header.style.animation="changeColorDown 1s 1 forwards"
        btn.style.animation="changeBtnDown 1s 1 forwards"
        check = true
    }
}