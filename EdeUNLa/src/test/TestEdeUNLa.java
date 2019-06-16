package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import datos.*;
import negocio.*;

public class TestEdeUNLa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// CREO UN CLIENTE y CONTACTO
		System.out.println("\n\n CREO UN CLIENTE y CONTACTO");
		try {
			int idCliente = ClienteABM.getInstance().agregar("20-36161871-9");
			int idContacto = ContactoABM.getInstance().agregar("A.Barbier 1234", "4235900", "ma@gmail.com",
					ClienteABM.getInstance().traerCliente("20-36161871-9"));
			Cliente c = ClienteABM.getInstance().TraerClienteYContacto(idCliente);
			System.out.println(c.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// AGREGAR OTRO CLIENTE

		try {
			int idCliente = ClienteABM.getInstance().agregar("27-36409153-8");
			int idContacto = ContactoABM.getInstance().agregar("mendoza 119", "42942088", "mail@gmail.com",
					ClienteABM.getInstance().traerCliente("27-36409153-8"));
			Cliente c = ClienteABM.getInstance().TraerClienteYContacto(idCliente);
			System.out.println(c.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n AGREGO INSPECTORES Y ZONA");
		try {
			// CREO INSPECTORES
			InspectorABM.getInstance().agregar("0-12345678-9");
			InspectorABM.getInstance().agregar("9-87654321-0");

			// CREO ZONA
			ZonaABM.getInstance().agregar("SUR");

			// AGREGO INSPECTORES A LA ZONA

			Zona z = ZonaABM.getInstance().traerZona("SUR");
			Set<Inspector> inspectoresZona = new HashSet<>();
			inspectoresZona.add(InspectorABM.getInstance().traerInspector(1));
			inspectoresZona.add(InspectorABM.getInstance().traerInspector(2));
			z.setInspectores(inspectoresZona);
			ZonaABM.getInstance().modificarZona(z);

			System.out.println(z.toString());
			for (Inspector i : z.getInspectores()) {
				System.out.println(i.toString());
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// CREO TARIFAS
		System.out.println("\n\n CREO TARIFAS");
		try {
			TarifaResidencialABM.getInstance().agregar("T1-R10-150", 32, 2);
			TarifaResidencialABM.getInstance().agregar("T1-R2-151-326", 56, 2);
			TarifaResidencialABM.getInstance().agregar("T1-R3-326-400", 91, 2);
			TarifaResidencialABM.getInstance().agregar("T1-R4-401-450", 107, 2);
			TarifaResidencialABM.getInstance().agregar("T1-R5-450-500", 161, 2);
			TarifaResidencialABM.getInstance().agregar("T1-R6-501-600", 316, 2);
			TarifaResidencialABM.getInstance().agregar("T1-R7-601-700", 850, 3);
			TarifaResidencialABM.getInstance().agregar("T1-R8-701-1400", 1203, 3);
			TarifaResidencialABM.getInstance().agregar("T1-R9 + 1400", 1442, 3);

			TarifaIndustrialABM.getInstance().agregar("TIN1", false, "BT", 3226, 2, 2, 2);
			TarifaIndustrialABM.getInstance().agregar("TIN2", false, "MT", 3226, 2, 2, 1);
			TarifaIndustrialABM.getInstance().agregar("TIN3", false, "AT", 3224, 2, 1, 1);
			TarifaIndustrialABM.getInstance().agregar("TIN4", true, "BT", 3226, 3, 3, 2);
			TarifaIndustrialABM.getInstance().agregar("TIN5", true, "MT", 3226, 3, 2, 2);
			TarifaIndustrialABM.getInstance().agregar("TIN6", true, "AT", 3224, 2, 2, 2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// CREO MEDIDORES
		System.out.println("\n\n CREO MEDIDORES");

		try {
			Cliente c = ClienteABM.getInstance().traerCliente("20-36161871-9");
			Zona z = ZonaABM.getInstance().traerZona("SUR");
			TarifaResidencial tr = TarifaResidencialABM.getInstance().traerTarifaResidencial("T1-R10-150");
			TarifaIndustrial ti = TarifaIndustrialABM.getInstance().traerTarifaIndustrial("TIN1");
			int idMedidor1 = MedidorABM.getInstance().agregar(12345, c, "calle falsa 123", z, false, tr);
			int idMedidor2 = MedidorABM.getInstance().agregar(45678, c, "calle falsa 124", z, false, ti);

			System.out.println(MedidorABM.getInstance().traerMedidorPorNumero(12345).toString());
			System.out.println("-------------------------------------------------------------");
			System.out.println(MedidorABM.getInstance().traerMedidorPorNumero(45678).toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// AGREGO LECTURAS
		try {
			System.out.println("\n\n CREO LECTURAS");
			int idLecturaBaja = LecturaBajaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(12345), LocalDate.of(2019, 06, 15),
					LocalTime.of(12, 00), InspectorABM.getInstance().traerInspector("0-12345678-9"), 1000);
			int idLecturaBaja2 = LecturaBajaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(12345), LocalDate.of(2019, 04, 15),
					LocalTime.of(12, 00), InspectorABM.getInstance().traerInspector("0-12345678-9"), 500);
			int idLecturaBaja3 = LecturaBajaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(12345), LocalDate.of(2019, 02, 15),
					LocalTime.of(12, 00), InspectorABM.getInstance().traerInspector("0-12345678-9"), 250);
			int idLecturaAlta = LecturaAltaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(45678), LocalDate.of(2019, 06, 15),
					LocalTime.of(9, 00), InspectorABM.getInstance().traerInspector("9-87654321-0"), 700, 70, 20);
			int idLecturaAlta2 = LecturaAltaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(45678), LocalDate.of(2019, 04, 15),
					LocalTime.of(9, 00), InspectorABM.getInstance().traerInspector("9-87654321-0"), 500, 50, 20);
			int idLecturaAlta3 = LecturaAltaDemandaABM.getInstance().agregar(
					MedidorABM.getInstance().traerMedidorPorNumero(45678), LocalDate.of(2019, 02, 15),
					LocalTime.of(9, 00), InspectorABM.getInstance().traerInspector("9-87654321-0"), 400, 40, 10);

			System.out.println(LecturaBajaDemandaABM.getInstance().traerLecturaBajaDemanda(idLecturaBaja).toString());
			System.out.println("-------------------------------------------------------------");
			System.out.println(LecturaAltaDemandaABM.getInstance().traerLecturaAltaDemanda(idLecturaAlta).toString());
			System.out.println("-------------------------------------------------------------");
			System.out.println("-------------------------------------------------------------");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n Lista de lecturas para el medidor nro: " + 12345);

		for (Lectura l : LecturaBajaDemandaABM.getInstance().traerLecturaBajaDemanda(12345)) {
			System.out.println(l.toString());
		}

		// GENERO FACTURA
		System.out.println("\n\n GENERO FACTURA");
		try {
			Factura factura1 = FacturaABM.getInstance().generarFactura(12345, 7, 2019);
			int idUltimaFactura = FacturaABM.getInstance().agregar(factura1.getNroMedidor(), factura1.getDireccion(),
					factura1.getFecha(), factura1.getTotalPagar(), factura1.getObservaciones(),
					factura1.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura1.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(12345, 07, 2019).toString());

			System.out.println("\n");

			Factura factura2 = FacturaABM.getInstance().generarFactura(12345, 8, 2019);
			idUltimaFactura = FacturaABM.getInstance().agregar(factura2.getNroMedidor(), factura2.getDireccion(),
					factura2.getFecha(), factura2.getTotalPagar(), factura2.getObservaciones(),
					factura2.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura2.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(12345, 8, 2019).toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n\n GENERO FACTURA DE MEDIDOR ALTA DEMANDA");
		try {
			Factura factura1 = FacturaABM.getInstance().generarFactura(45678, 7, 2019);
			int idUltimaFactura = FacturaABM.getInstance().agregar(factura1.getNroMedidor(), factura1.getDireccion(),
					factura1.getFecha(), factura1.getTotalPagar(), factura1.getObservaciones(),
					factura1.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura1.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(45678, 07, 2019).toString());

			System.out.println("\n");

			Factura factura2 = FacturaABM.getInstance().generarFactura(45678, 8, 2019);
			idUltimaFactura = FacturaABM.getInstance().agregar(factura2.getNroMedidor(), factura2.getDireccion(),
					factura2.getFecha(), factura2.getTotalPagar(), factura2.getObservaciones(),
					factura2.getIdCliente());
			ItemFacturaABM.getInstance().agregar(factura2.getLstItem(),
					FacturaABM.getInstance().traerFactura(idUltimaFactura));
			System.out.println(FacturaABM.getInstance().traerFacturaCompleta(45678, 8, 2019).toString());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
