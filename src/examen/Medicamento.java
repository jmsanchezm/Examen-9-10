package examen;

import java.util.TreeSet;

public class Medicamento implements Comparable<Medicamento> {

	/**
	 * Se guardará el codigo del medicamento
	 */
	private int codigo = 0;

	/**
	 * Se guardará el nombre del medicamento
	 */
	private String nombre = "";

	/**
	 * Se guardará la descripción del medicamento
	 */
	private String descripcion = "";

	/**
	 * Se guardará el precio del medicamento
	 */
	private double precio = 0;

	/**
	 * Se guardarán las instrucciones del medicamento
	 */
	private String posologia = "";

	/**
	 * Constructor por defecto
	 */
	public Medicamento() {
		super();
	}

	/**
	 * Constructor sólo con el código
	 * 
	 * @param codigo
	 */
	public Medicamento(int codigo) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	/**
	 * Constructor con todos los parametros
	 * 
	 * @param codigo
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @param posologia
	 */
	public Medicamento(int codigo, String nombre, String descripcion, double precio, String posologia) {
		super();
		if (codigo > 0) {
			this.codigo = codigo;
		}
		if (!nombre.isEmpty()) {
			this.nombre = nombre;
		}
		if (!descripcion.isEmpty()) {
			this.descripcion = descripcion;
		}
		if (precio > 0) {
			this.precio = precio;
		}
		if (!posologia.isEmpty()) {
			this.posologia = posologia;
		}
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		if (codigo > 0) {
			this.codigo = codigo;
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		if (!nombre.isEmpty()) {
			this.nombre = nombre;
		}
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		if (!descripcion.isEmpty()) {
			this.descripcion = descripcion;
		}
	}

	/**
	 * @return the precio
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(double precio) {
		if (precio > 0) {
			this.precio = precio;
		}
	}

	/**
	 * @return the posologia
	 */
	public String getPosologia() {
		return posologia;
	}

	/**
	 * @param posologia the posologia to set
	 */
	public void setPosologia(String posologia) {
		if (!posologia.isEmpty()) {
			this.posologia = posologia;
		}
	}

	/**
	 * Método toString
	 */
	@Override
	public String toString() {
		String result = "";
		result += "Código: " + codigo;
		result += "\nNombre: " + nombre;
		result += "\nDescripcion: " + descripcion;
		result += "\nPrecio: " + precio;
		result += "\nPosología: " + posologia;
		return result;
	}

	/**
	 * Método equals
	 */
	public boolean equals(Object o) {
		boolean result = false;
		Medicamento med = (Medicamento) o;
		if (codigo == med.codigo) {
			result = true;
		}
		return result;
	}

	/**
	 * Método compareTo
	 * @param o
	 * @return
	 */
	public int compareTo(Medicamento med) {
		int result = 0;

		result = codigo - med.codigo;

		return result;
	}

}
