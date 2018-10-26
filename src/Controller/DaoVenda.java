package Controller;

import Model.Venda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoVenda extends Dao{
    public int addVenda(Venda venda) throws SQLException{
        String SQL="INSERT INTO VENDA (ID_PRODUTO, ID_CLIENTE, DATA_VENDA, PESO, VALOR_TOTAL) VALUES(?,?,?,?,?)";
        return(super.executeUpdate(SQL,
                venda.getProduto().getId(), 
                venda.getCliente().getId(),
                venda.getData_venda(),
                venda.getPeso(),
                venda.getValor_total()));
    }
    public int updateVenda(Venda venda) throws SQLException{
        String SQL="UPDATE VENDA SET ID_PRODUTO=?, ID_CLIENTE=?, DATA_VENDA=?, PESO=?,VALOR_TOTAL=? WHERE ID_VENDA=?";
        return (super.executeUpdate(SQL,venda.getProduto().getId(), venda.getCliente().getId(),venda.getData_venda(),venda.getPeso(),venda.getValor_total(),venda.getId()));
    }
    public int deleteVenda(Venda venda) throws SQLException{
        return (super.executeUpdate("DELETE FROM VENDA WHERE ID_VENDA=?", venda.getId()));
    }
    public Venda getVenda(int pk) throws SQLException{
        String SQL="SELECT * FROM VENDA WHERE ID_VENDA=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        return (rs.next()?populateVenda(rs):null);
    }
    
    public List<Venda> getVendaList() throws SQLException{
        String SQL="SELECT * FROM VENDA";
        ResultSet rs = super.executeQuery(SQL);
        List<Venda> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateVenda(rs));
        }
        return lista;
    }
    
    public List<Venda> getVendaList(String filtro) throws SQLException{
        String SQL="SELECT * FROM VENDA WHERE ID_VENDA LIKE ?";
        ResultSet rs = super.executeQuery(SQL,"%"+filtro+"%");
        List<Venda> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateVenda(rs));
        }
        return lista;
    }
    
    private Venda populateVenda(ResultSet rs) throws SQLException{
        return (new Venda(rs.getInt("ID_VENDA"),
                new DaoProduto().getProduto(rs.getInt("ID_PRODUTO")),
                new DaoCliente().getCliente(rs.getInt("ID_CLIENTE")),
                rs.getDate("DATA_VENDA"),
                rs.getDouble("PESO"), 
                rs.getDouble("VALOR_TOTAL")));
    }
    
    
}
