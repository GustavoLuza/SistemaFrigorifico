package Model;

public class Cliente extends Padrao {
    private String CNPJ;
    private String telefone;
    private String endereco;
    private String contato;
    
     //METODOS
    public Cliente(){
        super();
        setCNPJ("00.000.000/0000-00");
        setTelefone("(00) 0 0000-0000");
        setEndereco("VAZIO");
        setContato("VAZIO");  
        
    }
    
    public Cliente(int id, String nome, String CNPJ,String telefone, String endereco, String contato){
        super(id,nome);
        this.setCNPJ(CNPJ);
        this.setTelefone(telefone);
        this.setEndereco(endereco);
        this.setContato(contato);
    }
    
    //SET
    public void setCNPJ(String param){
        CNPJ = param;
    }
    
    public void setTelefone(String param){
        telefone=param.trim().isEmpty()?"TELEFONE NÃO IDENTIFICADO":param;
    }
    
  public void setEndereco(String param){
        endereco=param.trim().isEmpty()?"ENDEREÇO NÃO IDENTIFICADO":param.toUpperCase();
    }
    
   public void setContato(String param){
        contato=param.trim().isEmpty()?"CONTATO NÃO IDENTIFICADO":param.toUpperCase();
    }
    
    //GET
    public String getCNPJ(){
        return CNPJ;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
      public String getEndereco(){
        return endereco;
    }
      
      public String getContato(){
        return contato;
    }
    
     

    
}
