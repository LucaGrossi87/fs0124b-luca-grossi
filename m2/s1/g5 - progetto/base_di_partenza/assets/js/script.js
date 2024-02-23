
let header = document.querySelector('header');
document.addEventListener ('scroll', colorFade)


function colorFade () {
    let scrollPoint=document.documentElement.scrollTop;
    if (scrollPoint > 400) {
        header.style.animation="changeColorDown 1s 1 forwards"
    } else if (scrollPoint < 400) {
        header.style.animation="changeColorUp 1s 1 forwards"
    }
}