package Model;


public class Padrao implements java.io.Serializable {
    @SwingColumn(description = "Código", colorOfBackgound = "#FF00FF")
    private int id;
    @SwingColumn(description = "Nome", colorOfBackgound = "#00FFFF")
    private String nome;
    //COSNTRUTOR
    public Padrao(){
        this.setId(0);
        this.setNome("default");
    }
    public Padrao(int id, String nome){
        this.setId(id);
        this.setNome(nome);
    }
    
    public void setId(int id) {
    this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"DEFAULT":nome.toUpperCase();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Padrao other = (Padrao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
