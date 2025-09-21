package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Utilidad para escribir archivos CSV.
 */
public final class CsvWriterUtil {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private CsvWriterUtil() {}

    /**
     * Escribe una lista de mapas a CSV; anidados se serializan como JSON en una celda.
     * @param rows filas (List<Map>)
     * @param path ruta del CSV de salida
     * @param delimiter delimitador, por ejemplo ',' o ';'
     */
    public static void writeCsv(List<Map<String, Object>> rows, Path path, char delimiter) throws IOException {
        if (rows == null) rows = Collections.emptyList();

        Set<String> headerSet = new HashSet<>();
        for (Map<String,Object> r : rows) if (r != null) headerSet.addAll(r.keySet());
        List<String> headers = new ArrayList<>(headerSet);
        Collections.sort(headers);

        try (Writer w = Files.newBufferedWriter(path);
             CSVWriter csv = new CSVWriter(w, delimiter, CSVWriter.DEFAULT_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END)) {

            csv.writeNext(headers.toArray(new String[0]));
            for (Map<String,Object> r : rows) {
                String[] line = new String[headers.size()];
                for (int i=0;i<headers.size();i++) {
                    Object v = (r==null)? null : r.get(headers.get(i));
                    line[i] = stringify(v);
                }
                csv.writeNext(line);
            }
        }
    }

    private static String stringify(Object v) {
        if (v==null) return "";
        if (v instanceof Map || v instanceof List) {
            try { return MAPPER.writeValueAsString(v); } catch (Exception ignore) {}
        }
        return String.valueOf(v);
    }
}