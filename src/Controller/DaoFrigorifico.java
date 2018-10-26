package Controller;

import Model.Frigorifico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoFrigorifico extends Dao {
    
    public int addFrigorifico(Frigorifico frigorifico) throws SQLException{
        return (super.executeUpdate("INSERT INTO FRIGORIFICO(NOME_FRIGORIFICO,CNPJ,TELEFONE,ENDERECO,NOME_RESPONSAVEL) VALUES (?,?,?,?,?)",frigorifico.getNome(),frigorifico.getCNPJ(), frigorifico.getTelefone(),frigorifico.getEndereco(), frigorifico.getResponsavel()));
    }
    public int updateFrigorifico(Frigorifico frigorifico) throws SQLException{
        return (super.executeUpdate("UPDATE FRIGORIFICO SET NOME_FRIGORIFICO=?,CNPJ=?, TELEFONE=?, ENDERECO=?, NOME_RESPONSAVEL=? WHERE ID_FRIGORIFICO=?",frigorifico.getNome(),frigorifico.getCNPJ(), frigorifico.getTelefone(),frigorifico.getEndereco(),frigorifico.getResponsavel(),frigorifico.getId()));
    }
    
    public int deleteFrigorifico(Frigorifico frigorifico) throws SQLException{
        return (super.executeUpdate("DELETE FROM FRIGORIFICO WHERE ID_FRIGORIFICO=?", frigorifico.getId()));
    }
    
    public Frigorifico getFrigorifico(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM FRIGORIFICO WHERE ID_FRIGORIFICO=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Frigorifico> getFrigorificoList() throws SQLException{
        List<Frigorifico> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM FRIGORIFICO ORDER BY NOME_FRIGORIFICO");
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Frigorifico> getFrigorificoList(String filtro) throws SQLException{
        List<Frigorifico> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM FRIGORIFICO WHERE NOME_FRIGORIFICO LIKE ? OR CNPJ = ? ORDER BY NOME_FRIGORIFICO","%"+filtro.toUpperCase()+"%",filtro);
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    
    
    private Frigorifico populateObject(ResultSet rs) throws SQLException{
        return (new Frigorifico(rs.getInt("ID_FRIGORIFICO"),rs.getString("NOME_FRIGORIFICO"),rs.getString("CNPJ"),rs.getString("TELEFONE"),rs.getString("ENDERECO"),rs.getString("NOME_RESPONSAVEL")));
    } 
    
}
