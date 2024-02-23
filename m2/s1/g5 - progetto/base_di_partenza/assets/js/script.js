
let header = document.querySelector('header');
document.addEventListener ('scroll', colorFade)

let scrollPoint=console.log(document.documentElement.scrollTop);
function colorFade () {
    if (scrollPoint = 400) {
        header.style.animation="changeColorDown 1s 1 forwards"
    }
}