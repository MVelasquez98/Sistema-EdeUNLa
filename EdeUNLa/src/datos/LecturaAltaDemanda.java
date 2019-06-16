package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class LecturaAltaDemanda extends Lectura {

	private int consumoPico;
	private int consumoValle;
	private int consumoResto;

	public LecturaAltaDemanda() {
		super();
	}

	public LecturaAltaDemanda(Medidor medidor, LocalDate fecha, LocalTime hora, Inspector inspector, int consumoPico,
			int consumoValle, int consumoResto) {
		super(medidor, fecha, hora, inspector);
		this.consumoPico = consumoPico;
		this.consumoValle = consumoValle;
		this.consumoResto = consumoResto;
		
	}

	public int getConsumoPico() {
		return consumoPico;
	}

	public void setConsumoPico(int consumoPico) {
		this.consumoPico = consumoPico;
	}

	public int getConsumoValle() {
		return consumoValle;
	}

	public void setConsumoValle(int consumoValle) {
		this.consumoValle = consumoValle;
	}

	public int getConsumoResto() {
		return consumoResto;
	}

	public void setConsumoResto(int consumoResto) {
		this.consumoResto = consumoResto;
	}



	@Override
	public String toString() {
		return super.toString() + ", LecturaAltaDemanda [consumoPico=" + consumoPico + ", consumoValle=" + consumoValle + ", consumoResto="
				+ consumoResto;
	}

	public int calcularPico(Lectura lecturaAnterior) {
		int consumo = 0;
		LecturaAltaDemanda LAD = (LecturaAltaDemanda) lecturaAnterior;
		if (lecturaAnterior.getFecha() != null) {
			consumo = this.consumoPico- LAD.consumoPico;
		} else {
			consumo = this.consumoPico;
		}
		return consumo;
	}

	public int calcularValle(Lectura lecturaAnterior) {
		int consumo = 0;
		LecturaAltaDemanda LAD = (LecturaAltaDemanda) lecturaAnterior;
		if (lecturaAnterior.getFecha() != null) {
			consumo = this.consumoValle- LAD.consumoValle;
		} else {
			consumo = this.consumoValle;
		}
		return consumo;
	}

	public int calcularResto(Lectura lecturaAnterior) {
		int consumo = 0;
		LecturaAltaDemanda LAD = (LecturaAltaDemanda) lecturaAnterior;
		if (lecturaAnterior.getFecha() != null) {
			consumo = this.consumoResto- LAD.consumoResto;
		} else {
			consumo = this.consumoResto;
		}
		return consumo;
	}

	
}
