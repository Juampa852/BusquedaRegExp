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
import Excepciones.*;
import javax.swing.JProgressBar;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author Juampa Monroy
 */
public class Buscador{
    private ArrayList<File> lista=new ArrayList<>();
    private File seleccion;
    private String nombre, extension, antes, despues, regEx="";
    private long menor, mayor;
    public Buscador(File seleccion, String nombre, String extension, String antes, String despues, double menor, double mayor) throws Excep{
        if(seleccion.exists()){
            this.seleccion=seleccion;
            this.nombre=nombre;
            this.extension=extension;
            this.antes=antes;
            this.despues=despues;
            this.menor= (long)Math.ceil(menor);
            this.mayor=(long)Math.ceil(mayor);
        }else
            throw new Excep("Este directorio o archivo no existe");
    }
    private void recorrer(File file) {
        
        File archivos[] = file.listFiles();
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                try{
                    if (archivos[i].isDirectory()) {
                        recorrer(archivos[i]);
                    } else {
                        lista.add(archivos[i]);
                    }
                }catch(Exception ex){
                    
                }
            }
        }
    }
    public ArrayList<String> validos () throws Excep{
        ArrayList<String> validos= new ArrayList<>();
        regEx=".*";
        if((!nombre.equals(""))&&(!extension.equals(""))){
            regEx=".*"+nombre+".*\\."+extension;
        }else if((!nombre.equals(""))&&(extension.equals(""))){
            regEx=".*"+nombre+".*";
        }else if((nombre.equals(""))&&(!extension.equals(""))){
            regEx=".*\\."+extension;
        }
        Pattern patron=Pattern.compile(regEx);
        Matcher validar;
        if(seleccion.isDirectory()){
            lista= new ArrayList<>();
            recorrer(seleccion);
            for (int i = 0; i < lista.size(); i++) {
                File temp=lista.get(i);
                validar=patron.matcher(temp.getName());
                if(mayor!=0&&menor!=0){
                    if(mayor>=menor){
                        if(validar.matches()){
                            long tam=temp.length();
                            if(tam<=mayor&&tam>=menor)
                                validos.add(temp.getAbsolutePath().substring(1+(int)seleccion.getAbsolutePath().length()));
                        }
                    }else
                        throw new Excep("Los rangos de búsqueda por tamaño de archivo no son válidos");
                }
                else if(mayor==0&&menor!=0)
                    throw new Excep("Los rangos de búsqueda por tamaño de archivo no son válidos");
                else{
                    if(validar.matches())
                        validos.add(temp.getAbsolutePath().substring(1+(int)seleccion.getAbsolutePath().length()));
                }
                
            }
        }else{
            validar=patron.matcher(seleccion.getName());
            if(mayor!=0){
                    if(mayor>menor){
                        if(validar.matches()){
                            long tam=seleccion.length();
                            if(tam<=mayor&&tam>=menor)
                                validos.add(seleccion.getAbsolutePath().substring(1+(int)seleccion.getAbsolutePath().length()));
                        }
                    }
            }
            else{
                if(validar.matches())
                    validos.add(seleccion.getAbsolutePath().substring((int)seleccion.getAbsolutePath().length()));
            }
        }
        return validos;
    }
   
    public File getSeleccion() {
        return seleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExtension() {
        return extension;
    }

    public String getRegEx() {
        return regEx;
    }

    public long getMenor() {
        return menor;
    }

    public long getMayor() {
        return mayor;
    }
}
