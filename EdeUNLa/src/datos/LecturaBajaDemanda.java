package datos;

import java.time.LocalDate;
import java.time.LocalTime;

public class LecturaBajaDemanda extends Lectura {

	private int consumo;

	public LecturaBajaDemanda() {
		super();
	}

	public LecturaBajaDemanda(Medidor medidor, LocalDate fecha, LocalTime hora, Inspector inspector, int consumo) {
		super(medidor, fecha, hora, inspector);
		this.consumo = consumo;
	}

	public void setConsumo(int consumo) {
		this.consumo = consumo;
	}

	public int getConsumo() {
		return consumo;
	}

	
	@Override
	public String toString() {
		return super.toString() + ", LecturaBajaDemanda [consumo=" + consumo + "]";
	}

	public int calcularConsumo(Lectura lecturaAnterior) {
		int consumo = 0;
		LecturaBajaDemanda LBD = (LecturaBajaDemanda) lecturaAnterior;
		if (lecturaAnterior.getFecha() != null) {
			consumo = (this.consumo) - LBD.getConsumo();
		} else {
			consumo = this.getConsumo();
		}
		return consumo;
	}
}
