package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class TipoRecurso implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter String nombre;

    @Override
    public String toString(){
        return "Tipo{" + "idT=" + id + "nombreT=" + nombre + "}";
    }
}
