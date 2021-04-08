package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import logico.Cilindro;
import logico.CilindroHueco;
import logico.Esfera;
import logico.Principal;
import logico.Queso;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class QuesoV extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextField txtCodigo;
	private JTextField txtRadioE;
	private JPanel panelCilindrico;
	private JSpinner spnPrecioBase;
	private JRadioButton rdbEsfera;
	private JRadioButton rdbCilindro;
	private JRadioButton rdbCilindroH;
	private JTextField txtRadioC;
	private JTextField txtLongitudC;
	private JPanel panelCilindroH;
	private JTextField txtCilindroH;
	private JPanel panelEsferico;
	private JSpinner spnPrecioUnitario;
	private JTextField txtRadioI;
	private JLabel lblNewLabel_7;
	private JTextField txtLongitudH;
	private JLabel lblNewLabel_8;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			QuesoV dialog = new QuesoV();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public QuesoV() {
		setTitle("Menu Quesos");
		setBounds(100, 100, 425, 379);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(5, 5, 394, 297);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 374, 83);
			panel.add(panel_1);
			panel_1.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("C\u00F3digo:");
				lblNewLabel.setBounds(10, 22, 58, 14);
				panel_1.add(lblNewLabel);
			}
			
			txtCodigo = new JTextField();
			txtCodigo.setEnabled(false);
			txtCodigo.setBounds(78, 18, 86, 23);
			txtCodigo.setText("Q-"+Queso.getCantidadQuesos());
			panel_1.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Precio Base:");
			lblNewLabel_1.setBounds(10, 55, 86, 14);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Precio Unitario:");
			lblNewLabel_2.setBounds(185, 55, 107, 14);
			panel_1.add(lblNewLabel_2);
			
			spnPrecioBase = new JSpinner();
			spnPrecioBase.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnPrecioBase.setBounds(93, 51, 72, 23);
			panel_1.add(spnPrecioBase);
			
			spnPrecioUnitario = new JSpinner();
			spnPrecioUnitario.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnPrecioUnitario.setBounds(292, 51, 72, 23);
			panel_1.add(spnPrecioUnitario);
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Tipo de Queso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_2.setBounds(10, 94, 374, 89);
				panel.add(panel_2);
				panel_2.setLayout(null);
				
				rdbEsfera = new JRadioButton("Esfera");
				rdbEsfera.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						panelEsferico.setVisible(true);
						panelCilindroH.setVisible(false);
						panelCilindrico.setVisible(false);
						rdbCilindro.setSelected(false);
						rdbCilindroH.setSelected(false);
					}
				});
				rdbEsfera.setSelected(true);
				rdbEsfera.setBounds(19, 39, 103, 23);
				panel_2.add(rdbEsfera);
				
				rdbCilindro = new JRadioButton("Cilindro");
				rdbCilindro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelCilindrico.setVisible(true);
						panelEsferico.setVisible(false);
						panelCilindroH.setVisible(false);
						rdbEsfera.setSelected(false);
						rdbCilindroH.setSelected(false);
					}
				});
				rdbCilindro.setBounds(124, 39, 103, 23);
				panel_2.add(rdbCilindro);
				
				rdbCilindroH = new JRadioButton("Cilindro Hueco");
				rdbCilindroH.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelCilindroH.setVisible(true);
						panelEsferico.setVisible(false);
						panelCilindrico.setVisible(false);
						rdbCilindro.setSelected(false);
						rdbEsfera.setSelected(false);
					}
				});
				rdbCilindroH.setBounds(229, 39, 120, 23);
				panel_2.add(rdbCilindroH);
			}
			{
				panelEsferico = new JPanel();
				panelEsferico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Queso Esf\u00E9rico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelEsferico.setBounds(10, 182, 374, 104);
				panel.add(panelEsferico);
				panelEsferico.setLayout(null);
				
				JLabel lblNewLabel_3 = new JLabel("Radio:");
				lblNewLabel_3.setBounds(10, 45, 46, 14);
				panelEsferico.add(lblNewLabel_3);
				
				txtRadioE = new JTextField();
				txtRadioE.setBounds(58, 41, 86, 23);
				panelEsferico.add(txtRadioE);
				txtRadioE.setColumns(10);
			}
			
			panelCilindrico = new JPanel();
			panelCilindrico.setVisible(false);
			panelCilindrico.setBounds(10, 182, 374, 104);
			panel.add(panelCilindrico);
			panelCilindrico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Queso Cilindrico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCilindrico.setLayout(null);
			
			JLabel lblNewLabel_5 = new JLabel("Radio:");
			lblNewLabel_5.setBounds(19, 44, 46, 14);
			panelCilindrico.add(lblNewLabel_5);
			
			txtRadioC = new JTextField();
			txtRadioC.setBounds(84, 40, 86, 23);
			panelCilindrico.add(txtRadioC);
			txtRadioC.setColumns(10);
			
			txtLongitudC = new JTextField();
			txtLongitudC.setBounds(270, 40, 84, 23);
			panelCilindrico.add(txtLongitudC);
			txtLongitudC.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Longitud:");
			lblNewLabel_4.setBounds(189, 44, 62, 14);
			panelCilindrico.add(lblNewLabel_4);
			
			panelCilindroH = new JPanel();
			panelCilindroH.setVisible(false);
			panelCilindroH.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Queso Cinl\u00EDndrico Hueco", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelCilindroH.setBounds(10, 182, 374, 104);
			panel.add(panelCilindroH);
			panelCilindroH.setLayout(null);
			
			JLabel lblNewLabel_6 = new JLabel("Radio:");
			lblNewLabel_6.setBounds(14, 20, 46, 14);
			panelCilindroH.add(lblNewLabel_6);
			
			txtCilindroH = new JTextField();
			txtCilindroH.setBounds(74, 16, 86, 23);
			panelCilindroH.add(txtCilindroH);
			txtCilindroH.setColumns(10);
			
			txtRadioI = new JTextField();
			txtRadioI.setBounds(274, 16, 86, 23);
			panelCilindroH.add(txtRadioI);
			txtRadioI.setColumns(10);
			
			lblNewLabel_7 = new JLabel("Radio Interior:");
			lblNewLabel_7.setBounds(174, 20, 86, 14);
			panelCilindroH.add(lblNewLabel_7);
			
			txtLongitudH = new JTextField();
			txtLongitudH.setBounds(74, 61, 86, 23);
			panelCilindroH.add(txtLongitudH);
			txtLongitudH.setColumns(10);
			
			lblNewLabel_8 = new JLabel("Longitud:");
			lblNewLabel_8.setBounds(10, 64, 86, 14);
			panelCilindroH.add(lblNewLabel_8);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Queso aux = null;
						String codigo = txtCodigo.getText();
						float precioU = Float.parseFloat(spnPrecioUnitario.getValue().toString());
						float precioB = Float.parseFloat(spnPrecioBase.getValue().toString());
						
						if(rdbEsfera.isSelected()) {
							float radio = Float.parseFloat(txtRadioE.getText());
							aux = new Esfera(precioB, precioU, codigo, radio);
						} else if (rdbCilindro.isSelected()) {
							float radio = Float.parseFloat(txtRadioC.getText());
							float longitud = Float.parseFloat(txtLongitudC.getText());
							aux = new Cilindro(precioB, precioU, codigo, radio, longitud);
						} else {
							float radio = Float.parseFloat(txtCilindroH.getText());
							float longitud = Float.parseFloat(txtLongitudH.getText());
							float radioI = Float.parseFloat(txtRadioI.getText());
							aux = new CilindroHueco(precioB, precioU,codigo,radio, longitud, radioI);
						}
						
						Principal.getInstance().insertarQueso(aux);
						JOptionPane.showMessageDialog(null,"Queso registrardo","Mensaje", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	private void clean () {
		txtCodigo.setText("Q-"+Queso.getCantidadQuesos());
		txtRadioE.setText("");
		spnPrecioBase.setValue(0);
		rdbEsfera.setSelected(true);
		panelEsferico.setVisible(true);
		panelCilindroH.setVisible(false);
		panelCilindrico.setVisible(false);
		rdbCilindro.setSelected(false);
		rdbCilindroH.setSelected(false);
		txtRadioC.setText("");
		txtLongitudC.setText("");
		txtCilindroH.setText("");
		spnPrecioUnitario.setValue(0);
		txtRadioI.setText("");
		txtLongitudH.setText("");
	}
}
