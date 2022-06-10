package deparBank;

public class CuentaBancaria {
//prueba
    private String iban, titularnombre, titularapellido;
    private double saldo;
    private double[] movimiento = new double[100];

    private int contadorInicio = 0;

    private int contadorLimite = 100;

    CuentaBancaria() {
        this.iban = "ES"+getnumsRandom();
        this.saldo = 0.00;
    }

    // getter y setter

    public String getiban() {
        return iban;
    }

    public String gettitularnombre() {
        return titularnombre;
    }

    public String gettitularapellido(){
        return titularapellido;
    }

    public double getsaldo() {
        if (saldo < 0) {
            System.out.println("[AVISO] SALDO NEGATIVO");
        }
        return saldo;
    }

    public void setiban(String iban) {
        this.iban = iban;
    }

    public void settitularnombre(String titularnombre) {
        this.titularnombre = titularnombre;
    }

    public void settitularapellido(String titularapellido){
        this.titularapellido = titularapellido;
    }

    public void setsaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(Double cantidad) {

        if (cantidadlegal(cantidad)) {
            movimiento[contadorInicio] = cantidad;
            saldo = (saldo + cantidad);
            System.out.println("\n*******[DeparBank]*******");
            System.out.println("\nHas ingresado " + cantidad + "€" + ", Saldo actual " + saldo + "€");
            System.out.println("\n*******[DeparBank]*******");
            contadorInicio++;
        }
    }

    public void retirada(Double cantidad) {
        if (cantidadlegal(cantidad) && tienedinero(cantidad)) {
            movimiento[contadorInicio] = cantidad;
            saldo = (saldo - cantidad);
            System.out.println("\n*******[DeparBank]*******");
            System.out.println("\nHas retirado " + cantidad + "€" + ", Saldo actual " + saldo + "€");
            System.out.println("\n*******[DeparBank]*******");
            contadorInicio++;
        }
    }

    public void movimientos() {
        System.out.println("\n\nMOVIMIENTOS:\n");

        for (int i = 0; i < movimiento.length; i++) {
            if (movimiento[i] != 0.00) {
                System.out.println(movimiento[i] + "€");
            }
        }
    }

    private boolean tienedinero() {
        boolean tienedinero = (contadorInicio != contadorLimite) ? true : false;
        if (!tienedinero) {
            limitemovimientos();
        }
        return tienedinero;
    }

    private boolean cantidadlegal(Double cantidad) {
        boolean cantidadlegal = true;
        if (cantidad > 3000.00) {
            cantidadlegal = false;
            mensajehacienda();
        } else {
            return tienedinero();
        }
        return cantidadlegal;
    }

    private boolean tienedinero(Double cantidad) {
        boolean tienedinero = false;
        if (saldo > -50 && saldo > cantidad) {
            tienedinero = true;
        } else {
            mensajeError(cantidad);
        }
        return tienedinero;
    }

    static String getnumsRandom() {

        // caracteres para la cadena random
        String numerosrandom =  "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder numeros = new StringBuilder(22);

        for (int i = 0; i < 22; i++) {

             //genera los numeros aleatorios
            int index = (int) (numerosrandom.length() * Math.random());

            // añadir los caracteres
            numeros.append(numerosrandom.charAt(index));
        }

        return numeros.toString();
    }
    
    private void limitemovimientos() {
        System.out.printf("\n[AVISO] *Has agotado los movimientos por hoy. %d movimientos hechos", contadorLimite);
    }

    private void mensajehacienda() {
        System.out.println("\n[AVISO] *Se notificará a hacienda.");
    }

    private void mensajeError(Double cantidad) {
        System.out.printf("\n[AVISO] *No puedes retirar %.2f\tSaldo: %.2f", cantidad, this.saldo);
    }

    public void mostrardatoscuenta() {

        System.out.println("\n*******[DeparBank]*******"
                + "\n\nIBAN: " + iban + "\nTitular: " + titularnombre + " " + titularapellido + "\nSaldo: " + saldo + "€"
                + "\n\n*******[DeparBank]*******");
    }

    public void mostrariban() {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nIBAN: " + iban);
        System.out.println("\n*******[DeparBank]*******");
    }

    public void mostrartitular(String titularnombre, String titularapellido) {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nTitular de la cuenta: " + titularnombre + " " + titularapellido);
        System.out.println("\n*******[DeparBank]*******");
    }

    public void mostrarsaldo() {

        System.out.println("*******[DeparBank]*******");
        System.out.println("\nSaldo de la cuenta: " + getsaldo() + "€");
        System.out.println("\n*******[DeparBank]*******");
    }
}
