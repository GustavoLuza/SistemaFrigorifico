package Tipos;

public enum TipoSexo {
    M("MASCULINO"),
    F("FEMININO"),
    O("OUTRO");
    
    private String descricao;

    private TipoSexo(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
}
