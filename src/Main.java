import java.util.ArrayList;

public class Main {

    private static double testMap(Map<String, Integer> map, String filename){
        long startTime = System.nanoTime();

        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)){
            System.out.println("Total words " + words.size());

            for(String word: words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Pride: " + map.get("pride"));
            System.out.println("Prejudice: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        String filename = "pride-and-prejudice.txt";

        BSTMap<String, Integer> bstSet = new BSTMap<>();
        double time1 = testMap(bstSet, filename);
        System.out.println("BST Map: " + time1 + " s");

        System.out.println();

        LinkedListMap<String, Integer> linkedListSet = new LinkedListMap<>();
        double time2 = testMap(linkedListSet, filename);
        System.out.println("Linked List Map: " + time2 + " s");
    }
}
