package samples.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class TipoRecurso implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter String tipo;
    private @Getter @Setter int capacidad;

    @Override
    public String toString(){
        return "Horario{" + "id=" + id + "tipo=" + tipo + "capacidad=" + capacidad + "}";
    }
}
