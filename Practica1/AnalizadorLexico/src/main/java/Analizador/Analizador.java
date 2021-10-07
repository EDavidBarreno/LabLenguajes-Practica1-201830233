package Analizador;

import Login.Login;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Analizador extends javax.swing.JFrame {
    Tokens analisisLexico;
    AnalisisLexico modelo = null;

    private JPanel panelAnalizador;
    private JButton buttonRegresar;
    private JButton buttonCargarArchivo;
    private JButton buttonAnalizar;
    private JTextArea textAreaMostrarDatos;
    private JButton guardarButton;
    private JButton buttonLimpiarTexto;
    private JTable tableMostrarTokens;


    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;

    public String AbirArchivo(File archivo){
        String documento="";
        try {
            entrada = new FileInputStream(archivo);
            int ascci;
            while((ascci = entrada.read()) !=-1){
                char caracter = (char)ascci;
                documento+=caracter;
            }
        }catch (Exception e){
        }
        return documento;
    }


    public String GuardarArchivo(File archivo, String documento){
        String mensaje=null;
        try {
            salida=new FileOutputStream(archivo);
            byte[] bytxt=documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo Guardado";
        }catch (Exception e){
        }
        return mensaje;
    }


    public Analizador(){
        analisisLexico = new Tokens();
        modelo = new AnalisisLexico(analisisLexico.getToken1(), analisisLexico.getLexema1());

        add(panelAnalizador);
        setTitle("Analizador Léxico");
        setExtendedState(MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        buttonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.show();
                dispose();
            }
        });
        buttonCargarArchivo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seleccionar.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION){
                    archivo=seleccionar.getSelectedFile();
                    if(archivo.canRead()){
                        if(archivo.getName().endsWith("txt")){
                            String documento=AbirArchivo(archivo);
                            textAreaMostrarDatos.setText(documento);
                            JOptionPane.showMessageDialog(null,"Se cargo el archivo correctamente."
                                    , "Carga correcta", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null, "Archivo no compatible.", "Carga incorrecta", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seleccionar.showDialog(null, "Guardar")==JFileChooser.APPROVE_OPTION){
                    archivo=seleccionar.getSelectedFile();
                    if(archivo.getName().endsWith("txt")){
                        String Documento=textAreaMostrarDatos.getText();
                        String mensaje=GuardarArchivo(archivo, Documento);
                        if(mensaje !=null){
                            JOptionPane.showMessageDialog(null, mensaje);
                        }else {
                            JOptionPane.showMessageDialog(null, "Archivo no compatible");
                        }
                    }else JOptionPane.showMessageDialog(null, "Guardar documento de Texto");
                }
            }
        });

        buttonLimpiarTexto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMostrarDatos.setText("");
                JOptionPane.showMessageDialog(null, "Se limpio correctamente el área de texto.", "Limpiar",JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buttonAnalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                analisisLexico.Inicia();
                analisisLexico.AnalisisAutomata(textAreaMostrarDatos.getText());
                modelo = new AnalisisLexico(analisisLexico.getToken1(), analisisLexico.getLexema1());
                tableMostrarTokens.setModel(modelo);
            }
        });
    }
}
