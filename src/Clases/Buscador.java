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
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author Juampa Monroy
 */
public class Buscador implements Runnable{
    private ArrayList<File> lista=new ArrayList<>();
    private File seleccion;
    private String nombre, extension, antes, despues, regEx;
    private long menor, mayor;
    private ArrayList<String> validos;
    private JProgressBar barra;
    private CustomListModel modelo;
    private JList list;
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
    public void variables(JProgressBar barra, JList lista){
        this.barra=barra;
        this.list=lista;
    }
    private void recorrer(File file) {
        
        File archivos[] = file.listFiles();
        if (archivos != null) {
            for (int i = 0; i < archivos.length; i++) {
                if (archivos[i].isDirectory()) {
                    recorrer(archivos[i]);
                } else {
                    lista.add(archivos[i]);
                }
            }
        }
    }
    public ArrayList<String> validos () throws Excep{
        return validos;
    }
    public void excepciones(String msj) throws Excep{
        throw new Excep(msj);
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

    @Override
    public void run(){
        validos= new ArrayList<>();
        regEx=".*";
        if((!nombre.equals(""))&&(!extension.equals(""))){
            regEx=antes+".*"+nombre+".*"+despues+"\\."+extension;
        }else if((!nombre.equals(""))&&(extension.equals(""))){
            regEx=antes+".*"+nombre+".*"+despues;
        }else if((nombre.equals(""))&&(!extension.equals(""))){
            regEx=antes+".*"+despues+"\\."+extension;
        }
        Pattern patron=Pattern.compile(regEx);
        Matcher validar;
        if(seleccion.isDirectory()){
            lista= new ArrayList<>();
            recorrer(seleccion);
            if(barra!=null){
                barra.setMinimum(0);
                barra.setMaximum(lista.size());
            }
            modelo=new CustomListModel();
            //modelo.setModel(validos);
            list.setModel(modelo);
            for (int i = 0; i < lista.size(); i++) {
                File temp=lista.get(i);
                validar=patron.matcher(temp.getName());
                if(mayor!=0&&menor!=0){
                    if(mayor>=menor){
                        if(validar.matches()){
                            long tam=temp.length();
                            if(tam<=mayor&&tam>=menor){
                                validos.add(temp.getAbsolutePath().substring(1+(int)seleccion.getAbsolutePath().length()));
                                modelo.add(validos.get(validos.size()-1));
                            }
                        }
                    }else{
                        try {
                            excepciones("Los rangos de búsqueda por tamaño de archivo no son válidos");
                            break;
                        } catch (Excep ex) {
                            Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else if(mayor==0&&menor!=0){
                    try {
                        excepciones("Los rangos de búsqueda por tamaño de archivo no son válidos");
                        break;
                    } catch (Excep ex) {
                        Logger.getLogger(Buscador.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                else{
                    if(validar.matches()){
                        validos.add(temp.getAbsolutePath().substring(1+(int)seleccion.getAbsolutePath().length()));
                        modelo.add(validos.get(validos.size()-1));
                    }
                }
                if(barra!=null)
                    barra.setValue(i);
//                if(validos.size()!=0)
//                    modelo.add(validos.get(validos.size()-1));
//                else
//                    modelo.add("Sin resultados");
                
                
            }
        }else{
            validar=patron.matcher(seleccion.getName());
            if(mayor!=0){
                    if(mayor>menor){
                        if(validar.matches()){
                            long tam=seleccion.length();
                            if(tam<=mayor&&tam>=menor){
                                validos.add(seleccion.getAbsolutePath().substring(1+(int)seleccion.getAbsolutePath().length()));
                                modelo.add(validos.get(validos.size()-1));
                            }
                        }
                    }
            }
            else{
                if(validar.matches()){
                    validos.add(seleccion.getAbsolutePath().substring((int)seleccion.getAbsolutePath().length()));
                    modelo.add(validos.get(validos.size()-1));
                }
            }
        }
    }
}
