import java.util.ArrayList;
import java.util.List;

/**
 * La clase Cliente representa un cliente de la videotienda.
 * Mantiene la información básica del cliente, la lista de copias prestadas y el saldo de su cuenta.
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private String direccion;
    private int saldo;
    private ArrayList<Copia> copiasPrestadas;
    
    public Cliente(String cedula, String nombre, String direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.direccion = direccion;
        this.saldo = 0;
        this.copiasPrestadas = new ArrayList<>();
    }
    
    public String darCedula() { return cedula; }
    public void incrementarSaldo(int monto) { saldo += monto; }
    public int darSaldo() { return saldo; }
    public void alquilarCopia(Copia copia) { copiasPrestadas.add(copia); }
    public void pagarAlquiler(int monto) { saldo -= monto; }
    public void devolverCopia(Copia copia) { copiasPrestadas.remove(copia); }
    public ArrayList<Copia> darCopiasPrestadas() { return copiasPrestadas; }

    /**
     * Alquila una copia de película.
     * 
     * @param copia La copia a alquilar.
     * @pre La copia debe estar disponible para alquilar.
     * @post La copia se añade a la lista de copias prestadas y se actualiza el saldo.
     * @exception IllegalStateException Si la copia ya está alquilada.
     */
    public void alquilarCopia(Copia copia) {
        copia.alquilar();
        copiasPrestadas.add(copia);
        // Aquí se podría agregar lógica para actualizar el saldo según la tarifa de alquiler.
    }

    /**
     * Devuelve una copia de película.
     * 
     * @param copia La copia a devolver.
     * @pre La copia debe estar en la lista de copias prestadas.
     * @post La copia se elimina de la lista de copias prestadas.
     * @exception IllegalArgumentException Si la copia no está en la lista de copias prestadas.
     */
    public void devolverCopia(Copia copia) {
        if (!copiasPrestadas.contains(copia)) {
            throw new IllegalArgumentException("La copia no está en la lista de copias prestadas.");
        }
        copia.devolver();
        copiasPrestadas.remove(copia);
        // Aquí se podría agregar lógica para actualizar el saldo según la tarifa de devolución.
    }

    /**
     * Obtiene el saldo del cliente.
     * 
     * @return El saldo actual del cliente.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Actualiza el saldo del cliente.
     * 
     * @param monto El monto a agregar o restar del saldo.
     * @pre El monto debe ser un valor válido.
     * @post El saldo se actualiza con el nuevo monto.
     */
    public void actualizarSaldo(double monto) {
        saldo += monto;
    }

    /**
     * Obtiene la información básica del cliente.
     * 
     * @return Una cadena con el nombre y el DNI del cliente.
     */
    public String getInformacion() {
        return "Nombre: " + nombre + ", DNI: " + dni;
    }
}
