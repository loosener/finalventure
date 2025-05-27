package interfaz;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
public class Licencia extends JFrame implements ActionListener, ChangeListener {
    private JCheckBox check;
    private JButton button1,button2;
    private JTextArea twArea;
    private JScrollPane scrollPane;

    public Licencia(){
        setLayout(null);
        setTitle("TÉRMINOS Y CONDICIONES");
        getContentPane().setBackground(new Color(9,13,13));
        setIconImage(new ImageIcon(getClass().getResource("images/logo.png")).getImage());

        twArea = new JTextArea();
        twArea.setEditable(false);
        twArea.setBackground(new Color(254,254,254));
        twArea.setFont(new Font("Andale mono",3,10));
        twArea.setText("\n\n          TÉRMINOS Y CONDICIONES DE USO"+"\n\n          Final Venture"+"\n          Última actualización: 25-05-25"+"\n\n          Al descargar, instalar o jugar Final Venture, aceptas los siguientes términos. Si no estás de acuerdo, no deberías utilizar el juego."+"\n\n          1. LICENCIA DE USO"+"\n           Te otorgamos una licencia personal, no comercial, limitada y revocable para usar el juego."+"\n\n          2. USO ADECUADO"+"\n          No puedes modificar, hackear, vender, ni distribuir el juego o su contenido. Está prohibido el uso de trampas, bots o software externo."+"\n\n          3. COMPRAS Y CUENTAS"+"\n          Las compras dentro del juego son opcionales y no reembolsables. Eres responsable de la seguridad de tu cuenta."+"\n\n          4. PROPIEDAD INTELECTUAL"+"\n          Todo el contenido del juego es propiedad de [Yeison Montaño, Alejandro Guevara, Gabriel Clavijo]. No adquieres ningún derecho sobre él por usarlo."+"\n\n          5. RESPONSABILIDAD"+"\n          Final Venture se ofrece “tal cual”, sin garantías. No nos hacemos responsables por pérdidas de datos, errores o interrupciones."+"\n\n          6. CAMBIOS EN LOS TÉRMINOS"+"\n          Podemos modificar estos términos en cualquier momento. El uso continuado del juego implica aceptación de los cambios."+"\n\n          7. LEY APLICABLE"+"\n          Estos términos se rigen por las leyes de [Colombia].");
        add(twArea);

        scrollPane = new JScrollPane(twArea);
        scrollPane.setBounds(10,40,675,300);
        add(scrollPane);

        check = new JCheckBox("Yo acepto");
        check.setBounds(10,350,100,30);
        check.setBackground(new Color(9,13,13));
        check.setFont(new Font("andale mono",1,12));
        check.setForeground(new Color(196,141,33));
        check.addChangeListener(this);
        add(check);

        button1 = new JButton("Continuar");
        button1.setBounds(10,390,100,30);
        button1.setBackground(new Color(196,141,33));
        button1.setFont(new Font("andale monno", 1,14));
        button1.setForeground(new Color(9,13,13));
        button1.setEnabled(false);
        button1.addActionListener(this);
        add(button1);

        button2 = new JButton("No acepto");
        button2.setBounds(120,390,200,30);
        button2.setBackground(new Color(196,141,33));
        button2.setFont(new Font("andale mono", 1,14));
        button2.setForeground(new Color(9,13,13));
        button2.setEnabled(true);
        button2.addActionListener(this);
        add(button2);
    }

    public void stateChanged(ChangeEvent f){
        if (check.isSelected() == true) {
            button1.setEnabled(true);
            
        } else if (check.isSelected() == false) {
            button1.setEnabled(false);
            
        }
        

    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == button1) {
            PantallaPrincipal principal = new PantallaPrincipal();
            principal.setSize(800, 600);
            principal.setVisible(true);
            principal.setLocationRelativeTo(null);
            this.setVisible(false);

        } else if (e.getSource() == button2) {
            Bienvenida bienvenida = new Bienvenida();
            bienvenida.setBounds(0,0,1020,1080);
            bienvenida.setVisible(true);
            bienvenida.setResizable(false);
            bienvenida.setLocationRelativeTo(null);
            this.setVisible(false);

            
        }

    }

    public static void main(String args[]){
     Licencia ventanalicencia = new Licencia();
     ventanalicencia.setBounds(0,0,700,460);
     ventanalicencia.setVisible(true);
     ventanalicencia.setResizable(false);
     ventanalicencia.setLocationRelativeTo(null);
   }

    
}
