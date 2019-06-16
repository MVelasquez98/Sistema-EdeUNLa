package test;

import negocio.FacturaABM;
import negocio.ItemFacturaABM;

public class Asd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			ItemFacturaABM.getInstance().agregar("asd", 1.5, 2, "asd", FacturaABM.getInstance().traerFactura(1));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}

	}

}
