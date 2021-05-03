
var cantidadProductos = 0;
var id
var pathPagination = "";
var pageSize;

$(document).ready(function () {
    
    listCategories()

setTimeout(() => {
    pagination(id)
}, 3000);
        

    

})

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
            cantidadProductos++
            document.getElementById('botonCarrito').innerHTML = "<a href='#'>Mi Carrito (" + cantidadProductos + ")</a>"
        }
    })
}

function addProductoBotonOver(id) {
    document.getElementById(id).removeAttribute('hidden');
}

function addProductoBotonOut(id) {
    document.getElementById(id).setAttribute('hidden', true);
}

function pagination(id) {

    var combo = document.getElementById("slctCantidadRegistros");
    pageSize = combo.options[combo.selectedIndex].text;

    if (id === "" || id === undefined) {
        pathPagination = "http://192.168.1.12:8080/api/products/v1/pagination/?size=" + pageSize
    } else {
        pathPagination = document.getElementById(id).value
        console.log(pathPagination)
    }

    var request = {
        'productOrder': +document.getElementById("slctOrdenamiento").value,
        'productCategory': document.getElementById("slctMenu").value,
        'productName': document.getElementById('inText').value
    };

    console.log(JSON.stringify(request))

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        dataType: 'json',
        data: JSON.stringify(request),
        url: pathPagination,
        success: function (data) {

            if (data.errorCode === 200) {
                console.log(JSON.stringify(data))

                let rutas = [] = data.data.listPath
                let listaProductos = [] = data.data.listProduct

                let elementoPaginado = []
                let elementoProducto = []

                console.log("LLEGA A LA PAGINACION")
                //PAGINACION
                elementoPaginado.push("<ul>")

                for (let index = 0; index < rutas.length; index++) {
                    let numeroPagina = index + 1
                    let identificador = "pagina" + index
                    elementoPaginado.push(
                        "<li><button id = " + identificador + " value = '" + rutas[index] + "' onclick = pagination('" + identificador +"') class='btn btn-secondary'>" + numeroPagina + "</button></li>"
                    )
                }

                elementoPaginado.push("</ul>")

                document.getElementById('paginado').innerHTML = elementoPaginado.join("")

                console.log("SALE DE LA PAGINACION")
                //PRODUCTOS

                console.log("LLEGA A LA PRODUCTOS")
                for (let index = 0; index < listaProductos.length; index++) {
                    let identificador = "btnAgregar" + index
                    elementoProducto.push("<article onclick=addProducto() onmouseover=addProductoBotonOver('" + identificador + "') onmouseout=addProductoBotonOut('" + identificador + "')>")
                    
                    if (listaProductos[index].url_image === null || listaProductos[index].url_image === "") {
                        elementoProducto.push("<img id='imagenProducto' src='../images/notFoundpng.png'>")
                    } else {
                        elementoProducto.push("<img id='imagenProducto' src= " + listaProductos[index].url_image + ">")
                    }

                    elementoProducto.push("<h4><b>" + listaProductos[index].name + "</b></h4>")
                    elementoProducto.push("<h5><b>PRECIO: </b>" + listaProductos[index].price + "</h5>")
                    elementoProducto.push("<h5><b>DESCUENTO: </b>" + listaProductos[index].discount + "</h5>")
                    elementoProducto.push("<button id='" + identificador + "' class='btn btn-secondary' hidden>Agregar Producto</button>")
                    elementoProducto.push("</article>")
                }

                document.getElementById('productos').innerHTML = elementoProducto.join("")
                
                console.log("SALE A LA PRODUCTOS")

                pathPagination = "";
            } else {
                Swal.fire({
                    title: 'Lo sentimos',
                    text: "No hemos podido encontrar un producto relacionado a su busqueda",
                    icon: 'info',
        
                    confirmButtonColor: '#3085d6',
                    confirmButtonText: 'OK',
                }).then((result) => {
                    if (result.isConfirmed) {
                        document.getElementById("slctOrdenamiento").value = 1,
                        document.getElementById("slctMenu").value = -1,
                        document.getElementById('inText').value = "";
                        pagination('');
                    }
                })
            }

            
        },
        error: function () {
            addProducto()
        }
    });
}

function keyPress(event) {

    if (event.keyCode === 13) {
        pagination(id)
    }

}


//LISTADO DE CATEGORIAS
function listCategories() {
    $.getJSON("http://192.168.1.12:8080/api/categories/v1/list", {}, function (data) {

        let categories = data.data

        let element = []

        element.push("<option value ='-1'> Seleccione Categoria </option>")

        for (let index = 0; index < categories.length; index++) {
            element.push("<option value = " + categories[index].id + ">" + categories[index].name.toUpperCase() + "</option>")
        }


        document.getElementById('slctMenu').innerHTML = element.join("")
    });

}