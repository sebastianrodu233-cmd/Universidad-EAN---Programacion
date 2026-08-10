package feriaempresarial;

/**
 * Representa a un visitante registrado en la Feria Empresarial.
 */
public class Visitante {

    private String nombre;
    private String identificacion;
    private String correoElectronico;

    /**
     * Constructor de la clase Visitante.
     *
     * @param nombre nombre del visitante
     * @param identificacion número de identificación
     * @param correoElectronico correo electrónico del visitante
     */
    public Visitante(String nombre, String identificacion, String correoElectronico) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el nombre del visitante.
     *
     * @return nombre del visitante
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Obtiene la identificación del visitante.
     *
     * @return identificación
     */
    public String obtenerIdentificacion() {
        return identificacion;
    }

    /**
     * Obtiene el correo electrónico del visitante.
     *
     * @return correo electrónico
     */
    public String obtenerCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Permite cambiar el correo electrónico del visitante.
     *
     * @param nuevoCorreo nuevo correo electrónico
     */
    public void cambiarCorreo(String nuevoCorreo) {
        this.correoElectronico = nuevoCorreo;
    }

    @Override
    public String toString() {
        return "Visitante: " + nombre
                + " | Identificación: " + identificacion
                + " | Correo: " + correoElectronico;
    }
}