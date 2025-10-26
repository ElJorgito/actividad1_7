package es.cifpcarlos3.actividad1_7;


import es.cifpcarlos3.actividad1_7.vo.CatalogoCoches;
import es.cifpcarlos3.actividad1_7.vo.Coches;
import tools.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class GestorCoches {
    public static void main(String[] args) throws IOException {
        Path base = Path.of("src","main","java","es","cifpcarlos3","actividad1_7");
        Path entrada = base.resolve("coches.txt");
        Path salida = base.resolve("coches.xml");

        CatalogoCoches catalogo = new CatalogoCoches();
        int lineasLeidas = 0;
        int lineasValidas = 0;
        int lineasIgnoradas = 0;

        try (var br = Files.newBufferedReader(entrada)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineasLeidas++;

                String[] partes = linea.split(",");
                if (partes.length != 4) {
                    lineasIgnoradas++;
                    System.out.println("ERROR: La linea debe tener 4 caracteres");
                    continue;
                }
                try{
                    String marca = partes[0].trim();
                    String modelo = partes[1].trim();
                    String color = partes[2].trim();
                    int anio = Integer.parseInt(partes[3].trim());

                    Coches coche = new Coches(marca, modelo, color, anio);
                    catalogo.add(coche);
                    lineasValidas++;
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: La linea debe tener un numero de caracteres" + e.getMessage());
                }
                var mapper = new XmlMapper();
                var writer = mapper.writerWithDefaultPrettyPrinter();
                writer.writeValue(salida.toFile(), catalogo);
            }
            System.out.println("Leídas: " + lineasLeidas + " | Válidas: " + lineasValidas + " | Ignoradas: " + lineasIgnoradas);
            System.out.println("XML generado en: " + salida.toAbsolutePath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}