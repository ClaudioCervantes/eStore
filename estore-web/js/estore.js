
var timeCarrousel;
var indicator = 0;
var numberProducts = 0;
var id
var pathPagination = "";
var pageSize;
var pathImages = [
    "images/banner1.jpg",
    "images/banner2.png",
    "images/banner3.jpg",
    "images/banner4.jpg",
    "images/banner5.jpg"
]

var numberImage = 0;

window.onload = function () {
    
    listCategories()
    carrousel()
    setTimeout(() => {
        pagination(id)
    }, 3000);
}

//PAGINACION
function pagination(id) {

    var onLoading = document.getElementById('onLoading')
    onLoading.style.visibility = "visible"
    onLoading.style.opacity = "0.9"

    var numberRegister = document.getElementById("selectNumberRegister");
    pageSize = numberRegister.options[numberRegister.selectedIndex].text;

    if (id === "" || id === undefined) {
        pathPagination = "http://143.198.119.78/estore-server/api/products/v1/pagination/?size=" + pageSize
    } else {
        pathPagination = document.getElementById(id).value
    }

    var request = {
        'productOrder': +document.getElementById("selectOrder").value,
        'productCategory': document.getElementById("selectMenu").value,
        'productName': document.getElementById('inText').value
    };

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(request),
        url: pathPagination,
        success: function (data) {

            if (data.errorCode === 200) {

                let listOfPaths = [] = data.data.listPath
                let listOfProducts = [] = data.data.listProduct

                let elementPage = []
                let elementProduct = []

                //PAGINACION
                elementPage.push("<ul>")

                for (let index = 0; index < listOfPaths.length; index++) {
                    let numberPage = index + 1
                    let identificator = "pagina" + index
                    elementPage.push(
                        "<li><button id = " + identificator + " value = 'http://143.198.119.78/estore-server" + listOfPaths[index] + "' onclick = pagination('" + identificator +"') class='btn btn-primary'>" + numberPage + "</button></li>"
                    )
                }

                elementPage.push("</ul>")

                document.getElementById('pages').innerHTML = elementPage.join("")

                //PRODUCTOS
                for (let index = 0; index < listOfProducts.length; index++) {
                    let identificator = "buttonAdd" + index
                    elementProduct.push("<article onclick=addProducto() onmouseover=addProductBotonOver('" + identificator + "') onmouseout=addProductBotonOut('" + identificator + "')>")
                    
                    if (listOfProducts[index].url_image === null || listOfProducts[index].url_image === "") {
                        elementProduct.push("<img id='imageProduct' src='images/imgNotFound.png'>")
                    } else {
                        elementProduct.push("<img id='imageProduct' src= " + listOfProducts[index].url_image + ">")
                    }

                    elementProduct.push("<h5><b>" + listOfProducts[index].name + "</b></h5>")
                    elementProduct.push("<h6><b>PRECIO: </b>" + listOfProducts[index].price + "</h6>")
                    elementProduct.push("<h6><b>DESCUENTO: </b>" + listOfProducts[index].discount + "</h6>")
                    elementProduct.push("<button id='" + identificator + "' class='btn btn-secondary' hidden>Agregar Producto</button>")
                    elementProduct.push("</article>")
                }

                document.getElementById('products').innerHTML = elementProduct.join("")

                pathPagination = "";

                var onLoading = document.getElementById('onLoading')
                onLoading.style.visibility = "hidden"
                onLoading.style.opacity = "0"
            } else {

                var onLoading = document.getElementById('onLoading')
                onLoading.style.visibility = "hidden"
                onLoading.style.opacity = "0"

                Swal.fire({
                    title: 'Lo sentimos',
                    text: "No hemos podido encontrar un producto relacionado a su busqueda",
                    icon: 'info',
        
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: 'OK',
                }).then((result) => {
                    if (result.isConfirmed) {
                        document.getElementById("selectOrder").value = 1,
                        document.getElementById("selectMenu").value = -1,
                        document.getElementById('inText').value = "";
                        document.getElementById('selectNumberRegister').value = 1;
                        pagination('');
                    }
                })
            }
        },
        error: function () {
            Swal.fire({
                title: 'Error',
                text: "La pagina necesita ser reiniciada",
                icon: 'error',
                confirmButtonColor: '#3085d6',
                confirmButtonText: 'OK',
            })
        }
    });
}

//LISTADO DE CATEGORIAS
function listCategories() {
    $.getJSON("http://143.198.119.78/estore-server/api/categories/v1/list", {}, function (data) {

        let categories = data.data

        let element = []

        element.push("<option value ='-1'> Seleccione Categoria </option>")

        for (let index = 0; index < categories.length; index++) {
            element.push("<option value = " + categories[index].id + ">" + categories[index].name.toUpperCase() + "</option>")
        }

        document.getElementById('selectMenu').innerHTML = element.join("")
    });

}

// UTILES

//BUSCAR AL PULSAR TECLA ENTER
function keyPress(event) {
    if (event.keyCode === 13) {
        pagination(id)
    }
}

//FUNCIONES PARA BOTONES DE CARRITO DE COMPRAS
function addProductBotonOver(id) {
    document.getElementById(id).removeAttribute('hidden');
}

function addProductBotonOut(id) {
    document.getElementById(id).setAttribute('hidden', true);
}

//FUNCION PARA AÑADIR PRODUCTOS AL CARRITO
function addProducto() {
    Swal.fire({
        title: 'Agregar producto',
        text: "¿Desea agregar este producto a su carrito?",
        icon: 'info',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'Si',
        cancelButtonColor: '#d33',
        cancelButtonText: 'No'
    }).then((result) => {
        if (result.isConfirmed) {
            numberProducts++
            document.getElementById('shoppingCarButton').innerHTML = "<a href='#'>Mi Carrito (" + numberProducts + ")</a>"
        }
    })
}

//CARRUSEL DE IMAGENES
function carrousel() {
    var imgCarrousel = document.getElementById('imageCarrousel')

    imgCarrousel.src = pathImages[indicator];
    imgCarrousel.style.transition = "all 1s ease-in-out"

    indicator++
    if (indicator >= pathImages.length) {
        indicator = 0
    }
    timeCarrousel = setTimeout("carrousel()", 3000);
}