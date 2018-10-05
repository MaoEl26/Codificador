/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
import Controller.Controlador;
import Controller.DTOAlgoritmos;
import Controller.DaoAlfabetos;
import Cliente.Cliente;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author mcv26
 */
public final class GUI extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    DaoAlfabetos daoAlfabetos;
    CodificaciónBinaria bin = new CodificaciónBinaria();
    CodigoTelefonico tel = new CodigoTelefonico();
    PalabraClave clave = new PalabraClave();
    Trasposicion tras = new Trasposicion();
    Vigenere vige = new Vigenere();
    
    private void ejecutar(){
        int alfabeto;
        boolean modoCodificacion = true;
        String frase = entText.getText();
        String tipoSalida = "",salida="";
        ArrayList<String> listaAlgoritmos = new ArrayList<>();
        ArrayList<String> listaSalidas = new ArrayList<>();
        
        if(telfCheckBox.isSelected()){
            listaAlgoritmos.add("CodigoTelefonico");
        }
        if(vigeCheckBox.isSelected()){
            listaAlgoritmos.add("Vigenere");
        }
        if(trasCheckBox.isSelected()){
            listaAlgoritmos.add("Trasposicion");
            //claveCheckBox.setVisible(false);
        }
        if(binCheckBox.isSelected()){
            listaAlgoritmos.add("CodificacionBin");
        }
        if(claveCheckBox.isSelected()){
            listaAlgoritmos.add("PalabraClave");
        }
        if(codiRadioB.isSelected()){
            modoCodificacion = true;
        }
        if(decoRadioB.isSelected()){
            modoCodificacion = false;
        }
        if(txtRadioB.isSelected()){
            tipoSalida = txtRadioB.getText().toLowerCase();
        }
        if(pdfRadioB.isSelected()){
            tipoSalida = pdfRadioB.getText().toLowerCase();
        }
        if(xmlRadioB.isSelected()){
            tipoSalida = xmlRadioB.getText().toLowerCase();
        }
        alfabeto = alfabetoCombo.getSelectedIndex()+1;
        
        DTOAlgoritmos dtoAlgoritmos = new DTOAlgoritmos(alfabeto, frase, 
                listaAlgoritmos, listaSalidas, modoCodificacion, tipoSalida);
        //Controlador controlador = new Controlador();
        //controlador.procesarPeticion(dtoAlgoritmos);
        
        Cliente c = new Cliente();
        
        try {
            dtoAlgoritmos = c.conecteServidor(dtoAlgoritmos);
        } catch (Exception e) {
            System.out.println("Error al recibir respuesta del servidor");
        }

        
        
        
        for (int i = 0; i < dtoAlgoritmos.getListaSalidas().size(); i++) {
            salida += dtoAlgoritmos.getListaSalidas().get(i)+"\n";
        }
        
        //System.out.println("ultima ---- " + salida);
        salidaText.setText(salida);
        
        /*//Controlador controlador = new Controlador();
        //controlador.procesarPeticion(dtoAlgoritmos);
        
        Cliente c = new Cliente();
        
        try {
            DTOAlgoritmos dtoAlgoritmosRespuesta = c.conecteServidor(dtoAlgoritmos);
            for (int i = 0; i < dtoAlgoritmosRespuesta.getListaSalidas().size(); i++) {
                salida += dtoAlgoritmosRespuesta.getListaSalidas().get(i)+"\n";
            }
        } catch (Exception e) {
            System.out.println("Error al recibir respuesta del servidor");
        }*/
    }
    
    public void listaAlfabetos(){
        ArrayList<Alfabeto> lista = daoAlfabetos.getListaAlfabetos();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).isEstado()){
                alfabetoCombo.addItem(lista.get(i).getNombreAlfabeto());
            }           
        }
    }
    
    public void inicioDao(DaoAlfabetos daoAlfabetos){
        this.daoAlfabetos = daoAlfabetos;
    }
   
    public void validaAlgoritmos(){
        binCheckBox.setVisible(bin.getEstado());
        vigeCheckBox.setVisible(vige.getEstado());
        trasCheckBox.setVisible(tras.getEstado());
        telfCheckBox.setVisible(tel.getEstado());
        claveCheckBox.setVisible(clave.getEstado());
    }
    
    private void inicioPrograma(){
        validaAlgoritmos();
        codiRadioB.setSelected(true);
        txtRadioB.setSelected(true);
        entText.setText("");
        salidaText.setText("");
        telfCheckBox.setSelected(false);
        trasCheckBox.setSelected(false);
        vigeCheckBox.setSelected(false);
        claveCheckBox.setSelected(false);
        binCheckBox.setSelected(false);
   }
    
    public void start(){
       initComponents();
       listaAlfabetos();
       inicioPrograma();
       //validaAlgoritmos();
    }
    
    public GUI() {

    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoModo = new javax.swing.ButtonGroup();
        grupoImpresion = new javax.swing.ButtonGroup();
        TituloLabel = new javax.swing.JLabel();
        entLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        entText = new javax.swing.JTextArea();
        formatoLabel = new javax.swing.JLabel();
        salidaLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        salidaText = new javax.swing.JTextArea();
        modoLabel = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        algoritmoLabel = new javax.swing.JLabel();
        decoRadioB = new javax.swing.JRadioButton();
        codiRadioB = new javax.swing.JRadioButton();
        txtRadioB = new javax.swing.JRadioButton();
        pdfRadioB = new javax.swing.JRadioButton();
        xmlRadioB = new javax.swing.JRadioButton();
        vigeCheckBox = new javax.swing.JCheckBox();
        trasCheckBox = new javax.swing.JCheckBox();
        telfCheckBox = new javax.swing.JCheckBox();
        alfabetoLabel = new javax.swing.JLabel();
        alfabetoCombo = new javax.swing.JComboBox<>();
        binCheckBox = new javax.swing.JCheckBox();
        claveCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(175, 127, 164));

        TituloLabel.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        TituloLabel.setForeground(new java.awt.Color(243, 126, 11));
        TituloLabel.setText("Codificador y Decodificador de Textos ");

        entLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        entLabel.setForeground(new java.awt.Color(153, 153, 0));
        entLabel.setText("Texto de Entrada ");

        entText.setColumns(20);
        entText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        entText.setRows(5);
        jScrollPane1.setViewportView(entText);

        formatoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        formatoLabel.setForeground(new java.awt.Color(153, 153, 0));
        formatoLabel.setText("Formato de Documento de Salida:");

        salidaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        salidaLabel.setForeground(new java.awt.Color(153, 153, 0));
        salidaLabel.setText("Texto de Salida");

        salidaText.setEditable(false);
        salidaText.setColumns(20);
        salidaText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        salidaText.setRows(5);
        jScrollPane3.setViewportView(salidaText);

        modoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        modoLabel.setForeground(new java.awt.Color(153, 153, 0));
        modoLabel.setText("Modo de Procesamiento: ");

        acceptButton.setBackground(new java.awt.Color(51, 204, 255));
        acceptButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        acceptButton.setForeground(new java.awt.Color(153, 153, 0));
        acceptButton.setText("Aceptar");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(51, 204, 255));
        cancelButton.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(153, 153, 0));
        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        algoritmoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        algoritmoLabel.setForeground(new java.awt.Color(153, 153, 0));
        algoritmoLabel.setText("Algoritmos de Codificación:");

        grupoModo.add(decoRadioB);
        decoRadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        decoRadioB.setText("Decodificación");

        grupoModo.add(codiRadioB);
        codiRadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        codiRadioB.setText("Codificación");
        codiRadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codiRadioBActionPerformed(evt);
            }
        });

        grupoImpresion.add(txtRadioB);
        txtRadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        txtRadioB.setText("TXT");
        txtRadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRadioBActionPerformed(evt);
            }
        });

        grupoImpresion.add(pdfRadioB);
        pdfRadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        pdfRadioB.setText("PDF");

        grupoImpresion.add(xmlRadioB);
        xmlRadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        xmlRadioB.setText("XML");

        vigeCheckBox.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        vigeCheckBox.setText("Vigénere");

        trasCheckBox.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        trasCheckBox.setText("Trasposición");

        telfCheckBox.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        telfCheckBox.setText("Código Telefónico");
        telfCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telfCheckBoxActionPerformed(evt);
            }
        });

        alfabetoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alfabetoLabel.setForeground(new java.awt.Color(153, 153, 0));
        alfabetoLabel.setText("Alfabeto:");

        alfabetoCombo.setBackground(new java.awt.Color(51, 204, 255));
        alfabetoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabetoComboActionPerformed(evt);
            }
        });

        binCheckBox.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        binCheckBox.setText("Codificación Binaria");
        binCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binCheckBoxActionPerformed(evt);
            }
        });

        claveCheckBox.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        claveCheckBox.setText("Palabra Clave");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(32, 32, 32)
                                    .addComponent(vigeCheckBox)
                                    .addGap(26, 26, 26)
                                    .addComponent(trasCheckBox)
                                    .addGap(26, 26, 26)
                                    .addComponent(telfCheckBox))
                                .addComponent(algoritmoLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(cancelButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(acceptButton)
                                        .addGap(25, 25, 25))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(formatoLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtRadioB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(pdfRadioB)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(xmlRadioB))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(modoLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(codiRadioB)
                                                .addGap(14, 14, 14)
                                                .addComponent(decoRadioB))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(alfabetoLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(binCheckBox)
                                                    .addComponent(alfabetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(claveCheckBox)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(TituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(entLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salidaLabel)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(salidaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(algoritmoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vigeCheckBox)
                    .addComponent(trasCheckBox)
                    .addComponent(telfCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(claveCheckBox)
                    .addComponent(binCheckBox))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alfabetoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alfabetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(decoRadioB)
                        .addComponent(codiRadioB)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(formatoLabel)
                    .addComponent(txtRadioB)
                    .addComponent(pdfRadioB)
                    .addComponent(xmlRadioB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton)
                    .addComponent(cancelButton))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if(!"".equals(entText.getText())){
            ejecutar();
        }else{
            JOptionPane.showMessageDialog(null,"El texto de entrada se encuentra vacío",
                    "Texto Vacío",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        inicioPrograma();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void codiRadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codiRadioBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codiRadioBActionPerformed

    private void txtRadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRadioBActionPerformed
        
    }//GEN-LAST:event_txtRadioBActionPerformed

    private void telfCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telfCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telfCheckBoxActionPerformed

    private void alfabetoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabetoComboActionPerformed
     
    }//GEN-LAST:event_alfabetoComboActionPerformed

    private void binCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_binCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JButton acceptButton;
    private javax.swing.JComboBox<String> alfabetoCombo;
    private javax.swing.JLabel alfabetoLabel;
    private javax.swing.JLabel algoritmoLabel;
    private javax.swing.JCheckBox binCheckBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JCheckBox claveCheckBox;
    private javax.swing.JRadioButton codiRadioB;
    public javax.swing.JRadioButton decoRadioB;
    private javax.swing.JLabel entLabel;
    private javax.swing.JTextArea entText;
    private javax.swing.JLabel formatoLabel;
    private javax.swing.ButtonGroup grupoImpresion;
    private javax.swing.ButtonGroup grupoModo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel modoLabel;
    private javax.swing.JRadioButton pdfRadioB;
    private javax.swing.JLabel salidaLabel;
    private javax.swing.JTextArea salidaText;
    private javax.swing.JCheckBox telfCheckBox;
    private javax.swing.JCheckBox trasCheckBox;
    private javax.swing.JRadioButton txtRadioB;
    private javax.swing.JCheckBox vigeCheckBox;
    private javax.swing.JRadioButton xmlRadioB;
    // End of variables declaration//GEN-END:variables
}
