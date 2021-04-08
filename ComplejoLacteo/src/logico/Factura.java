package logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;
	private String codigo;
	private Cliente cliente;
	private ArrayList<Queso> queso;
	private float precioTotal;
	private static int cantidadFactura = 1;
	public Factura(String codigo, Cliente cliente, float precioTotal) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.queso = new ArrayList<Queso>();
		this.precioTotal = precioTotal;
		Factura.cantidadFactura++;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
		this.precioTotal = precioTotal;
	}
	public static int getCantidad() {
		return cantidadFactura;
	}
	public static void setCantidad(int cantidad) {
		Factura.cantidadFactura = cantidad;
	}
	public ArrayList<Queso> getQueso() {
		return queso;
	}
	public void setQueso(ArrayList<Queso> queso) {
		this.queso = queso;
	}
	public float calcularPrecio() {
		for(Queso i : this.queso) {
			this.precioTotal += i.precioQuesos();
		}
		return this.precioTotal;
	}
	
}
