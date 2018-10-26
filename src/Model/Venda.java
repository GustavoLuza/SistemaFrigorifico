package Model;

import java.util.Date;

public class Venda implements java.io.Serializable {
    @SwingColumn(description = "CÓDIGO", colorOfBackgound = "")
    private int id;
    @SwingColumn(description = "CLIENTE", colorOfBackgound = "")
    private Cliente cliente;
    @SwingColumn(description = "PRODUTO", colorOfBackgound = "")
    private Produto produto;
    @SwingColumn(description = "DATA DA VENDA", colorOfBackgound = "")
    private Date data_venda;
    @SwingColumn(description = "PESO TOTAL", colorOfBackgound = "")
    private double peso;
    @SwingColumn(description = "VALOR TOTAL", colorOfBackgound = "")
    private double valor_total;
    
    public Venda(){
        setPeso(0.00);
        setValor_total(0.00);
    }
    public Venda(  int id,Produto produto, Cliente cliente,  Date data_venda, double peso, double valor_total){
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.data_venda = data_venda;
        this.peso = peso;
        this.valor_total = valor_total;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public Date getData_venda() {
        return data_venda;
    }

    public double getPeso() {
        return peso;
    }

    public double getValor_total() {
        return valor_total;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venda other = (Venda) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
   
}
