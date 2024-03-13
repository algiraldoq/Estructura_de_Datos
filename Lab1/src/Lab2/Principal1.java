package Lab2;

public class Principal1 {

	public static void main(String[] args) {
		Fecha fecha_nacimiento = new Fecha(Short.valueOf("02"), Short.valueOf("01"), Short.valueOf("2002"));
//		fecha_nacimiento.setA(Short.valueOf("20002"));
//		fecha_nacimiento.setMes(Short.valueOf("01"));
//		fecha_nacimiento.setDia(Short.valueOf("02"));

		Direccion direccion_residencia = new Direccion("calle66", "66-66", "VillaHermosa", "Medellín", null, null);
//		direccion_residencia.setCalle("calle 66");
//		direccion_residencia.setNomenclatura("66-66");
//		direccion_residencia.setBarrio("VillaHermosa");
//		direccion_residencia.setCiudad("Medellín");
//		direccion_residencia.setEdificio(null);
//		direccion_residencia.setApto(null);

		Usuario usuario = new Usuario("Alejandro Giraldo Quiceno", 1000753146L, fecha_nacimiento, "Medellin",
				3053080620L, "algiraldoq@unal.edu.co", direccion_residencia);
		
		System.out.println(usuario.toString());
	}

}
