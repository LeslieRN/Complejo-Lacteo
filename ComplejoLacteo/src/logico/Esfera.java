package logico;

import java.io.Serializable;

public class Esfera extends Queso implements Serializable {
	private static final long serialVersionUID = 1L;
	private float radio;
	
	public Esfera(float precioBase, float precioUnitario, String codigo, float radio) {
		super(precioBase, precioUnitario, codigo);
		this.radio = radio;
		// TODO Auto-generated constructor stub
	}
	
	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return (float) (4/3*Math.PI*(Math.pow(this.radio, 3)));
	}

}
