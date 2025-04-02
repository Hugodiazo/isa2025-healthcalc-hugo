package healthcalc.GUI.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;

public class HealthCalcView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAltura;
	private JTextField txtEdad;
	private JTextField txtPeso;
	private JRadioButton rbtnMasc;
	private JRadioButton rbtnFem;
	private JButton btnPesoIdeal;
	private JButton btnBRM;
	private JLabel lblResultado;
	private JLabel lblMensaje;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcView frame = new HealthCalcView();
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
	public HealthCalcView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 305, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panelTitulo = new JPanel();
		contentPane.add(panelTitulo);
		
		JLabel lblTitle = new JLabel("CALCULADORA DE SALUD");
		panelTitulo.add(lblTitle);
		
		JPanel panelGenero = new JPanel();
		contentPane.add(panelGenero);
		panelGenero.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblGenero = new JLabel("Genero");
		panelGenero.add(lblGenero);
		
		rbtnMasc = new JRadioButton("Masculino");
		panelGenero.add(rbtnMasc);
		
		rbtnFem = new JRadioButton("Femenino");
		panelGenero.add(rbtnFem);
		
		JPanel panelInputs = new JPanel();
		contentPane.add(panelInputs);
		panelInputs.setLayout(new GridLayout(3, 2, 0, 0));
		
		JLabel lblAltura = new JLabel("Altura (cm): ");
		panelInputs.add(lblAltura);
		
		txtAltura = new JTextField();
		panelInputs.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad (años): ");
		panelInputs.add(lblEdad);
		
		txtEdad = new JTextField();
		panelInputs.add(txtEdad);
		txtEdad.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (kg): ");
		panelInputs.add(lblPeso);
		
		txtPeso = new JTextField();
		panelInputs.add(txtPeso);
		txtPeso.setColumns(10);
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons);
		panelButtons.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnPesoIdeal = new JButton("Calcular Peso Ideal");
		panelButtons.add(btnPesoIdeal);
		
		btnBRM = new JButton("Calcular BMR");
		btnBRM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelButtons.add(btnBRM);
		
		ButtonGroup grupoGenero = new ButtonGroup();
		grupoGenero.add(rbtnMasc);
		grupoGenero.add(rbtnFem);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		lblResultado = new JLabel("Resultado: ");
		panel.add(lblResultado);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		lblMensaje = new JLabel("");
		panel_1.add(lblMensaje);
	}
	
	
	public JButton getBtnPesoIdeal() {
	    return btnPesoIdeal;
	}

	public JButton getBtnBMR() {
	    return btnBRM;
	}

	public JTextField getTxtAltura() {
	    return txtAltura;
	}

	public JTextField getTxtEdad() {
	    return txtEdad;
	}

	public JTextField getTxtPeso() {
	    return txtPeso;
	}

	public String getGeneroSeleccionado() {
	    return rbtnMasc.isSelected() ? "masculino" : "femenino";
	}

	public void setResultado(String texto) {
	    lblResultado.setText("Resultado: " + texto);
	}

	public void setMensaje(String texto) {
	    lblMensaje.setText(texto);
	}
	
}

