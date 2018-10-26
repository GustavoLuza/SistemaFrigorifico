package Model;


public class Frigorifico extends Padrao{
    private String CNPJ;
    private String telefone;
    private String endereco;
    private String responsavel;
    
     //METODOS
    public Frigorifico(){
        super();
        setCNPJ("00.000.000/0000-00");
        setTelefone("(00) 0 0000-0000");
        setEndereco("VAZIO");
        setResponsavel("VAZIO");  
        
    }
    
    public Frigorifico(int id, String nome, String CNPJ,String telefone, String endereco, String responsavel){
        super(id,nome);
        setCNPJ(CNPJ);
        setTelefone(telefone);
        setEndereco(endereco);
        setResponsavel(responsavel);
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
    
   public void setResponsavel(String param){
        responsavel=param.trim().isEmpty()?"RESPONSAVEL NÃO IDENTIFICADO":param.toUpperCase();
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
      
      public String getResponsavel(){
        return responsavel;
    }
    
}
