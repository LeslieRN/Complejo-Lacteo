package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logico.Factura;
import logico.Principal;
import logico.Queso;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PrincipalV extends JFrame{

	private JPanel contentPane;
	private Dimension dimension;
	private JMenuItem mntmNewMenuItem_1;
	public static JTextField txtCantidadTotal;
	public static JTextField txtTotalVentas;
	private JTextField txtCodigoFactura;
	private JPanel panel_3;
	private GraficoPie pie;
	private Thread t1;
	private JLabel lblVolumenFact;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				
				try {
					empresa = new FileInputStream ("empresa.dat");
					empresaRead = new ObjectInputStream(empresa);
					Principal temp = (Principal)empresaRead.readObject();
					Principal.setPrincipal(temp);
					int quesosCantidad, facturasCantidad = 0;
					quesosCantidad = Principal.getInstance().getQuesos().size();
					Queso.setCantidadQuesos(quesosCantidad + 1);
					facturasCantidad = Principal.getInstance().getFacturas().size();
					Factura.setCantidad(facturasCantidad + 1);
					empresa.close();
					empresaRead.close();
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("empresa.dat");
						//empresaWrite = new ObjectOutputStream(empresa2);
						//empresaWrite.writeObject(Principal.getInstance());
						empresa2.close();
						//empresaWrite.close();
					} catch (FileNotFoundException e1) {
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {

				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					PrincipalV frame = new PrincipalV();
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
	public PrincipalV() {
		GraficoPie pie = new GraficoPie(true); 
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					empresa2 = new  FileOutputStream("empresa.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Principal.getInstance());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		pie.setBounds(10, 22, 608, 392);
		t1 = new Thread(pie);
		setTitle("Complejo Lacteo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1045, 723);
		dimension = super.getToolkit().getScreenSize();
		super.setSize(dimension.width, dimension.height - 45);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(51, 102, 153));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Listado de Cliente");
		mnNewMenu.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Mostrar Cliente");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarCliente auxMCliente = new MostrarCliente();
				auxMCliente.setModal(true);
				auxMCliente.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("Produccion");
		mnNewMenu_1.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Fabricacion Quesos");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QuesoV quesoAux = new QuesoV();
				quesoAux.setModal(true);
				quesoAux.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Listado de Quesos");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MostrarQueso quesoM = new MostrarQueso();
				quesoM.setModal(true);
				quesoM.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_2 = new JMenu("Ventas");
		mnNewMenu_2.setForeground(new Color(255, 255, 255));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Facturar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Venta auxV = new Venta();
				auxV.setModal(true);
				auxV.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Listado de Ventas");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MostrarVentas mVenta = new MostrarVentas();
				mVenta.setModal(true);
				mVenta.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Ventas Totales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(131, 151, 319, 129);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("Cantidad Vendida:");
		label.setBounds(19, 33, 120, 14);
		panel_2.add(label);
		
		txtCantidadTotal = new JTextField();
		txtCantidadTotal.setText(String.valueOf((Principal.getInstance().calcularCantidadTotalVentas())));
		txtCantidadTotal.setEnabled(false);
		txtCantidadTotal.setColumns(10);
		txtCantidadTotal.setBounds(137, 29, 163, 20);
		panel_2.add(txtCantidadTotal);
		
		JLabel label_1 = new JLabel("Total Vendido:");
		label_1.setBounds(19, 80, 120, 14);
		panel_2.add(label_1);
		
		txtTotalVentas = new JTextField();
		txtTotalVentas.setText(String.valueOf(Principal.getInstance().calcularTotalVentas())+"$RD");
		txtTotalVentas.setEnabled(false);
		txtTotalVentas.setColumns(10);
		txtTotalVentas.setBounds(137, 78, 163, 20);
		panel_2.add(txtTotalVentas);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Informacion General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(581, 114, 628, 425);
		panel_3.setLayout(null);
		panel_3.add(pie);
		t1.start();
		panel_1.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(51, 102, 153), new Color(51, 102, 153)), "Mayor Volumen en Factura", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(131, 349, 319, 129);
		panel_1.add(panel_4);
		
		txtCodigoFactura = new JTextField();
		txtCodigoFactura.setColumns(10);
		txtCodigoFactura.setBounds(48, 21, 86, 20);
		panel_4.add(txtCodigoFactura);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(PrincipalV.class.getResource("/icons/loupe (2).png")));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblVolumenFact.setText(String.valueOf(Principal.getInstance().mayorVolumen(txtCodigoFactura.getText())));
				
			}
		});
		btnBuscar.setBounds(179, 11, 89, 41);
		panel_4.add(btnBuscar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_5.setBounds(10, 62, 299, 56);
		panel_4.add(panel_5);
		
		lblVolumenFact = new JLabel("");
		lblVolumenFact.setBounds(10, 11, 289, 23);
		panel_5.add(lblVolumenFact);
	}

}
