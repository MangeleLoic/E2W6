package epicode.E2W6.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Blog {
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoDiLettura;

    public Blog(String categoria, String contenuto, String cover, int tempoDiLettura, String titolo) {
        this.categoria = categoria;
        this.contenuto = contenuto;
        this.cover = cover;
        this.tempoDiLettura = tempoDiLettura;
        this.titolo = titolo;
    }
}
