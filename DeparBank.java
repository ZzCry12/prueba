package deparBank;

import java.util.Scanner;

public class DeparBank {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean exit = false;

        CuentaBancaria cuenta = new CuentaBancaria();

        System.out.println("*******[DeparBank BIENVENIDA]*******");
        System.out.println("Bienvenido a DeparBank (De Perduts al Riu Bank)"
                + "\n\nPara continuar introduzca su nombre");

        String titularnombre = sc.nextLine();

        System.out.println("A continuación introduzca su apellido, porfavor");
        String titularapelido = sc.nextLine();

        System.out.println("*******[DeparBank BIENVENIDA]*******");

        cuenta.settitularnombre(titularnombre);
        cuenta.settitularapellido(titularapelido);

        if (cuenta.gettitularnombre().equals(titularnombre) && cuenta.gettitularapellido().equals(titularapelido)) {
            do {
                System.out.println("\n1. Datos de la cuenta");
                System.out.println("2. IBAN");
                System.out.println("3. Titular");
                System.out.println("4. Saldo");
                System.out.println("5. Ingreso");
                System.out.println("6. Retirada");
                System.out.println("7. Movimientos");
                System.out.println("8. Salir");
                System.out.println("\n*******[DeparBank]*******");

                int menu = sc.nextInt();

                switch (menu) {

                    case 1:

                        System.out.println("Datos de la cuenta");
                        cuenta.mostrardatoscuenta();

                        break;
                    case 2:

                        System.out.println("IBAN");
                        cuenta.mostrariban();
                        break;

                    case 3:

                        System.out.println("Titular");
                        cuenta.mostrartitular(titularnombre, titularapelido);
                        break;

                    case 4:

                        System.out.println("Saldo de la cuenta");
                        cuenta.mostrarsaldo();

                        break;
                    case 5:

                        System.out.println("Ingreso de efectivo" +
                                "\nPor favor, indique la cantidad que va a ingresar");
                        Double cantidad = sc.nextDouble();
                        cuenta.ingreso(cantidad);

                        break;
                    case 6:

                        System.out.println("Retirada de efectivo" +
                                "\nPor favor, indique la cantidad que va a retirar");
                        cantidad = sc.nextDouble();
                        cuenta.retirada(cantidad);

                        break;
                    case 7:

                        cuenta.movimientos();
                        break;
                    case 8:

                        System.out.println("\n\n\n\n\n\n\n\n\n*******[DeparBank]*******");
                        System.out.println("\nProcesando salida....");
                        System.out.println("\n*******[DeparBank]*******");
                        exit = true;
                        break;
                    default:
                        System.out.println("\n[ERROR]Seleccione una opción válida, porfavor.");
                        break;
                }
            } while (!exit);
        } else {
            System.out.println("ERROR CRÍTICO, EN 5 SEGUNDOS EXPLOTARÁ EL EQUIPO");
        }
    }
}
