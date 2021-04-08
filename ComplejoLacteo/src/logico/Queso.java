package logico;

import java.io.Serializable;

public abstract class Queso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	protected String codigo;
	protected float precioBase;
	protected float precioUnitario;
	protected boolean estado;
	private static int cantidadQuesos = 1;
	public Queso(float precioBase, float precioUnitario, String codigo) {
		super();
		this.precioBase = precioBase;
		this.precioUnitario = precioUnitario;
		this.codigo = codigo;
		this.estado = true;
		Queso.cantidadQuesos++;
	}
	
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getPrecioBase() {
		return precioBase;
	}

	public void setPrecioBase(float precioBase) {
		this.precioBase = precioBase;
	}

	public float getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public static int getCantidadQuesos() {
		return cantidadQuesos;
	}

	public static void setCantidadQuesos(int cantidadQuesos) {
		Queso.cantidadQuesos = cantidadQuesos;
	}

	public abstract float volumen();
	
	//calcular el precio del queso
	public float precioQuesos() {
		float total = 0;
		total = this.precioBase * this.precioUnitario * volumen();
		return total;
	}
}
