Download Manager
-

#### El programa debe:

1. Leer un archivo, puede ser un simple archivo de texto. que va ha tener una lista de archivos a descargar y la prioridad de cada archivo.
2. La prioridad indica que archivos se deberian descargar primero.
3. La prioridad sera un nro entero empezando de 1. El 1 seria la prioridad mas alta y a medida que se incremente baja la prioridad del archivo.
4. El gestor debe tener la habilidad de gestionar hasta 5 descargas en paralelo, es decir leer el archivo y poner a descargar varios de los archivos en paralelo.
5. La aplicación indicará que ha terminado cuando todos los archivos se hayan descargado.
6. Los archivos estaran en un servidor (FTP, HTML, o lo que sea) predeterminado y los archivos se guardaran localmente donde corre la aplicacion.



#### Ejemplo de archivo:

```
    -----------------------------
    ## [prioridad]:[nombre del archivo]
    6:page1.html
    10:image1.jpg
    2:db.dump
    1:log.txt
    10:image2.jpg
```