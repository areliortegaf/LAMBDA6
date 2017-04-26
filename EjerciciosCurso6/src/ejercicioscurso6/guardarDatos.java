/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioscurso6;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author asortega
 */
public class guardarDatos {

    public static void main(String... args) {
System.out.println("\n-----------------gUARDAR DATOS DE UN ARRAYLIST EN UN VERCTOR---------------");
        //GUARDAR LOS ELEMENTOS DE UN ARRAY EN UN VECTOR
        ArrayList<String> arrayList = new ArrayList<String>();

        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");

        Vector<String> vector = new Vector<String>();

        vector.add("A");
        vector.add("B");
        vector.add("D");
        vector.add("E");
        vector.add("F");
        vector.add("G");
        vector.add("H");

        System.out.println(vector);
        Collections.copy(vector, arrayList);
        System.out.println(vector);

        System.out.println("\n-----------------Imprimir averagingDouble---------------");
        Stream<String> s = Stream.of("1", "2", "3");
        double o = s.collect(Collectors.averagingDouble(n -> Double.parseDouble(n)));
        System.out.println(o);

        /*
        DOCUMENTACION DE ORACLE
         // Accumulate names into a List
     List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

     // Accumulate names into a TreeSet
     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

     // Convert elements to strings and concatenate them, separated by commas
     String joined = things.stream()
                           .map(Object::toString)
                           .collect(Collectors.joining(", "));

     // Compute sum of salaries of employee
     int total = employees.stream()
                          .collect(Collectors.summingInt(Employee::getSalary)));

     // Group employees by department
     Map<Department, List<Employee>> byDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

     // Compute sum of salaries by department
     Map<Department, Integer> totalByDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,
                                                   Collectors.summingInt(Employee::getSalary)));

     // Partition students into passing and failing
     Map<Boolean, List<Student>> passingFailing =
         students.stream()
                 .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
        
        
        
         */
        
        
    }

}
