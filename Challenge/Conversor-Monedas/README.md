# Conversor de Monedas
Este proyecto es un Conversor de Monedas diseñado para realizar conversiones entre el dólar estadounidense (USD) y varias otras monedas. Utiliza la API Exchange Rate para obtener las tasas de cambio más recientes.

# Funcionalidades
El conversor de monedas incluye las siguientes funcionalidades:
- Conversión de USD a Monedas Locales: Permite convertir dólares estadounidenses (USD) a varias monedas: peso argentino (ARS), peso chileno (CLP), real brasileño (BRL), y yen japonés (JPY).
- Conversión de Monedas Locales a USD: De manera inversa, puedes convertir desde las monedas mencionadas anteriormente a dólares estadounidenses.
- Selección de Moneda: Interfaz interactiva a través de la terminal para elegir entre varias opciones de conversión.
- Manejo de Excepciones: Gestiona errores comunes, como problemas de conectividad a la API o entradas no válidas.
- Código Modular: Separación de lógica de negocio, comunicación con API y manejo de interfaz de usuario para un código limpio y fácil de entender.

# Estructura del Proyecto
La estructura principal del proyecto se organiza en tres clases:
- ChallengeConversor: Contiene el método principal main y el menú interactivo para la selección de conversiones.
- PeticionesApi: Encargada de gestionar las solicitudes a la API de Exchange Rate y el manejo de las tasas de cambio.

# Mejoras Futuras
- Historial de Conversiones: Implementar un sistema de historial que registre las conversiones realizadas, permitiendo al usuario consultar su actividad previa.
- Soporte para Más Monedas: Extiender la lista de monedas para incluir otras opciones globales, ofreciendo más flexibilidad al usuario.
- Registros con Marca de Tiempo: Utilizar la biblioteca java.time para incluir marcas de tiempo en el historial, registrando cuándo se realizó cada conversión.
