
# eStore:

La tienda virtual eStore es desarrollada con el fin de brindar al usuario mayores facilidades al momento de comprar sus productos, sean estas bebidas alcohólicas, energizantes o snacks. Brinda una interfaz web amigable y de aspecto sencillo para no llegar a ser pesada para la vista.

Este proyecto es desarrollado en dos componentes diferenciados.
  
  1. ESTORE-SERVER
      - Componente del lado BACK-END, desarrollado en lenguaje Java 8 mediante el uso del framework Spring-Boot y usando la extensión .war para su empaquetamiento y fácil despliegue en un tomcat.
      - La funcionalidad de este componente es la exposición de servicios mediante API REST, con peticiones y respuestas en formato JSON, para brindar información hacia el componente BACK-END.
      - Para este componente fueron desarrolladas dos API REST mostradas a continuación:

      1.1 LISTADO DE CATEGORIAS
          
          - URL: http://143.198.119.78/estore-server/api/categories/v1/list
          - TIPO DE PETICION: GET
          - FUNCION: Obtener listado de las categorías encontradas en base de datos

      1.2 PAGINADO DE PRODUCTOS
        
          - URL: http://143.198.119.78/estore-server/api/products/v1/pagination
          - TIPO DE PETICION: POST
          - EJEMPLO DE PETICION:
              {
                  "productOrder": 6,
                  "productCategory": -1,
                  "productName": ""
              }
          - FUNCION: Obtener un paginado de productos de forma general o filtrado por los siguientes criterios:
              a. CATEGORIA (productCategory) 
              b. NOMBRE (productCategory)
              c. ORDEN DE DATOS (productOrder):
                   - Este último cuenta con tipos de ordenes como:
                        > A - Z
                        > Z - A
                        > Mayor Precio
                        > Menor Precio
                        > Mayor Descuento
                        > Menor Descuento
       
       POSTMAN ADJUNTO: https://www.getpostman.com/collections/5455bb6aa9c4755907c0
                        
      
  2. ESTORE-WEB
      - Componente del lado BACK-END, desarrollado con HTML5, CSS3 y VANILLA JS, haciendo uso de JQuery para el consumo de servicios y Bootstrap para componentes DropDown.
      - Versión optimizada para su uso en ORDENADORES.
      - Algunas características del portal:
      
            a. Filtro de ordenamiento por nombre, precio y descuento
            b. Filtro de búsqueda por Categoría y Nombre de producto
            c. Tamaños de paginado soportados actualmente 6, 9, 12
            d. Banner de rotación automática para mostrar productos seleccionados.
            
      - Versión optimizada para dispositivos móviles disponible próximamente.
      - Se adjunta Manual de Usuario: [Manual de Usuario Portal eStore.pdf](https://github.com/ClaudioCervantes/eStore/files/6420451/Manual.de.Usuario.Portal.eStore.pdf)
