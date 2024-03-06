fetch ('https://striveschool-api.herokuapp.com/books')
.then(response => response.json())
.then(dati => {

    console.log(dati[0].title);

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
            let bookTitle = this.parentElement.querySelector('.card-title').innerHTML
            let bookPrice = this.parentElement.querySelector('.card-text').innerHTML
            document.querySelector('.bill').innerHTML=parseInt(document.querySelector('.bill').innerHTML)+parseInt(bookPrice)
            let cartItem = document.createElement('li')
            cartItem.innerHTML=bookTitle
            document.querySelector('.cart-list').appendChild(cartItem)
            let removeFromCart = document.createElement ('button')
            removeFromCart.classList.add("remove-from-cart")
            removeFromCart.innerHTML='Rimuovi dal carrello'
            cartItem.append(removeFromCart)
            document.querySelector('.remove-from-cart').onclick = function() {
                this.parentElement.remove()
            }
        }
        
        let column = document.createElement('div')
        column.classList.add("col-12", "col-md-6", "col-lg-4", "col-xl-3")
        column.appendChild(clone)
        document.querySelector('.col-10').appendChild(column)
    }

})