 /**
 * La clase Copia representa una copia de una película que se alquila en la videotienda.
 * Cada copia tiene un identificador único basado en el nombre de la película y un consecutivo.
 */
public class Copia {
    private String nombrePelicula;
    private int consecutivo;
    private boolean alquilada;
    private String titulo;
    private int codigo;
    /**
     * Constructor de la clase Copia.
     * 
     * @param nombrePelicula El nombre de la película.
     * @param consecutivo El número consecutivo de la copia.
     */
    public Copia(String nombrePelicula, int consecutivo,String titulo, int codigo ) {
        this.nombrePelicula = nombrePelicula;
        this.consecutivo = consecutivo;
        this.alquilada = false;
        this.titulo = titulo;
        this.codigo = codigo;
    }

    public int darCodigo() { return codigo; }
    public String darTituloPelicula() { return titulo; }


    /**
     * Alquila la copia de la película.
     * 
     * @pre La copia no debe estar ya alquilada.
     * @post La copia se marca como alquilada.
     * @exception IllegalStateException Si la copia ya está alquilada.
     */
    public void alquilar() {
        if (alquilada) {
            throw new IllegalStateException("La copia ya está alquilada.");
        }
        alquilada = true;
    }

    /**
     * Devuelve la copia de la película.
     * 
     * @pre La copia debe estar alquilada.
     * @post La copia se marca como no alquilada.
     * @exception IllegalStateException Si la copia no está alquilada.
     */
    public void devolver() {
        if (!alquilada) {
            throw new IllegalStateException("La copia no está alquilada.");
        }
        alquilada = false;
    }

    /**
     * Obtiene el identificador de la copia.
     * 
     * @return El identificador de la copia en formato "nombrePelicula - consecutivo".
     */
    public String getIdentificador() {
        return nombrePelicula + " - " + consecutivo;
    }

    /**
     * Verifica si la copia está alquilada.
     * 
     * @return true si la copia está alquilada, false en caso contrario.
     */
    public boolean isAlquilada() {
        return alquilada;
    }
}
