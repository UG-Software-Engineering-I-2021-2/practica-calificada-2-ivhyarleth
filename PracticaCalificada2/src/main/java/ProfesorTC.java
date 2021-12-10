public class ProfesorTC extends Teacher {
    ProfesorTC(String nombre) {
        super(nombre);
    }

    @Override
    int sueldo() {
        return _salarioBaseMensual + _comision;
    }
}
