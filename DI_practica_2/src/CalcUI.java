import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Point;

public class CalcUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField input_uno;
	private JTextField input_dos;
	private JLabel final_result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalcUI frame = new CalcUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CalcUI() {
		setLocation(new Point(50, 0));
		setTitle("Calculadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 249, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_uno = new JLabel("Numero 1:");
		label_uno.setBounds(10, 24, 69, 14);
		contentPane.add(label_uno);
				
		input_uno = new JTextField();
		input_uno.setText("0.0");
		input_uno.setBounds(89, 21, 82, 20);
		contentPane.add(input_uno);
		input_uno.setColumns(7);
		
		JLabel label_dos = new JLabel("Numero 2:");
		label_dos.setBounds(10, 49, 69, 14);
		contentPane.add(label_dos);
		
		input_dos = new JTextField();
		input_dos.setText("0.0");
		input_dos.setBounds(89, 46, 82, 20);
		contentPane.add(input_dos);
		input_dos.setColumns(7);
		
		JButton sumar_btn = new JButton("Sumar");
		sumar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addition();
			}
		});
		sumar_btn.setBounds(10, 77, 98, 23);
		contentPane.add(sumar_btn);
		
		JButton restar_btn = new JButton("Restar");
		restar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtraction();
			}
		});
		restar_btn.setBounds(118, 77, 98, 23);
		contentPane.add(restar_btn);
		
		JButton multiplicar_btn = new JButton("Multiplicar");
		multiplicar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiplication();
			}
		});
		multiplicar_btn.setBounds(10, 111, 98, 23);
		contentPane.add(multiplicar_btn);
		
		JButton dividir_btn = new JButton("Dividir");
		dividir_btn.setBounds(118, 111, 98, 23);
		dividir_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				division();
			}
		});
		contentPane.add(dividir_btn);
		
		JButton raiz_btn = new JButton("Raiz 2");
		raiz_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqrt();				
			}
		});
		raiz_btn.setBounds(10, 145, 98, 23);
		contentPane.add(raiz_btn);
		
		JButton raiz_cubica_btn = new JButton("Raiz 3");
		raiz_cubica_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbrt();				
			}
		});
		raiz_cubica_btn.setBounds(118, 145, 98, 23);
		contentPane.add(raiz_cubica_btn);
		
		JLabel label_res = new JLabel("Resultado: ");
		label_res.setBounds(10, 179, 69, 14);
		contentPane.add(label_res);
		
		final_result = new JLabel();
		final_result.setBounds(91, 179, 82, 14);
		contentPane.add(final_result);
		
		// mandamos el foco a la entrada 1
		input_uno.requestFocus();
	}
	
	private Object getNumeroUno() {
		Object number = string2double(input_uno.getText(), "Numero 1 debe ser un numero reale. Se reseteará a 0");
		if(number == null) {
			input_uno.setText("0.0");
		}
		return number;
	}
	
	private Object getNumeroDos() {
		Object number = string2double(input_dos.getText(), "Numero 2 debe ser un numero reale. Se reseteará a 0");
		if(number == null) {
			input_dos.setText("0.0");
		}
		return number;
	}
	
	private Object string2double(String str, String warn_msg) {
		Object number = null;
		try {
			number = Double.parseDouble(str);
		}catch(NumberFormatException exp){  
			System.out.println(warn_msg);
		}
		if(number == null) {
			showWarnMessage(warn_msg);
			input_dos.setText("0.0");
		}
		return number;
	}
	
	private void showWarnMessage(String msg) {
		JOptionPane.showMessageDialog(null,msg,"¡Atencion!",JOptionPane.WARNING_MESSAGE);
	}
		
	private void addition() {
		Object num_a = getNumeroUno();
		Object num_b = getNumeroDos();		
		if(num_a != null && num_b != null) {
			final_result.setText(""+((double)num_a + (double)num_b));			
		}
	}
	
	private void subtraction() {
		Object num_a = getNumeroUno();
		Object num_b = getNumeroDos();		
		if(num_a != null && num_b != null) {
			final_result.setText(""+((double)num_a - (double)num_b));			
		}
	}
	
	private void multiplication() {
		Object num_a = getNumeroUno();
		Object num_b = getNumeroDos();		
		if(num_a != null && num_b != null) {
			final_result.setText(""+((double)num_a * (double)num_b));
		}
	}
	
	private void division() {
		Object num_a = getNumeroUno();
		Object num_b = getNumeroDos();	
		if(num_a != null && num_b != null) {
			if((double)num_b == 0) {
				System.out.println("No se puede dividir entre cero. Cambie el Numero 2");
				showWarnMessage("No se puede dividir entre cero. Cambie el Numero 2");
			}else if((double)num_a == 0) {
				final_result.setText("infinito");	
			}else {
				final_result.setText(""+((double)num_a / (double)num_b));
			}					
		}
	}

	private void sqrt() {
		JOptionPane.showMessageDialog(null,"funcion no disponible", "Raiz Cuadrada",JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void cbrt() {
		String password = JOptionPane.showInputDialog(null,"password");
		if(password.equals("0000")) {
			Object num_a = getNumeroUno();
			Object num_b = getNumeroDos();
			final_result.setText( Math.cbrt((double)num_a) +" | "+  Math.cbrt((double)num_b));
		}else {
			showWarnMessage("Contrasena incorrecta. No tienes acceso a la operacion");
		}
	}
}
