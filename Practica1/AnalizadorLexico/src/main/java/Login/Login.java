package Login;

import Analizador.Analizador;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel panelLogin;
    private JButton ButtonSalir;
    private JButton ButtonSoporte;
    private JButton ButtonAnalizador;

    public Login(){
        add(panelLogin);
        setTitle("Inicio");
        setExtendedState(MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        ButtonSoporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Hecho por:\nEstuardo David Barreno Nimatuj\n201830233"
                        , "Soporte técnico", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ButtonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ButtonAnalizador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Analizador analizador = new Analizador();
                analizador.show();
                dispose();
            }
        });
    }
}
