package feriaempresarial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase principal encargada de gestionar la Feria Empresarial.
 *
 * Permite registrar empresas, stands y visitantes.
 * También administra las visitas, comentarios y reportes.
 */
public class FeriaEmpresarial {

    private String nombreFeria;

    private ArrayList<Empresa> empresas;
    private ArrayList<Stand> stands;
    private ArrayList<Visitante> visitantes;
    private ArrayList<Comentario> comentarios;

    // Guarda los stands visitados por cada visitante.
    private Map<Visitante, ArrayList<Stand>> visitas;

    // Guarda los comentarios realizados en cada stand.
    private Map<Stand, ArrayList<Comentario>> comentariosPorStand;

    /**
     * Constructor de la clase FeriaEmpresarial.
     *
     * @param nombreFeria nombre de la feria
     */
    public FeriaEmpresarial(String nombreFeria) {
        this.nombreFeria = nombreFeria;

        empresas = new ArrayList<>();
        stands = new ArrayList<>();
        visitantes = new ArrayList<>();
        comentarios = new ArrayList<>();

        visitas = new HashMap<>();
        comentariosPorStand = new HashMap<>();
    }

    /**
     * Registra una nueva empresa.
     *
     * @param empresa empresa que se desea registrar
     */
    public void registrarEmpresa(Empresa empresa) {

        if (empresa == null) {
            System.out.println("No se puede registrar una empresa vacía.");
            return;
        }

        if (buscarEmpresa(empresa.obtenerNombre()) != null) {
            System.out.println("Ya existe una empresa con ese nombre.");
            return;
        }

        empresas.add(empresa);
        System.out.println("Empresa registrada correctamente.");
    }

    /**
     * Edita el correo electrónico de una empresa.
     *
     * @param nombreEmpresa nombre de la empresa
     * @param nuevoCorreo nuevo correo electrónico
     */
    public void editarEmpresa(String nombreEmpresa, String nuevoCorreo) {

        Empresa empresa = buscarEmpresa(nombreEmpresa);

        if (empresa == null) {
            System.out.println("Empresa no encontrada.");
            return;
        }

        empresa.cambiarCorreo(nuevoCorreo);
        System.out.println("Empresa actualizada correctamente.");
    }

    /**
     * Elimina una empresa.
     *
     * @param nombreEmpresa nombre de la empresa
     */
    public void eliminarEmpresa(String nombreEmpresa) {

        Empresa empresa = buscarEmpresa(nombreEmpresa);

        if (empresa == null) {
            System.out.println("Empresa no encontrada.");
            return;
        }

        // Si la empresa tiene un stand, se libera.
        for (Stand stand : stands) {
            if (stand.obtenerEmpresaAsignada() == empresa) {
                stand.asignarEmpresa(null);
            }
        }

        empresas.remove(empresa);
        System.out.println("Empresa eliminada correctamente.");
    }

    /**
     * Registra un nuevo stand.
     *
     * @param stand stand que se desea registrar
     */
    public void registrarStand(Stand stand) {

        if (stand == null) {
            System.out.println("No se puede registrar un stand vacío.");
            return;
        }

        if (buscarStand(stand.obtenerNumeroUnico()) != null) {
            System.out.println("Ya existe un stand con ese número.");
            return;
        }

        stands.add(stand);
        comentariosPorStand.put(stand, new ArrayList<Comentario>());

        System.out.println("Stand registrado correctamente.");
    }

    /**
     * Registra un nuevo visitante.
     *
     * @param visitante visitante que se desea registrar
     */
    public void registrarVisitante(Visitante visitante) {

        if (visitante == null) {
            System.out.println("No se puede registrar un visitante vacío.");
            return;
        }

        if (buscarVisitante(visitante.obtenerIdentificacion()) != null) {
            System.out.println("Ya existe un visitante con esa identificación.");
            return;
        }

        visitantes.add(visitante);
        visitas.put(visitante, new ArrayList<Stand>());

        System.out.println("Visitante registrado correctamente.");
    }

    /**
     * Edita el correo electrónico de un visitante.
     *
     * @param identificacion identificación del visitante
     * @param nuevoCorreo nuevo correo electrónico
     */
    public void editarVisitante(String identificacion, String nuevoCorreo) {

        Visitante visitante = buscarVisitante(identificacion);

        if (visitante == null) {
            System.out.println("Visitante no encontrado.");
            return;
        }

        visitante.cambiarCorreo(nuevoCorreo);
        System.out.println("Visitante actualizado correctamente.");
    }

    /**
     * Elimina un visitante.
     *
     * @param identificacion identificación del visitante
     */
    public void eliminarVisitante(String identificacion) {

        Visitante visitante = buscarVisitante(identificacion);

        if (visitante == null) {
            System.out.println("Visitante no encontrado.");
            return;
        }

        visitas.remove(visitante);
        visitantes.remove(visitante);

        System.out.println("Visitante eliminado correctamente.");
    }

    /**
     * Asigna una empresa a un stand.
     *
     * @param nombreEmpresa nombre de la empresa
     * @param numeroStand número del stand
     */
    public void asignarStand(String nombreEmpresa, int numeroStand) {

        Empresa empresa = buscarEmpresa(nombreEmpresa);
        Stand stand = buscarStand(numeroStand);

        if (empresa == null) {
            System.out.println("Empresa no encontrada.");
            return;
        }

        if (stand == null) {
            System.out.println("Stand no encontrado.");
            return;
        }

        if (!stand.estaDisponible()) {
            System.out.println("El stand ya está ocupado.");
            return;
        }

        stand.asignarEmpresa(empresa);

        System.out.println("Stand asignado correctamente a "
                + empresa.obtenerNombre() + ".");
    }

    /**
     * Registra la visita de un visitante a un stand.
     *
     * @param identificacion identificación del visitante
     * @param numeroStand número del stand visitado
     */
    public void registrarVisita(String identificacion, int numeroStand) {

        Visitante visitante = buscarVisitante(identificacion);
        Stand stand = buscarStand(numeroStand);

        if (visitante == null) {
            System.out.println("Visitante no encontrado.");
            return;
        }

        if (stand == null) {
            System.out.println("Stand no encontrado.");
            return;
        }

        ArrayList<Stand> standsVisitados = visitas.get(visitante);

        if (standsVisitados.contains(stand)) {
            System.out.println("El visitante ya ha registrado una visita a este stand.");
            return;
        }

        standsVisitados.add(stand);

        System.out.println("Visita registrada correctamente.");
    }

    /**
     * Agrega un comentario a la lista general de comentarios.
     *
     * @param comentario comentario realizado por un visitante
     */
    public void agregarComentario(Comentario comentario) {

        if (comentario == null) {
            System.out.println("No se puede agregar un comentario vacío.");
            return;
        }

        comentarios.add(comentario);
    }

    /**
     * Registra un comentario realizado por un visitante
     * sobre un stand específico.
     *
     * @param numeroStand número del stand
     * @param comentario comentario realizado
     */
    public void registrarComentario(int numeroStand, Comentario comentario) {

        Stand stand = buscarStand(numeroStand);

        if (stand == null) {
            System.out.println("Stand no encontrado.");
            return;
        }

        if (comentario == null) {
            System.out.println("Comentario inválido.");
            return;
        }

        agregarComentario(comentario);

        if (!comentariosPorStand.containsKey(stand)) {
            comentariosPorStand.put(stand, new ArrayList<Comentario>());
        }

        comentariosPorStand.get(stand).add(comentario);

        System.out.println("Comentario registrado correctamente.");
    }

    /**
     * Muestra todos los stands disponibles.
     */
    public void mostrarStandsDisponibles() {

        System.out.println("\n===== STANDS DISPONIBLES =====");

        boolean hayDisponibles = false;

        for (Stand stand : stands) {
            if (stand.estaDisponible()) {
                System.out.println(stand);
                hayDisponibles = true;
            }
        }

        if (!hayDisponibles) {
            System.out.println("No hay stands disponibles.");
        }
    }

    /**
     * Muestra todos los stands ocupados.
     */
    public void mostrarStandsOcupados() {

        System.out.println("\n===== STANDS OCUPADOS =====");

        boolean hayOcupados = false;

        for (Stand stand : stands) {
            if (!stand.estaDisponible()) {
                System.out.println(stand);
                hayOcupados = true;
            }
        }

        if (!hayOcupados) {
            System.out.println("No hay stands ocupados.");
        }
    }

    /**
     * Muestra los comentarios y calificaciones de un stand.
     *
     * @param numeroStand número del stand
     */
    public void mostrarComentariosStand(int numeroStand) {

        Stand stand = buscarStand(numeroStand);

        if (stand == null) {
            System.out.println("Stand no encontrado.");
            return;
        }

        System.out.println("\n===== COMENTARIOS DEL STAND "
                + numeroStand + " =====");

        ArrayList<Comentario> lista = comentariosPorStand.get(stand);

        if (lista == null || lista.isEmpty()) {
            System.out.println("Este stand todavía no tiene comentarios.");
            return;
        }

        for (Comentario comentario : lista) {
            System.out.println(comentario);
        }
    }

    /**
     * Genera un reporte de todas las empresas y sus stands asignados.
     */
    public void reporteEmpresasYStands() {

        System.out.println("\n========================================");
        System.out.println("       REPORTE DE EMPRESAS Y STANDS");
        System.out.println("========================================");

        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas.");
            return;
        }

        for (Empresa empresa : empresas) {

            System.out.println("\nEmpresa: " + empresa.obtenerNombre());
            System.out.println("Sector: " + empresa.obtenerSector());
            System.out.println("Correo: " + empresa.obtenerCorreoElectronico());

            boolean tieneStand = false;

            for (Stand stand : stands) {

                if (stand.obtenerEmpresaAsignada() == empresa) {

                    System.out.println("Stand asignado: "
                            + stand.obtenerNumeroUnico());

                    System.out.println("Ubicación: "
                            + stand.obtenerUbicacion());

                    System.out.println("Tamaño: "
                            + stand.obtenerTamano());

                    tieneStand = true;
                }
            }

            if (!tieneStand) {
                System.out.println("Sin stand asignado.");
            }
        }
    }

    /**
     * Genera un reporte de visitantes y los stands que han visitado.
     */
    public void reporteVisitantesYStands() {

        System.out.println("\n========================================");
        System.out.println("     REPORTE DE VISITANTES Y STANDS");
        System.out.println("========================================");

        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
            return;
        }

        for (Visitante visitante : visitantes) {

            System.out.println("\nVisitante: "
                    + visitante.obtenerNombre());

            System.out.println("Identificación: "
                    + visitante.obtenerIdentificacion());

            System.out.println("Correo: "
                    + visitante.obtenerCorreoElectronico());

            ArrayList<Stand> lista = visitas.get(visitante);

            if (lista == null || lista.isEmpty()) {

                System.out.println("No ha visitado ningún stand.");

            } else {

                System.out.println("Stands visitados:");

                for (Stand stand : lista) {

                    System.out.println("- Stand "
                            + stand.obtenerNumeroUnico()
                            + " | "
                            + stand.obtenerUbicacion());
                }
            }
        }
    }

    /**
     * Genera un reporte con el promedio de calificaciones
     * de cada stand.
     */
    public void reportePromedioCalificaciones() {

        System.out.println("\n========================================");
        System.out.println("   PROMEDIO DE CALIFICACIONES POR STAND");
        System.out.println("========================================");

        if (stands.isEmpty()) {
            System.out.println("No hay stands registrados.");
            return;
        }

        for (Stand stand : stands) {

            ArrayList<Comentario> lista =
                    comentariosPorStand.get(stand);

            System.out.print("\nStand "
                    + stand.obtenerNumeroUnico());

            if (stand.obtenerEmpresaAsignada() != null) {

                System.out.print(" - Empresa: "
                        + stand.obtenerEmpresaAsignada().obtenerNombre());
            }

            if (lista == null || lista.isEmpty()) {

                System.out.println(" | Sin calificaciones.");

            } else {

                double suma = 0;

                for (Comentario comentario : lista) {
                    suma += comentario.obtenerCalificacion();
                }

                double promedio = suma / lista.size();

                System.out.printf(" | Promedio: %.2f/5%n", promedio);
            }
        }
    }

    /**
     * Genera todos los reportes solicitados por la guía.
     */
    public void generarReportes() {

        reporteEmpresasYStands();
        reporteVisitantesYStands();
        reportePromedioCalificaciones();
    }

    /**
     * Muestra todas las empresas registradas.
     */
    public void listarEmpresas() {

        System.out.println("\n===== EMPRESAS REGISTRADAS =====");

        if (empresas.isEmpty()) {
            System.out.println("No hay empresas registradas.");
            return;
        }

        for (Empresa empresa : empresas) {
            System.out.println(empresa);
        }
    }

    /**
     * Muestra todos los visitantes registrados.
     */
    public void listarVisitantes() {

        System.out.println("\n===== VISITANTES REGISTRADOS =====");

        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
            return;
        }

        for (Visitante visitante : visitantes) {
            System.out.println(visitante);
        }
    }

    /**
     * Muestra todos los stands registrados.
     */
    public void listarStands() {

        System.out.println("\n===== TODOS LOS STANDS =====");

        if (stands.isEmpty()) {
            System.out.println("No hay stands registrados.");
            return;
        }

        for (Stand stand : stands) {
            System.out.println(stand);
        }
    }

    /**
     * Busca una empresa por su nombre.
     *
     * @param nombre nombre de la empresa
     * @return empresa encontrada o null
     */
    private Empresa buscarEmpresa(String nombre) {

        for (Empresa empresa : empresas) {

            if (empresa.obtenerNombre().equalsIgnoreCase(nombre)) {
                return empresa;
            }
        }

        return null;
    }

    /**
     * Busca un stand por su número.
     *
     * @param numero número del stand
     * @return stand encontrado o null
     */
    private Stand buscarStand(int numero) {

        for (Stand stand : stands) {

            if (stand.obtenerNumeroUnico() == numero) {
                return stand;
            }
        }

        return null;
    }

    /**
     * Busca un visitante por su identificación.
     *
     * @param identificacion identificación del visitante
     * @return visitante encontrado o null
     */
    private Visitante buscarVisitante(String identificacion) {

        for (Visitante visitante : visitantes) {

            if (visitante.obtenerIdentificacion()
                    .equalsIgnoreCase(identificacion)) {

                return visitante;
            }
        }

        return null;
    }

    /**
     * Obtiene el nombre de la feria.
     *
     * @return nombre de la feria
     */
    public String obtenerNombreFeria() {
        return nombreFeria;
    }
}