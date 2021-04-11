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
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 425, 402);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Nuevo Queso", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(5, 5, 394, 309);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 23, 374, 83);
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
			spnPrecioBase.setBounds(88, 51, 72, 23);
			panel_1.add(spnPrecioBase);
			
			spnPrecioUnitario = new JSpinner();
			spnPrecioUnitario.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
			spnPrecioUnitario.setBounds(281, 51, 72, 23);
			panel_1.add(spnPrecioUnitario);
			{
				JPanel panel_2 = new JPanel();
				panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Tipo de Queso", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panel_2.setBounds(10, 106, 374, 89);
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
				panelEsferico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Queso Esferico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				panelEsferico.setBounds(10, 195, 374, 104);
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
			panelCilindrico.setBounds(10, 195, 374, 104);
			panel.add(panelCilindrico);
			panelCilindrico.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Queso Cilindrico", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
			panelCilindroH.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Queso Cilindrico Hueco", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panelCilindroH.setBounds(10, 195, 374, 104);
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
			buttonPane.setBackground(new Color(51, 102, 153));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrar = new JButton("");
				btnRegistrar.setIcon(new ImageIcon(QuesoV.class.getResource("/icons/diskette (1).png")));
				btnRegistrar.setBorderPainted(false);
				btnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						
						Queso aux = null;
						String codigo = txtCodigo.getText();
						float precioU = Float.parseFloat(spnPrecioUnitario.getValue().toString());
						float precioB = Float.parseFloat(spnPrecioBase.getValue().toString());
						
						if(rdbEsfera.isSelected()) {
							
							if(!txtRadioE.getText().isEmpty()) {
								
							float radio = Float.parseFloat(txtRadioE.getText());
							aux = new Esfera(precioB, precioU, codigo, radio);
							JOptionPane.showMessageDialog(null,"Queso registrado","Informacion", JOptionPane.INFORMATION_MESSAGE);
							
							}else {
								
								JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Aviso", JOptionPane.INFORMATION_MESSAGE);
							}
		
						}
						if (rdbCilindro.isSelected()) {
							
							if(!txtRadioC.getText().isEmpty() && !txtLongitudC.getText().isEmpty()) {
								
							float radio = Float.parseFloat(txtRadioC.getText());
							float longitud = Float.parseFloat(txtLongitudC.getText());
							aux = new Cilindro(precioB, precioU, codigo, radio, longitud);
							JOptionPane.showMessageDialog(null,"Queso registrado","Informacion", JOptionPane.INFORMATION_MESSAGE);
							
							}else {
								
								JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Aviso", JOptionPane.INFORMATION_MESSAGE);
								
							}
						} 
						if(rdbCilindroH.isSelected()){
							
							if(!txtCilindroH.getText().isEmpty() && !txtLongitudH.getText().isEmpty() && !txtRadioI.getText().isEmpty()) {
								
							float radio = Float.parseFloat(txtCilindroH.getText());
							float longitud = Float.parseFloat(txtLongitudH.getText());
							float radioI = Float.parseFloat(txtRadioI.getText());
							aux = new CilindroHueco(precioB, precioU,codigo,radio, longitud, radioI);
							JOptionPane.showMessageDialog(null,"Queso registrado","Informacion", JOptionPane.INFORMATION_MESSAGE);
							
							}else {
								
								JOptionPane.showMessageDialog(null,"Debe llenar todos los campos","Aviso", JOptionPane.INFORMATION_MESSAGE);
							}
						}
						
						Principal.getInstance().insertarQueso(aux);
						clean();
						
					
					}
				});
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				btnCancelar = new JButton("");
				btnCancelar.setBorderPainted(false);
				btnCancelar.setIcon(new ImageIcon(QuesoV.class.getResource("/icons/home (2).png")));
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
		spnPrecioBase.setValue(1);
		rdbEsfera.setSelected(true);
		panelEsferico.setVisible(true);
		panelCilindroH.setVisible(false);
		panelCilindrico.setVisible(false);
		rdbCilindro.setSelected(false);
		rdbCilindroH.setSelected(false);
		txtRadioC.setText("");
		txtLongitudC.setText("");
		txtCilindroH.setText("");
		spnPrecioUnitario.setValue(1);
		txtRadioI.setText("");
		txtLongitudH.setText("");
	}
}
