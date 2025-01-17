import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        String menu = """
                1)Peso Mexicano => Dolar
                2)Dolar => Peso Mexicano
                3)Peso Mexicano => Peso Argentino
                4)Peso Argentino => Peso Mexicano
                5)Peso Mexicano => Dinar Libio
                6)Peso Mexicano => Yemeni Rial
                7)Peso Mexicano => Euro
                8)Euro => Peso Mexicano
                9)Peso Mexicano => Yen
                10)Yen => Peso Mexicano
                11)Salir
                Digite su opcion->
                """;
        System.out.println("*****Conversor de Monedas*****");
        while(op != 11) {
            System.out.println(menu);
            try {
                op = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error inesperado: ");
                System.out.println(e.getMessage());
                scanner.nextLine();
                op = 0;
                continue;
            }
            String m1 = "", m2 = "";
            switch (op) {
                case 1:
                    m1 = "MXN";
                    m2 = "USD";
                    break;
                case 2:
                    m1 = "USD";
                    m2 = "MXN";
                    break;
                case 3:
                    m1 = "MXN";
                    m2 = "ARS";
                    break;
                case 4:
                    m1 = "ARS";
                    m2 = "MXN";
                    break;
                case 5:
                    m1 = "MXN";
                    m2 = "LYD";
                    break;
                case 6:
                    m1 = "MXN";
                    m2 = "YER";
                    break;
                case 7:
                    m1 = "MXN";
                    m2 = "EUR";
                    break;
                case 8:
                    m1 = "EUR";
                    m2 = "MXN";
                    break;
                case 9:
                    m1 = "MXN";
                    m2 = "JPY";
                    break;
                case 10:
                    m1 = "JPY";
                    m2 = "MXN";
                    break;
                case 11:
                    System.out.println("Gracias por emplear el programa!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida...");
                    continue;
            }

            //Cambio de moneada por API
            System.out.print("Valor a convertir: ");
            double valor = 0.0;
            try {
                valor = scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Error inesperado: ");
                System.out.println(e.getMessage());
                scanner.nextLine();
                continue;
            }
            Exchange exchange = new Exchange();

            Moneda moneda = exchange.exchange(m1, m2);
            System.out.println("El cambio de la moneda base [" + m1 + "] a la moneda [" + m2 + "] " +
                    "es equivalente a: " + Cambio.cambioMoneda(moneda, valor));
        }


    }
}
