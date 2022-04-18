package entities;

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
    private @Getter @Setter int ejemplares;
    private @Getter @Setter int capacidad;
    private @Getter @Setter TipoRecurso tipo;
    private @Getter @Setter List<Horario> horarios;
    private @Getter @Setter List<Reserva> reservas;

    @Override
    public String toString() {
        return "Recurso{" + "id= " + id + " nombre= " + nombre + " habilitado= " + habilitado + " ubicacion= " + ubicacion + " capacidad= "+ capacidad + " ejemplares= " +ejemplares+ " horarios= " + horarios + " reservas= " + reservas + " tipo= " + tipo + "}";
    }
}