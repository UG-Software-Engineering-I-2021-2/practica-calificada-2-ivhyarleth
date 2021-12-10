public abstract class Teacher {
    public String _Nombre;
    public int _salarioBaseMensual =2000;
    public int _comision = 500;
    public int _bonus = 100;

    Teacher( String nombre) {
        _Nombre = nombre;
    }
    abstract int sueldo();
}

