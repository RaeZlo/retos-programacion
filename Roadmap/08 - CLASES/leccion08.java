public class leccion08 {
    public static void main(String[] args) {
        // una clase es una plantilla o un modelo a partir del cual se crean objetos.
        // Define un conjunto de atributos (propiedades) y métodos (funciones) que
        // determinan el comportamiento y el estado de los objetos que se basan en ella.


        Person person = new Person("Rafa", 19);
        System.out.println(person);
        person.setName("Lily");
        person.setAge(21);
        System.out.println(person);

        System.out.println("--------- DIFICULTAD EXTRA -------------");

        // Uso de la clase Stack
        Stack pila = new Stack();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        pila.imprimirContenido();
        pila.pop();
        pila.imprimirContenido();
        System.out.println("Elementos en la pila: " + pila.getNumeroElementos());

        // Uso de la clase Cola
        Queue cola = new Queue();
        cola.push(5);
        cola.push(15);
        cola.push(25);
        cola.imprimirContenido();
        cola.pop();
        cola.imprimirContenido();
        System.out.println("Elementos en la cola: " + cola.getNumeroElementos());
    }
}

class Person {
    // Atributos
    private String name;
    private int age;

    //Métodos de acceso (get) y sobrescritura (set) de atributos
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Constructor (Inicializador)
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Metodo para imprimir los atributos
    public String toString() {
        return "Nombre: " + name + ", Edad: " + age;
    }
}

class Stack {
    private ArrayList<Integer> elementos;

    public Stack() {
        this.elementos = new ArrayList<>();
    }

    public void push(int valor) {
        elementos.add(valor);
    }

    public int pop() {
        if (!elementos.isEmpty()) {
            return elementos.remove(elementos.size() - 1);
        } else {
            System.out.println("La pila está vacia.");
            return 0;
        }
    }

    public int getNumeroElementos() {
        return elementos.size();
    }

    public void imprimirContenido() {
        System.out.println("Contenido de la pila: " + elementos);
    }
}

class Queue {
    private ArrayList<Integer> elementos;

    public Queue() {
        this.elementos = new ArrayList<>();
    }

    public void push(int valor) {
        elementos.add(valor);
    }

    public void pop() {
        if (!elementos.isEmpty()) {
            elementos.remove(0);
        } else {
            System.out.println("La cola está vacia.");
        }
    }

    public int getNumeroElementos() {
        return elementos.size();
    }

    public void imprimirContenido() {
        System.out.println("Contenido de la cola: " + elementos);
    }
}
