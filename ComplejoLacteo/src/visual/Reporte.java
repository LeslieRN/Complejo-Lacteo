package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;

import logico.Factura;
import logico.Principal;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCantidadTotal;
	private JTextField txtCantidadE;
	private JTextField txtCantidadC;
	private JTextField txtCantidadH;
	private JTextField txtCodigoFactura;
	private JButton btnBuscar;
	private JLabel lblVolumenFact;
	private JButton btnCancelar;
	private JTextField txtTotalVentas;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Reporte dialog = new Reporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Reporte() {
		setTitle("Reportes");
		setBounds(100, 100, 720, 374);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ventas Totales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 14, 319, 129);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cantidad Vendida:");
		lblNewLabel.setBounds(19, 33, 120, 14);
		panel.add(lblNewLabel);
		
		txtCantidadTotal = new JTextField();
		txtCantidadTotal.setText(String.valueOf((Principal.getInstance().calcularCantidadTotalVentas())));
		txtCantidadTotal.setEnabled(false);
		txtCantidadTotal.setBounds(137, 29, 163, 20);
		panel.add(txtCantidadTotal);
		txtCantidadTotal.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Total Vendido:");
		lblNewLabel_4.setBounds(19, 80, 120, 14);
		panel.add(lblNewLabel_4);
		
		txtTotalVentas = new JTextField();
		txtTotalVentas.setText(String.valueOf(Principal.getInstance().calcularTotalVentas()));
		txtTotalVentas.setEnabled(false);
		txtTotalVentas.setBounds(137, 78, 163, 20);
		panel.add(txtTotalVentas);
		txtTotalVentas.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Quesos Vendidos por Categoria", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(363, 11, 319, 129);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Queso Esf\u00E9rico:");
		lblNewLabel_1.setBounds(10, 21, 100, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Queso Cil\u00EDndrico:");
		lblNewLabel_2.setBounds(10, 56, 100, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Queso C. Hueco:");
		lblNewLabel_3.setBounds(10, 91, 100, 14);
		panel_1.add(lblNewLabel_3);
		
		txtCantidadE = new JTextField();
		txtCantidadE.setText(String.valueOf(Principal.getInstance().cantidadQuesos()[0]));
		txtCantidadE.setEnabled(false);
		txtCantidadE.setBounds(174, 18, 135, 20);
		panel_1.add(txtCantidadE);
		txtCantidadE.setColumns(10);
		
		txtCantidadC = new JTextField();
		txtCantidadC.setText(String.valueOf(Principal.getInstance().cantidadQuesos()[1]));
		txtCantidadC.setEnabled(false);
		txtCantidadC.setBounds(174, 53, 135, 20);
		panel_1.add(txtCantidadC);
		txtCantidadC.setColumns(10);
		
		txtCantidadH = new JTextField();
		txtCantidadH.setText(String.valueOf(Principal.getInstance().cantidadQuesos()[2]));
		txtCantidadH.setEnabled(false);
		txtCantidadH.setBounds(174, 88, 135, 20);
		panel_1.add(txtCantidadH);
		txtCantidadH.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Mayor Volumen en Factura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(190, 162, 319, 129);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		txtCodigoFactura = new JTextField();
		txtCodigoFactura.setBounds(48, 21, 86, 20);
		panel_2.add(txtCodigoFactura);
		txtCodigoFactura.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblVolumenFact.setText(String.valueOf(Principal.getInstance().mayorVolumen(txtCodigoFactura.getText())));
				
			}
		});
		btnBuscar.setBounds(182, 20, 89, 23);
		panel_2.add(btnBuscar);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBounds(10, 62, 299, 56);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		lblVolumenFact = new JLabel("");
		lblVolumenFact.setBounds(10, 11, 289, 23);
		panel_3.add(lblVolumenFact);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
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
}
