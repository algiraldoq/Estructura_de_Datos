package Lab3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Lab2.Direccion;
import Lab2.Fecha;
import Lab2.Usuario;

public class Agenda {

	public Usuario[] usuarios;
	private Integer nro_reg;

	public Agenda(Integer capacity) {
		super();
		this.usuarios = new Usuario[capacity];
		this.nro_reg = 0;
	}

	public Boolean Agregar(Usuario u) {
		Integer existe = Buscar(u.getId());
		if (existe != -1) {
			return Boolean.FALSE;
		} else {
			if (usuarios.length > nro_reg && nro_reg != 0) {
				usuarios[nro_reg + 1] = u;
				nro_reg++;
				return Boolean.TRUE;
			} else if (usuarios.length > nro_reg && nro_reg == 0) {
				usuarios[nro_reg] = u;
				nro_reg++;
				return Boolean.TRUE;
			} else {
				return Boolean.FALSE;
			}
		}
	}

	public Integer Buscar(Long id) {
		Integer buscar = -1;
		Integer contadorTemp = 0;
		if (usuarios != null && usuarios[0] != null) {
			while (usuarios.length > 0 && contadorTemp < nro_reg) {

				if (usuarios[contadorTemp] != null && usuarios[contadorTemp].getId().compareTo(id) == 0) {
					buscar = contadorTemp;
					return buscar;
				}

				contadorTemp++;
			}
		}
		return buscar;
	}

	public Boolean Eliminar(Long id) {
		Integer existe = Buscar(id);
		if (existe < 0 || existe > nro_reg) {
			return Boolean.FALSE;
		} else {
//			Usuario temp = usuarios[existe];
			for (Integer j = existe; j < nro_reg - 1; j++) {
				usuarios[j] = usuarios[j + 1];
			}
			if (nro_reg > 0) {
				usuarios[nro_reg - 1] = null;
				nro_reg--;
			}
		}

		return Boolean.TRUE;
	}

	public void Tofile() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/EstructuraDeDatos/Lab1/src/Archivos/Agenda2.txt";
			File file = new File(ruta);
			// Si el archivo no existe es creado
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Usuario u : usuarios) {
				if (u != null) {
					bw.write(u.toString() +"\n");
				}
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Import() {
		try {
			String ruta = "/home/artifex/Documents/Universidad/EstructuraDeDatos/Lab1/src/Archivos/Agenda.txt";
			File file = new File(ruta);
			FileReader fr = new FileReader(file);
			BufferedReader entrada = new BufferedReader(fr);
			String s;
			try {
				while ((s = entrada.readLine()) != null) {
					String usuario[] = s.split(", ");
					String fecha[] = usuario[2].split("/");
					Fecha fecha_nacimiento = new Fecha(Short.valueOf(fecha[0]), Short.valueOf(fecha[1]),
							Short.valueOf(fecha[2]));
					String direccion[] = usuario[6].split(" ");
					Direccion dir;
					if (direccion.length == 4) {
						dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], null, null);
					} else {
						dir = new Direccion(direccion[0], direccion[1], direccion[2], direccion[3], direccion[4],
								direccion[5]);
					}
					Usuario u = new Usuario(usuario[0], Long.valueOf(usuario[1]), fecha_nacimiento, usuario[3],
							Long.valueOf(usuario[4]), usuario[5], dir);
					Agregar(u);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
