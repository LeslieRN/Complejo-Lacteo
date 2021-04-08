package logico;

import java.io.Serializable;

public class CilindroHueco extends Cilindro implements Serializable {
	private static final long serialVersionUID = 1L;
	private float radioInterior;
	
	//private float radioE;
	/*public CilindroHueco(float precioBase, float precioUnitario, String codigo,float radioInterior) {
		super(precioBase, precioUnitario,codigo, radioInterior);
		// TODO Auto-generated constructor stub
		this.radioInterior = radioInterior;
		//this.radioE = radio;
	}*/
	
	public CilindroHueco(float precioBase, float precioUnitario, String codigo, float radio, float longitud, float radioInterior) {
		super(precioBase, precioUnitario, codigo, radio, longitud);
		// TODO Auto-generated constructor stub
		this.radioInterior = radioInterior;
	}
	
	public float getRadioInterior() {
		return radioInterior;
	}

	public void setRadioInterior(float radioInterior) {
		this.radioInterior = radioInterior;
	}

	//implementar area de base
	public float areaBase() {
		return (float) (Math.PI  * (Math.pow(super.getRadio(), 2) - Math.pow(this.radioInterior,2)));
	}
}
