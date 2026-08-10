package feriaempresarial;

/**
 * Representa un comentario realizado por un visitante
 * sobre su experiencia en un stand.
 */
public class Comentario {

    private String nombreVisitante;
    private String fecha;
    private int calificacion;
    private String comentario;

    /**
     * Constructor de la clase Comentario.
     *
     * @param nombreVisitante nombre del visitante
     * @param fecha fecha en que se realizó la visita
     * @param calificacion calificación de 1 a 5
     * @param comentario comentario realizado por el visitante
     */
    public Comentario(String nombreVisitante, String fecha,
            int calificacion, String comentario) {

        this.nombreVisitante = nombreVisitante;
        this.fecha = fecha;

        if (calificacion < 1 || calificacion > 5) {
            this.calificacion = 1;
        } else {
            this.calificacion = calificacion;
        }

        this.comentario = comentario;
    }

    /**
     * Obtiene el nombre del visitante.
     *
     * @return nombre del visitante
     */
    public String obtenerNombreVisitante() {
        return nombreVisitante;
    }

    /**
     * Obtiene la fecha de la visita.
     *
     * @return fecha de la visita
     */
    public String obtenerFecha() {
        return fecha;
    }

    /**
     * Obtiene la calificación.
     *
     * @return calificación de 1 a 5
     */
    public int obtenerCalificacion() {
        return calificacion;
    }

    /**
     * Obtiene el comentario realizado.
     *
     * @return comentario
     */
    public String obtenerComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Visitante: " + nombreVisitante
                + " | Fecha: " + fecha
                + " | Calificación: " + calificacion + "/5"
                + " | Comentario: " + comentario;
    }
}