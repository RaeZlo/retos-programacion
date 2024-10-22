import java.util.ArrayList;

public class leccion09 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.speak();

        Cat cat = new Cat();
        cat.speak();

        System.out.println("\n------ DIFICULTAD EXTRA ---------\n");
        // Creando empleados
        Programador p1 = new Programador(1, "Rafael", "Java");
        Programador p2 = new Programador(2, "Lucía", "Python");

        Gerente g1 = new Gerente(3, "Carlos");

        GerenteDeProyectos gp1 = new GerenteDeProyectos(4, "Ana", "Sistema de Gestión");

        // Agregando empleados al gerente
        g1.agregarEmpleadoACargo(p1);
        g1.agregarEmpleadoACargo(p2);

        // Mostrando información de los empleados
        g1.mostrarInfo();
        g1.mostrarEmpleadosACargo();

        // Mostrando el lenguaje del programador
        p1.mostrarLenguaje();

        // Mostrando información del gerente de proyectos
        gp1.mostrarInfo();
        gp1.mostrarInfoProyecto();
    }
}

class Animal{
    String sonido;

    public String getSonido() {
        return sonido;
    }

    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    //Método para hablar
    public void speak(){
        System.out.println(sonido);
    }
}

class Dog extends Animal {
    public Dog() {
        this.sonido = "Guau!";
    }
}

class Cat extends Animal {
    public Cat() {
        this.sonido = "Miau!";
    }
}

// Extra
class Empleado {
    protected int id;
    protected String nombre;

    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void mostrarInfo() {
        System.out.println("ID: " + id + ", Nombre: " + nombre);
    }
}

class Gerente extends Empleado {
    private ArrayList<Empleado> empleadosACargo;

    public Gerente(int id, String nombre) {
        super(id, nombre); // Llamamos al constructor de la clase padre
        this.empleadosACargo = new ArrayList<>();
    }

    public void agregarEmpleadoACargo(Empleado empleado) {
        empleadosACargo.add(empleado);
    }

    public void mostrarEmpleadosACargo() {
        System.out.println("Empleados a cargo de " + nombre + ":");
        for (Empleado e : empleadosACargo) {
            e.mostrarInfo();
        }
    }
}

class GerenteDeProyectos extends Empleado {
    private String nombreDelProyecto;

    public GerenteDeProyectos(int id, String nombre, String nombreDelProyecto) {
        super(id, nombre);
        this.nombreDelProyecto = nombreDelProyecto;
    }

    public void mostrarInfoProyecto() {
        System.out.println("Gerente del proyecto: " + nombreDelProyecto);
    }
}

class Programador extends Empleado {
    private String lenguajePrincipal;

    public Programador(int id, String nombre, String lenguajePrincipal) {
        super(id, nombre);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public void mostrarLenguaje() {
        System.out.println(nombre + " programa en " + lenguajePrincipal);
    }
}
