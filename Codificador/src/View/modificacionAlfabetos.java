/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author mcv26
 */
public class modificacionAlfabetos extends javax.swing.JFrame {

    /**
     * Creates new form modificacionAlfabetos
     */
    public modificacionAlfabetos() {
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

        tituloLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        alfabetoLabel = new javax.swing.JLabel();
        alfabetoText = new javax.swing.JTextField();
        atrasBtn = new javax.swing.JButton();
        eliminarBtn1 = new javax.swing.JButton();
        nombreText = new javax.swing.JTextField();
        nomLabel = new javax.swing.JLabel();
        estadoLabel = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        modificarBtn = new javax.swing.JButton();

        tituloLabel.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        tituloLabel.setForeground(new java.awt.Color(243, 126, 11));
        tituloLabel.setText("Modificar/Eliminar un Nuevo Alfabeto");

        idLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(153, 153, 0));
        idLabel.setText("Identificador");

        jComboBox1.setBackground(new java.awt.Color(51, 204, 255));
        jComboBox1.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(153, 153, 0));
        jComboBox1.setMaximumRowCount(100);

        alfabetoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alfabetoLabel.setForeground(new java.awt.Color(153, 153, 0));
        alfabetoLabel.setText("Alfabeto");

        alfabetoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alfabetoTextActionPerformed(evt);
            }
        });

        atrasBtn.setBackground(new java.awt.Color(51, 204, 255));
        atrasBtn.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        atrasBtn.setForeground(new java.awt.Color(153, 153, 0));
        atrasBtn.setText("Atrás");

        eliminarBtn1.setBackground(new java.awt.Color(51, 204, 255));
        eliminarBtn1.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        eliminarBtn1.setForeground(new java.awt.Color(153, 153, 0));
        eliminarBtn1.setText("Eliminar");

        nomLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nomLabel.setForeground(new java.awt.Color(153, 153, 0));
        nomLabel.setText("Nombre");

        estadoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        estadoLabel.setForeground(new java.awt.Color(153, 153, 0));
        estadoLabel.setText("Estado");

        comboEstado.setBackground(new java.awt.Color(51, 204, 255));
        comboEstado.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        comboEstado.setForeground(new java.awt.Color(153, 153, 0));
        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activado", "Desactivado" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        modificarBtn.setBackground(new java.awt.Color(51, 204, 255));
        modificarBtn.setFont(new java.awt.Font("Trajan Pro", 2, 18)); // NOI18N
        modificarBtn.setForeground(new java.awt.Color(153, 153, 0));
        modificarBtn.setText("Modificar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(alfabetoText)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alfabetoLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(idLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nomLabel)
                                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(estadoLabel)
                                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(tituloLabel)
                        .addGap(0, 17, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(atrasBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarBtn1)
                .addGap(36, 36, 36)
                .addComponent(modificarBtn)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel)
                    .addComponent(nomLabel)
                    .addComponent(estadoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboEstado, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(alfabetoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(alfabetoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atrasBtn)
                    .addComponent(eliminarBtn1)
                    .addComponent(modificarBtn))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alfabetoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alfabetoTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alfabetoTextActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboEstadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alfabetoLabel;
    private javax.swing.JTextField alfabetoText;
    private javax.swing.JButton atrasBtn;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JButton eliminarBtn1;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JLabel idLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton modificarBtn;
    private javax.swing.JLabel nomLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}
