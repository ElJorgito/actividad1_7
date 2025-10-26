package es.cifpcarlos3.actividad1_7.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Coches {
    String marca;
    String modelo;
    String color;
    int anio;

    @Override
    public String toString() {return "'" + marca + "'" + " '" + modelo + "'" + " '" + color + "'" + anio + "'";}
}
