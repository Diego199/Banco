
package banco;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Cajero extends JFrame {

	private static final long serialVersionUID = 1583724102189855698L;

	JTextField pantalla;
        
        JTextField User;
        
        JTextField Password;
        
        String U;
        
        String P;
        
        Double Fondos;

	Double resultado;

	String operacion;

	JPanel panelNumeros, panelOperaciones , panelUser;

	boolean nuevaOperacion = true;

	public Cajero() {
		super();
		setSize(250, 300);
		setTitle("Cajero");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(false);

		JPanel panel = (JPanel) this.getContentPane();
		panel.setLayout(new BorderLayout());

		pantalla = new JTextField("0", 20);
		pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
		pantalla.setFont(new Font("Arial", Font.BOLD, 25));
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setEditable(false);
		pantalla.setBackground(Color.WHITE);
		panel.add("North", pantalla);

                User = new JTextField("0", 20);
		User.setBorder(new EmptyBorder(4, 4, 4, 4));
		User.setFont(new Font("Arial", Font.BOLD, 25));
		User.setHorizontalAlignment(JTextField.RIGHT);
		User.setEditable(false);
		User.setBackground(Color.WHITE);
		panel.add("North", User);
                
		panelNumeros = new JPanel();
		panelNumeros.setLayout(new GridLayout(4, 3));
		panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

		for (int n = 9; n >= 0; n--) {
			nuevoBotonNumerico("" + n);
		}

		nuevoBotonNumerico(".");

		panel.add("Center", panelNumeros);

		panelOperaciones = new JPanel();
		panelOperaciones.setLayout(new GridLayout(6, 1));
		panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

		nuevoBotonOperacion("Nueva Cuenta");
		nuevoBotonOperacion("Abonar");
		nuevoBotonOperacion("Retirar");
		nuevoBotonOperacion("Salir");

		panel.add("East", panelOperaciones);

		validate();
	}

	private void nuevoBotonNumerico(String digito) {
		JButton btn = new JButton();
		btn.setText(digito);
		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				numeroPulsado(btn.getText());
			}
		});

		panelNumeros.add(btn);
	}

	private void nuevoBotonOperacion(String operacion) {
		JButton btn = new JButton(operacion);
		btn.setForeground(Color.RED);

		btn.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent evt) {
				JButton btn = (JButton) evt.getSource();
				operacionPulsado(btn.getText());
			}
		});

		panelOperaciones.add(btn);
	}

	private void numeroPulsado(String digito) {
		if (pantalla.getText().equals("0") || nuevaOperacion) {
			pantalla.setText(digito);
		} else {
			pantalla.setText(pantalla.getText() + digito);
		}
		nuevaOperacion = false;
	}

	
	private void operacionPulsado(String tecla) {
		if (tecla.equals("Nueva Cuenta")) {
			User();
		} else if (tecla.equals("Abonar")) {
                    Meter();
			pantalla.setText("Abonado");
			nuevaOperacion = true;
		} else if (tecla.equals("Retirar")) {
			Sacar();
			pantalla.setText("Retirado");
			nuevaOperacion = true;
		} else if (tecla.equals("Salir")) {
			Salir();
		}

		nuevaOperacion = true;
	}

	
	private void User() {
            panelUser = new JPanel();
		panelUser.setLayout(new GridLayout(6, 1));
		panelUser.setBorder(new EmptyBorder(4, 4, 4, 4));
                    
                   User.setVisible(true);
                   Password.setVisible(true);
            
                   
            
	}
        private void Meter() {
                    
                        Fondos = 0.0;
			resultado = Fondos + new Double(pantalla.getText());
                    
                        pantalla.setText("Balance: " + resultado);
                        operacion = "";
	}
        private void Sacar() {
                        Fondos = 0.0;
			resultado = Fondos - new Double(pantalla.getText());
                    
                    pantalla.setText("Balance: " + resultado);
		operacion = "";
	}
         private void Salir() {
            
             }
             
	}

