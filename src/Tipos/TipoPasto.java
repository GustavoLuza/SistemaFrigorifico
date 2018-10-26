package Tipos;

public enum TipoPasto {
    N("PASTO NORMAL"),
    O("PASTO ORGANICO"),
    R("RAÇÃO"),
    M("MISTO");
    
    private String descricao;

    private TipoPasto(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
}
