public class Doctorado extends Student {
    Doctorado(String nombre) {
        super(nombre);
    }

    @Override
    int grado() {
        return _notaBase + 2;
    }
}
