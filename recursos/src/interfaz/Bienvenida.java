package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Bienvenida extends JFrame implements ActionListener{
    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JMenuItem menuItem1, menuItem2, menuItem3;
    private JLabel label1, label2, label3, label4;
    private JButton button1;
    private JTextField texField;
    public static String texto = "";

    public Bienvenida(){
        setLayout(null);
        setTitle("Final Venture");
        getContentPane().setBackground(new Color(9,13,13));
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu1 = new JMenu("Opciones");
        menu1.setFont(new Font("Serif",3,12));
        menu1.setForeground(new Color(196,141,33));
        menuBar.add(menu1);
       
        menu2 = new JMenu("Tema");
        menu1.add(menu2);

        menuItem3 = new JMenuItem("Salir");
        menu1.add(menuItem3);
        menuItem3.addActionListener(this);
       
        menuItem1 = new JMenuItem("Claro");
        menu2.add(menuItem1);
        menuItem1.addActionListener(this);

        menuItem2 = new JMenuItem("Oscuro");
        menu2.add(menuItem2);
        menuItem2.addActionListener(this);

        ImageIcon imagen = new ImageIcon("finalventure/recursos/Finalventureimg.png");
        label1 = new JLabel(imagen);
        label1.setBounds(25,45,850,80);
        add(label1);

        label2 = new JLabel("Bienvenidos a ");
        label2.setBounds(35, 15,300,30);
        label2.setFont(new Font("Serif", 2,16));
        label2.setForeground(new Color(196, 141,33));
        add(label2);

        label3 = new JLabel("Ingresa tu nombre de usuario: ");
        label3.setBounds(410, 212,200,14);
        label3.setFont(new Font("Serif", 1,12));
        label3.setForeground(new Color(196,141,33));
        add(label3);

        label4 = new JLabel("©Version 0.9 - 2025 ");
        label4.setBounds(490, 550,300,12);
        label4.setFont(new Font("Serif", 1,12));
        label4.setForeground(new Color(196,141,33));
        add(label4);

        texField = new JTextField();
        texField.setBounds(410,240,255,25);
        texField.setBackground(new Color(224,224,224));
        texField.setFont(new Font("andale mono", 1,14));
        texField.setForeground(new Color(196,141,33));
        add(texField);

        button1 = new JButton("Ingresar");
        button1.setBounds(490,280,100,30);
        button1.setBackground(new Color(196,141,33));
        button1.setFont(new Font("Serif", 1,14));
        button1.addActionListener(this);
        add(button1);
       
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()  == menuItem1) {
            getContentPane().setBackground(new Color(255,255,255));
            
        } else if (e.getSource() == menuItem2) {
            getContentPane().setBackground(new Color(9,13,13));
            
        } else if (e.getSource() == menuItem3) {
            System.exit(0);
            
        } else if (e.getSource() == button1) {
            texto = texField.getText();
            if (texto.equals("")) {
                JOptionPane.showMessageDialog(null, "Debes ingresar tú nombre");

            } else{
                Licencia ventanalicencia = new Licencia();
                ventanalicencia.setBounds(0,0,700,460);
                ventanalicencia.setVisible(true);
                ventanalicencia.setResizable(false);
                ventanalicencia.setLocationRelativeTo(null);
                this.setVisible(false);

            }
            
        }
    }

    public static void main(String[] args) {
        Bienvenida bienvenida = new Bienvenida();
        bienvenida.setBounds(0,0,1020,1080);
        bienvenida.setVisible(true);
        bienvenida.setResizable(false);
        bienvenida.setLocationRelativeTo(null);
    }
    
}