public abstract class Student {
    public String _Nombre;
    public int _notaBase =11;

    Student(String nombre) {
        _Nombre = nombre;
    }
    abstract int grado();
}

