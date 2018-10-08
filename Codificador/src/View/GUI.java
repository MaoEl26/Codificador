/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import Model.*;
import Controller.DTOAlgoritmos;
import Controller.DaoAlfabetos;
import Controller.DTOFrase;
import Controller.OBJComunicacion;
import Cliente.Cliente;
import Controller.AccionesServidor;
import Controller.Controlador;
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
    ArrayList<Algoritmo> listaAlgoritmos = new ArrayList<>();
    
    int alfabeto;
    int tipoFrase;
    int longFrase;
    boolean modoCodificacion = true;
    String frase = "";
    ArrayList<String> tipoSalida = null;
    String salida="";
    ArrayList<String> listaSalidas = new ArrayList<>();
    DTOAlgoritmos dtoAlgoritmos;
    DTOFrase dtoFrase;
    
    
    //limpia todas las variables a cero
    private void limpiarVariables(){
        alfabeto = 0;
        tipoFrase = 0;
        longFrase = 0;
        modoCodificacion = true;
        frase = entText.getText();
        tipoSalida = new ArrayList <>();
        salida = "";
//        listaAlgoritmos = new ArrayList<>();
//        listaSalidas = new ArrayList<>();
        dtoAlgoritmos = null;
        dtoFrase = null;
        longFraseText.setEnabled(false);
    }
    
    //setea todos los valores de la interfaz a las variables
    private void setearVariables(){
        if(codiRadioB.isSelected()){
            modoCodificacion = true;
        }
        if(decoRadioB.isSelected()){
            modoCodificacion = false;
        }
        /*
        Agregar metodo para usar las salidas enviadas por el administrador
        */
        alfabeto = alfabetoCombo.getSelectedIndex()+1;
        
        dtoAlgoritmos = new DTOAlgoritmos(alfabeto, frase, 
                listaAlgoritmos, listaSalidas, modoCodificacion, tipoSalida);

        if(longFraseText.isEnabled()){
            longFrase = Integer.parseInt(longFraseText.getText());
        }else{
            longFrase = 0;
        }
        dtoFrase = new DTOFrase(frase,longFrase,tipoFrase);
    }
    
    private void ejecutar(){
        
        //llamar estos 2 metodos para iniciar las variables
        limpiarVariables();
        setearVariables();
        
        OBJComunicacion objeto = new OBJComunicacion(dtoAlgoritmos, dtoFrase, 
                AccionesServidor.PROCESAR_PETICION_CODIFICAR);
        
        Cliente c = new Cliente();
        
        try {
            objeto = c.conecteServidor(objeto);
            dtoAlgoritmos = objeto.getDtoAlgoritmo();
        } catch (Exception e) {
            System.out.println("Error al recibir respuesta del servidor");
        }
        
        for (int i = 0; i < dtoAlgoritmos.getListaSalidas().size(); i++) {
            salida += dtoAlgoritmos.getListaSalidas().get(i)+"\n";
        }

        salidaText.setText(salida);
        
    }
    
    public void listaAlfabetos(){
        ArrayList<Alfabeto> lista = daoAlfabetos.getListaAlfabetos();
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).isEstado()){
                alfabetoCombo.addItem(lista.get(i).getNombreAlfabeto());
            }           
        }
    }
    
    private void obtenerAlgoritmosHabilitados(){
        
//        limpiarVariables();
//        setearVariables();
//        
        OBJComunicacion objeto = new OBJComunicacion( 
                AccionesServidor.OBTENER_ALGORITMOS);
        
        Cliente c = new Cliente();
        
        try {
            objeto = c.conecteServidor(objeto);
            listaAlgoritmos = (ArrayList<Algoritmo>) objeto.getDatoSalida();
        } catch (Exception e) {
            System.out.println("Error al recibir respuesta del servidor");
        }
//        for (Algoritmo ar : listaAlgoritmos) System.out.println(ar.getClass().getName());
        
    }
    
    public void inicioDao(DaoAlfabetos daoAlfabetos){
        this.daoAlfabetos = daoAlfabetos;
    }
   
    public void validaAlgoritmos(){
    }
    
    private void inicioPrograma(){
        validaAlgoritmos();
        codiRadioB.setSelected(true);
        fraseRadioB.setSelected(true);
        entText.setText("");
        salidaText.setText("");
   }
    
    public void start(){
       initComponents();
       listaAlfabetos();
       inicioPrograma();
    }
    
    public GUI() {

    }
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
        fraseRadioB = new javax.swing.JRadioButton();
        met1RadioB = new javax.swing.JRadioButton();
        met2RadioB = new javax.swing.JRadioButton();
        alfabetoLabel = new javax.swing.JLabel();
        alfabetoCombo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldAlgoritmos = new javax.swing.JList<>();
        guardarAlgoritmos = new javax.swing.JButton();
        met3RadioB = new javax.swing.JRadioButton();
        longFraseText = new javax.swing.JTextField();
        formatoLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

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
        formatoLabel.setText("Formato Frase Ingresada");

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

        grupoImpresion.add(fraseRadioB);
        fraseRadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        fraseRadioB.setText("Frase original");
        fraseRadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fraseRadioBActionPerformed(evt);
            }
        });

        grupoImpresion.add(met1RadioB);
        met1RadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        met1RadioB.setText("Sin Consecutivos y Duplicados");
        met1RadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                met1RadioBActionPerformed(evt);
            }
        });

        grupoImpresion.add(met2RadioB);
        met2RadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        met2RadioB.setText("Sin Consecutivos");
        met2RadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                met2RadioBActionPerformed(evt);
            }
        });

        alfabetoLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alfabetoLabel.setForeground(new java.awt.Color(153, 153, 0));
        alfabetoLabel.setText("Alfabeto:");

        alfabetoCombo.setBackground(new java.awt.Color(51, 204, 255));

        fieldAlgoritmos.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        jScrollPane2.setViewportView(fieldAlgoritmos);

        guardarAlgoritmos.setBackground(new java.awt.Color(54, 205, 255));
        guardarAlgoritmos.setFont(new java.awt.Font("Trajan Pro", 2, 14)); // NOI18N
        guardarAlgoritmos.setForeground(new java.awt.Color(153, 153, 0));
        guardarAlgoritmos.setText("Guardar Selección");
        guardarAlgoritmos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarAlgoritmosActionPerformed(evt);
            }
        });

        grupoImpresion.add(met3RadioB);
        met3RadioB.setFont(new java.awt.Font("Trajan Pro", 3, 12)); // NOI18N
        met3RadioB.setText("Con consecutivos y Duplicados");
        met3RadioB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                met3RadioBActionPerformed(evt);
            }
        });

        longFraseText.setFont(new java.awt.Font("Trajan Pro", 2, 12)); // NOI18N

        formatoLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        formatoLabel1.setForeground(new java.awt.Color(153, 153, 0));
        formatoLabel1.setText("Longitud Frase:");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acceptButton)
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(TituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(entLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salidaLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(algoritmoLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(alfabetoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alfabetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(formatoLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(longFraseText, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(guardarAlgoritmos))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jButton1))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(formatoLabel)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(modoLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(codiRadioB)
                                    .addGap(14, 14, 14)
                                    .addComponent(decoRadioB))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fraseRadioB)
                                        .addComponent(met2RadioB))
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(met3RadioB)
                                        .addComponent(met1RadioB)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(entLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salidaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(algoritmoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardarAlgoritmos)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alfabetoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(alfabetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formatoLabel1)
                    .addComponent(longFraseText, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formatoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(met1RadioB)
                    .addComponent(fraseRadioB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(met2RadioB, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(met3RadioB, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(modoLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(decoRadioB)
                        .addComponent(codiRadioB)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(acceptButton)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cancelButton)
                        .addContainerGap())))
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

    private void guardarAlgoritmosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarAlgoritmosActionPerformed
        listaAlgoritmos = (ArrayList)fieldAlgoritmos.getSelectedValuesList();
    }//GEN-LAST:event_guardarAlgoritmosActionPerformed

    private void met1RadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_met1RadioBActionPerformed
        tipoFrase = 1;
        longFraseText.setEnabled(true);
    }//GEN-LAST:event_met1RadioBActionPerformed

    private void met2RadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_met2RadioBActionPerformed
        tipoFrase = 2;
        longFraseText.setEnabled(true);
    }//GEN-LAST:event_met2RadioBActionPerformed

    private void met3RadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_met3RadioBActionPerformed
        tipoFrase = 3;
        longFraseText.setEnabled(true);
    }//GEN-LAST:event_met3RadioBActionPerformed

    private void fraseRadioBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fraseRadioBActionPerformed
        tipoFrase = 4;
        longFraseText.setEnabled(false);
    }//GEN-LAST:event_fraseRadioBActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        obtenerAlgoritmosHabilitados();
        Controlador controlador = new Controlador();
        listaAlgoritmos = controlador.obtenerAlgoritmos();
        tipoSalida = controlador.obtenerTipoSalida();
        ejecutar();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TituloLabel;
    private javax.swing.JButton acceptButton;
    private javax.swing.JComboBox<String> alfabetoCombo;
    private javax.swing.JLabel alfabetoLabel;
    private javax.swing.JLabel algoritmoLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JRadioButton codiRadioB;
    public javax.swing.JRadioButton decoRadioB;
    private javax.swing.JLabel entLabel;
    private javax.swing.JTextArea entText;
    private javax.swing.JList<String> fieldAlgoritmos;
    private javax.swing.JLabel formatoLabel;
    private javax.swing.JLabel formatoLabel1;
    private javax.swing.JRadioButton fraseRadioB;
    private javax.swing.ButtonGroup grupoImpresion;
    private javax.swing.ButtonGroup grupoModo;
    private javax.swing.JButton guardarAlgoritmos;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField longFraseText;
    private javax.swing.JRadioButton met1RadioB;
    private javax.swing.JRadioButton met2RadioB;
    private javax.swing.JRadioButton met3RadioB;
    private javax.swing.JLabel modoLabel;
    private javax.swing.JLabel salidaLabel;
    private javax.swing.JTextArea salidaText;
    // End of variables declaration//GEN-END:variables
}
