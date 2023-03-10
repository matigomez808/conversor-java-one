package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import Principal.Conversiones;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class ventanaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> miCombo;
	private JButton btnConvertir, btnExit;
	private JLabel lblValorConvertir, lblElegirConversion;
//	private Conversiones misConversiones;
	private JTextField textRes;

//	Create the frame.

	public ventanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 210, 302);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(119, 118, 123));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Conversor ONE");
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(contentPane);

		btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(this);

		btnExit = new JButton("Cerrar");
		btnExit.addActionListener(this);
		FlowLayout fl_contentPane = new FlowLayout(FlowLayout.CENTER, 5, 10);
		fl_contentPane.setAlignOnBaseline(true);
		contentPane.setLayout(fl_contentPane);

		lblElegirConversion = new JLabel("Elija tipo de conversion");
		lblElegirConversion.setForeground(new Color(0, 0, 0));
		contentPane.add(lblElegirConversion);

		miCombo = new JComboBox<>();
		miCombo.setForeground(new Color(0, 0, 0));
		contentPane.add(miCombo);
		miCombo.setModel(new DefaultComboBoxModel<String>(new String[] { "ARS -> USD", "USD -> ARS", "ARS -> EUR",
				"EUR -> ARS", "ARS -> GBP", "GBP -> ARS", "ARS -> JPY", "JPY -> ARS", "ARS -> KPW", "KPW -> ARS" }));

		miCombo.addActionListener(this);

		lblValorConvertir = new JLabel("Valor a convertir");
		lblValorConvertir.setForeground(new Color(0, 0, 0));
		contentPane.add(lblValorConvertir);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(textField);
		textField.setColumns(10);
		getContentPane().add(btnConvertir);

		textRes = new JTextField();
		textRes.setHorizontalAlignment(SwingConstants.CENTER);
		textRes.setForeground(new Color(0, 0, 0));
		textRes.setEditable(false);
		contentPane.add(textRes);
		textRes.setColumns(10);

		contentPane.add(btnExit);

	}

//	Implementaci??n del m??todo abstracto requerido por la interfaz ActionListener
	@Override
	public void actionPerformed(ActionEvent e) {
		if (btnExit == e.getSource()) {
			System.exit(0);
		}

		miCombo.hidePopup();

		double input;
		double r;
		DecimalFormat df = new DecimalFormat("#.##");
		if (btnConvertir == e.getSource()) {

			if (validar()) {

				input = Double.parseDouble(textField.getText());
				
				if (miCombo.getSelectedItem().equals("ARS -> USD")) {
					r = input / 199.65;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("USD -> ARS")) {
					r = input * 199.65;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("ARS -> EUR")) {
					r = input / 212.81;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("EUR -> ARS")) {
					r = input * 212.81;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("ARS -> GBP")) {
					r = input / 239.20;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("GBP -> ARS")) {
					r = input * 239.20;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("ARS -> JPY")) {
					r = input / 1.46;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("JPY -> ARS")) {
					r = input * 1.46;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("ARS -> KRW")) {
					r = input / 0.15;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
				if (miCombo.getSelectedItem().equals("KRW -> ARS")) {
					r = input * 0.15;

					r = Double.valueOf(df.format(r));
					textRes.setText(String.valueOf(r));
				}
			}
		}

	}

	private boolean validar() {
		try {
			double input = Double.parseDouble(textField.getText());
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Error. Ingrese solo n??meros.");
			return false;
		}
		return true;

	}

}
