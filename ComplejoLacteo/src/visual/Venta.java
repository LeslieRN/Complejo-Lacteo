package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import logico.Cliente;
import logico.Factura;
import logico.Principal;
import logico.Queso;

import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Event;

public class Venta extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoCliente;
	private JTextField txtNombre;
	private JTextField txtDirec;
	private JTextField txtTel;
	private JButton btnBuscar;
	private JButton btnRegistrarVenta;
	private JButton btnCancelar;
	private JButton btnInsertar;
	private JButton btnRegresar;
	private JComboBox<Object> cmbTipoQuesos;
	private JList<String> listaQuesos;
	private JList<String> listaFactura;
	private JTextField txtSubtotal;
	private DefaultListModel<String> model, model_Factura;
	private JTextField txtCodigoFactura;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			Venta dialog = new Venta();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public Venta() {
		setTitle("Venta");
		setBounds(100, 100, 616, 591);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Datos Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 11, 566, 147);
			panel.add(panel_1);
			panel_1.setLayout(null);

			JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de Cliente:");
			lblNewLabel_1.setBounds(10, 26, 113, 14);
			panel_1.add(lblNewLabel_1);

			txtCodigoCliente = new JTextField();
			txtCodigoCliente.setBounds(122, 22, 251, 23);
			panel_1.add(txtCodigoCliente);
			txtCodigoCliente.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Nombre:");
			lblNewLabel_2.setBounds(10, 67, 82, 14);
			panel_1.add(lblNewLabel_2);

			txtNombre = new JTextField();
			txtNombre.setEnabled(false);
			txtNombre.setBounds(122, 63, 251, 23);
			panel_1.add(txtNombre);
			txtNombre.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Direcci\u00F3n:");
			lblNewLabel_3.setBounds(292, 98, 89, 14);
			panel_1.add(lblNewLabel_3);

			txtDirec = new JTextField();
			txtDirec.setEnabled(false);
			txtDirec.setBounds(409, 94, 147, 23);
			panel_1.add(txtDirec);
			txtDirec.setColumns(10);

			JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono:");
			lblNewLabel_4.setBounds(10, 98, 61, 14);
			panel_1.add(lblNewLabel_4);

			txtTel = new JTextField();
			txtTel.setEnabled(false);
			txtTel.setBounds(98, 94, 147, 23);
			panel_1.add(txtTel);
			txtTel.setColumns(10);

			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String codigo = txtCodigoCliente.getText();
					Cliente aux = null;
					aux = Principal.getInstance().buscarCliente(codigo);
					if(aux != null) {
						txtNombre.setText(aux.getNombre());
						txtTel.setText(aux.getTelefono());
						txtDirec.setText(aux.getDireccion());
					}
					else {
						JOptionPane.showMessageDialog(null,"Cliente no encontrado","Mensaje", JOptionPane.ERROR_MESSAGE);
						txtNombre.setEnabled(true);
						txtTel.setEnabled(true);
						txtDirec.setEnabled(true);
					}
				}
			});
			btnBuscar.setBounds(383, 21, 89, 23);
			panel_1.add(btnBuscar);

			JPanel panel_2 = new JPanel();
			panel_2.setBounds(10, 200, 239, 235);
			panel.add(panel_2);
			panel_2.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setLocation(52, 0);
			panel_2.add(scrollPane, BorderLayout.CENTER);

			model = new DefaultListModel<String>();

			listaQuesos = new JList<String>();
			listaQuesos.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnInsertar.setEnabled(true);
				}
			});
			listaQuesos.setModel(model);
			listaQuesos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(listaQuesos);

			JPanel panel_3 = new JPanel();
			panel_3.setBounds(337, 200, 239, 235);
			panel.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel_3.add(scrollPane_1, BorderLayout.CENTER);

			model_Factura = new DefaultListModel<String>();
			listaFactura = new JList<String>();
			listaFactura.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					btnRegresar.setEnabled(true);
				}
			});
			listaFactura.setModel(model_Factura);
			scrollPane_1.setViewportView(listaFactura);

			JPanel panel_4 = new JPanel();
			panel_4.setBounds(10, 446, 566, 52);
			panel.add(panel_4);
			panel_4.setLayout(null);

			JLabel lblNewLabel = new JLabel("Total:");
			lblNewLabel.setBounds(145, 11, 70, 17);
			panel_4.add(lblNewLabel);

			txtSubtotal = new JTextField();
			txtSubtotal.setForeground(Color.RED);
			txtSubtotal.setText("0");
			txtSubtotal.setEnabled(false);
			txtSubtotal.setBounds(302, 8, 136, 23);
			panel_4.add(txtSubtotal);
			txtSubtotal.setColumns(10);

			cmbTipoQuesos = new JComboBox<Object>();
			cmbTipoQuesos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					model.removeAllElements();
					cargarQuesos();
				}
			});
			cmbTipoQuesos.setModel(new DefaultComboBoxModel<Object>(new String[] {"<Todo>", "Esfera", "Cilindrico", "Cilindro Hueco"}));
			cmbTipoQuesos.setBounds(54, 169, 155, 20);
			panel.add(cmbTipoQuesos);

			btnRegresar = new JButton("<");
			btnRegresar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Queso aux = null;
					String codigo = "";
					float total = 0;
					int index = -1, espacioCodigo = 0;
					index = listaFactura.getSelectedIndex();
					if(index != -1) {
						model.addElement(model_Factura.get(index));
						listaQuesos.setModel(model);

						espacioCodigo = listaFactura.getSelectedValue().toString().indexOf(' ');
						codigo =listaFactura.getSelectedValue().toString().substring(0, espacioCodigo).toString();

						aux = Principal.getInstance().buscarQueso(codigo);
						//aux.setEstado(true);
						total = Float.parseFloat(txtSubtotal.getText()) - aux.precioQuesos();
						txtSubtotal.setText(String.valueOf(total));
						model_Factura.remove(index);
						btnRegresar.setEnabled(false);
					}
				}
			});
			btnRegresar.setEnabled(false);
			btnRegresar.setBounds(259, 312, 68, 23);
			panel.add(btnRegresar);

			btnInsertar = new JButton(">");
			btnInsertar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Queso aux = null;
					float total = 0;
					String codigo = "";
					int index = -1, espacioCodigo = 0;;
					index = listaQuesos.getSelectedIndex();
					if(index != -1) {
						model_Factura.addElement(model.get(index));
						listaFactura.setModel(model_Factura);
						espacioCodigo = listaQuesos.getSelectedValue().toString().indexOf(' ');
						codigo =listaQuesos.getSelectedValue().toString().substring(0, espacioCodigo).toString();

						aux = Principal.getInstance().buscarQueso(codigo);
						//aux.setEstado(false);*/
						total = Float.parseFloat(txtSubtotal.getText()) + aux.precioQuesos();
						txtSubtotal.setText(String.valueOf(total));
						model.remove(index);
						btnInsertar.setEnabled(false);
					}
				}
			});
			btnInsertar.setEnabled(false);
			btnInsertar.setBounds(259, 278, 68, 23);
			panel.add(btnInsertar);

			txtCodigoFactura = new JTextField();
			txtCodigoFactura.setEnabled(false);
			txtCodigoFactura.setText("FACT-"+Factura.getCantidad());
			txtCodigoFactura.setBounds(337, 169, 239, 23);
			panel.add(txtCodigoFactura);
			txtCodigoFactura.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnRegistrarVenta = new JButton("Registrar Venta");
				btnRegistrarVenta.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Factura auxFact = null;
						Cliente auxCliente = null;
						String codigo = txtCodigoCliente.getText();
						auxCliente = Principal.getInstance().buscarCliente(codigo);
						if(auxCliente == null) {
							auxCliente = new Cliente(txtCodigoCliente.getText(), txtNombre.getText(), txtDirec.getText(), txtTel.getText());
							Principal.getInstance().insertarCliente(auxCliente);
						}

						auxFact = new Factura(txtCodigoFactura.getText(), auxCliente, Float.valueOf(txtSubtotal.getText()));
						//ArrayList<Queso> auxQueso = new ArrayList<Queso>();

						auxFact.setQueso(quesosFactura());
						Principal.getInstance().insertarFactura(auxFact);
						Principal.setNombreFactura(txtCodigoFactura.getText());
						facturaServidor (auxFact);
						JOptionPane.showMessageDialog(null,"Factura registrada","Mensaje", JOptionPane.INFORMATION_MESSAGE);
						if(guardarFactura(txtCodigoFactura.getText(), auxFact)) {
							JOptionPane.showMessageDialog(null,"Factura guardada","Mensaje", JOptionPane.INFORMATION_MESSAGE);
						}
						clean();



					}
				});
				btnRegistrarVenta.setActionCommand("OK");
				buttonPane.add(btnRegistrarVenta);
				getRootPane().setDefaultButton(btnRegistrarVenta);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		cargarQuesos();
	}
	private void cargarQuesos() {
		ArrayList<String> aux = new ArrayList<String>();
		if(cmbTipoQuesos.getSelectedItem() == "<Todo>") {
			aux = Principal.getInstance().mostrarQuesos();
		} else if (cmbTipoQuesos.getSelectedIndex() == 1) {
			aux = Principal.getInstance().mostrarQuesosE();
		} else if(cmbTipoQuesos.getSelectedIndex() == 2) {
			aux = Principal.getInstance().mostrarQuesosC();
		} else if(cmbTipoQuesos.getSelectedIndex() == 3) {
			aux = Principal.getInstance().mostrarQuesosCH();
		}
		for(int i = 0; i < aux.size(); i++) {
			model.addElement(aux.get(i).toString());
		}
	}
	private ArrayList<Queso> quesosFactura() {
		ArrayList<Queso> auxQueso = new ArrayList<Queso>();
		int espacioCodigo = 0;
		Queso aux = null;
		String codigo = "";
		for(int i = 0; i < model_Factura.getSize(); i++) {
			espacioCodigo = model_Factura.get(i).toString().indexOf(' ');
			codigo =model_Factura.get(i).toString().substring(0, espacioCodigo).toString();
			aux = Principal.getInstance().buscarQueso(codigo);
			aux.setEstado(false);
			auxQueso.add(aux);
		}
		return auxQueso;
	}

	private void clean() {
		txtCodigoCliente.setText("");
		txtNombre.setText("");
		txtDirec.setText("");
		txtTel.setText("");
		txtSubtotal.setText("0.00");
		txtCodigoFactura.setText("FACT-"+Factura.getCantidad());
		model_Factura.removeAllElements();
		listaFactura.setModel(model_Factura);
	}

	private boolean guardarFactura(String nombreFactura, Factura factura) {
		String path = System.getProperty("user.dir");
		FileOutputStream archivoFactura;
		ObjectOutputStream objectoFactura;
		try {
			archivoFactura = new FileOutputStream (path+"\\facturas\\"+nombreFactura+".dat");
			objectoFactura = new ObjectOutputStream (archivoFactura);
			objectoFactura.writeInt(1);
			objectoFactura.writeObject(factura);
			objectoFactura.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	private void facturaServidor (Factura auxFact) {
		Socket socket = null;
		String host = "127.0.0.1";
		String path = System.getProperty("user.dir");
		FileOutputStream file;
		byte[] bytes = new byte[16 * 1024];
		FileInputStream in;
		
		try {
			socket = new Socket(host, 7000);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			file = new FileOutputStream (path+"\\facturas\\"+txtCodigoFactura.getText()+".dat");
			ObjectOutputStream oos = new ObjectOutputStream (file);
			oos.writeInt(1);
			oos.writeObject(auxFact);
			oos.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			in = new FileInputStream(txtCodigoFactura.getText()+".dat");
			OutputStream out = socket.getOutputStream();
			int count;
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
			}

			out.close();
			in.close();
			socket.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}