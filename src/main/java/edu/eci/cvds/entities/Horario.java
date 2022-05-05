package edu.eci.cvds.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;

@NoArgsConstructor
@AllArgsConstructor
public class Horario implements Serializable {

    private @Getter @Setter int id;
    private @Getter @Setter Recurso idRecurso;
    private @Getter @Setter String estado;
    private @Getter @Setter Time hora_ini;
    private @Getter @Setter Time hora_fin;

    @Override
    public String toString(){
        return "Horario{" + "id=" + id + " idRecurso=" + idRecurso + " estado=" + estado+ " hora inicio=" + hora_ini + " hora fin=" + hora_fin + "}";
    }
}
