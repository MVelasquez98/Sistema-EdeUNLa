package negocio;

import java.time.LocalDate;
import java.time.LocalTime;
import  java.util.List;
import dao.LecturaDao;
import datos.Inspector;
import datos.Lectura;
import datos.Medidor;

public class LecturaABM {
	private static LecturaABM instancia = null;

	public static LecturaABM getInstance (){
		if(instancia == null){
			instancia = new LecturaABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public Lectura traerLectura(int idLectura) throws Exception{
		Lectura c= LecturaDao.getInstance().traerLectura(idLectura);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Lectura con el id indicado");
		}
		return c;
	}

	
	
	public void modificarLectura (Lectura c) throws Exception{
		//implementar excepci�n
		LecturaDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		Lectura c = traerLectura(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe Lectura con el id indicado");
		}
		LecturaDao.getInstance().eliminar(c);
	}
	
	public List<Lectura>traerLecturas(){
		return LecturaDao.getInstance().traerLecturas();
	}
	
	public Lectura traerLectura(Medidor m, int anio, int mes) throws Exception{
		Lectura retorno = null;
		List<Lectura> lecs = LecturaDao.getInstance().traerLecturas(m);
		for(Lectura l : lecs){
			LocalDate fechaLectura = l.getFecha();
			if ((fechaLectura.getMonthValue()==mes) && (fechaLectura.getYear()==anio)){
				retorno = l;
			}
		}
		if (retorno == null){
			throw new Exception ("Error en capa de negocio, no se encontro una lectura para el medidor, mes y a�o indicados");
		}
		return retorno;
	}
}