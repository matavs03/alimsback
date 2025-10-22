package rs.alims.pismaBack.dto;

/**
 *
 * @author lazar
 */
public class MedicationDTO {
    private String sifraProizvoda;
    private String nazivLeka;
    private String proizvodjac;
    private String inn;
    private String oblikIDozaLeka;

    public String getSifraProizvoda() {
        return sifraProizvoda;
    }

    public void setSifraProizvoda(String sifraProizvoda) {
        this.sifraProizvoda = sifraProizvoda;
    }

    
    public String getNazivLeka() {
        return nazivLeka;
    }

    public void setNazivLeka(String nazivLeka) {
        this.nazivLeka = nazivLeka;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String proizvodjac) {
        this.proizvodjac = proizvodjac;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getOblikIDozaLeka() {
        return oblikIDozaLeka;
    }

    public void setOblikIDozaLeka(String oblikIDozaLeka) {
        this.oblikIDozaLeka = oblikIDozaLeka;
    }
    
    
}