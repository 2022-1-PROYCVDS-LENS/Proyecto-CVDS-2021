package samples.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Recurso implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter String nombre;
    private @Getter @Setter String habilitado;
    private @Getter @Setter String ubicacion;

}
