package Controller;

import Model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DaoProduto extends Dao {
        public int addProduto(Produto produto) throws SQLException{
        String SQL="INSERT INTO PRODUTO (ID_FRIGORIFICO, NOME_PRODUTO, DATA_ABATE,VALIDADE_PRODUTO,LOTE_PRODUTO, VALOR_VENDA, PESO_TOTAL) VALUES(?,?,?,?,?,?,?)";
        return(super.executeUpdate(SQL,produto.getFrigorifico().getId(),produto.getNome(), produto.getData_abate(),produto.getValidade(),produto.getLote(),produto.getValor_venda(),produto.getPeso_total()));
    }
    public int updateProduto(Produto produto) throws SQLException{
        String SQL="UPDATE PRODUTO SET ID_FRIGORIFICO=?, NOME_PRODUTO=?, DATA_ABATE=?,VALIDADE_PRODUTO=?,LOTE_PRODUTO=?, VALOR_VENDA=?, PESO_TOTAL=? WHERE ID_PRODUTO=?";
        return (super.executeUpdate(SQL,
                produto.getFrigorifico().getId(),
                produto.getNome(), 
                produto.getData_abate(),
                produto.getValidade(),
                produto.getLote(),
                produto.getValor_venda(),
                produto.getPeso_total(),
                produto.getId()));
    }
    public int deleteProduto(Produto produto) throws SQLException{
        return (super.executeUpdate("DELETE FROM PRODUTO WHERE ID_PRODUTO=?", produto.getId()));
    }
    public Produto getProduto(int pk) throws SQLException{
        String SQL="SELECT * FROM PRODUTO WHERE ID_PRODUTO=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        return (rs.next()?populateProduto(rs):null);
    }
    
    public List<Produto> getProdutoList() throws SQLException{
        String SQL="SELECT * FROM PRODUTO";
        ResultSet rs = super.executeQuery(SQL);
        List<Produto> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateProduto(rs));
        }
        return lista;
    }
    
    public List<Produto> getProdutoList(String filtro) throws SQLException{
        List<Produto> retorno = new LinkedList<>();
        String SQL="SELECT * FROM PRODUTO WHERE LOTE_PRODUTO LIKE ? ";
        ResultSet rs= super.executeQuery(SQL,"%"+filtro+"%");
        while (rs.next()){
            retorno.add(populateProduto(rs));
        }
        return retorno;
    }
    
    
    private Produto populateProduto(ResultSet rs) throws SQLException{
        return (new Produto(rs.getInt("ID_PRODUTO"),                
                new DaoFrigorifico().getFrigorifico(rs.getInt("ID_FRIGORIFICO")),
                rs.getString("NOME_PRODUTO"),
                rs.getDate("DATA_ABATE"),
                rs.getDate("VALIDADE_PRODUTO"),
                rs.getString("LOTE_PRODUTO"),
                rs.getDouble("VALOR_VENDA"),
                rs.getDouble("PESO_TOTAL")));
                
    }
    
}
