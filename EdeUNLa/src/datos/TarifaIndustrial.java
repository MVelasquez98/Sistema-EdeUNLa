package datos;

public class TarifaIndustrial extends Tarifa {

	private boolean potenciaMayor;
	private String tension;
	private int cargoFijo;
	private int cargoVariablePico;
	private int cargoVariableValle;
	private int cargoVariableResto;

	
	public TarifaIndustrial() {
		super();
	}

	public TarifaIndustrial(String codigo, boolean potenciaMayor, String tension, int cargoFijo, int cargoVariablePico,
			int cargoVariableValle, int cargoVariableResto) {
		super(codigo);
		this.potenciaMayor = potenciaMayor;
		this.tension = tension;
		this.cargoFijo = cargoFijo;
		this.cargoVariablePico = cargoVariablePico;
		this.cargoVariableValle = cargoVariableValle;
		this.cargoVariableResto = cargoVariableResto;
	}



	public boolean isPotenciaMayor() {
		return potenciaMayor;
	}

	public void setPotenciaMayor(boolean potenciaMayor) {
		this.potenciaMayor = potenciaMayor;
	}

	public int getCargoFijo() {
		return cargoFijo;
	}

	public void setCargoFijo(int cargoFijo) {
		this.cargoFijo = cargoFijo;
	}

	public int getCargoVariablePico() {
		return cargoVariablePico;
	}

	public void setCargoVariablePico(int cargoVariablePico) {
		this.cargoVariablePico = cargoVariablePico;
	}

	public int getCargoVariableValle() {
		return cargoVariableValle;
	}

	public void setCargoVariableValle(int cargoVariableValle) {
		this.cargoVariableValle = cargoVariableValle;
	}

	public int getCargoVariableResto() {
		return cargoVariableResto;
	}

	public void setCargoVariableResto(int cargoVariableResto) {
		this.cargoVariableResto = cargoVariableResto;
	}

	public String getTension() {
		return tension;
	}

	public void setTension(String tension) {
		this.tension = tension;
	}
	
	public String toString(){
		return "Tarifa Industrial \nCodigo: " + super.getCodigo() + "\nCargo fijo: " + cargoFijo + ", Cargo variable pico: " + cargoVariablePico
				+ ", Cargo variable valle: " + cargoVariableValle + ", Cargo variable resto: " + cargoVariableResto
				+ "\n tension: " + tension + ", potencia mayor: " + potenciaMayor;
	}

}
