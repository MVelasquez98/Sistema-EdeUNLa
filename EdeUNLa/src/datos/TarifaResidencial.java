package datos;

public class TarifaResidencial extends Tarifa {

	private int montoMinimo;
	private int cargoVariable;
	
	public TarifaResidencial() {
		super();
	}

	public TarifaResidencial(String codigo, int montoMinimo, int cargoVariable) {
		super(codigo);
		this.montoMinimo = montoMinimo;
		this.cargoVariable = cargoVariable;
	}


	public int getMontoMinimo() {
		return montoMinimo;
	}

	public void setMontoMinimo(int montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	public int getCargoVariable() {
		return cargoVariable;
	}

	public void setCargoVariable(int cargoVariable) {
		this.cargoVariable = cargoVariable;
	}

	@Override
	public String toString() {
		return "TarifaResidencial \ncodigo:" + super.getCodigo() + "\n montoMinimo:" + montoMinimo + ", cargoVariable:"
				+ cargoVariable;
	}
	
	
}
