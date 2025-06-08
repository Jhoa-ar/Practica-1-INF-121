package EJERCICIO1;

import java.io.*;
import java.util.ArrayList;

public class ArchivoEmpleado {
    private String nomA;

    public ArchivoEmpleado(String nomA) {
        this.nomA = nomA;
    }

    public void crearArchivo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.nomA))) {
            System.out.println("Archivo creado: " + nomA);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guardarEmpleado(Empleado e) {
        ArrayList<Empleado> empleados = leerEmpleados();
        empleados.add(e);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomA))) {
            out.writeObject(empleados);
            System.out.println("Empleado guardado: " + e.nombre);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Empleado buscaEmpleado(String nombre) {
        ArrayList<Empleado> empleados = leerEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);
            if (e.nombre.equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public Empleado mayorSalario(float sueldo) {
        ArrayList<Empleado> empleados = leerEmpleados();
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);
            if (e.salario > sueldo) {
                return e;
            }
        }
        return null;
    }

    private ArrayList<Empleado> leerEmpleados() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomA))) {
            return (ArrayList<Empleado>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
