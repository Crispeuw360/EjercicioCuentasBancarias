package main;
import java.util.HashMap;
import clases.*;
import utilidades.Utilidades;

public class MainCuentasBancarias {
	
	public static int mostrarMenu() 
	{
		System.out.println("1. Introducir nueva cuenta ");
		System.out.println("2. Mostrar Cuenta ");
		System.out.println("3. Insertar Dinero ");
		System.out.println("4. Retirar Dinero");
		System.out.println("5. Obtener dni de las cuentas por nombre de cuenta");
		System.out.println("6. Salir");
		return Utilidades.leerInt();
	}
	
	public static void introducirNuevaCuenta(HashMap<String,Cuenta> m)
	{
		String dni,nomCuenta;
		
		System.out.println("Introduce el dni: ");
		dni = Utilidades.introducirCadena();
		
		System.out.println("Introduce el nombre de la Cuenta: ");
		nomCuenta = Utilidades.introducirCadena();
		
		Cuenta c = new Cuenta(dni,nomCuenta,0);
		
		m.put(c.getDni(), c);
	}
	
	public static void mostrarCuentas(HashMap<String,Cuenta> m)
	{
		for(Cuenta c:m.values())
		{
			System.out.println(c.toString());
		}
	}

	public static void insertarDinero(HashMap<String,Cuenta> m)
	{
		String dni;
		int sueldoIntro;
		
		System.out.println("Introduce el Dni: ");
		dni = Utilidades.introducirCadena();
		
		if(m.containsKey(dni))
		{
			sueldoIntro = Utilidades.leerInt("Introduce el saldo que quieres añadir: ",1, 1000000000);
			m.get(dni).setSaldo(m.get(dni).getSaldo()+sueldoIntro);
		}
		else
		{
			System.out.println("introduce un dni valido");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int opcion;
		
		HashMap<String,Cuenta> mapa = new HashMap<>();
		
		do {
			switch(opcion=mostrarMenu()) 
			{
			case 1:
				introducirNuevaCuenta(mapa);
				break;

			case 2:
				mostrarCuentas(mapa);
				break;
			case 3:
				//alquilar(c,s,dni);
				break;
			case 4:
				//mostrarSocios(s);
				break;
			case 5:
				//	mostrarProfesores(a);

				break;
			case 6:
				System.out.println("Agur!");
				break;
			}
		}while(opcion!=6);
	}

}
