package models;

public class Persona {
    String nombre;
    int edad;

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getName(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setName(String nombre){
        this.nombre = nombre;
    }

    public void setEdad(int edad){
        this.edad = edad;
    }

    @Override
    public String toString(){
        return this.nombre + " - " + this.edad;
    }
}
