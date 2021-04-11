package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logico.Principal;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MostrarVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnCancelar;
	private final JPanel panel = new JPanel();
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private DefaultTableModel model;
	private Object[] rows;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the dialog.
	 */
	public MostrarVentas() {
		setTitle("Listado de Ventas");
		setBounds(100, 100, 553, 397);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Mostrar Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			
			contentPanel.add(panel, BorderLayout.CENTER);
		}
		panel.setLayout(new BorderLayout(0, 0));
		{
			panel.add(scrollPane, BorderLayout.CENTER);
		}
		{	
			model = new DefaultTableModel();
			String[] encabezados = {"Codico Factura", "Codigo Cliente", "Nombre Cliente", "Monto Total"};
			model.setColumnIdentifiers(encabezados);
			table.setModel(model);
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(new Color(51, 102, 153));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnCancelar = new JButton("");
				btnCancelar.setIcon(new ImageIcon(MostrarVentas.class.getResource("/icons/home (2).png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargarClientes();
	}
	private void cargarClientes() {
		rows = new Object[model.getColumnCount()];
		model.setRowCount(0);
		for(int i = 0; i < Principal.getInstance().getClientes().size() ; i++) {
			rows[0] = Principal.getInstance().getFacturas().get(i).getCodigo();
			rows[1] = Principal.getInstance().getFacturas().get(i).getCliente().getCodigo();
			rows[2] = Principal.getInstance().getFacturas().get(i).getCliente().getNombre();
			rows[3] = Principal.getInstance().getFacturas().get(i).getPrecioTotal();;
			model.addRow(rows);
		}
	}

}
