package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
public class ReservaRecurrente implements Serializable {
    private @Getter @Setter int id;
    private @Getter @Setter String periodo;
    private @Getter @Setter String fin;

    @Override
    public String toString(){
        return "ReservaRe{" + "id=" + id + "periodo=" + periodo + "fin=" + fin + "}";
    }
}
