import java.util.ArrayList;
import java.util.HashMap;

public class GestorAcademico implements ServiciosAcademicosI {
    private ArrayList<Estudiante> listaEstudiantes;
    private ArrayList<Curso> listaCursos;
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso;

    public GestorAcademico() {
        listaEstudiantes = new ArrayList<>();
        listaCursos = new ArrayList<>();
        estudiantesPorCurso = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        if (!listaEstudiantes.contains(estudiante)) {
            listaEstudiantes.add(estudiante);
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (!listaCursos.contains(curso)) {
            listaCursos.add(curso);
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.getOrDefault(idCurso, new ArrayList<>());
        if (inscritos.contains(estudiante)) {
            throw new EstudianteYaInscritoException("El estudiante ya está inscrito en este curso.");
        }
        inscritos.add(estudiante);
        estudiantesPorCurso.put(idCurso, inscritos);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        if (inscritos == null || inscritos.stream().noneMatch(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en este curso.");
        }
        inscritos.removeIf(e -> e.getId() == idEstudiante);
    }
}
