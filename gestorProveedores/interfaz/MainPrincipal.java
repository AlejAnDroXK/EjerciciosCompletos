package EjerciciosCompletos.gestorProveedores.interfaz;

import EjerciciosCompletos.gestorProveedores.negocio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainPrincipal {
    static List<Proveedor> proveedores = new ArrayList<>();
    static List<ClienteEmpresa> clientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opc;
        do {
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc) {
                case 1: { // Crear proveedor
                    System.out.println("-----------------");
                    System.out.println("Nombre del proveedor:");
                    String nombre = sc.nextLine();
                    System.out.println("País:");
                    String pais = sc.nextLine();
                    System.out.println("Tipo (Cloud / SaaS / Pago):");
                    String tipo = sc.nextLine();

                    if (tipo.equalsIgnoreCase("Cloud")) {
                        proveedores.add(new ProveedorCloud(nombre, pais));
                    } else if (tipo.equalsIgnoreCase("SaaS")) {
                        proveedores.add(new ProveedorSaaS(nombre, pais));
                    } else if (tipo.equalsIgnoreCase("Pago")) {
                        proveedores.add(new ProveedorPasarelasPago(nombre, pais));
                    } else {
                        System.out.println("El proveedor es invalido");
                    }
                    pausa();
                }
                break;
                case 2: { // Crear cliente empresarial
                    System.out.println("-----------------");
                    System.out.println("Nombre de la empresa cliente:");
                    String nombre = sc.nextLine();
                    clientes.add(new ClienteEmpresa(nombre));
                    pausa();
                }
                break;
                case 3: { // Asociar proveedor a cliente
                    System.out.println("-----------------");
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados, ingrese un cliente previamente");
                        pausa();
                        break;
                    }
                    if (proveedores.isEmpty()) {
                        System.out.println("No hay proveedores registrados, ingrese un proveedor previamente");
                        pausa();
                        break;
                    }
                    ClienteEmpresa cliente = buscarCliente(sc);
                    Proveedor proveedor = buscarProveedor(sc);

                    if (cliente != null && proveedor != null) {
                        cliente.contratarProveedor(proveedor);
                        System.out.println("Proveedor asociado correctamente.");
                    }
                    pausa();
                }
                break;
                case 4: { // Crear contrato entre proveedor y cliente
                    System.out.println("-----------------");
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados, ingrese un cliente previamente");
                        pausa();
                        break;
                    }
                    if (proveedores.isEmpty()) {
                        System.out.println("No hay proveedores registrados, ingrese un proveedor previamente");
                        pausa();
                        break;
                    }
                    ClienteEmpresa cliente = buscarCliente(sc);
                    if (cliente == null) {
                        pausa();
                        break;
                    }
                    Proveedor proveedor = buscarProveedor(sc);
                    if (proveedor == null) {
                        pausa();
                        break;
                    }
                    boolean asociado = false;
                    for (Proveedor p : cliente.getProveedores()) {
                        if (p.equals(proveedor)) {
                            asociado = true;
                            break;
                        }
                    }
                    if (!asociado) {
                        System.out.println("El cliente NOOOO tiene asociado este proveedor");
                        System.out.println("Debe asociarlo antes de crear un contrato en la opcion 3");
                        pausa();
                        break;
                    }
                    System.out.println("Precio:");
                    double precio = Double.parseDouble(sc.nextLine());
                    System.out.println("Duración en meses:");
                    int meses = Integer.parseInt(sc.nextLine());
                    proveedor.agregarContrato(new Contrato(precio, meses));
                    System.out.println("Contrato creado correctamente.");
                    pausa();
                }
                break;

                case 5: { // Verificar si un cliente posee proveedores de un tipo determinado
                    System.out.println("-----------------");
                    if (clientes.isEmpty()) {
                        System.out.println("No hay clientes registrados, ingrese un cliente previamente");
                        pausa();
                        break;
                    }
                    ClienteEmpresa cliente = buscarCliente(sc);
                    if (cliente != null) {
                        System.out.println("Ingrese tipo de proveedor: (Cloud / SaaS / Pago)");
                        String tipo = sc.nextLine();
                        boolean tiene = cliente.tieneProveedorTipo(tipo);
                        if (tiene) {
                            System.out.println("El cliente si cuenta con proveedores tipo:  " + tipo);
                        } else {
                            System.out.println("El cliente no cuenta con proveedores tipo: " + tipo);
                        }
                    }
                    pausa();
                }
                break;
                case 6: { // Listar contratos activos
                    System.out.println("---- CONTRATOS ACTIVOS DEL SISTEMA ----");
                    for (ClienteEmpresa c : clientes) {
                        System.out.println(c.listarContratosActivos());
                    }
                    pausa();
                }
                break;
                case 7: {
                    System.out.println("-----------------");
                    System.out.println("Saliendo del sistema...");
                    System.exit(0);
                }
                break;
                default:
                    System.out.println("Opción inválida");
            }

        } while (opc != 7);
    }

    public static ClienteEmpresa buscarCliente(Scanner sc) {
        System.out.println("Nombre del cliente:");
        String nombre = sc.nextLine();
        for (ClienteEmpresa c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        System.out.println("Cliente no encontrado");
        return null;
    }

    public static Proveedor buscarProveedor(Scanner sc) {
        System.out.println("Nombre del proveedor:");
        String nombre = sc.nextLine();
        for (Proveedor p : proveedores) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        System.out.println("Proveedor no encontrado");
        return null;
    }

    public static void menu() {
        System.out.println("------ MENU GESTOR DE PROVEEDORES ------");
        System.out.println("1. Crear proveedor");
        System.out.println("2. Crear cliente empresarial");
        System.out.println("3. Asociar proveedor a cliente");
        System.out.println("4. Crear contrato");
        System.out.println("5. Verificar tipo de proveedor");
        System.out.println("6. Listar contratos activos");
        System.out.println("7. Salir");
        System.out.println("---------------------------------------");
    }

    public static void pausa() {
        System.out.println("__________Presione enter para continuar__________");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
    }
}
