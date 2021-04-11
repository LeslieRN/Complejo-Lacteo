package visual;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.general.DefaultPieDataset;

import logico.Factura;
import logico.Principal;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
	}
	 */
	/**
	 * Create the dialog.
	 */
	public Reporte() {
		setTitle("Reportes");
		setBounds(100, 100, 819, 428);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Ventas Totales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 28, 319, 129);
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
		txtTotalVentas.setText(String.valueOf(Principal.getInstance().calcularTotalVentas())+"$RD");
		txtTotalVentas.setEnabled(false);
		txtTotalVentas.setBounds(137, 78, 163, 20);
		panel.add(txtTotalVentas);
		txtTotalVentas.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(363, 11, 430, 302);
		contentPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		// Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Queso Esférico", Principal.getInstance().cantidadQuesos()[0]);
        data.setValue("Queso Cilíndrico", Principal.getInstance().cantidadQuesos()[1]);
        data.setValue("Queso C. Hueco", Principal.getInstance().cantidadQuesos()[2]);
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "", 
         data, 
         true, 
         true, 
         false);
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);;
        plot.setSectionPaint("Queso Esférico", new Color(11, 55, 99));
        plot.setSectionPaint("Queso Cilíndrico", new Color(19,98,176));
        plot.setSectionPaint("Queso C. Hueco", new Color(28,140,252));
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        panel_1.add(chartPanel);
		/*JLabel lblNewLabel_1 = new JLabel("Queso Esf\u00E9rico:");
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Queso Cil\u00EDndrico:");
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Queso C. Hueco:");
		panel_1.add(lblNewLabel_3);
		
		txtCantidadE = new JTextField();
		txtCantidadE.setText(String.valueOf(Principal.getInstance().cantidadQuesos()[0]));
		txtCantidadE.setEnabled(false);
		panel_1.add(txtCantidadE);
		txtCantidadE.setColumns(10);
		
		txtCantidadC = new JTextField();
		txtCantidadC.setText(String.valueOf(Principal.getInstance().cantidadQuesos()[1]));
		txtCantidadC.setEnabled(false);
		panel_1.add(txtCantidadC);
		txtCantidadC.setColumns(10);
		
		txtCantidadH = new JTextField();
		txtCantidadH.setText(String.valueOf(Principal.getInstance().cantidadQuesos()[2]));
		txtCantidadH.setEnabled(false);
		panel_1.add(txtCantidadH);
		txtCantidadH.setColumns(10);*/
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Mayor Volumen en Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(22, 185, 319, 129);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		txtCodigoFactura = new JTextField();
		txtCodigoFactura.setBounds(48, 21, 86, 20);
		panel_2.add(txtCodigoFactura);
		txtCodigoFactura.setColumns(10);
		
		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(Reporte.class.getResource("/icons/loupe (2).png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblVolumenFact.setText(String.valueOf(Principal.getInstance().mayorVolumen(txtCodigoFactura.getText())));
				
			}
		});
		btnBuscar.setBounds(179, 11, 89, 41);
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
			buttonPane.setBackground(new Color(51, 102, 153));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("");
				btnCancelar.setIcon(new ImageIcon(Reporte.class.getResource("/icons/home (2).png")));
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
