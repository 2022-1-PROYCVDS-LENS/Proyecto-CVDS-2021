package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Reserva implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter Usuario idUsuario;
    private @Getter @Setter Recurso idRecurso;
    private @Getter @Setter String inicio;
    private @Getter @Setter String fin;
    private @Getter @Setter boolean recurrente;
    private @Getter @Setter String estado;
    private @Getter @Setter String solicitud;
    private @Getter @Setter List<ReservaRecurrente> reservaRecurrentes;
    private @Getter @Setter List<Usuario> usuarios;

    @Override
    public String toString(){
        return "Reserva" + "id=" + id + "idUsuario=" + idUsuario + "idRecurso=" + idRecurso + "inicio=" + inicio + "fin=" + fin + "recurrente=" + recurrente+"estado=" + estado+"solicitud="+solicitud+"reservaRecurrentes=\n\t" + reservaRecurrentes + "usuarios=\n\t" + usuarios+"}";
    }

}
