# JSON to CSV Tool

[Go to English version](#json-to-csv-conversion-tool)

Este proyecto es una aplicación en **Java 17** que permite **leer archivos JSON** y convertirlos en **archivos CSV** de manera flexible.  
Fue desarrollado como parte del **Sprint 3** del curso y se enfoca en consolidar funcionalidades, documentación y pruebas.

---

## 🚀 Funcionalidades principales

1. **Lectura de JSON**  
   - Se desarrolló la clase `JsonReader` que utiliza **Jackson** para interpretar archivos JSON.  
   - Soporta tanto objetos como arreglos JSON.  

2. **Transformación de datos**  
   - Los datos del JSON se mapean en una estructura interna (`List<Map<String,Object>>`) que permite un manejo flexible.  

3. **Escritura de CSV**  
   - La clase `CsvWriterUtil` implementa la escritura en CSV usando **OpenCSV**.  
   - Maneja delimitadores configurables (ejemplo: `,` o `;`).  
   - Valores anidados (`List` o `Map`) se serializan como JSON dentro de una celda.  

4. **Configuración de parámetros**  
   - El programa recibe argumentos desde la línea de comandos:  
     ```bash
     java -jar json-csv-tool.jar input.json output.csv ;
     ```
     - `args[0]`: Ruta del archivo JSON de entrada  
     - `args[1]`: Ruta del archivo CSV de salida  
     - `args[2]`: (opcional) delimitador, por defecto `,`

5. **Algoritmo de transformación**  
   - Convierte cada objeto JSON en un mapa clave-valor.  
   - Unifica cabeceras dinámicamente a partir de las llaves encontradas en los objetos.  
   - Los valores complejos se serializan para no perder información.  

---

## 📖 Documentación JavaDoc

Se añadieron **comentarios JavaDoc detallados** para todas las clases y métodos principales.  
- Se describen las responsabilidades de cada clase.  
- Se documentan parámetros y valores de retorno.  
- Se añadieron ejemplos explicativos en secciones clave.  

Adicionalmente:  
- Se instaló **Maven** y el plugin `maven-javadoc-plugin` para generar la documentación.  
- Se corrigieron detalles de formato para mejorar la visualización del JavaDoc.  

---

## 🧪 Archivos de prueba

Se incluyeron ejemplos adicionales de archivos JSON en la carpeta /test-data:

1. products.json
[
  { "id": 1, "name": "Laptop", "price": 1200.50, "inStock": true },
  { "id": 2, "name": "Mouse", "price": 25.99, "inStock": false }
]

2. users.json
[
  { "id": 101, "username": "leonel", "email": "leon@example.com" },
  { "id": 102, "username": "camila", "email": "camila@example.com" }
]

3. orders.json
[
  { "orderId": 5001, "userId": 101, "total": 1300.75, "status": "paid" },
  { "orderId": 5002, "userId": 102, "total": 25.99, "status": "pending" }
]

--------------------------------------------------
✅ Checklist de verificación

[✔] Lectura de archivos JSON con soporte para objetos y arreglos  
[✔] Transformación de datos en estructura List<Map<String,Object>>  
[✔] Escritura de CSV con delimitador configurable  
[✔] Manejo de valores anidados con serialización a JSON  
[✔] Recepción de parámetros por línea de comandos  
[✔] Documentación JavaDoc completa y clara  
[✔] Instalación y configuración de Maven para generación de Javadoc  
[✔] Inclusión de archivos JSON de prueba  
[✔] Actualización del repositorio en GitHub con los entregables del Sprint  
--------------------------------------------------
📌 Ejecución

Para compilar y generar la documentación JavaDoc:
```bash
   mvn clean compile javadoc:javadoc
```

Para ejecutar el programa:
```bash
   java -jar target/json-csv-tool-1.0.0.jar input.json output.csv ;
```
--------------------------------------------------

Desarrollado por Leonel Campos como parte de la práctica de Sprint 3.

---
# JSON to CSV Conversion Tool

This project is an application built for **Java 17** that allows to **read JSON archives** and to convert them into **CSV archives** in a flexible manner.  
It was developed as part of **Sprint 3** of the course and focuses on consolidating functionality, documentation, and testing

---

## 🚀 Main functionalities

1. **JSON reading**  
   - The `JsonReader` class was developer using **Jackson** to parse JSON files.
   - It supports both JSON objects and arrays.  

2. **Data transformation**  
   - The JSON data is mapped into an internal structure (`List<Map<String,Object>>`) that allows flexible handling.

3. **CSV writing**  
   - The `CsvWriterUtil` class implements CSV writing using **OpenCSV**.  
   - It handles configurable delimiters (e.g., `,` or `;`).  
   - Nested values (`List` or `Map`) are serialized as JSON within a cell.

4. **Parameter configuration**  
   - The program receives arguments from the command line:  
     ```bash
     java -jar json-csv-tool.jar input.json output.csv ;
     ```
     - `args[0]`: Path to the input JSON file  
     - `args[1]`: Path to the output CSV file  
     - `args[2]`: (optional) delimeter, defaults to `,`

5. **Transformation Algorithm**  
   - Converts each JSON object into a key-value map.  
   - Dynamically unifies headers based on the keys found in the objects.  
   - Complex values are serialized to avoid data loss.  

---

## 📖 JavaDoc Documentation

Detailed **JavaDoc comments** were added for all main classes and methods.  
- Each class's responsibilities are described.  
- Parameters and return values are documented.  
- Explanatory examples were added in key sections.  

Additionally:  
- **Maven** and the `maven-javadoc-plugin` were installed to generate the documentation.  
- Formatting details were fixed to improve JavaDoc visualization.  

---

## 🧪 Test Files

Additional JSON example files were included in the /test-data folder:

1. products.json
[
  { "id": 1, "name": "Laptop", "price": 1200.50, "inStock": true },
  { "id": 2, "name": "Mouse", "price": 25.99, "inStock": false }
]

2. users.json
[
  { "id": 101, "username": "leonel", "email": "leon@example.com" },
  { "id": 102, "username": "camila", "email": "camila@example.com" }
]

3. orders.json
[
  { "orderId": 5001, "userId": 101, "total": 1300.75, "status": "paid" },
  { "orderId": 5002, "userId": 102, "total": 25.99, "status": "pending" }
]

--------------------------------------------------
✅ Verification Checklist

[✔] JSON file reading with support for objects and arrays  
[✔] Data transformation into `List<Map<String,Object>>` structure  
[✔] CSV writing with configurable delimiter  
[✔] Handling of nested values with JSON serialization  
[✔] Receiving parameters via command line  
[✔] Complete and clear JavaDoc documentation  
[✔] Maven installation and configuration for Javadoc generation  
[✔] Inclusion of test JSON files  
[✔] Repository update on GitHub with Sprint deliverables  
--------------------------------------------------
📌 Execution

To compile and generate the JavaDoc documentation:
```bash
   mvn clean compile javadoc:javadoc
```

To run the program:
```bash
   java -jar target/json-csv-tool-1.0.0.jar input.json output.csv ;
```
--------------------------------------------------

Developed by Leonel Campos as part of the Sprint 3 practice.
