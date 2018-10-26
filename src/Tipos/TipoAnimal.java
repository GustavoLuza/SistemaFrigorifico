package Tipos;

public enum TipoAnimal {
    A("AVES"),
    B("BÚFALO"),
    G("GADO"), 
    O("OVELHA");
    
    
    private String descricao;

    private TipoAnimal(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
}
