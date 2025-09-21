package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Utilidad para leer archivos JSON.
 */
public final class JsonReader {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private JsonReader() {}

    /**
     * Lee un archivo JSON (objeto o arreglo) y devuelve una lista de mapas.
     * @param path ruta del archivo
     * @return lista de filas
     * @throws IOException si falla lectura o parseo
     */
    public static List<Map<String, Object>> readJsonFile(Path path) throws IOException {
        String content = Files.readString(path);
        try {
            if (content.trim().startsWith("[")) {
                return MAPPER.readValue(content, new TypeReference<>() {});
            } else {
                Map<String,Object> obj = MAPPER.readValue(content, new TypeReference<Map<String,Object>>() {});
                return Collections.singletonList(obj);
            }
        } catch (IOException e) {
            throw new IOException("No se pudo parsear el JSON (" + path + "): " + e.getMessage(), e);
        }
    }
}