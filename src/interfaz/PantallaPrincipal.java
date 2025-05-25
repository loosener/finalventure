package interfaz;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PantallaPrincipal extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JMenuItem menuItem1, menuItem2;
    private JLabel label1;
    private JButton button1, button2, button3;

    public PantallaPrincipal() {
        setTitle("FinalVenture");
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());
        menuBar = new JMenuBar();
        menuBar.setBackground(new Color(9, 13, 13));
        setJMenuBar(menuBar);

        menu1 = new JMenu("Configuración");
        menu1.setFont(new Font("andale mono", 3, 12));
        menu1.setForeground(new Color(196, 141, 33));
        menuBar.add(menu1);
        
        menu2 = new JMenu("Opcion de pantalla");
        menu1.add(menu2);
        
        
        menuItem1 = new JMenuItem(" 800*600");
        menuItem1.addActionListener(this);
        menu2.add(menuItem1);
        
        menuItem2 = new JMenuItem("1920*1080");
        menuItem2.addActionListener(this);
        menu2.add(menuItem2);
        
        JPanel panel = new JPanel() {
            Image Image = new ImageIcon("finalventure/recursos/Fondo.png").getImage();

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(Image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        setContentPane(panel);
        setLayout(null);

        button1 = new JButton("Nueva partida");
        button1.addActionListener(this);
        button1.setBackground(new Color(9, 13, 13));
        button1.setFont(new Font("Serif", 3, 14));
        button1.setForeground(new Color(196, 141, 33));
        button1.setBorder(BorderFactory.createLineBorder(new Color(196, 141, 33)));
        panel.add(button1);

        button2 = new JButton("Cargar partida");
        button2.addActionListener(this);
        button2.setBackground(new Color(9, 13, 13));
        button2.setFont(new Font("Serif", 3, 14));
        button2.setForeground(new Color(196, 141, 33));
        button2.setBorder(BorderFactory.createLineBorder(new Color(196, 141, 33)));
        panel.add(button2);

        button3 = new JButton("Salir");
        button3.addActionListener(this);
        button3.setBackground(new Color(9, 13, 13));
        button3.setFont(new Font("Serif", 3, 14));
        button3.setForeground(new Color(196, 141, 33));
        button3.setBorder(BorderFactory.createLineBorder(new Color(196, 141, 33)));
        panel.add(button3);

        label1 = new JLabel("©Version 0.9 - 2025");
        label1.setFont(new Font("Serif",3,14));
        label1.setForeground(new Color(196,141,33));
        panel.add(label1);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent c) {
                posicionarBotones();
            }
        });
        posicionarBotones();
    }

    private void posicionarBotones() {
        button1.setBounds(getWidth() - 170, getHeight() / 2 - 75, 150, 50);
        button2.setBounds(getWidth() - 170, getHeight() / 2 + 1, 150, 50);
        button3.setBounds(getWidth() - 170, getHeight() / 2 + 75, 150, 50);
        label1.setBounds(getWidth() / 2 - 50, getHeight() - 100, 200,30);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItem1) {
            setSize(800,600);
        } else if (e.getSource() == menuItem2) {
            setSize(1920,1080);
        } else if (e.getSource() == button1) {
            
        } else if (e.getSource() == button2) {
           
        } else if (e.getSource() == button3) {
            System.exit(0);
            
        }
    }

    public static void main(String[] args) {
        PantallaPrincipal principal = new PantallaPrincipal();
        principal.setSize(800, 600);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}