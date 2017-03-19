/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import java.math.*; 
/**
 *
 * @author Juampa Monroy
 */
public class Buscador {
    private String regEx;
    private String validar;
    private ArrayList<String> lista=new ArrayList<>();
    
    private File seleccion;
    private String nombre, extension;
    long menor, mayor;
    public Buscador(File seleccion, String nombre, String extension, double menor, double mayor){
        this.seleccion=seleccion;
        this.nombre=nombre;
        this.extension=extension;
        this.menor= (long) Math.ceil(menor);
        this.mayor=(long)Math.ceil(mayor);
    }
    private void recorrer(File file) {
        lista= new ArrayList<>();
        File archivos[] = file.listFiles();
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].isDirectory()) {
                    recorrer(archivos[i]);
                } else {
                    lista.add(archivos[i].getAbsolutePath());
                }
            }
        }
    }
    public ArrayList<String> validos (File directorio){
        ArrayList<String> validos= new ArrayList<>();
        
        return validos;
    }
//    private boolean validar(String expReg, String cadena){
//        
//    }
//    String regex=".*"+busquedaField.getText()+".*";
//        String busqueda=jTextField1.getText();
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(busqueda);
//        //JOptionPane.showMessageDialog(null, matcher.find());
//        while (matcher.find()) {
//            System.out.println("Full match: " + matcher.group(0));
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("Group " + i + ": " + matcher.group(i));
//            }
//        }
}
