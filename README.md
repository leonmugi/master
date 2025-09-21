# JSON → CSV Transformer

This project is a **Java 17** application that can **read JSON files** and convert them into **CSV files**.  
It was implemented as a **command-line interface (CLI)** tool, receiving the input file, the output file, and optionally the delimiter as arguments.

---

## 📚 Libraries Used

- **Jackson (com.fasterxml.jackson.databind)**  
  Used to parse JSON files into Java structures (`Map<String,Object>` or `List<Map<...>>`).  
  It provides flexibility to handle both JSON objects and arrays.

- **OpenCSV (com.opencsv)**  
  Used to write CSV files.  
  It simplifies handling delimiters, quotes, and escaping without reinventing the wheel.

- **JUnit 5 (org.junit.jupiter)**  
  Used for unit testing, ensuring that JSON reading and CSV writing work correctly and that errors are properly handled.

---

## 🛠️ Code Structure

- **`JsonReader.java`**  
  Utility class to read JSON files:
    - Detects if the file contains an object or an array.
    - Always returns a list of maps (`List<Map<String,Object>>`).
    - Handles exceptions when the format is invalid.

- **`CsvWriterUtil.java`**  
  Utility class to write CSV files from a list of maps:
    - Automatically generates headers from all keys found.
    - Nested structures (objects/lists) are serialized as JSON strings inside a cell.
    - Allows choosing the delimiter (default `,`, also supports `;`).

- **`Main.java`**  
  Entry point for the CLI version:
    - Requires 2 or 3 arguments: input JSON, output CSV, and optionally the delimiter.
    - Displays a usage message if arguments are missing.
    - Useful for automation or direct execution from the terminal.

---

## ⚙️ How It Works

1. **JSON Reading:**  
   The program reads the `.json` file, parses it into Java structures, and validates the format.

2. **Data Processing:**  
   Iterates over all maps and collects all unique keys to build the CSV headers.

3. **CSV Writing:**  
   Creates a `.csv` file where each row corresponds to one JSON object.
    - Simple values (numbers, strings) are written directly.
    - Complex values (lists, nested objects) are stored as JSON strings.

`input.json` → path to the JSON file

`output.csv` → path for the generated CSV file

---

## ✅ Quick Example

### Input (input.json)
```json
[
  {"id":1,"name":"Carlos","power":12},
  {"id":2,"name":"Samuel","power":9001}
]
```

### Command in Windows PowerShell
```powershell
java -jar target/json-csv-tool-1.0.0-shaded.jar data\input.json data\output.csv ;
```

### Output (output.csv)
```csv
id,name,power
1,Carlos,12
2,Samuel,9001
```

---

## 🔎 Summary
The project demonstrates how to use external Java libraries (Jackson and OpenCSV) to handle common data formats.

It was designed in a modular way: independent utility classes + a CLI entry point.

It includes JavaDoc documentation and JUnit 5 tests to ensure code quality.

---

## 🌟 Future Projection
Since this is my first time programming in IntelliJ and Java, the project is very basic.  
In the future, I would like to add a graphical interface where the user can select the JSON file and directly visualize the generated CSV without having to search for it manually.  
There are also many other opportunities to improve the tool and make it more user-friendly and versatile.

Finally i want to say that was a good progress for my and i am happy, i'll hope be better in the near future.
