package negocio;

import  java.util.List;
import dao.TarifaResidencialDao;
import datos.TarifaResidencial;


public class TarifaResidencialABM {

	
	private static TarifaResidencialABM instancia = null;

	public static TarifaResidencialABM getInstance (){
		if(instancia == null){
			instancia = new TarifaResidencialABM();
		}
		return instancia;
	}

	
	//Traer por clacve primaria

	public TarifaResidencial traerTarifaResidencial(int idTarifaResidencial) throws Exception{
		TarifaResidencial c= TarifaResidencialDao.getInstance().traerTarifaResidencial(idTarifaResidencial);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe TarifaResidencial con el id indicado");
		}
		return c;
	}

	
	//Traer por codigo
	public TarifaResidencial traerTarifaResidencial(String codigo) throws Exception{
		TarifaResidencial c= TarifaResidencialDao.getInstance().traerTarifaResidencial(codigo);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe TarifaResidencial con el codigo indicado");
		}
		return c;
	}
	
	
	public int agregar(String codigo, int montoMinimo, int cargoVariable) throws Exception{
		TarifaResidencial t = TarifaResidencialDao.getInstance().traerTarifaResidencial(codigo);
		if(t != null){
			throw new Exception ("Error en la capa de negocio, ya existe TarifaResidencial con el codigo indicado");
		}
		TarifaResidencial c = new TarifaResidencial( codigo,  montoMinimo, cargoVariable);
		return TarifaResidencialDao.getInstance().agregar(c);					//devuelve id agregado
	}
	
	public void modificarTarifaResidencial (TarifaResidencial c) throws Exception{
		//implementar excepción
		TarifaResidencialDao.getInstance().actualizar(c);
	}
	
	public void eliminar(int pk) throws Exception {
		TarifaResidencial c = traerTarifaResidencial(pk);
		if (c== null){
			throw new Exception ("Error en la capa de negocio, no existe TarifaResidencial con el id indicado");
		}
		TarifaResidencialDao.getInstance().eliminar(c);
	}
	
	public List<TarifaResidencial>traerTarifaResidencial(){
		return TarifaResidencialDao.getInstance().traerTarifaResidencial();
	}
}
