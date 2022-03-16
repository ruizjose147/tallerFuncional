package co.com.sofka.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Factura {

    String descripcion;
    int importe;
    int cantidad;
    LocalDate fechaFactura;
    int codigoFactura;


    public Factura(String descripcion, int importe, int cantidad, LocalDate fechaFactura, int codigoFactura) {
        this.descripcion = descripcion;
        this.importe = importe;
        this.cantidad = cantidad;
        this.fechaFactura = fechaFactura;
        this.codigoFactura = codigoFactura;
    }

    Factura(String descripcion, int importe){
        this.descripcion=descripcion;
        this.importe=importe;
    }

    int getImporte(){
        return importe;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public int getCodigoFactura() {
        return codigoFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "descripcion='" + descripcion + '\'' +
                ", importe=" + importe +
                ", cantidad=" + cantidad +
                ", fechaFactura=" + fechaFactura +
                ", codigoFactura=" + codigoFactura +
                '}';
    }

    public static void main(String[] args) {
        // registros de la data
        Factura f=new Factura("ordenador",1000, 2, LocalDate.of(1991,10,16), 1);
        Factura f2=new Factura("movil",300, 4, LocalDate.of(1997,01,07),2);
        Factura f3=new Factura("imporesora",200, 5, LocalDate.of(1988,10,11), 3);
        Factura f4=new Factura("imac",1500, 4, LocalDate.of(2000,11,27), 4);

        // generar una lista
        List<Factura> lista=new ArrayList<Factura>();

        // agregar los productos de la factura
        lista.add(f);
        lista.add(f2);
        lista.add(f3);
        lista.add(f4);


        // filtraje funcional con streams
        Factura facturaFiltro=lista.stream()
                .filter(elemento->elemento.getImporte()<1000)
                .findFirst()
                .orElseThrow();
        System.out.println(facturaFiltro.getImporte());
        System.out.println("\n");


        //filtraje por cantidadProductos
        System.out.println("filtraje por cantidad de Productos");

        List<Factura> facturaFiltroCantidad= lista.stream()
                .filter(elemento -> elemento.getCantidad() == 4)
                .collect(Collectors.toList());

        facturaFiltroCantidad.forEach(System.out::println);
        System.out.println("\n");

        //Filtrar por codigo de factura
        System.out.println("Filtrar por codigo de factura");
        Factura filtrarCodigo=lista.stream()
                .filter(elemento->elemento.getCodigoFactura() == 2)
                .findFirst()
                .orElseThrow();
        System.out.println(filtrarCodigo);
        System.out.println("\n");

        //filtrar por fecha <
        System.out.println("filtrar por fecha igual");

        List<Factura> filtrarPorFechaIgual= lista.stream()
                .filter(elemento -> elemento.getFechaFactura().equals(LocalDate.of(2022, 03, 16)))
                .collect(Collectors.toList());

        filtrarPorFechaIgual.forEach(System.out::println);
        System.out.println("\n");

        //filtrar por fecha <
        System.out.println("filtrar por fecha <");

        List<Factura> filtrarPorFechaMenor= lista.stream()
                .filter(elemento -> elemento.getFechaFactura().isBefore(LocalDate.of(1990, 03, 17)))
                .collect(Collectors.toList());

        filtrarPorFechaMenor.forEach(System.out::println);
        System.out.println("\n");

        //filtrar por fecha >
        System.out.println("filtrar por fecha >");

        List<Factura> filtrarPorFechaMayor= lista.stream()
                .filter(elemento -> elemento.getFechaFactura().isAfter(LocalDate.of(1999, 03, 15)))
                .collect(Collectors.toList());

        filtrarPorFechaMayor.forEach(System.out::println);
        System.out.println("\n");
    }



}

