package org.example;


import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculateWord;

public class Main {
    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(2, "Ayşe", "Demir"));
        employees.add(new Employee(1, "Ali", "Yılmaz"));
        employees.add(new Employee(3, "Mehmet", "Can"));
        employees.add(new Employee(4, "Zeynep", "Aslan"));
        employees.add(new Employee(2, "Ayşe", "Demir"));

        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
                " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
                " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
                " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
                " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" +
                " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
                " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
                " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
                " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
                " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
                " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        System.out.println("\nİlk 10 kelimenin frekansı:");
        Map<String, Integer> result = calculateWord(text);
        result.entrySet().stream().limit(10).forEach(entry ->
                System.out.println(entry.getKey() + " : " + entry.getValue()));

    }
    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();
        for (Employee emp : list) {
            if (!seen.add(emp)) {
                if (!duplicates.contains(emp)) {
                    duplicates.add(emp);
                }
            }
        }
        return duplicates;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> list){
        Map<Employee, Integer> countMap= new HashMap<>();
        for(Employee emp : list){
            countMap.put(emp, countMap.getOrDefault(emp, 0) + 1);
        }
        Map<Integer, Employee> result = new HashMap<>();
        for(Map.Entry<Employee, Integer> entry : countMap.entrySet()){
            result.put(entry.getKey().getId(), entry.getKey());
        }
        return result;
    }

    public static List<Employee> removeDuplicates(List<Employee> list){
        Map<Employee, Integer> freqMap = new HashMap<>();

        for (Employee emp : list) {
            freqMap.put(emp, freqMap.getOrDefault(emp, 0) + 1);
        }

        List<Employee> result = new LinkedList<>();
        for (Map.Entry<Employee, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }

        return result;
    }

}


