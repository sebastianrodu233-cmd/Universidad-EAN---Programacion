package feriaempresarial;

/**
 * Representa un stand disponible en la Feria Empresarial.
 */
public class Stand {

    private int numeroUnico;
    private String ubicacion;
    private String tamano;

    private Empresa empresaAsignada;

    /**
     * Constructor de la clase Stand.
     *
     * @param numeroUnico número único del stand
     * @param ubicacion ubicación del stand
     * @param tamano tamaño del stand
     */
    public Stand(int numeroUnico, String ubicacion, String tamano) {
        this.numeroUnico = numeroUnico;
        this.ubicacion = ubicacion;
        this.tamano = tamano;
        this.empresaAsignada = null;
    }

    /**
     * Obtiene el número único del stand.
     *
     * @return número del stand
     */
    public int obtenerNumeroUnico() {
        return numeroUnico;
    }

    /**
     * Obtiene la ubicación del stand.
     *
     * @return ubicación
     */
    public String obtenerUbicacion() {
        return ubicacion;
    }

    /**
     * Obtiene el tamaño del stand.
     *
     * @return tamaño
     */
    public String obtenerTamano() {
        return tamano;
    }

    /**
     * Obtiene la empresa asignada al stand.
     *
     * @return empresa asignada o null si está disponible
     */
    public Empresa obtenerEmpresaAsignada() {
        return empresaAsignada;
    }

    /**
     * Asigna una empresa al stand.
     *
     * @param empresa empresa que ocupará el stand
     */
    public void asignarEmpresa(Empresa empresa) {
        this.empresaAsignada = empresa;
    }

    /**
     * Verifica si el stand está disponible.
     *
     * @return true si está disponible, false si está ocupado
     */
    public boolean estaDisponible() {
        return empresaAsignada == null;
    }

    @Override
    public String toString() {
        String estado;

        if (estaDisponible()) {
            estado = "Disponible";
        } else {
            estado = "Ocupado por: " + empresaAsignada.obtenerNombre();
        }

        return "Stand " + numeroUnico
                + " | Ubicación: " + ubicacion
                + " | Tamaño: " + tamano
                + " | Estado: " + estado;
    }
}