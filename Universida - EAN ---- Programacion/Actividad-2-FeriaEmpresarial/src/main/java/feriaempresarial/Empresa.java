package feriaempresarial;

/**
 * Representa una empresa participante en la Feria Empresarial.
 */
public class Empresa {

    private String nombre;
    private String sector;
    private String correoElectronico;

    /**
     * Constructor de la clase Empresa.
     *
     * @param nombre nombre de la empresa
     * @param sector sector al que pertenece la empresa
     * @param correoElectronico correo de contacto
     */
    public Empresa(String nombre, String sector, String correoElectronico) {
        this.nombre = nombre;
        this.sector = sector;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el nombre de la empresa.
     *
     * @return nombre de la empresa
     */
    public String obtenerNombre() {
        return nombre;
    }

    /**
     * Obtiene el sector de la empresa.
     *
     * @return sector de la empresa
     */
    public String obtenerSector() {
        return sector;
    }

    /**
     * Obtiene el correo electrónico de la empresa.
     *
     * @return correo electrónico
     */
    public String obtenerCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Permite cambiar el correo electrónico de la empresa.
     *
     * @param nuevoCorreo nuevo correo electrónico
     */
    public void cambiarCorreo(String nuevoCorreo) {
        this.correoElectronico = nuevoCorreo;
    }

    @Override
    public String toString() {
        return "Empresa: " + nombre
                + " | Sector: " + sector
                + " | Correo: " + correoElectronico;
    }
}