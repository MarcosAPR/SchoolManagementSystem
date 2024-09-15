public class Main {
    public static void main(String[] args) {
        GestorAcademico gestor = new GestorAcademico();

        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "2000-01-15", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "María", "López", "1999-11-20", "matriculado");

        Curso curso1 = new Curso(1, "Matemáticas", "Curso básico de matemáticas", 3, "1.0");
        Curso curso2 = new Curso(2, "Programación", "Curso de introducción a la programación", 4, "1.0");

        gestor.matricularEstudiante(estudiante1);
        gestor.matricularEstudiante(estudiante2);
        gestor.agregarCurso(curso1);
        gestor.agregarCurso(curso2);

        try {
            gestor.inscribirEstudianteCurso(estudiante1, 1);
            gestor.inscribirEstudianteCurso(estudiante2, 2);
        } catch (EstudianteYaInscritoException e) {
            e.printStackTrace();
        }
    }
}
