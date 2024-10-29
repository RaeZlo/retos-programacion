public class leccion11 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/data.txt");
        FileWriter escribir;
        Scanner leer;

        try {
            file.createNewFile();

            escribir = new FileWriter(file);

            escribir.append("Nombre: RaeZlo\n"); 
            escribir.append("Edad: 19\n");
            escribir.append("Lenguaje de programación: Java\n");

            escribir.close();

            leer = new Scanner(file);
            while (leer.hasNext()) {
                String line = leer.nextLine();
                System.out.println(line);
            }

            leer.close();
            file.delete();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n-------DIFICULTAD EXTRA------\n");

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        File ventas = new File("src/ventas.txt");
        try {
            if (!ventas.exists()) {
                ventas.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error al crear el archivo\n");
        }
        do {
            System.out.println("Bienvenido al programa de ventas!\n");
            System.out.println("1- Añadir un producto");
            System.out.println("2- Eliminar un producto");
            System.out.println("3- Buscar un producto");
            System.out.println("4- Actualizar un producto");
            System.out.println("5- Calcular precio de un producto");
            System.out.println("6- Calcular precio de venta total");
            System.out.println("7- Salir\n");

            System.out.println("Introduzca una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    try {
                        System.out.println("Ingrese el nombre del producto: ");
                        String name = scanner.nextLine();

                        System.out.println("Ingrese la cantidad vendida: ");
                        int amout = scanner.nextInt();

                        System.out.println("Ingrese el precio: ");
                        double price = scanner.nextDouble();

                        FileWriter escribirVentas = new FileWriter(ventas, true);
                        escribirVentas.append("Producto: " + name + ", " + "Cantidad: " + amout + ", " + "Precio: " + price + "\n");
                        escribirVentas.close();
                    } catch (Exception e) {
                        System.out.println("No se pudo escribir el archivo.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del producto a eliminar: ");
                    String delProducto = scanner.nextLine();

                    ArrayList<String> productos = new ArrayList<>();
                    try {
                        boolean exist = false;
                        Scanner readVentas = new Scanner(ventas);

                        while (readVentas.hasNext()) {
                            String producto = readVentas.nextLine();
                            productos.add(producto);
                            if (producto.contains(delProducto)) {
                                exist = true;
                            }
                        }

                        if (exist) {
                            //Eliminamos el producto de la lista
                            for (int i = 0; i < productos.size(); i++) {
                                if (productos.get(i).contains(delProducto)) {
                                    productos.remove(i);
                                }
                            }
                        } else {
                            System.out.println("No existe el producto");
                        }

                        try {
                            FileWriter writeProducts = new FileWriter(ventas, false);
                            for (String product : productos) {
                                writeProducts.append(product + "\n");
                            }
                            writeProducts.close();
                        } catch (IOException e) {
                            System.out.println("Error al escribir el archivo\n");
                        }

                        readVentas.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Error al leer el archivo\n");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del producto que quiere buscar: ");
                    String searchName = scanner.nextLine();

                    try {
                        boolean exist = false;
                        String line = null;
                        Scanner readVentas = new Scanner(ventas);

                        while (readVentas.hasNext() && !exist) {
                            line = readVentas.nextLine();
                            if (line.contains(searchName)) {
                                exist = true;
                            }
                        }

                        if (exist) {
                            System.out.println(line + "\n");
                        } else {
                            System.out.println("No existe el producto");
                        }
                        readVentas.close();
                    } catch (Exception e) {
                        System.out.println("Error al leer el archivo.");
                    }
                    break;
                case 4:
                    System.out.println("Ingrese el producto que desea actualizar: ");
                    String nameUp = scanner.nextLine();

                    ArrayList<String> productsUpdate = new ArrayList<>();
                    try {
                        boolean exist = false;
                        Scanner readerVenta = new Scanner(ventas);

                        while (readerVenta.hasNext()) {
                            String product = readerVenta.nextLine();
                            productsUpdate.add(product);
                            if (product.contains(nameUp)) {
                                exist = true;
                            }
                        }

                        if (exist) {
                            System.out.print("Introduce el nombre (nuevo): ");
                            String nameUpdate = scanner.nextLine();

                            System.out.print("Introduce la cantidad (nueva): ");
                            int amountUpdate = scanner.nextInt();
                            scanner.nextLine();

                            System.out.print("Introduce el nuevo precio (nuevo): ");
                            double priceUpdate = scanner.nextDouble();
                            scanner.nextLine();

                            //Actualizamos el producto de la lista
                            for (int i = 0; i < productsUpdate.size(); i++) {
                                if (productsUpdate.get(i).contains(nameUp)) {
                                    productsUpdate.set(i,nameUpdate+", "+amountUpdate+", "+priceUpdate);
                                }
                            }
                        } else {
                            System.out.println("No existe el producto");
                        }

                        readerVenta.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("Error al leer el archivo\n");
                    }

                    try {
                        FileWriter writeProducts = new FileWriter(ventas, false);
                        for (String product : productsUpdate) {
                            writeProducts.append(product + "\n");
                        }
                        writeProducts.close();
                    } catch (IOException e) {
                        System.out.println("Error al escribir el archivo\n");
                    }
                    break;
                case 5:
                    System.out.println("Vamos a calcular el precio de un producto!\n");

                    System.out.print("Introduce el nombre: ");
                    String nameProductPrice = scanner.nextLine();

                    Scanner readProduct = null;
                    try {
                        readProduct = new Scanner(ventas);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error al leer el archivo\n");
                    }
                    String product = "";
                    boolean exist = false;
                    while (readProduct.hasNext() && !exist) {
                        product = readProduct.nextLine();
                        if (product.contains(nameProductPrice)) {
                            exist = true;
                        }
                    }

                    int amountProduct = Integer.parseInt(product.substring((product.indexOf(',')+2),product.lastIndexOf(',')));
                    Double priceProduct = Double.valueOf(product.substring(product.lastIndexOf(",")+2));
                    System.out.println("\nEl precio total del producto es: " + (priceProduct*amountProduct)+"\n");

                    break;
                case 6:
                    System.out.println("Vamos a calcular el precio total!\n");

                    Scanner readProductPrice = null;
                    try {
                        readProductPrice = new Scanner(ventas);
                    } catch (FileNotFoundException e) {
                        System.out.println("Error al leer el archivo\n");
                    }

                    int sum = 0;
                    while (readProductPrice.hasNext()) {
                        String prod = readProductPrice.nextLine();
                        int amount = Integer.parseInt(prod.substring((prod.indexOf(',')+2),prod.lastIndexOf(',')));
                        Double price = Double.valueOf(prod.substring(prod.lastIndexOf(",")+2));
                        sum += amount*price;
                    }

                    System.out.println("El precio total de la venta es: " + sum +"\n");

                    readProductPrice.close();
                    break;
                case 7:
                    exit = true;
                    ventas.delete();
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no valida.");
            }
        } while (!exit);
    }
}
