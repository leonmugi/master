# JSON to CSV Tool

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
mvn clean compile javadoc:javadoc

Para ejecutar el programa:
java -jar target/json-csv-tool-1.0.0.jar input.json output.csv ;

--------------------------------------------------

Desarrollado por Leonel Campos como parte de la práctica de Sprint 3.
