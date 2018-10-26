package Controller;

import Model.Animal;
import Tipos.TipoAnimal;
import Tipos.TipoSexo;
import java.sql.ResultSet;
import java.sql.SQLException;import java.util.LinkedList;
import java.util.List;

public class DaoAnimal extends Dao{
    public int addAnimal(Animal animal) throws SQLException{
        String SQL="INSERT INTO ANIMAL (ID_FAZENDA, RACA_ANIMAL, ESPECIE_ANIMAL,PESO_ANIMAL,SEXO) VALUES(?,?,?,?,?)";
        return(super.executeUpdate(SQL,animal.getFazenda().getId(), animal.getRaca(),animal.getEspecie().name(),animal.getPeso(),animal.getSexo().name()));
    }
    public int updateAnimal(Animal animal) throws SQLException{
        String SQL="UPDATE ANIMAL SET ID_FAZENDA=?,RACA_ANIMAL=?,ESPECIE_ANIMAL=?,PESO_ANIMAL=?,SEXO=? WHERE ID_ANIMAL=?";
        return (super.executeUpdate(SQL,animal.getFazenda().getId(), animal.getRaca(),animal.getEspecie().name(),animal.getPeso(),animal.getSexo().name(),animal.getId()));
    }
    public int deleteAnimal(Animal animal) throws SQLException{
        return (super.executeUpdate("DELETE FROM ANIMAL WHERE ID_ANIMAL=?", animal.getId()));
    }
    public Animal getAnimal(int pk) throws SQLException{
        String SQL="SELECT * FROM ANIMAL WHERE ID_ANIMAL=?";
        ResultSet rs = super.executeQuery(SQL, pk);
        return (rs.next()?populateAnimal(rs):null);
    }
    
    public List<Animal> getAnimalList() throws SQLException{
        String SQL="SELECT * FROM ANIMAL";
        ResultSet rs = super.executeQuery(SQL);
        List<Animal> lista = new LinkedList<>();
        while (rs.next()){
            lista.add(populateAnimal(rs));
        }
        return lista;
    }
    
    
    private Animal populateAnimal(ResultSet rs) throws SQLException{
        return (new Animal(rs.getInt("ID_ANIMAL"),
                new DaoFazenda().getFazenda(rs.getInt("ID_FAZENDA")),
                rs.getString("RACA_ANIMAL"),
                TipoAnimal.valueOf(rs.getString("ESPECIE_ANIMAL")),
                rs.getDouble("PESO_ANIMAL"), 
                TipoSexo.valueOf(rs.getString("SEXO"))));
    }
    
}
