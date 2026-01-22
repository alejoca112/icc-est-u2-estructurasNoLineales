package models;

public class Persona implements Comparable<Persona> {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "[Nombre: " + nombre + " - Edad: " + edad + " ]";
    }

    @Override
    public int compareTo(Persona otraPersona) {
        int res = Integer.compare(this.edad, otraPersona.getEdad());
        if (res != 0) {
            return res;
        }
        return this.nombre.compareTo(otraPersona.getNombre());
    }
}
