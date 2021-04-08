package logico;

public class Cilindro extends Queso {
	private float radio;
	private float longitud;
	public Cilindro(float precioBase, float precioUnitario, String codigo,float radio, float longitud) {
		super(precioBase, precioUnitario, codigo);
		// TODO Auto-generated constructor stub
		this.radio = radio;
		this.longitud = longitud;
	}
	
	public float getRadio() {
		return radio;
	}

	public void setRadio(float radio) {
		this.radio = radio;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public float volumen() {
		// TODO Auto-generated method stub
		return (float) (areaBase()* this.longitud);
	}
	//hacer funcion que se llame area de la base
	
	public float areaBase() {
		return (float) (Math.PI * Math.pow(this.radio, 2));
	}

}
