/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import Excepciones.Excep;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
/**
 *
 * @author Juampa Monroy
 */
public class Ventana1 extends javax.swing.JFrame {
    private File seleccion;
    private Buscador buscar;
    private ArrayList<String> validos= new ArrayList<>();
    private CustomListModel modelo =new CustomListModel();
    /**
     * Creates new form Ventana1
     */
    public Ventana1() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreField = new javax.swing.JTextField();
        seleccionCarpetaButton = new javax.swing.JButton();
        buscarButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        extensionField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        unidadCombo2 = new javax.swing.JComboBox<>();
        unidadCombo1 = new javax.swing.JComboBox<>();
        tamSpinner1 = new javax.swing.JSpinner();
        tamSpinner2 = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        carpetaField = new javax.swing.JTextField();
        regExButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        abrirButton = new javax.swing.JButton();
        carpetaContButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buscador de Archivos");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterio de Búsqueda"));

        jLabel1.setText("El Nombre Contiene");

        nombreField.setNextFocusableComponent(extensionField);
        nombreField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nombreFieldKeyReleased(evt);
            }
        });

        seleccionCarpetaButton.setText("Seleccionar");
        seleccionCarpetaButton.setNextFocusableComponent(nombreField);
        seleccionCarpetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionCarpetaButtonActionPerformed(evt);
            }
        });

        buscarButton.setText("Volver a Buscar");
        buscarButton.setNextFocusableComponent(regExButton);
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Extensión:");

        extensionField.setNextFocusableComponent(tamSpinner1);
        extensionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                extensionFieldKeyReleased(evt);
            }
        });

        jLabel4.setText("Tamaño entre:");

        jLabel5.setText("y");

        unidadCombo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KiB", "MiB", "GiB" }));
        unidadCombo2.setNextFocusableComponent(buscarButton);

        unidadCombo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KiB", "MiB", "GiB" }));
        unidadCombo1.setNextFocusableComponent(tamSpinner2);

        tamSpinner1.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.01d));
        tamSpinner1.setToolTipText("");
        tamSpinner1.setNextFocusableComponent(unidadCombo1);
        tamSpinner1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tamSpinner1StateChanged(evt);
            }
        });

        tamSpinner2.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 0.01d));
        tamSpinner2.setNextFocusableComponent(unidadCombo2);
        tamSpinner2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tamSpinner2StateChanged(evt);
            }
        });

        jLabel2.setText("Carpeta:");

        carpetaField.setNextFocusableComponent(seleccionCarpetaButton);

        regExButton.setText("Mostrar Expresión Regular");
        regExButton.setNextFocusableComponent(carpetaField);
        regExButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regExButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carpetaField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seleccionCarpetaButton))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreField))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unidadCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tamSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(unidadCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 262, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(extensionField, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(buscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(regExButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seleccionCarpetaButton)
                    .addComponent(carpetaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nombreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(extensionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(unidadCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tamSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tamSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(unidadCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscarButton)
                    .addComponent(regExButton)))
        );

        lista.setNextFocusableComponent(abrirButton);
        jScrollPane3.setViewportView(lista);

        abrirButton.setText("Abrir");
        abrirButton.setNextFocusableComponent(carpetaContButton);
        abrirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirButtonActionPerformed(evt);
            }
        });

        carpetaContButton.setText("Ver carpeta contenedora");
        carpetaContButton.setNextFocusableComponent(lista);
        carpetaContButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carpetaContButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(abrirButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carpetaContButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(abrirButton)
                    .addComponent(carpetaContButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void seleccionCarpetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionCarpetaButtonActionPerformed
        JFileChooser carpeta= new JFileChooser();
        carpeta.setDialogType(JFileChooser.OPEN_DIALOG);
        carpeta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int opcion = carpeta.showOpenDialog(null);
        if(opcion==JFileChooser.APPROVE_OPTION){
            seleccion=carpeta.getSelectedFile();
            if(seleccion.exists()&&seleccion.isDirectory())
                carpetaField.setText(seleccion.toString());
        }
    }//GEN-LAST:event_seleccionCarpetaButtonActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        busqueda();
    }//GEN-LAST:event_buscarButtonActionPerformed

    private void nombreFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreFieldKeyReleased
//        int tecla=evt.getKeyCode();
//        if(tecla==10){
            busqueda();
//        }
    }//GEN-LAST:event_nombreFieldKeyReleased

    private void extensionFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_extensionFieldKeyReleased
//        int tecla=evt.getKeyCode();
//        if(tecla==10){
            busqueda();
//        }
    }//GEN-LAST:event_extensionFieldKeyReleased

    private void tamSpinner1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tamSpinner1StateChanged
        busqueda();
    }//GEN-LAST:event_tamSpinner1StateChanged

    private void tamSpinner2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tamSpinner2StateChanged
        busqueda();
    }//GEN-LAST:event_tamSpinner2StateChanged

    private void regExButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regExButtonActionPerformed
        JOptionPane.showMessageDialog(null, buscar.getRegEx(),"Expresión Regular",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_regExButtonActionPerformed

    private void abrirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirButtonActionPerformed
        if(lista.getSelectedIndex()!=-1){
            try {
                File archivo = new File(seleccion.getAbsolutePath()+File.separatorChar+lista.getSelectedValue());
                if(archivo.exists())
                    Desktop.getDesktop().open(archivo);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_abrirButtonActionPerformed

    private void carpetaContButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carpetaContButtonActionPerformed
        if(lista.getSelectedIndex()!=-1){
            try {
                File archivo = new File(seleccion.getAbsolutePath()+File.separatorChar+lista.getSelectedValue());
                if(archivo.exists()){
                    String ruta=archivo.getAbsolutePath().substring(0, archivo.getAbsolutePath().length()-archivo.getName().length());
                    Desktop.getDesktop().open(new File(ruta));
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_carpetaContButtonActionPerformed
    private void busqueda (){
       seleccion=new File(carpetaField.getText());
       if(seleccion.exists()){
           try {
               String nombre=nombreField.getText().trim();
               String extension= extensionField.getText().trim();
               double menor=((double)(tamSpinner1.getValue()))*pow(1024.00,unidadCombo1.getSelectedIndex()+1);
               double mayor=((double)(tamSpinner2.getValue()))*pow(1024.00,unidadCombo2.getSelectedIndex()+1);
               buscar = new Buscador(seleccion,nombre,extension,menor, mayor);
               validos=buscar.validos();
               modelo=new CustomListModel();
               for (int i = 0; i < validos.size(); i++) {
                   modelo.add(validos.get(i));
               }
               lista.setModel(modelo);
           } catch (Excep ex) {
               JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
           }
       }
    }
    
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
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.JButton carpetaContButton;
    private javax.swing.JTextField carpetaField;
    private javax.swing.JTextField extensionField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> lista;
    private javax.swing.JTextField nombreField;
    private javax.swing.JButton regExButton;
    private javax.swing.JButton seleccionCarpetaButton;
    private javax.swing.JSpinner tamSpinner1;
    private javax.swing.JSpinner tamSpinner2;
    private javax.swing.JComboBox<String> unidadCombo1;
    private javax.swing.JComboBox<String> unidadCombo2;
    // End of variables declaration//GEN-END:variables
}
