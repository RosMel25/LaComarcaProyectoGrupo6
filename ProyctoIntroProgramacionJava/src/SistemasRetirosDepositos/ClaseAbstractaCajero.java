package SistemasRetirosDepositos;

import java.util.Scanner;

public abstract class ClaseAbstractaCajero {

    protected int transacciones, retiro, deposito;
    private static int saldo;
    Scanner entrada = new Scanner(System.in);

    public void Operaciones() {
        int bandera = 0;
        int seleccion = 0;
        do {
            do {
                System.out.println("Porfavor seleccione una opción:");
                System.out.println("    1. Consulta de saldo.");
                System.out.println("    2. Retiro de efectivo.");
                System.out.println("    3. Deposito de efectivo.");
                System.out.println("    4. Salir.");
                seleccion = entrada.nextInt();

                if (seleccion >= 1 && seleccion <= 4) {
                    bandera = 1;
                } else {
                    System.out.println("-------------------------------------------------");
                    System.out.println("Opción no disponible, vuelva a intentar porfavor.");
                    System.out.println("-------------------------------------------------");
                }
            } while (bandera == 0);

            if (seleccion == 1) {
                ClaseAbstractaCajero mensajero = new Consulta();
                mensajero.Transacciones();
            } else if (seleccion == 2) {
                ClaseAbstractaCajero mensajero = new Retiro();
                mensajero.Transacciones();
            } else if (seleccion == 3) {
                ClaseAbstractaCajero mensajero = new Deposito();
                mensajero.Transacciones();
            } else if (seleccion == 4) {
                System.out.println("--------------------------");
                System.out.println("¡Gracias!, vuelva pronto.");
                System.out.println("--------------------------");
                bandera = 2;
            }
        } while (bandera != 2);
    }

    //Método para solicitar cantidad de retiro
    public void Retiro() {
        retiro = entrada.nextInt();
    }

    //Método para solicitar deposito
    public void Deposito() {
        deposito = entrada.nextInt();
    }

    //Método abstracto
    public abstract void Transacciones();

    //Métodos setter y getter
    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;

    }
}
