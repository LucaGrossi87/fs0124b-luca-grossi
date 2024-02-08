let btn = document.querySelector('.gioca')

function creaBussolotto () {
    let bussText = document.createElement('h4')
    bussText.innerText='Estrai un numero:'
    document.querySelector('.bussolotto').append(bussText)
    bussText.style.margin='30px 0'
    let numEstr = document.createElement('p')
    numEstr.className='numEstr'
    numEstr.innerText= '---'
    numEstr.style.border='solid 1px black'
    numEstr.style.borderRadius='50px'
    numEstr.style.width='fit-content'
    numEstr.style.padding='5px'
    numEstr.style.margin='auto'
    document.querySelector('.bussolotto').append(numEstr)
    let btnBus = document.createElement('button')
    btnBus.className='btnBus'
    btnBus.innerText= 'Estrai'
    btnBus.style.marginTop='30px'
    document.querySelector('.bussolotto').append(btnBus)
    let numEstratto = document.querySelector('.numEstr')
    let btnEstrai = document.querySelector('.btnBus')
    btnEstrai.addEventListener('click', function() {
        estraiNumero();
        numEstratto.innerText=estraiNumero()
    })
    function estraiNumero () {
        let numeroCasuale = Math.floor(Math.random() * 76)+1
        return numeroCasuale
    }
    console.log(estraiNumero());
}

function creaTabellone (){
    for (let i=0;i<76;i++){
    let numeroTabellone = document.createElement('div')
    numeroTabellone.className = 'finestraTabellone'
    numeroTabellone.innerHTML = (i+1)
    document.querySelector('.cartellone').append(numeroTabellone)
    numeroTabellone.style.flex='1 0 calc(100% / 19)'
    numeroTabellone.style.paddingTop='10px'
    numeroTabellone.style.paddingBottom='10px'
    numeroTabellone.style.border='solid 1px black'
    //let numEstratto = document.querySelector('.numEstr')
    //if (numeroTabellone.innerHTML===numEstratto.innerText) {
    //    numeroTabellone.style.backgroundColor='yellow'
    //}
    function evidenzia() {
            this.style.backgroundColor='yellow'
        }
    numeroTabellone.addEventListener('click', evidenzia)
    }
}

function cartellaCasuale() {
    let result=[]
    while (result.length<24) {
        let numeroCasuale = Math.floor(Math.random() * 76)+1
        if (!result.includes(numeroCasuale)){
            result.push(numeroCasuale)
        }
        }
        return result//.sort((a,b) => a-b);
    }

function creaCartelle (){
    let n = parseInt(document.querySelector('#numeroCartelle').value)
    for (let i=0;i<n;i++) {
    let cartella = document.createElement('div')
    document.querySelector('.cartelleGiocatore').append(cartella)
    cartella.style.display='inline-block'
    cartella.style.width='20vw'
    cartella.style.minWidth='200px'
    cartella.style.border='solid 1px black'
    let cartellaRandom=cartellaCasuale()
    for (let j=0;j<24;j++){
        let finestraCartella = document.createElement('div')
        finestraCartella.className = 'finestraCartella'
        finestraCartella.innerHTML = (cartellaRandom[j])
        finestraCartella.style.display='inline-block'
        finestraCartella.style.border='solid 1px black'
        finestraCartella.style.width='calc(100% / 6)'
        cartella.append(finestraCartella)
        function evidenzia() {
            this.style.backgroundColor='yellow'
        }
        finestraCartella.addEventListener('click', evidenzia)
        }
    }

}

function eliminaSelect (){
    document.querySelector('.sceltaCartelle').remove()
}

function sceltaCartella (){
    creaBussolotto();
    creaTabellone();
    creaCartelle();
    eliminaSelect();
}

btn.addEventListener('click', sceltaCartella)
