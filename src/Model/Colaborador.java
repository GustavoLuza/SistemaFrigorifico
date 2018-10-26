package Model;

import Tipos.TipoSexo;
import java.util.Date;
import java.util.Set;


public class Colaborador extends Padrao {
    private String CPF;
    private String telefone;
    private TipoSexo sexo;
    private Date data_nascimento;
    
    //METODOS
    public Colaborador(){
        super();
        setCPF("000.000.000-00");
        setTelefone("(00) 0 0000-0000");
        this.setSexo(TipoSexo.M);
        setDataNascimento(new Date());  
        
    }
    
    public Colaborador(int id, String nome, String CPF,String telefone, TipoSexo sexo, Date DataNascimento){
        super(id,nome);
        setCPF(CPF);
        setTelefone(telefone);
        setSexo(sexo);
        setDataNascimento(DataNascimento);
    }
    
    //SET
    public void setCPF(String param){
        CPF = param;
    }
    
    public void setTelefone(String param){
        telefone=param.trim().isEmpty()?"TELEFONE NÃO IDENTIFICADO":param;
    }
    
    public void setSexo(TipoSexo sexo){
       this.sexo = sexo;
    }
    
    public void setDataNascimento(Date param){
        data_nascimento = param == null ? new Date() : param;
    }
    
    //GET
    public String getCPF(){
        return CPF;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public TipoSexo getSexo(){
        return sexo;
    }
    
    public Date getDataNascimento(){
        return data_nascimento;
    }    

}
