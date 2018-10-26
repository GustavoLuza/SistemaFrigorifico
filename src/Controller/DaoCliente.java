package Controller;

import Model.Cliente;
import Model.Padrao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoCliente extends Dao {
    public int addCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("INSERT INTO CLIENTE(NOME_CLIENTE,CNPJ,TELEFONE,ENDERECO,NOME_CONTATO) VALUES (?,?,?,?,?)",cliente.getNome(),cliente.getCNPJ(), cliente.getTelefone(),cliente.getEndereco(), cliente.getContato()));
    }
    public int updateCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("UPDATE CLIENTE SET NOME_CLIENTE=?,CNPJ=?, TELEFONE=?, ENDERECO=?, NOME_CONTATO=? WHERE ID_CLIENTE=?",cliente.getNome(),cliente.getCNPJ(), cliente.getTelefone(),cliente.getEndereco(),cliente.getContato(),cliente.getId()));
    }
    
    public int deleteCliente(Cliente cliente) throws SQLException{
        return (super.executeUpdate("DELETE FROM CLIENTE WHERE ID_CLIENTE=?", cliente.getId()));
    }
    
    public Cliente getCliente(int pk) throws SQLException{
        ResultSet rs = super.executeQuery("SELECT * FROM CLIENTE WHERE ID_CLIENTE=?", pk);
        return (rs.next() ? populateObject(rs) : null);
    }
    
    public List<Cliente> getClienteList() throws SQLException{
        List<Cliente> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM CLIENTE ORDER BY NOME_CLIENTE");
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    public List<Cliente> getClienteList(String filtro) throws SQLException{
        List<Cliente> retorno = new LinkedList<>();
        ResultSet rs= super.executeQuery("SELECT * FROM CLIENTE WHERE NOME_CLIENTE LIKE ? OR CNPJ =? ORDER BY NOME_CLIENTE","%"+filtro.toUpperCase()+"%",filtro);
        while (rs.next()){
            retorno.add(populateObject(rs));
        }
        return retorno;
    }
    
    
    private Cliente populateObject(ResultSet rs) throws SQLException{
        return (new Cliente(rs.getInt("ID_CLIENTE"),rs.getString("NOME_CLIENTE"),rs.getString("CNPJ"),rs.getString("TELEFONE"),rs.getString("ENDERECO"),rs.getString("NOME_CONTATO")));
    } 
    
    
}
