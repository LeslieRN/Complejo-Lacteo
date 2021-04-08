package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Cilindro;
import logico.CilindroHueco;
import logico.Esfera;
import logico.Principal;
import logico.Queso;

import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarQueso extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JComboBox cmbOpcion;
	private DefaultTableModel model;
	private Object[] rows;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			MostrarQueso dialog = new MostrarQueso();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public MostrarQueso() {
		setBounds(100, 100, 519, 372);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Men\u00FA Selecci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				panel_1.setBounds(0, 0, 493, 57);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					cmbOpcion = new JComboBox();
					cmbOpcion.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(cmbOpcion.getSelectedIndex() == 0) {
								cargarQuesos();
							} else if(cmbOpcion.getSelectedIndex() == 1) {
								cargarQuesosE();
							} else if(cmbOpcion.getSelectedIndex() == 2) {
								cargarQuesosC();
							} else if(cmbOpcion.getSelectedIndex() == 3) {
								cargarQuesosCH();
							}
						}
					});
					cmbOpcion.setModel(new DefaultComboBoxModel(new String[] {"<Todo>", "Queso Esferico", "Queso Cilindrico", "Queso Cilindrico Hueco"}));
					cmbOpcion.setBounds(80, 26, 160, 20);
					panel_1.add(cmbOpcion);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 60, 493, 219);
				panel.add(panel_1);
				panel_1.setLayout(new BorderLayout(0, 0));
				{
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane, BorderLayout.CENTER);
					{
						table = new JTable();
						model = new DefaultTableModel();
						String[] encabezados = {"Codigo", "Precio U.", "Precio B."};
						model.setColumnIdentifiers(encabezados);
						table.setModel(model);
						//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						table.getTableHeader().setReorderingAllowed(false);
						scrollPane.setViewportView(table);
					}
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(cmbOpcion.getSelectedIndex() == 0) {
			cargarQuesos();
		} else if(cmbOpcion.getSelectedIndex() == 1) {
			cargarQuesosE();
		} else if(cmbOpcion.getSelectedIndex() == 2) {
			cargarQuesosC();
		} else if(cmbOpcion.getSelectedIndex() == 3) {
			cargarQuesosCH();
		}
	}
	
	private void cargarQuesos() {
		rows = new Object[model.getColumnCount()];
		model.setRowCount(0);
		for(int i = 0; i < Principal.getInstance().getQuesos().size() ; i++) {
			rows[0] = Principal.getInstance().getQuesos().get(i).getCodigo();
			rows[1] = Principal.getInstance().getQuesos().get(i).getPrecioUnitario();
			rows[2] = Principal.getInstance().getQuesos().get(i).getPrecioBase();
			model.addRow(rows);
		}
	}
	
	private void cargarQuesosCH() {
		rows = new Object[model.getColumnCount()];
		model.setRowCount(0);
		for(int i = 0; i < Principal.getInstance().getQuesos().size() ; i++) {
			if(Principal.getInstance().getQuesos().get(i) instanceof CilindroHueco) {
				rows[0] = Principal.getInstance().getQuesos().get(i).getCodigo();
				rows[1] = Principal.getInstance().getQuesos().get(i).getPrecioUnitario();
				rows[2] = Principal.getInstance().getQuesos().get(i).getPrecioBase();
				model.addRow(rows);
			}
		}
	}
	
	private void cargarQuesosE() {
		rows = new Object[model.getColumnCount()];
		model.setRowCount(0);
		for(int i = 0; i < Principal.getInstance().getQuesos().size() ; i++) {
			if(Principal.getInstance().getQuesos().get(i) instanceof Esfera) {
				rows[0] = Principal.getInstance().getQuesos().get(i).getCodigo();
				rows[1] = Principal.getInstance().getQuesos().get(i).getPrecioUnitario();
				rows[2] = Principal.getInstance().getQuesos().get(i).getPrecioBase();
				model.addRow(rows);
			}
		}
	}
	
	private void cargarQuesosC() {
		rows = new Object[model.getColumnCount()];
		model.setRowCount(0);
		for(int i = 0; i < Principal.getInstance().getQuesos().size() ; i++) {
			if(Principal.getInstance().getQuesos().get(i) instanceof Cilindro && !(Principal.getInstance().getQuesos().get(i)  instanceof CilindroHueco)) {
				rows[0] = Principal.getInstance().getQuesos().get(i).getCodigo();
				rows[1] = Principal.getInstance().getQuesos().get(i).getPrecioUnitario();
				rows[2] = Principal.getInstance().getQuesos().get(i).getPrecioBase();
				model.addRow(rows);
			}
		}
	}
}
