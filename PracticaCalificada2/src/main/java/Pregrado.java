public class Pregrado extends Student {
    Pregrado(String nombre) {
        super(nombre);
    }

    @Override
    int grado() {
        return _notaBase;
    }
}
