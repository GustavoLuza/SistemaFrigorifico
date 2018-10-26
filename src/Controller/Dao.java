package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {
    //RETORNA UM STATEMENT
    public Statement getStatement() throws SQLException{
        return Dados.Conexao.getConnection().createStatement();
    }
    //RETORNA UM PREPARED STATEMENT
    public PreparedStatement getStatement(String SQL) throws SQLException{
        return Dados.Conexao.getConnection().prepareStatement(SQL);
    }
    //EXECUTA UM COMANDO SQL COM UPDATE
    public int executeUpdate(String SQL, Object... args) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        return pst.executeUpdate();
    }
    
    //EXECUTA UM COMANDO SQL DE SELECT
    public ResultSet executeQuery(String SQL, Object... args) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < args.length; i++) {
            pst.setObject((i+1), args[i]);
        }
        return pst.executeQuery();
    }
    
}
