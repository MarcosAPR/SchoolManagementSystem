public class Estudiante extends Persona {
    private int id;
    private String estado;  // matriculado, inactivo, graduado

    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, String estado) {
        super(nombre, apellido, fechaDeNacimiento);
        this.id = id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    // Getters y Setters adicionales si los necesitas
}

