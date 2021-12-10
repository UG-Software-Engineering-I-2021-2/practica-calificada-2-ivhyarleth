public class ProfesorTP extends Teacher {
    ProfesorTP( String nombre) {
        super( nombre);
    }

    @Override
    int sueldo() {
        return _salarioBaseMensual;
    }
}
