package Lab2;

import java.util.Scanner;

public class Principal2 {

	public static void main(String[] args) {
		Scanner myobj = new Scanner(System.in);
		System.out.println("Ingrese El dia de nacimiento en numero:");
		String dianacimiento = myobj.nextLine();
		System.out.println("Ingrese El mes de nacimiento en numero:");
		String mesnacimiento = myobj.nextLine();
		System.out.println("Ingrese El año de nacimiento en numero:");
		String añonacimiento = myobj.nextLine();
		Fecha fecha_nacimiento = new Fecha();
		fecha_nacimiento.setA(Short.valueOf(dianacimiento));
		fecha_nacimiento.setMes(Short.valueOf(mesnacimiento));
		fecha_nacimiento.setDia(Short.valueOf(añonacimiento));

		Direccion direccion_residencia = new Direccion();
		
		System.out.println("Ingrese Su calle: (Ejemplo calle 54)");
		String calle = myobj.nextLine();
		System.out.println("Ingrese la nomenclatura de su direccion (Ejmplo 64-34)");
		String nomenclatura = myobj.nextLine();
		System.out.println("Ingrese Su barrio:");
		String barrio = myobj.nextLine();
		System.out.println("Ingrese Su Ciudad:");
		String ciudad = myobj.nextLine();
		System.out.println("¿Vive en edificio? responda 'Si' o 'NO'");
		String pregunta = myobj.nextLine();
		if(pregunta.equalsIgnoreCase("Si")) {
			System.out.println("Nombre edificio:");
			String edificio = myobj.nextLine();
			direccion_residencia.setEdificio(edificio);
			System.out.println("# de Apartamento:");
			String apt = myobj.nextLine();
			direccion_residencia.setApto(apt);
		}else {
			direccion_residencia.setEdificio(null);
			direccion_residencia.setApto(null);
		}
		
		direccion_residencia.setCalle(calle);
		direccion_residencia.setNomenclatura(nomenclatura);
		direccion_residencia.setBarrio(barrio);
		direccion_residencia.setCiudad(ciudad);
		
		Usuario usuario = new Usuario();
		System.out.println("Digite su nombre:");
		String nombre = myobj.nextLine();
		usuario.setNombre(nombre);
		System.out.println("Digite su #identificacion:");
		String id = myobj.nextLine();
		usuario.setId(Long.valueOf(id));
		System.out.println("Digite su ciudad de nacimiento:");
		String ciudad_nacimiento = myobj.nextLine();
		usuario.setCiudad_nacimiento(ciudad_nacimiento);
		System.out.println("Digite su telefono:");
		String telefono = myobj.nextLine();
		usuario.setTel(Long.valueOf(telefono));
		System.out.println("Digite su email:");
		String email = myobj.nextLine();
		usuario.setEmail(email);
		usuario.setFecha_nacimiento(fecha_nacimiento);
		usuario.setDir(direccion_residencia);
		
		myobj.close();
		
		System.out.println(usuario.toString());
	}

}
