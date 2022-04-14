package samples.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter String tipoUsuario;
    private @Getter @Setter String nombre;
    private @Getter @Setter String programa;

    @Override
    public String toString(){
        return "Usuario{" + "id=" + id + "tipoUsuario=" + tipoUsuario + "nombre=" + nombre + "programa=" + programa + "}";
    }
}
