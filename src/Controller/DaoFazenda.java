package Controller;

import Model.Colaborador;
import Model.Fazenda;
import Tipos.TipoAnimal;
import Tipos.TipoPasto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoFazenda extends Dao {
    public int addFazenda(Fazenda fazenda) throws SQLException{
        return (super.executeUpdate("INSERT INTO FAZENDA(NOME_FAZENDA, CNPJ, TELEFONE, ENDERECO, TIPO_PASTO, TIPO_ANIMAL, NOME_CONTATO) VALUES (?,?,?,?,?,?,?)",fazenda.getNome(),fazenda.getCNPJ(), fazenda.getTelefone(),fazenda.getEndereco(), fazenda.getPasto().name(), fazenda.getAnimal().name(),fazenda.getContato()));
    }
    public int updateFazenda(Fazenda fazenda) throws SQLException{
        return (super.executeUpdate("UPDATE FAZENDA SET NOME_FAZENDA=?,CNPJ=?,TELEFONE=?,ENDERECO=?,TIPO_PASTO=?, TIPO_ANIMAL=?, NOME_CONTATO=? WHERE ID_FAZENDA=?",fazenda.getNome(),fazenda.getCNPJ(), fazenda.getTelefone(),fazenda.getEndereco(), fazenda.getPasto().name(), fazenda.getAnimal().name(),fazenda.getContato(),fazenda.getId()));
    }
    
    public int deleteFazenda(Fazenda fazenda) throws SQLException{
        return (super.executeUpdate("DELETE FROM FAZENDA WHERE ID_FAZENDA=?", fazenda.getId()));
    }
    
    public Fazenda getFazenda(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM FAZENDA WHERE ID_FAZENDA=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Fazenda> getFazendaList() throws SQLException{
        List<Fazenda> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM FAZENDA ORDER BY NOME_FAZENDA");
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Fazenda> getFazendaList(String filtro) throws SQLException{
        List<Fazenda> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM FAZENDA WHERE NOME_FAZENDA LIKE ? OR CNPJ=? ORDER BY NOME_FAZENDA","%"+filtro.toUpperCase()+"%",filtro);
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    
    private Fazenda populateObject(ResultSet rs) throws SQLException{
        return (new Fazenda(rs.getInt("ID_FAZENDA"),rs.getString("NOME_FAZENDA"),rs.getString("CNPJ"),rs.getString("TELEFONE"),rs.getString("ENDERECO"),TipoPasto.valueOf(rs.getString("TIPO_PASTO")),TipoAnimal.valueOf(rs.getString("TIPO_ANIMAL")),rs.getString("NOME_CONTATO")));
    } 
    
}
