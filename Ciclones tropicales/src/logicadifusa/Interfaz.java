package logicadifusa;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Interfaz extends JFrame {

	static JPanel contentPane;
	static JTextField campo1;
	static JTextField campo2;
	static JTextField campo3;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interfaz frame = new Interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}	/**
	 * Create the frame.
	 */
	public Interfaz() {
		setTitle("Da\u00F1os por Ciclones Tropicales El Juego");
		setIconImage(Toolkit.getDefaultToolkit().getImage("ciclon.jpg"));
		setBackground(Color.BLUE);
		setResizable(false);
		
		JLabel bienvenida = new JLabel(
				"<html><center><font size=6><center>Bienvenidos a</center></font><font size=7><center>FINE-E</center></font></center></html>");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campo1 = new JTextField();
		campo1.setBounds(260, 92, 86, 20);
		contentPane.add(campo1);
		campo1.setColumns(10);
		
		campo2 = new JTextField();
		campo2.setBounds(260, 134, 86, 20);
		contentPane.add(campo2);
		campo2.setColumns(10);
		
		campo3 = new JTextField();
		campo3.setBounds(260, 178, 86, 20);
		contentPane.add(campo3);
		campo3.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String actionCommand = arg0.getActionCommand();
				if (arg0.getSource() instanceof JButton) {
					if("Calcular".equals(actionCommand)) {
						try {
							LogicaDifusa.main();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		btnNewButton.setBounds(183, 237, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Poblaci\u00F3n");
		lblNewLabel.setBounds(35, 95, 193, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Proximidad al mar");
		lblNewLabel_1.setBounds(35, 137, 193, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Velocidad");
		lblNewLabel_2.setBounds(35, 181, 179, 14);
		contentPane.add(lblNewLabel_2);
		
		JPanel P1 = new JPanel();
		JPanel P1_1 = new JPanel();
		
		getContentPane().add(P1, BorderLayout.NORTH);
		
		P1.add(P1_1);
		P1.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));

		P1_1.add(bienvenida);
		
		JLabel lblbienvenidosAdaosPor = new JLabel("<html><center><font size=6><center>Bienvenidos a</center></font><font size=5><center>DA\u00D1OS POR CICLONES TROPICALES</center></font></center></html>");
		lblbienvenidosAdaosPor.setFont(new Font("Consolas", Font.PLAIN, 11));
		lblbienvenidosAdaosPor.setBounds(76, 0, 312, 73);
		contentPane.add(lblbienvenidosAdaosPor);
	}
}
