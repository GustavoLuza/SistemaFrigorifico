package View;

import Controller.DaoFrigorifico;
import Controller.DaoProduto;
import Model.Frigorifico;
import Model.Padrao;
import Model.Produto;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class DialogProduto extends javax.swing.JDialog {
    
        DaoProduto dao = new DaoProduto();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    
    
    private void carregaFK() throws SQLException{
        DaoFrigorifico daoFrigorifico = new DaoFrigorifico();
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new Vector(daoFrigorifico.getFrigorificoList()));
        ComboAbatedouro.setModel(cbm);
    }
    
    private void carregaProduto() throws SQLException{
        TableProduto.setModel(new MyTableModel(Produto.class, dao.getProdutoList(), TableProduto));
    }
    
    private void carregaProduto(String filtro) throws SQLException{
        TableProduto.setModel(new MyTableModel(Produto.class, dao.getProdutoList(filtro), TableProduto));
    }
    
    
    //INICIAR COMPONENTES
    private void iniciaComponentes(){
        TextID.setText("");
        TextNome.setText("");
        ComboAbatedouro.setSelectedItem(0);
        TextAbate.setText("");
        TextLote.setText("");
        TextValidade.setText("");
        TextVenda.setText("");
        TextPeso.setText("");
        TextPesquisar.setText("");
        TextNome.requestFocus();
    }
    //CRIAR UM OBJETO A PARTIR DA TELA
    private Produto populateProduto() throws ParseException{
        return new Produto(TextID.getText().isEmpty()?0:Integer.parseInt(TextID.getText()),
                   (Frigorifico)ComboAbatedouro.getSelectedItem(),
                   TextNome.getText(),
                   formato.parse(TextAbate.getText()),
                   formato.parse(TextValidade.getText()),
                   TextLote.getText(),
                   Double.parseDouble(TextVenda.getText()),
                   Double.parseDouble(TextPeso.getText()));
    }
    
    //PREENCHER OS COMPONENTES COM UM OBJETO
    private void populateComponente(Produto produto){
        TextID.setText(produto.getId()+"");
        TextNome.setText(produto.getNome());
        ComboAbatedouro.setSelectedItem(produto.getFrigorifico());
        TextAbate.setText(formato.format(produto.getData_abate()));
        TextValidade.setText(formato.format(produto.getValidade()));
        TextLote.setText(produto.getLote());
        TextVenda.setText(produto.getValor_venda()+"");
        TextPeso.setText(produto.getPeso_total()+"");
        
    }
   
    public DialogProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextID = new javax.swing.JTextField();
        TextNome = new javax.swing.JTextField();
        TextLote = new javax.swing.JTextField();
        TextVenda = new javax.swing.JTextField();
        TextPesquisar = new javax.swing.JTextField();
        TextAbate = new javax.swing.JFormattedTextField();
        TextValidade = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        ComboAbatedouro = new javax.swing.JComboBox<>();
        ButtonPesquisar = new javax.swing.JButton();
        ButtonNovo = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        ButtonRemover = new javax.swing.JButton();
        TextPeso = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableProduto = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRODUTO");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRO DE PRODUTO"));

        jLabel1.setText("CÓDIGO");

        jLabel2.setText("NOME");

        jLabel4.setText("ABATEDOURO");

        jLabel5.setText("DATA DO ABATE");

        jLabel6.setText("LOTE");

        jLabel7.setText("VALIDADE");

        jLabel8.setText("VALOR DE VENDA");

        jLabel9.setText("PESQUISAR POR LOTE");

        TextID.setEditable(false);

        try {
            TextAbate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            TextValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel10.setText("R$");

        ComboAbatedouro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ButtonPesquisar.setText("PESQUISAR");
        ButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPesquisarActionPerformed(evt);
            }
        });

        ButtonNovo.setText("NOVO");
        ButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNovoActionPerformed(evt);
            }
        });

        ButtonSalvar.setText("SALVAR");
        ButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSalvarActionPerformed(evt);
            }
        });

        ButtonRemover.setText("REMOVER");
        ButtonRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRemoverActionPerformed(evt);
            }
        });

        jLabel3.setText("PESO");

        jLabel11.setText("KG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(ButtonNovo)
                .addGap(103, 103, 103)
                .addComponent(ButtonSalvar)
                .addGap(102, 102, 102)
                .addComponent(ButtonRemover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboAbatedouro, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextAbate, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TextPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextLote, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonPesquisar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)))
                .addGap(0, 337, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboAbatedouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextAbate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextValidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TextLote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonNovo)
                            .addComponent(ButtonSalvar)
                            .addComponent(ButtonRemover))
                        .addGap(47, 47, 47))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(TextVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(TextPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ButtonPesquisar))
                        .addContainerGap(98, Short.MAX_VALUE))))
        );

        TableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProdutoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try{
            this.carregaFK();
            this.carregaProduto();
        }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void ButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNovoActionPerformed
        // TODO add your handling code here:
        this.iniciaComponentes();
    }//GEN-LAST:event_ButtonNovoActionPerformed

    private void ButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSalvarActionPerformed
        // TODO add your handling code here:
        //NOME
        try {
            double teste;
            teste = Double.parseDouble(TextNome.getText());
            JOptionPane.showMessageDialog(null, "NÃO É PERMITIDO NÚMEROS NO CAMPO DE NOME");
            TextNome.setText("");
            TextNome.requestFocus();
            return;
        } catch (Exception nome) {
            
        }
        
        if (TextNome.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "CAMPO NOME NÃO PODE SER VAZIO");
            TextNome.requestFocus();
            return;
        }
                
        //DATA DO ABATE
        if(TextAbate.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "CAMPO DATA DO ABATE NÃO PODE SER VAZIO");
            TextAbate.setText("");
            TextAbate.requestFocus();
            return;
        }
        
        //DATA DE VALIDADE
        if(TextValidade.getText().equals("  /  /    ")){
            JOptionPane.showMessageDialog(null, "CAMPO DATA DE VALIDADE NÃO PODE SER VAZIO");
            TextValidade.setText("");
            TextValidade.requestFocus();
            return;
        }
        
        //LOTE
        if (TextLote.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "CAMPO LOTE NÃO PODE SER VAZIO");
            TextLote.requestFocus();
            return;
        }
        
        try {
            double teste;
            teste = Double.parseDouble(TextLote.getText());
            
        } catch (Exception codigo) {
            JOptionPane.showMessageDialog(null, "NÃO É ACEITO LETRAS NO CAMPO LOTE");
            TextLote.setText("");
            TextLote.requestFocus();
            return;
        }
        
        //PESO
        if (TextPeso.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "CAMPO PESO NÃO PODE SER VAZIO");
            TextPeso.requestFocus();
            return;
        }
        
        try {
            double teste;
            teste = Double.parseDouble(TextPeso.getText());
            
        } catch (Exception codigo) {
            JOptionPane.showMessageDialog(null, "NÃO É ACEITO LETRAS NO CAMPO PESO");
            TextPeso.setText("");
            TextPeso.requestFocus();
            return;
        }
                
        //VENDA
        
        if (TextVenda.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "CAMPO VALOR DE VENDA NÃO PODE SER VAZIO");
            TextVenda.requestFocus();
            return;
        }
        
        try {
            double teste;
            teste = Double.parseDouble(TextVenda.getText());
            
        } catch (Exception codigo) {
            JOptionPane.showMessageDialog(null, "NÃO É ACEITO LETRAS NO CAMPO VALOR DE VENDA");
            TextVenda.setText("");
            TextVenda.requestFocus();
            return;
        }
        
        try{
           if(TextID.getText().isEmpty()){ //REGISTRO NOVO
               dao.addProduto(populateProduto());
           }else{ //ATUALIZAÇÃO
               dao.updateProduto(populateProduto());
           }
            
            this.carregaFK();
            this.carregaProduto();
            this.iniciaComponentes();
        }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(DialogAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonSalvarActionPerformed

    private void ButtonRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRemoverActionPerformed
        // TODO add your handling code here:
        if (TextID.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"DE UM DUPLO CLIQUE NO REGISTRO QUE DESEJA EXCLUIR");
            return;
        }
        if (JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR?")!=0){
            iniciaComponentes();
            return;
        }
        try{
            dao.deleteProduto(populateProduto());
            iniciaComponentes();
            carregaProduto();
        }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(DialogAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRemoverActionPerformed

    private void TableProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProdutoMouseClicked
        // TODO add your handling code here:
         try{
            if (evt.getClickCount()==2){
                String valor= TableProduto.getValueAt(TableProduto.getSelectedRow(),0)+""; //+"" TRANSFORMA EM STRING
                int codigo = Integer.parseInt(valor);
                populateComponente(dao.getProduto(codigo));
            }
        }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }//GEN-LAST:event_TableProdutoMouseClicked

    private void ButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquisarActionPerformed
        // TODO add your handling code here:
        if(TextPesquisar.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"DIGITE ALGO PARA PESQUISAR");
            TextPesquisar.requestFocus();
        }
        try{
            this.carregaProduto(TextPesquisar.getText());
           }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }//GEN-LAST:event_ButtonPesquisarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogProduto dialog = new DialogProduto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonNovo;
    private javax.swing.JButton ButtonPesquisar;
    private javax.swing.JButton ButtonRemover;
    private javax.swing.JButton ButtonSalvar;
    private javax.swing.JComboBox<String> ComboAbatedouro;
    private javax.swing.JTable TableProduto;
    private javax.swing.JFormattedTextField TextAbate;
    private javax.swing.JTextField TextID;
    private javax.swing.JTextField TextLote;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextPeso;
    private javax.swing.JTextField TextPesquisar;
    private javax.swing.JFormattedTextField TextValidade;
    private javax.swing.JTextField TextVenda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
