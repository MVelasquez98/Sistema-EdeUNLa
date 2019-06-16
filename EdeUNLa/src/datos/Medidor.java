package datos;

public class Medidor {

	private int idMedidor;
	private int nroSerie;
	private Cliente cliente;
	private String direccion;
	private Zona zona;
	private boolean esBaja;
	private Tarifa tarifa;
	

	public Medidor() {
		super();
	}
	
	public Medidor(int nroSerie, Cliente cliente, String direccion, Zona zona, boolean esBaja, Tarifa tarifa) {
		super();
		this.nroSerie = nroSerie;
		this.cliente = cliente;
		this.direccion = direccion;
		this.zona = zona;
		this.esBaja = esBaja;
		this.setTarifa(tarifa);
	}

	
	public int getIdMedidor() {
		return idMedidor;
	}

	public void setIdMedidor(int idMedidor) {
		this.idMedidor = idMedidor;
	}

	public boolean isEsBaja() {
		return esBaja;
	}

	public void setEsBaja(boolean esBaja) {
		this.esBaja = esBaja;
	}

	public int getNroSerie() {
		return nroSerie;
	}

	public void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Tarifa getTarifa() {
		return tarifa;
	}

	public void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}

	@Override
	public String toString() {
		String retorno = "Medidor " + nroSerie;
		retorno += "\nDireccion: " + direccion;
		retorno += ", Zona " + zona.getNombre();
		retorno += "\ncliente cuil/cuit: " + cliente.getCuil_cuit();
		retorno += "\n\n" + tarifa.toString();
		return retorno;
	}
	
	
}
