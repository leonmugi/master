package org.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 * CLI principal.
 * Uso: java -jar json-csv-tool-1.0.0-shaded.jar input.json output.csv [;|,]
 */
public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Uso: java -jar <jar> <input.json> <output.csv> [delimitador (por defecto ,)]");
            System.exit(1);
        }
        Path in = Paths.get(args[0]);
        Path out = Paths.get(args[1]);
        char delimiter = (args.length >= 3) ? args[2].charAt(0) : ',';

        try {
            List<Map<String,Object>> rows = JsonReader.readJsonFile(in);
            CsvWriterUtil.writeCsv(rows, out, delimiter);
            System.out.println("CSV generado en: " + out.toAbsolutePath());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(2);
        }
    }
}
