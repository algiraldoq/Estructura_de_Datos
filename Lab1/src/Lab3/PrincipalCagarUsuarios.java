package Lab3;

import java.util.Scanner;

import Lab2.Direccion;
import Lab2.Fecha;
import Lab2.Usuario;

public class PrincipalCagarUsuarios {

	public static void main(String[] args) {
		Agenda agenda = new Agenda(6);
		// Usuario 1
		Fecha fecha_nacimiento = new Fecha(Short.valueOf("02"), Short.valueOf("01"), Short.valueOf("2002"));
		Direccion direccion_residencia = new Direccion("calle66", "66-66", "VillaHermosa", "Medellín", null, null);
		Usuario usuario = new Usuario("Alejandro Giraldo Quiceno", 1000753146L, fecha_nacimiento, "Medellin",
				3053080620L, "algiraldoq@unal.edu.co", direccion_residencia);
		agenda.Agregar(usuario);

		// Usuario 2
		fecha_nacimiento = new Fecha(Short.valueOf("12"), Short.valueOf("04"), Short.valueOf("2002"));
		direccion_residencia = new Direccion("calle13", "40-23", "Boston", "Medellín", null, null);
		usuario = new Usuario("Omar Garcia", 82364592236L, fecha_nacimiento, "Medellin",
				3214574323L, "ogarcia@unal.edu.co", direccion_residencia);
		agenda.Agregar(usuario);

		// Usuario 3
		fecha_nacimiento = new Fecha(Short.valueOf("03"), Short.valueOf("07"), Short.valueOf("2001"));
		direccion_residencia = new Direccion("calle23", "74-12", "CampoValdez", "Medellín", null, null);
		usuario = new Usuario("Oscar Espinoza", 7936538921L, fecha_nacimiento, "Medellin",
				3014538957L, "oespinoza@unal.edu.co", direccion_residencia);
		agenda.Agregar(usuario);

		// Usuario 4
		fecha_nacimiento = new Fecha(Short.valueOf("14"), Short.valueOf("8"), Short.valueOf("2000"));
		direccion_residencia = new Direccion("carrera 40", "43-65", "VillaHermosa", "Medellín", null, null);
		usuario = new Usuario("Isabella Vanegas", 3969823375L, fecha_nacimiento, "Medellin",
				3116453279L, "ivanegas@unal.edu.co", direccion_residencia);
		agenda.Agregar(usuario);

		// Usuario 5
		fecha_nacimiento = new Fecha(Short.valueOf("30"), Short.valueOf("11"), Short.valueOf("1999"));
		direccion_residencia = new Direccion("calle3", "56-33", "guayabal", "Medellín", null, null);
		usuario = new Usuario("Sofia Morales", 2384657289L, fecha_nacimiento, "Medellin",
				3204658239L, "smorales@unal.edu.co", direccion_residencia);
		agenda.Agregar(usuario);

		Scanner myobj = new Scanner(System.in);
		System.out.println("Ingrese Id que desea buscar:");
		String strId = myobj.nextLine();
		Long id = Long.valueOf(strId);
		Integer posicion = agenda.Buscar(id);
		System.out.println("La posicion de ese usuario es:" + posicion);
		agenda.Tofile();
		myobj.close();
		System.out.println("Se creo un nuevo archivo llamado agenda2 con los usuarios");
	}

}
