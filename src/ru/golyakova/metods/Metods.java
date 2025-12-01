package ru.golyakova.metods;
import ru.golyakova.cat.*;

import java.util.*;

public class Metods {
    public static <T> void addElement(List<T> first, List<T> second, List<T> result){
        for(T element : first){
            if(!second.contains(element) && !result.contains(element)){
                result.add(element);
            }
        }
    }

    public static <T> void printQueue(Queue<T> queue){
        if(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size -i- 1; j++) {
                    queue.add(queue.poll());
                }
                T element = queue.poll();
                System.out.print(element + " ");
                queue.add(element);
                for(int j = 0; j<i; j++){
                    queue.add(queue.poll());
                }
            }
        }
    }

    public static void meowsCare(Meowable meowable){
        Random random = new Random();
        int count = random.nextInt(5)+ 3;
        for(int i = 0; i< count; i++){
            meowable.meow();
        }
    }

    public static void processResult(Map<String, int[]> applicants){
        System.out.println("Абитуриенты, не допущенные к экзаменам: ");
        boolean flag = false;
        int count = 0;

        for(Map.Entry<String, int[]> entry : applicants.entrySet()){
            String name = entry.getKey();
            int[] scores= entry.getValue();

            if(scores[0] < 30 || scores[1] < 30){
                count++;
                System.out.println(name + " " + scores[0] + " " + scores[1]);
                flag = true;
            }
        }
        if(!flag){
            System.out.println("Таких абитуриентов нет");
        }
        System.out.println();
        System.out.println("Всего абитуриентов: " + applicants.size());
        System.out.println("Не допущенных абитуриентов: " + count);
    }

    public static Set<Character> findConsonants(Set<String> words, Set<Character> consonants){
        Set<Character> result = new TreeSet<>();
        for(char consonant : consonants){
            int count = 0;
            for(String word: words){
                if(word.contains(String.valueOf(consonant))){
                    count++;
                    if(count> 1){
                        result.add(consonant);
                        break;
                    }
                }
            }
        }
        return result;
    }
}
