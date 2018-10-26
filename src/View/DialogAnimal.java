/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DaoAnimal;
import Controller.DaoFazenda;
import Model.Animal;
import Model.Fazenda;
import Tipos.TipoAnimal;
import Tipos.TipoSexo;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class DialogAnimal extends javax.swing.JDialog {

    DaoAnimal dao = new DaoAnimal();
    
    
    private void carregaSexo(){
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(TipoSexo.values ());
        ComboSexo.setModel(cbm);
    }
    
    private void carregaEspecie(){
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(TipoAnimal.values ());
        ComboEspecie.setModel(cbm);
    }
    
    
    private void carregaFK() throws SQLException{
        DaoFazenda daoFazenda = new DaoFazenda();
        DefaultComboBoxModel cbm = new DefaultComboBoxModel(new Vector(daoFazenda.getFazendaList()));
        ComboFazenda.setModel(cbm);
    }
    
    private void carregaAnimal() throws SQLException{
        List<Animal> lista = dao.getAnimalList();
        TableAnimal.setModel(new MyTableModel(Animal.class, dao.getAnimalList(), TableAnimal));
    }
    
    
    
    private void carregaPesquisa(List<Animal> ultimaListas) throws SQLException{
        LinkedList<Animal> filtro = new LinkedList<>();
       for (Animal ultimaLista : ultimaListas) {
            filtro.add(ultimaLista);
        }
        
        TableAnimal.setModel(new MyTableModel(Animal.class, filtro, TableAnimal));
    }
    
    private void pesquisaDinamica() throws SQLException{
        List<Animal> listas = dao.getAnimalList();
        
        //filtrar todos
        List<Animal> listaTodos = new LinkedList<>();
        for (Animal lista : listas) {
            if(RadioTodos.isSelected()){
                listaTodos.add(lista);
            }else{
                listaTodos.add(lista);
            }    
        }
        
       //filtrar por codigo
         List<Animal> listaCodigos = new LinkedList<>();
        for (Animal listaTodo : listaTodos) {
            if(RadioCodigo.isSelected() && (!TextPesquisar.getText().isEmpty())){
                if(listaTodo.getId() == Integer.parseInt(TextPesquisar.getText())){
                    listaCodigos.add(listaTodo);
                }      
            }else{
                listaCodigos.add(listaTodo);                   
            }   
        }
        
        //filtrar por especie
        List<Animal> listaEspecies = new LinkedList<>();
        for (Animal listaCodigo : listaCodigos) {
            if(RadioRaca.isSelected() && (!TextPesquisar.getText().isEmpty())){
                if(listaCodigo.getRaca().contains(TextPesquisar.getText().toUpperCase())){
                    listaEspecies.add(listaCodigo);
                }
            }else{
                listaEspecies.add(listaCodigo);
            }
            
        }
        
        //filtrar por fazenda
        List<Animal> listaFazendas = new LinkedList<>();
        for (Animal listaEspecie : listaEspecies) {
            if(RadioFazenda.isSelected() && (!TextPesquisar.getText().isEmpty())){
                if(listaEspecie.getFazenda().getNome().contains(TextPesquisar.getText().toUpperCase())){
                    listaFazendas.add(listaEspecie);
                }
            }else{
                listaFazendas.add(listaEspecie);
            }
        } 
      /* LinkedList<Animal> novalista = new LinkedList<>();
       for (Animal lista : listaFazendas) {
           novalista.add(lista);
        }*/
        
        this.carregaPesquisa(listaFazendas);
    }
    
    //INICIAR COMPONENTES
    private void iniciaComponentes(){
        TextID.setText("");
        TextRaca.setText("");
        ComboEspecie.setSelectedItem(0);
        TextPeso.setText("");
        ComboSexo.setSelectedItem(0);
        ComboFazenda.setSelectedItem(0);
        TextPesquisar.setText("");
        TextRaca.requestFocus();
    }
    
    private Animal populateAnimal() throws ParseException{
        return new Animal(TextID.getText().isEmpty()?0:Integer.parseInt(TextID.getText()),
                (Fazenda)ComboFazenda.getSelectedItem(), 
                TextRaca.getText(), 
                (TipoAnimal)ComboEspecie.getSelectedItem(),
                Double.parseDouble(TextPeso.getText()),
                (TipoSexo)ComboSexo.getSelectedItem());
    }
    
    //PREENCHER OS COMPONENTES COM UM OBJETO
    private void populateComponente(Animal animal){
        TextID.setText(animal.getId()+""); //"" converte para string nesse caso
        ComboFazenda.setSelectedItem(animal.getFazenda());
        TextRaca.setText(animal.getRaca());
        ComboEspecie.setSelectedItem(animal.getEspecie());
        TextPeso.setText(animal.getPeso()+"");
        ComboSexo.setSelectedItem(animal.getSexo());
        
    }
    
    public DialogAnimal(java.awt.Frame parent, boolean modal) {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextID = new javax.swing.JTextField();
        TextRaca = new javax.swing.JTextField();
        TextPeso = new javax.swing.JTextField();
        TextPesquisar = new javax.swing.JTextField();
        ComboEspecie = new javax.swing.JComboBox<>();
        ComboFazenda = new javax.swing.JComboBox<>();
        ComboSexo = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        RadioCodigo = new javax.swing.JRadioButton();
        RadioRaca = new javax.swing.JRadioButton();
        RadioFazenda = new javax.swing.JRadioButton();
        ButtonPesquisar = new javax.swing.JButton();
        ButtonNovo = new javax.swing.JButton();
        ButtonSalvar = new javax.swing.JButton();
        ButtonRemover = new javax.swing.JButton();
        RadioTodos = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableAnimal = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ANIMAL");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CADASTRO DE ANIMAL"));

        jLabel1.setText("CÓDIGO");

        jLabel2.setText("RAÇA");

        jLabel3.setText("ESPÉCIE");

        jLabel4.setText("PESO");

        jLabel5.setText("SEXO");

        jLabel6.setText("FAZENDA FORNECEDORA");

        jLabel7.setText("PESQUISAR");

        TextID.setEditable(false);

        ComboEspecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboFazenda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ComboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("KG");

        buttonGroup1.add(RadioCodigo);
        RadioCodigo.setText("PESQUISAR POR CÓDIGO");
        RadioCodigo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioCodigoMouseClicked(evt);
            }
        });

        buttonGroup1.add(RadioRaca);
        RadioRaca.setText("PESQUISAR POR RAÇA");
        RadioRaca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioRacaMouseClicked(evt);
            }
        });
        RadioRaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioRacaActionPerformed(evt);
            }
        });

        buttonGroup1.add(RadioFazenda);
        RadioFazenda.setText("PESQUISAR POR FAZENDA");
        RadioFazenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioFazendaMouseClicked(evt);
            }
        });

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

        buttonGroup1.add(RadioTodos);
        RadioTodos.setText("PESQUISAR POR TODOS");
        RadioTodos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RadioTodosMouseClicked(evt);
            }
        });
        RadioTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioTodosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(ComboFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonPesquisar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(212, 212, 212)
                                .addComponent(ButtonNovo)
                                .addGap(90, 90, 90)
                                .addComponent(ButtonSalvar)
                                .addGap(99, 99, 99))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RadioCodigo)
                                .addGap(18, 18, 18)
                                .addComponent(RadioRaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RadioFazenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadioTodos)
                            .addComponent(ButtonRemover)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(TextPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ComboSexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(ComboEspecie, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(TextRaca, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(110, Short.MAX_VALUE))
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
                    .addComponent(TextRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ComboEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TextPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(ComboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ComboFazenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioCodigo)
                    .addComponent(RadioRaca)
                    .addComponent(RadioFazenda)
                    .addComponent(RadioTodos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonPesquisar))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonNovo)
                    .addComponent(ButtonSalvar)
                    .addComponent(ButtonRemover))
                .addContainerGap())
        );

        TableAnimal.setModel(new javax.swing.table.DefaultTableModel(
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
        TableAnimal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableAnimalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableAnimal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        try{
            this.carregaSexo();
            this.carregaEspecie();
            this.carregaFK();
            this.carregaAnimal();
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
        //RAÇA
        try {
            double teste;
            teste = Double.parseDouble(TextRaca.getText());
            JOptionPane.showMessageDialog(null, "NÃO É PERMITIDO NÚMEROS NO CAMPO DE RAÇA");
            TextRaca.setText("");
            TextRaca.requestFocus();
            return;
        } catch (Exception nome) {
            
        }
        
        if(TextRaca.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"CAMPO RAÇA NÃO PODE SER VAZIO");
            TextRaca.requestFocus();
            return;
        }
                       
        //PESO
        
        if(TextPeso.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"PREENCHA O CAMPO PESO");
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
        
        try{
           if(TextID.getText().isEmpty()){ //REGISTRO NOVO
               dao.addAnimal(populateAnimal());
           }else{ //ATUALIZAÇÃO
               dao.updateAnimal(populateAnimal());
           }
            this.carregaEspecie();
            this.carregaFK();
            this.carregaSexo();
            this.carregaAnimal();
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
            dao.deleteAnimal(populateAnimal());
            iniciaComponentes();
            carregaAnimal();
        }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        } catch (ParseException ex) {
            Logger.getLogger(DialogAnimal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ButtonRemoverActionPerformed

    private void TableAnimalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableAnimalMouseClicked
        // TODO add your handling code here:
        try{
            if (evt.getClickCount()==2){
                String valor= TableAnimal.getValueAt(TableAnimal.getSelectedRow(),0)+""; //+"" TRANSFORMA EM STRING
                int codigo = Integer.parseInt(valor);
                populateComponente(dao.getAnimal(codigo));
            }
        }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }//GEN-LAST:event_TableAnimalMouseClicked

    private void ButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPesquisarActionPerformed
        // TODO add your handling code here:
        try{
            //FILTROS
           this.pesquisaDinamica();
           }catch(SQLException ex){
            System.out.println("ERRO: "+ex.getMessage());
        }
    }//GEN-LAST:event_ButtonPesquisarActionPerformed

    private void RadioRacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioRacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioRacaActionPerformed

    private void RadioTodosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioTodosMouseClicked
        // TODO add your handling code here:
        if(RadioTodos.isSelected()){
            TextPesquisar.setEnabled(false);
        }
    }//GEN-LAST:event_RadioTodosMouseClicked

    private void RadioTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioTodosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioTodosActionPerformed

    private void RadioFazendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioFazendaMouseClicked
        // TODO add your handling code here:
        if(!RadioTodos.isSelected()){
            TextPesquisar.setEnabled(true);
        }
    }//GEN-LAST:event_RadioFazendaMouseClicked

    private void RadioRacaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioRacaMouseClicked
        // TODO add your handling code here:
        if(!RadioTodos.isSelected()){
            TextPesquisar.setEnabled(true);
        }
    }//GEN-LAST:event_RadioRacaMouseClicked

    private void RadioCodigoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RadioCodigoMouseClicked
        // TODO add your handling code here:
        if(!RadioTodos.isSelected()){
            TextPesquisar.setEnabled(true);
        }
    }//GEN-LAST:event_RadioCodigoMouseClicked

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
            java.util.logging.Logger.getLogger(DialogAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogAnimal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogAnimal dialog = new DialogAnimal(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> ComboEspecie;
    private javax.swing.JComboBox<String> ComboFazenda;
    private javax.swing.JComboBox<String> ComboSexo;
    private javax.swing.JRadioButton RadioCodigo;
    private javax.swing.JRadioButton RadioFazenda;
    private javax.swing.JRadioButton RadioRaca;
    private javax.swing.JRadioButton RadioTodos;
    private javax.swing.JTable TableAnimal;
    private javax.swing.JTextField TextID;
    private javax.swing.JTextField TextPeso;
    private javax.swing.JTextField TextPesquisar;
    private javax.swing.JTextField TextRaca;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
