package EJERCICIO1;

import java.io.Serializable;

public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    public String nombre;
    public int edad;
    public float salario;

    public Empleado(String nombre, int edad, float salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String toString() {
        return "Empleado nombre=" + nombre + ", edad=" + edad + ", salario=" + salario + " ";
    }
}
