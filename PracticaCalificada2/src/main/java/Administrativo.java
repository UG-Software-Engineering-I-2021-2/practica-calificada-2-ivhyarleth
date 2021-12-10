public class Administrativo extends Teacher {
    Administrativo( String nombre) {
        super(nombre);
    }

    @Override
    int sueldo() {
        return _salarioBaseMensual + _bonus;
    }
}
