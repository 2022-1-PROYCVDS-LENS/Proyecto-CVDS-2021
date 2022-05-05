package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
