package persistence;


import entities.Reserva;

public interface ReservaDAO {
    public void save(Reserva reserva);
    public Reserva load(int id);
    public void reservarRecurso(int id_usuario,int id_recurso,String inicio, String fin, boolean recurrente, String estado, String solicitud);
}
