Download Manager
-

#### Exercise:

El programa debe:

1. Leer un archivo, puede ser un simple archivo de texto, que va ha tener una lista de archivos a descargar y la prioridad de cada archivo.
2. La prioridad indica que archivos se deberían descargar primero.
3. La prioridad será un número entero empezando en 1, donde el 1 sería la prioridad más alta y a medida que se incremente baja la prioridad del archivo.
4. El gestor debe tener la habilidad de gestionar hasta 5 descargas en paralelo, es decir leer el archivo y poner a descargar varios de los archivos en paralelo.
5. La aplicación indicará que ha terminado cuando todos los archivos se hayan descargado.
6. Los archivos estarán en un servidor (FTP, HTML, o lo que sea) predeterminado y los archivos se guardaran localmente donde corre la aplicacion.

#### Sample File:

```
## [prioridad]:[nombre del archivo]
6;page1.html
10;image1.jpg
2;db.dump
1;log.txt
10;image2.jpg
```

#### Technology used:
    * Java 8
    * Apache Commons Validator 1.4.0
    * Logback classic 1.2.3
    * Unit Test 4.11
    * PowerMock 1.7.1
    * Apache Maven 3.5.4 

#### How to run:

1. Clone the project:
    ```
    $ git clone https://github.com/juanca87/download-manager.git

    ```

2. Enter to the folder downloaded and package the project:
    ```
    $ cd download-manager
    $ mvn package
    ```

    * You should get the output something like this:
    ```
    Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.011 sec
    Results :
    Tests run: 35, Failures: 0, Errors: 0, Skipped: 0
    ...
    [INFO] BUILD SUCCESS
    ...
    ```

3. Run the application:
    * The application receives two parameters, the first one is the input file, that is, the file with the elements that will be downloaded and the second is the place where the files will be downloaded; this last parameter is optional, if the directory is not specified, the files will be downloaded to the same directory where the application is executed.
    ```
    java -jar target/download-manager-jar-with-dependencies.jar <file-with-the-items-to-be-downloaded> </download/in/this/path>
    ```

    * You must create a file with the structure mentioned above _(see the section "Sample File")_

    * You can take the [items.txt](https://raw.githubusercontent.com/juanca87/download-manager/master/src/main/resources/items.txt) file from the `resources` folder as a sample.

    * The final command could be:

    ```
    java -jar target/download-manager-jar-with-dependencies.jar ~/Downloads/items.txt ~/Desktop
    ```

    * Or simply:

    ```
    java -jar target/download-manager-jar-with-dependencies.jar ~/Downloads/items.txt
    ```