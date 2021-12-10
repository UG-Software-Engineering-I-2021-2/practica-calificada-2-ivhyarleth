public class Maestria extends Student {
    Maestria(String nombre) {
        super(nombre);
    }

    @Override
    int grado() {
        return _notaBase + 1;
    }
}
