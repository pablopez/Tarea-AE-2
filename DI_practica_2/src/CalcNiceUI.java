import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

public class CalcNiceUI extends JFrame {

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
					CalcNiceUI frame = new CalcNiceUI();
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
	public CalcNiceUI() {
		setFont(new Font("Arial", Font.PLAIN, 12));
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setLocation(new Point(50, 0));
		setTitle("Calculadora");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 285, 255);
		
		try {
		     ClassLoader cl = this.getClass().getClassLoader();
		     ImageIcon programIcon = new ImageIcon(cl.getResource("imgs/calculadora_icon.png"));
		     setIconImage(programIcon.getImage());
		  } catch (Exception whoJackedMyIcon) {
		     System.out.println("Could not load program icon.");
		  }
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_uno = new JLabel("Numero 1:");
		label_uno.setFont(new Font("Arial", Font.BOLD, 15));
		label_uno.setBounds(10, 24, 110, 14);
		contentPane.add(label_uno);
				
		input_uno = new JTextField();
		input_uno.setFont(new Font("Arial", Font.BOLD, 16));
		input_uno.setText("0.0");
		input_uno.setBounds(150, 21, 110, 20);
		contentPane.add(input_uno);
		input_uno.setColumns(7);
		
		JLabel label_dos = new JLabel("Numero 2:");
		label_dos.setFont(new Font("Arial", Font.BOLD, 15));
		label_dos.setBounds(10, 49, 110, 14);
		contentPane.add(label_dos);
		
		input_dos = new JTextField();
		input_dos.setFont(new Font("Arial", Font.BOLD, 16));
		input_dos.setText("0.0");
		input_dos.setBounds(150, 46, 110, 20);
		contentPane.add(input_dos);
		input_dos.setColumns(7);
		
		JButton sumar_btn = new JButton("Sumar");
		sumar_btn.setToolTipText("Suma los numeros introducidos");
		sumar_btn.setBackground(new Color(240, 240, 240));
		sumar_btn.setFont(new Font("Arial", Font.BOLD, 15));
		sumar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addition();
			}
		});
		sumar_btn.setBounds(10, 77, 120, 23);
		contentPane.add(sumar_btn);
		
		JButton restar_btn = new JButton("Restar");
		restar_btn.setToolTipText("Resta los numeros introducidos");
		restar_btn.setBackground(new Color(240, 240, 240));
		restar_btn.setFont(new Font("Arial", Font.BOLD, 15));
		restar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				subtraction();
			}
		});
		restar_btn.setBounds(140, 77, 120, 23);
		contentPane.add(restar_btn);
		
		JButton multiplicar_btn = new JButton("Multiplicar");
		multiplicar_btn.setToolTipText("Multiplica los numeros introducidos");
		multiplicar_btn.setBackground(new Color(240, 240, 240));
		multiplicar_btn.setFont(new Font("Arial", Font.BOLD, 15));
		multiplicar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				multiplication();
			}
		});
		multiplicar_btn.setBounds(10, 111, 120, 23);
		contentPane.add(multiplicar_btn);
		
		JButton dividir_btn = new JButton("Dividir");
		dividir_btn.setBounds(140, 111, 120, 23);
		dividir_btn.setToolTipText("Divide los numeros introducidos. El numero 2 no puede ser cero");
		dividir_btn.setBackground(new Color(240, 240, 240));
		dividir_btn.setFont(new Font("Arial", Font.BOLD, 15));
		dividir_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				division();
			}
		});
		contentPane.add(dividir_btn);
		
		JButton raiz_btn = new JButton("Raiz 2");
		raiz_btn.setToolTipText("Hace la raiz cuadrada del numero 1");
		raiz_btn.setBackground(new Color(240, 240, 240));
		raiz_btn.setFont(new Font("Arial", Font.BOLD, 15));
		raiz_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sqrt();				
			}
		});
		raiz_btn.setBounds(10, 145, 120, 23);
		contentPane.add(raiz_btn);
		
		JButton raiz_cubica_btn = new JButton("Raiz 3");
		raiz_cubica_btn.setToolTipText("Hace la raiz cubica del numero 1");
		raiz_cubica_btn.setBackground(new Color(240, 240, 240));
		raiz_cubica_btn.setFont(new Font("Arial", Font.BOLD, 15));
		raiz_cubica_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbrt();				
			}
		});
		raiz_cubica_btn.setBounds(140, 145, 120, 23);
		contentPane.add(raiz_cubica_btn);
		
		final_result = new JLabel();
		final_result.setFont(new Font("Arial", Font.BOLD, 17));
		final_result.setBackground(new Color(192, 192, 192));
		final_result.setBounds(140, 179, 120, 30);
		contentPane.add(final_result);			
		
		JLabel final_result_1 = new JLabel();
		final_result_1.setText("RESULTADO:");
		final_result_1.setFont(new Font("Arial", Font.BOLD, 17));
		final_result_1.setBackground(Color.LIGHT_GRAY);
		final_result_1.setBounds(10, 179, 120, 30);
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {			    	  
		    	  //esta funcion evitará que entren elementos no numericos en las inputs
		    	  //también chequeará si hay alguna tecla de acción pulsada
		    	checkTextFieldInput(e);
		        return false;
		      }
		});
		
		contentPane.add(final_result_1);
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
		if (password!=null) {
			if(password.equals("0000")) {
				Object num_a = getNumeroUno();
				Object num_b = getNumeroDos();
				final_result.setText( Math.cbrt((double)num_a) +" | "+  Math.cbrt((double)num_b));
			}else {
				showWarnMessage("Contrasena incorrecta. No tienes acceso a la operacion");
			}
		}
	}
	
	private void checkTextFieldInput(java.awt.event.KeyEvent e) {
		//chequeamos si la tecla requiere alguna acción
		if(e.getID() == KeyEvent.KEY_PRESSED) {
  		  if(e.getKeyCode() == 90) {
  			  // si pulsas en z foco en el campo 1
  			  input_uno.requestFocus();
  		  }else if(e.getKeyCode() == 88) {
  			  // si pulsas en x foco en el campo 2
  			  input_dos.requestFocus();
  		  }else if(e.getKeyCode() == 27) {
  			  // se cierra la app al pulsar escape
  			  System.exit(0);
  		  }else if(e.getKeyCode() == 81) {
  			  // raiz cuadrada al pulsar q
  			  sqrt();
  		  }else if(e.getKeyCode() == 87) {
  			  // raiz cubica al pulsar w
  			  cbrt();
  		  }else if(e.getKeyCode() == 106) {
  			  // si pulsas multiplicar en el tec. numerico multiplica
  			  multiplication();
  		  }else if(e.getKeyCode() == 107) {
  			  // si pulsas sumar en el tec. numerico suma
  			 addition();
  		  }else if(e.getKeyCode() == 109) {
  			  // si pulsas restar en el tec. numerico resta
  			subtraction();
  		  }else if(e.getKeyCode() == 111) {
  			  // si pulsas dividir en el tec. numerico divide
  			  division();
  		  
  		  }
		}
		char c= e.getKeyChar();
		System.out.println(c);
		if((c < '0' || c >'9') && c != (char)KeyEvent.VK_BACK_SPACE && c != '.') {
			e.consume();
		}
	}
}
