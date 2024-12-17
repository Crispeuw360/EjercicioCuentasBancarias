package main;

import java.util.HashMap;
import clases.*;
import excepciones.ExcepcionPropia;
import utilidades.Utilidades;

public class MainCuentasBancarias {

	public static int mostrarMenu() {
		System.out.println("1. Introducir nueva cuenta ");
		System.out.println("2. Mostrar Cuenta ");
		System.out.println("3. Insertar Dinero ");
		System.out.println("4. Retirar Dinero");
		System.out.println("5. Obtener dni de las cuentas por nombre de cuenta");
		System.out.println("6. Salir");
		return Utilidades.leerInt();
	}

	public static void introducirNuevaCuenta(HashMap<String, Cuenta> m) {
		String dni, nomCuenta;

		System.out.println("Introduce el dni: ");
		dni = Utilidades.introducirCadena();
		if(m.containsKey(dni))
		{
			System.err.println("Este dni ya existe");
		}

		System.out.println("Introduce el nombre de la Cuenta: ");
		nomCuenta = Utilidades.introducirCadena();

		Cuenta c = new Cuenta(dni, nomCuenta, 0);

		m.put(c.getDni(), c);
	}

	public static void mostrarCuentas(HashMap<String, Cuenta> m) {
		for (Cuenta c : m.values()) {
			System.out.println(c.toString());
		}
	}

	public static void insertarDinero(HashMap<String, Cuenta> m) {
		String dni;
		int sueldoIntro;

		System.out.println("Introduce el Dni: ");
		dni = Utilidades.introducirCadena();

		if (m.containsKey(dni)) {
			sueldoIntro = Utilidades.leerInt("Introduce el saldo que quieres añadir: ", 1, 1000000000);
			m.get(dni).setSaldo(m.get(dni).getSaldo() + sueldoIntro);
		} else {
			System.err.println("introduce un dni valido");
		}
	}

	public static void sacarDinero(HashMap<String, Cuenta> m) {
		String dni;
		int cantidadRetirar;
		boolean ok =false;

		System.out.println("Introduce el dni");
		dni = Utilidades.introducirCadena();

		if (m.containsKey(dni)) 
		{
			cantidadRetirar = Utilidades.leerInt("Cantidad a retirar", 1, 1000000000);
			do {
				try {
					Cuenta cuenta = m.get(dni);
					if (cuenta.getSaldo() < cantidadRetirar) 
					{
						throw new ExcepcionPropia("Saldo insuficiente en la cuenta");
					}
					cuenta.setSaldo(cuenta.getSaldo() - cantidadRetirar);
					System.out.println("Retiro exitoso. Saldo actual: " + cuenta.getSaldo());
					ok =true;
				} catch (ExcepcionPropia e) 
				{
					System.out.println(e.getMessage());
					ok = false;
				} 
			} while (!ok);
		}else
		{
			System.out.println("No existe este dni en la base: ");
		}
	}

	public static void obtenerDniPorNombre(HashMap<String, Cuenta> m) {
		String nombre;

		System.out.println("introduce el nombre a buscar: ");
		nombre = Utilidades.introducirCadena();

		for (Cuenta c : m.values()) 
		{
			if (nombre.equalsIgnoreCase(c.getNomCuenta())) 
			{
				System.out.println(c.getDni());
			} else {
				System.err.println("No se Encontro ese nombre en la base");
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcion;
		HashMap<String, Cuenta> mapa = new HashMap<>();
		
		do {
			switch (opcion = mostrarMenu()) 
			{
			case 1:
				introducirNuevaCuenta(mapa);
				break;

			case 2:
				mostrarCuentas(mapa);
				break;
			case 3:
				insertarDinero(mapa);
				break;
			case 4:
				sacarDinero(mapa);
				break;
			case 5:
				obtenerDniPorNombre(mapa);

				break;
			case 6:
				System.out.println("Agur!");
				break;
			}
		} while (opcion != 6);
	}
}
