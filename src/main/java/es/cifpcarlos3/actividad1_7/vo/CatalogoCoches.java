package es.cifpcarlos3.actividad1_7.vo;

import lombok.Data;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@Data
@JacksonXmlRootElement(localName = "catalogo")

public class CatalogoCoches {

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Coches> coche = new ArrayList<>();

    public void add(Coches c) {
        coche.add(c);
    }
}

