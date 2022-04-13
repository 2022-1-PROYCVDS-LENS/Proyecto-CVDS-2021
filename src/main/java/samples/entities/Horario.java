package samples.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Horario implements Serializable {

    private @Getter @Setter int id;
    private @Getter @Setter Recurso idRecurso;
    private @Getter @Setter String horario;
    private @Getter @Setter String estado;

    @Override
    public String toString(){
        return "Horario{" + "id=" + id + "idRecurso=" + idRecurso + "horario=" + horario + "estado=" + estado+ "}";
    }
}
