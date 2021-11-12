package LiteDiccionario;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        String palabra;
        String traduccion;
        int opt = 1;

        while (opt != 0) {
            try {
                System.out.println("\nBienvenido al pequeño diccionario ");
                System.out.println("Menu Principal");
                System.out.println("Diguite 1 para agregar una palabra al diccionario");
                System.out.println("Diguite 2 para impimir el listado");
                System.out.println("Diguite 3 para buscar una palabra en el diccionario");
                System.out.print("Ingrese 0 para salir: ");
                opt = Integer.parseInt(scanner.nextLine());
                Diccionario nuevoDicc = new Diccionario();

                switch (opt) {
                    case 0:
                        opt = 0;
                        break;
                    case 1:

                        System.out.println("ingrese la palabra en español");
                        palabra = scanner.nextLine();
                        nuevoDicc.setPalabra(palabra.toUpperCase(Locale.ROOT));
                        System.out.println("Ingrese su traduccion");
                        traduccion = scanner.next();
                        nuevoDicc.setTraduccion(traduccion.toUpperCase(Locale.ROOT));
                        nuevoDicc.agregar();
                        break;
                    case 2:
                        System.out.println("\nDiccionario: \n");
                        nuevoDicc.imprimirLista();
                        break;
                    case 3:
                        String respuesta;
                        System.out.println("ingrese la palabra que desea buscar");
                        String palabraBuscada=scanner.nextLine();
                        respuesta=nuevoDicc.BuscarPalabra(palabraBuscada.toUpperCase(Locale.ROOT));
                        if(!respuesta.equals("lo sentimos")){
                            System.out.println("la traducion de la palabra es :"+respuesta);
                        }

                        break;

                    default:
                        System.out.println("la opcion seleccionada no es valida");
                        }

            } catch (Exception e) {
                System.out.println(e);
            }


        }

    }
}
