package samples.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Recurso implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter String nombre;
    private @Getter @Setter String habilitado;
    private @Getter @Setter String ubicacion;
    private @Getter @Setter List<Horario> horarios;
    private @Getter @Setter List<Reserva> reservas;
    private @Getter @Setter TipoRecurso tipo;

    @Override
    public String toString() {
        return "Horario{" + "id=" + id + "nombre=" + nombre + "habilitado=" + habilitado + "ubicacion=" + ubicacion + "horarios=\n\t" + horarios + "reservas=\n\t" + reservas + "tipo=" + tipo + "}";
    }
}