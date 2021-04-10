package logico;

import java.util.ArrayList;

public class Principal {
	private ArrayList<Factura> facturas;
	private ArrayList<Cliente> clientes;
	private ArrayList<Queso> quesos;
	private static Principal principal = null;
	private static String nombreFactura = "";

	public Principal() {
		super();
		this.clientes = new ArrayList<Cliente>();
		this.facturas = new ArrayList<Factura>();
		this.quesos = new ArrayList<Queso>();
	}
	public static Principal getInstance() {
		if (principal == null) {
			principal = new Principal();
		}
		return principal;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(ArrayList<Factura> facturas) {
		this.facturas = facturas;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Queso> getQuesos() {
		return quesos;
	}

	public void setQuesos(ArrayList<Queso> quesos) {
		this.quesos = quesos;
	}

	public void insertarCliente(Cliente cli) {
		this.clientes.add(cli);
	}

	public void insertarQueso(Queso queso) {
		this.quesos.add(queso);
	}
	
	public void insertarFactura(Factura fact) {
		this.facturas.add(fact);
	}
	public Queso buscarQueso(String codigo) {
		for(Queso x : this.quesos) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return x;
			}
		}
		return null;
	}

	public Factura buscarFactura(String codigo) {
		for(Factura x : this.facturas) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return x;
			}
		}
		return null;
	}

	public Cliente buscarCliente(String codigo) {
		for(Cliente x : this.clientes) {
			if(x.getCodigo().equalsIgnoreCase(codigo)) {
				return x;
			}
		}
		return null;
	}
	//b
	public float calcularPrecioTotal(String codigo) {
		Factura aux = buscarFactura(codigo);
		float precio = 0;
		if(aux != null) {
			precio = aux.calcularPrecio();
		}
		return precio;
	}
	
	//C
	public int[] cantidadQuesos() {
		int[] cantidadQuesos = new int[3];

		for(Factura x : this.facturas) {
			for(int i = 0; i < x.getQueso().size(); i++) {
				if(x.getQueso().get(i) instanceof Esfera) {
					cantidadQuesos[0]++;
				} else if (x.getQueso().get(i) instanceof Cilindro && !(x.getQueso().get(i) instanceof CilindroHueco)) {
					cantidadQuesos[1]++;
				} else {
					cantidadQuesos[2]++;
				}
			}
		}

		return cantidadQuesos;
	}
	
	//calcular total de ventas
	public float calcularTotalVentas() {
		float total = 0;
		for(Factura x: this.facturas) {
			total += x.getPrecioTotal();
		}
		return total;
	}
	public int calcularCantidadTotalVentas() {
		return this.facturas.size();
	}
	public ArrayList<String> mostrarQuesos() {
		ArrayList<String> cantidadQuesos = new ArrayList<String>();

		for(Queso x : this.quesos) {
			if(x.isEstado()) {
				if(x instanceof Esfera) {
					cantidadQuesos.add(x.codigo +" "+"Esfera"+" "+x.precioBase+" "+ x.precioUnitario);
				} else if (x instanceof Cilindro && x instanceof CilindroHueco) {
					cantidadQuesos.add(x.codigo +" "+"Cilindro H"+" "+x.precioBase+" "+ x.precioUnitario);
				} else {
					cantidadQuesos.add(x.codigo +" "+"Cilindro"+" "+x.precioBase+" "+ x.precioUnitario);
				}
			}
		}

		return cantidadQuesos;
	}
	public ArrayList<String> mostrarQuesosE() {
		ArrayList<String> cantidadQuesos = new ArrayList<String>();

		for(Queso x : this.quesos) {
			if(x.isEstado()) {
				if(x instanceof Esfera) {
					cantidadQuesos.add(x.codigo +" "+"Esfera"+" "+x.precioBase+" "+ x.precioUnitario);
				}
			}
		}

		return cantidadQuesos;
	}
	public ArrayList<String> mostrarQuesosC() {
		ArrayList<String> cantidadQuesos = new ArrayList<String>();

		for(Queso x : this.quesos) {
			if(x.isEstado()) {
				if (x instanceof Cilindro && !(x instanceof CilindroHueco)) {
					cantidadQuesos.add(x.codigo +" "+"Cilindro"+" "+x.precioBase+" "+ x.precioUnitario);
				}
			}
		}

		return cantidadQuesos;
	}
	public ArrayList<String> mostrarQuesosCH() {
		ArrayList<String> cantidadQuesos = new ArrayList<String>();

		for(Queso x : this.quesos) {
			if(x.isEstado()) {
				if (x instanceof Cilindro && x instanceof CilindroHueco) {
					cantidadQuesos.add(x.codigo +" "+"Cilindro H"+" "+x.precioBase+" "+ x.precioUnitario);
				}
			}
		}

		return cantidadQuesos;
	}
	//d

	public float mayorVolumen(String codigo) {
		//buscar factura con codigo
		Factura aux = buscarFactura(codigo);
		float mayor = 0, precio = 0;
		if(aux != null) {
			for(Queso i : aux.getQueso()) {
				if(i instanceof Esfera) {
					if(i.volumen() > mayor) {
						mayor = i.volumen();
						precio = i.precioQuesos();
						//calcular precio de quesos
					}
				}
			}
		}
		//float mayor = 0;
		//String nombre = "";
		/*float precio = 0;
		for(Factura x : this.facturas) {
			if(x.getQueso().volumen() > mayor) {
				mayor = x.getQueso().volumen();
				nombre = x.getCodigo();
			}
		}*/
		return precio;
	}
	public static String getNombreFactura() {
		return nombreFactura;
	}
	public static void setNombreFactura(String nombreFactura) {
		Principal.nombreFactura = nombreFactura;
	}

}
