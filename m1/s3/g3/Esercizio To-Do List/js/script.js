let questText = document.querySelector('#questText')
let questButton = document.querySelector('#questButton')
let questList = document.querySelector('.list')


function sendQuest (){
    const newLi = document.createElement ('li')
    const newEntry = document.createElement ('p')
    let buttonDone = document.createElement('button')
    let entryP =document.querySelector ('.entry')
    buttonDone.innerText='Quest completed!'
    buttonDone.style.fontFamily='Rock Salt'
    buttonDone.style.fontSize='0.6rem'
    buttonDone.style.color='white'
    buttonDone.style.backgroundColor='black'
    buttonDone.style.borderRadius='15px'
    buttonDone.addEventListener('click', function(){
        newEntry.style.textDecoration='line-through'
    })
    let buttonDelete = document.createElement('button')
    buttonDelete.innerText='Delete Quest'
    buttonDelete.style.fontFamily='Rock Salt'
    buttonDelete.style.fontSize='0.6rem'
    buttonDelete.style.color='white'
    buttonDelete.style.backgroundColor='black'
    buttonDelete.style.borderRadius='15px'
    buttonDelete.addEventListener('click', function(){
        newLi.remove()
    })
    if (questText.value!==''){
    newEntry.innerText = questText.value
    }
    newLi.append(newEntry, " - ", buttonDone, " - ", buttonDelete)
    questList.append(newLi)
    questText.value = ""
}

questButton.addEventListener('click', function(e){
    e.preventDefault();
    sendQuest()
})

