fetch ('https://striveschool-api.herokuapp.com/books')
.then(response => response.json())
.then(dati => {
    
    let titleStorage = []
        
    for (let i = 0; i < sessionStorage.length; i++) {
        titleStorage.push(sessionStorage.key(i))
    }

    window.addEventListener ('click', keepCount())

    function keepCount () {
        for (let i = 0; i < titleStorage.length; i++) {
            let el = titleStorage[i];
            let cartItem = document.createElement('li')
            cartItem.innerHTML=el
            document.querySelector('.cart-list').appendChild(cartItem)
            let removeFromCart = document.createElement ('button')
            removeFromCart.classList.add("remove-from-cart")
            removeFromCart.innerHTML='Rimuovi dal carrello'
            cartItem.append(removeFromCart)
            removeFromCart.onclick = function() {
                this.parentElement.remove()
            }
        }
    }
        
    for(let book of dati){

        let template = document.getElementsByTagName('template')[0];

        document.querySelector('template').content.querySelector('.card-img-top').src=book.img
        document.querySelector('template').content.querySelector('.card-title').innerHTML=book.title
        document.querySelector('template').content.querySelector('.card-text').innerHTML=`${book.price} €`

        let clone = template.content.cloneNode(true);
        clone.querySelector('.remove').onclick = function() {
            this.parentElement.parentElement.remove()
        }
        clone.querySelector('.addToCart').onclick = function() {
            let cartItem = document.createElement('li')
            cartItem.innerHTML=this.parentElement.querySelector('.card-title').innerHTML
            document.querySelector('.cart-list').appendChild(cartItem)
            sessionStorage.setItem(cartItem.innerHTML, cartItem.innerHTML)
            let removeFromCart = document.createElement ('button')
            removeFromCart.classList.add("remove-from-cart")
            removeFromCart.innerHTML='Rimuovi dal carrello'
            cartItem.append(removeFromCart)
            removeFromCart.onclick = function() {
                this.parentElement.remove()
            }
        }
        
        let column = document.createElement('div')
        column.classList.add("col-12", "col-md-6", "col-lg-4", "col-xl-3")
        column.appendChild(clone)
        document.querySelector('.col-10').appendChild(column)
    }

})