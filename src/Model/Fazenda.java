package Model;

import Tipos.TipoAnimal;
import Tipos.TipoPasto;


public class Fazenda extends Padrao {
    private String CNPJ;
    private String telefone;
    private String endereco;
    private TipoPasto tipo_pasto;
    private TipoAnimal tipo_animal;
    private String nome_contato;
    
     //METODOS
    public Fazenda(){
        super();
        setCNPJ("00.000.000/0000-00");
        setTelefone("(00) 0 0000-0000");
        setEndereco("VAZIO");
        this.setPasto(tipo_pasto.N);
        this.setAnimal(tipo_animal.G);
        setContato("VAZIO");  
        
    }
    
    public Fazenda(int id, String nome, String CNPJ,String telefone,String endereco, TipoPasto tipo_pasto, TipoAnimal tipo_animal, String nome_contato){
        super(id,nome);
        setCNPJ(CNPJ);
        setTelefone(telefone);
        setEndereco(endereco);
        setPasto(tipo_pasto);
        setAnimal(tipo_animal);
        setContato(nome_contato);
    }
    
    //SET
    public void setCNPJ(String param){
        CNPJ = param;
    }
    
    public void setTelefone(String param){
        telefone = param;
    }
    
    public void setEndereco(String param){
        endereco=param.trim().isEmpty()?"ENDEREÇO NÃO IDENTIFICADO":param.toUpperCase();
    }
    
    public void setPasto(TipoPasto tipo_pasto){
       this.tipo_pasto = tipo_pasto;
    }
    
    public void setAnimal(TipoAnimal tipo_animal){
       this.tipo_animal = tipo_animal;
    }
    
   public void setContato(String param){
       nome_contato=param.trim().isEmpty()?"CONTATO NÃO IDENTIFICADO":param.toUpperCase();
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
    
    public TipoPasto getPasto(){
        return tipo_pasto;
    }
    
      public TipoAnimal getAnimal(){
        return tipo_animal;
    }
    
    
    public String getContato(){
        return nome_contato;
    }

}
