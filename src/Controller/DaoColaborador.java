package Controller;

import Model.Colaborador;
import Tipos.TipoSexo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class DaoColaborador extends Dao {
    public int addColaborador(Colaborador colaborador) throws SQLException{
        return (super.executeUpdate("INSERT INTO COLABORADOR(NOME_COLABORADOR,CPF,TELEFONE,SEXO,DATA_NASCIMENTO) VALUES (?,?,?,?,?)",colaborador.getNome(),colaborador.getCPF(), colaborador.getTelefone(),colaborador.getSexo().name(), colaborador.getDataNascimento()));
    }
    public int updateColaborador(Colaborador colaborador) throws SQLException{
        return (super.executeUpdate("UPDATE COLABORADOR SET NOME_COLABORADOR=?,CPF=?, TELEFONE=?, SEXO=?, DATA_NASCIMENTO=? WHERE ID_COLABORADOR=?",colaborador.getNome(),colaborador.getCPF(), colaborador.getTelefone(),colaborador.getSexo().name(), colaborador.getDataNascimento(),colaborador.getId()));
    }
    
    public int deleteColaborador(Colaborador colaborador) throws SQLException{
        return (super.executeUpdate("DELETE FROM COLABORADOR WHERE ID_COLABORADOR=?", colaborador.getId()));
    }
    
    public Colaborador getColaborador(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM COLABORADOR WHERE ID_COLABORADOR=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Colaborador> getColaboradorList() throws SQLException{
        List<Colaborador> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM COLABORADOR ORDER BY NOME_COLABORADOR");
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Colaborador> getColaboradorList(String filtro) throws SQLException{
        List<Colaborador> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM COLABORADOR WHERE NOME_COLABORADOR LIKE ? OR CPF = ? ORDER BY NOME_COLABORADOR","%"+filtro.toUpperCase()+"%",filtro);
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    private Colaborador populateObject(ResultSet rs) throws SQLException{
        return (new Colaborador(rs.getInt("ID_COLABORADOR"),rs.getString("NOME_COLABORADOR"),rs.getString("CPF"),rs.getString("TELEFONE"),TipoSexo.valueOf(rs.getString("SEXO")),rs.getDate("DATA_NASCIMENTO")));
    } 
}
