package Task2;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Artur\\IdeaProjects25.10.2022\\homeworkAdvanced7\\src\\Task2\\task2.txt");
        Animal animal = new Animal("Tom", 3, "Black");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))
        ) {
            out.writeObject(animal);
            Animal animal1 = (Animal) in.readObject();
            System.out.println(animal);
            System.out.println(animal1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
