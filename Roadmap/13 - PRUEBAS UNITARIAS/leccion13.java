public class leccion13 {
    public static void main(String[] args) {

    }

    public double suma(double a, double b) {
        return a + b;
    }

    @Test
    public void sumaTest() {
        double resultado = suma(5.8, 0.9);
        assertEquals(6.7, resultado, "La función de suma deberia retornar 6.7");
    }
}

// Extra
class datosPersonales {

    public HashMap<String, Object> crearDiccionario() {
        HashMap<String, Object> diccionario = new HashMap<>();
        diccionario.put("Name", "Rafael");
        diccionario.put("Age", 19);
        diccionario.put("birthDate", "22/01/2005");
        diccionario.put("programmingLanguages", Arrays.asList("Python", "Java", "JavaScript"));
        return diccionario;
    }
}

class testDatos {

    @Test
    public void existeClave() {
        datosPersonales datos = new datosPersonales();
        HashMap<String, Object> diccionario = datos.crearDiccionario();

        assertTrue(diccionario.containsKey("Name"));
        assertTrue(diccionario.containsKey("Age"));
        assertTrue(diccionario.containsKey("birthDate"));
        assertTrue(diccionario.containsKey("programmingLanguages"));
    }

    @Test
    public void datosCorrectos() {
        datosPersonales datos = new datosPersonales();
        HashMap<String, Object> diccionario = datos.crearDiccionario();

        assertEquals("Rafael", diccionario.get("Name"));
        assertEquals(19, diccionario.get("Age"));
        assertEquals("22/01/2005", diccionario.get("birthDate"));

        List<String> lenguajes = (List<String>) diccionario.get("programmingLanguages");
        assertTrue(lenguajes.contains("Python"));
        assertTrue(lenguajes.contains("JavaScript"));
        assertTrue(lenguajes.contains("Java"));
    }
}
