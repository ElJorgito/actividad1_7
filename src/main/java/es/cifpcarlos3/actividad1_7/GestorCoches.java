package es.cifpcarlos3.actividad1_7;


import es.cifpcarlos3.actividad1_7.vo.CatalogoCoches;
import tools.jackson.dataformat.xml.XmlMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GestorCoches {
    public static void main(String[] args) throws IOException {
        Path base = Path.of("src","main","java","es","cifpcarlos3","actividad1_7");
        Path entrada = base.resolve("coches.txt");
        Path salida = base.resolve("coches.xml");
        List<CatalogoCoches> catalogo = new ArrayList<>();
        int lineasLeidas = 0;
        int lineasIgnoradas = 0;

        try (var br = Files.newBufferedReader(entrada)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;

                String[] partes = linea.split(",");
                if (partes.length != 4) {
                    lineasIgnoradas++;
                    continue;
                }
            }
            var mapper = new XmlMapper();
            var writer = mapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(salida.toFile(), catalogo);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}