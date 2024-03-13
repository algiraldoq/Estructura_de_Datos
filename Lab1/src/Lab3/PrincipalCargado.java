package Lab3;

import java.util.Scanner;

public class PrincipalCargado {

	public static void main(String[] args) {
		Agenda agenda = new Agenda(10);
		agenda.Import();
		
		
		for (int i = 0; i< agenda.usuarios.length; i++) {
			if(agenda.usuarios[i] != null) {
				System.out.println(agenda.usuarios[i].toString());
			}
		}
		
		Scanner myobj = new Scanner(System.in);
		System.out.println("Ingrese numero de id para Eliminar Usuario:");
		String strId = myobj.nextLine();
		Long id = Long.valueOf(strId);
		agenda.Eliminar(id);
		agenda.Tofile();
		myobj.close();
		System.out.println("Se creo un nuevo archivo llamado agenda2 con los usuarios actualizados");
	}

}
