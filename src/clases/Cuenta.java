package clases;

public class Cuenta {

	private String dni;
	private String nomCuenta;
	private int saldo;
	
	public Cuenta()
	{
		this.dni="";
		this.nomCuenta="";
		this.saldo=0;
	}
	public Cuenta(String d, String n,int s)
	{
		this.dni=d;
		this.nomCuenta=n;
		this.saldo=s;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNomCuenta() {
		return nomCuenta;
	}
	public void setNomCuenta(String nomCuenta) {
		this.nomCuenta = nomCuenta;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [dni=" + dni + ", nomCuenta=" + nomCuenta + ", saldo=" + saldo + "]";
	}
	
}
