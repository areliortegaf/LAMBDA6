/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscurso6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author asortega
 */
public class EjerciciosCurso6 {

    //usada en varios ejemplos miLista<3
    List<tipo> miLista = Arrays.asList(
            new tipo("te", "quiero", "mucho"),
            new tipo("te", "amo", "mucho"),
            new tipo("te", "odio", "mucho")
    );

    public static void main(String[] args) {
        //USANDO MAP
        System.out.println("\n-----------------Imprimir Map---------------");
        Map<Integer, String> nombres = new HashMap<>();
        nombres.put(1, "Areli");
        nombres.put(2, "Sarai");
        nombres.put(3, "Luis");
        nombres.put(4, "Paris");

        String result = "";

        result = nombres.entrySet().stream()
                .filter(map -> "Luis".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        System.out.println("Te amo : " + result);

        //FINDFIRST
        System.out.println("\n-----------------Imprimir FindFirst---------------");
        List<Integer> numeros = Arrays.asList(8, 2, 3, 4, 5);
        Optional<Integer> o = numeros.stream()
                .findFirst();//allMatch() noneMatch
        if (o.isPresent()) {
            System.out.println(o.get());
        } else {
            System.out.println("SIN VALOR");
        }

        //NONE DETERMINISTIC FIND METHODS.. PEEK
        //SE USAN CUANDO CORRER ALGO EN PARALELO ES MAS EFECTIVO COMO EL THREADING
        //findAny() anyMatch() 
        List<String> listita = Arrays.asList("1", "1", "2", "3", "4");

        listita.stream()
                .limit(2)
                .peek(System.out::println);

        //COUNTING
        System.out.println("\n-----------------Imprimir Counting---------------");
        Stream<String> secuencia = Stream.of("1", "2", "5");
        long contar = secuencia.collect(Collectors.counting());
        System.out.println(contar);

        System.out.println("\n-----------------Imprimir minBy---------------");
        Stream<String> sMin = Stream.of("1", "2", "3"); //el minimo al revez imprime 3
        Optional<String> minimoPor = sMin.collect(Collectors.minBy(Comparator.reverseOrder()));

        if (minimoPor.isPresent()) {
            System.out.println(minimoPor.get());
        } else {
            System.out.println("Sin valor");
        }

        System.out.println("\n-----------------Imprimir maxBy---------------");
        Stream<String> sMax = Stream.of("1", "2", "3");  //el maximo al revez imprime 1
        Optional<String> maximoPor = sMax.collect(Collectors.maxBy(Comparator.reverseOrder()));

        if (maximoPor.isPresent()) {
            System.out.println(maximoPor.get());
        } else {
            System.out.println("Sin valor");
        }
        System.out.println("\n-----------------Imprimir average---------------");
        IntStream i = IntStream.of(6, 5, 7, 1, 2, 3, 3);
        OptionalDouble d = i.average();
        if (d.isPresent()) {
            System.out.println(d.getAsDouble());
        } else {
            System.out.println("siin valor");
        }

        System.out.println("\n-----------------Imprimir sorted---------------");
        List<Integer> listaSorted = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        listaSorted.stream()
                .filter(x -> x % 3 == 0)
                .sorted((x, y) -> y - x)
                .map(x -> x * 3)
                .forEach(System.out::println);

        System.out.println("\n-----------------Imprimir reversed---------------");
        List<String> lenguajes = Arrays.asList("JAVA", "HTML", "JAVASCRIPT", "PL/SQL");

        //same but reverse
        System.out.println("\n revez:");
        Comparator<String> comp = (aName, bName) -> aName.compareTo(bName);

        lenguajes.stream().sorted(comp.reversed())
                .forEach(System.out::println);

        
        
    }

}
