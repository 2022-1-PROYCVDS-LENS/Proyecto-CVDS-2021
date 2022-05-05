package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Reserva implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter int idUsuario;
    private @Getter @Setter int idRecurso;
    private @Getter @Setter String inicio;
    private @Getter @Setter String fin;
    private @Getter @Setter boolean recurrente;
    private @Getter @Setter String estado;
    private @Getter @Setter Date solicitud;
    private @Getter @Setter Timestamp inicio;
    private @Getter @Setter Timestamp fin;
    private @Getter @Setter String solicitud;
    private @Getter @Setter Usuario idUsuario;
    private @Getter @Setter Recurso idRecurso;
    private @Getter @Setter List<ReservaRecurrente> reservaRecurrentes;
    private @Getter @Setter List<Usuario> usuarios;

    @Override
    public String toString(){
        return "Reserva" + "inicio=" + inicio + "fin=" + fin +"estado=" + estado+"solicitud="+solicitud;
        return "Reserva" + "id=" + id + "inicio" + inicio.toString() + "}";
    }
}