import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;

class Test<T, U> {
    T objT;
    U objU;

    Test(T objT, U objU) {
        this.objT = objT;
        this.objU = objU;
    }

    public T getObj() {
        return this.objT;
    }
}

class Vehicle {
    protected String name = "Honda";

    public void honk() {
        System.out.println(name + " Honk honk!!");
    }
}

class Car<T, W> extends Vehicle {
    T model;
    W wheels;

    Car(T model, W wheels) {
        this.model = model;
        this.wheels = wheels;
    }

    public String engineType = "V6";

    public void getModel() {
        System.out.println("This is " + this.name + " " + this.model);
    }

    public void getWheels() {
        System.out.println("It has " + this.wheels + " wheels.");
    }

    public void getEngineType() {
        System.out.println("The engine that powers this model is " + this.engineType);
    }
}

abstract class Animal {
    public void sleep() {
        System.out.println("ZZZzz");
    }
}

class Dog extends Animal {
    public void makeSound() {
        System.out.println("Woof Woof!!");
    }
}

public class Main {
    public static void main(String[] args) {

        String sentence = "Today is a good day.";
        System.out.println(sentence.indexOf("x"));
        System.out.println(sentence.indexOf("a", 4));
        // split by empty space.
        int length_of_word = sentence.split("\\s").length;
        String[] splitString = sentence.split("\\s");
        System.out.println(Arrays.toString(splitString));
        System.out.println(Arrays.asList(splitString));
        System.out.println(length_of_word);
        System.out.println(Arrays.hashCode(splitString));
        System.out.println(primeNaive(4));
        System.out.println(primeSlightlyBetter(11));

        try {
            File myFile = new File("created_and_written.txt");
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("The file already exists!!!");
            }

            FileWriter myWriter = new FileWriter("created_and_written.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");

            File fileToRead = new File("readable_file.txt");
            Scanner myReader = new Scanner(fileToRead);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();

            File myFileToDelete = new File("delete_this_file.txt");
            if (myFileToDelete.delete()) {
                System.out.println("Deleted file: " + myFileToDelete.getName());
            } else {
                System.out.println("Failed to delete the file because the file does not exist.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.getStackTrace();
        }

        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.sleep();

        Car<String, Integer> myCivic = new Car<>("Civic", 4);
        myCivic.honk();
        myCivic.getModel();
        myCivic.getWheels();
        myCivic.getEngineType();

        Test<Integer, String> iObj = new Test<>(15, "This is object 1.");
        System.out.println(iObj.getObj());

        Test<String, Boolean> sObj = new Test<>("Cracking the Coding Interview", true);
        System.out.println(sObj.getObj());

        ArrayList<String> merged_items = merge(new String[]{"Apple", "Banana", "Citrus", "Dates"}, new String[]{"Elderberry", "Fig", "Grape", "Honeydew"});
        System.out.println(merged_items);

        int[] new_array_list = new int[]{2, 3, 4};
        System.out.println(Arrays.toString(new_array_list));

        int[] numbers = {22, 3355, 66, 78};
        System.out.println(Arrays.toString(numbers));

        boolean uniqueChar = isUniqueChars("graphs");

        System.out.println(uniqueChar ? "True: The string is unique." : "False: The string has duplicates.");

        int given_num = 10000;
        int display_sum = sum(given_num);

        System.out.println(given_num + " is the number provided and its sum is: " + display_sum);

        callScanner();
    }

    public static boolean primeNaive(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean primeSlightlyBetter(int n) {
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void callScanner() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter username");

        String username = myObj.nextLine();
        System.out.println(username);
    }

    public static int sum(int number_to_sum) {
        return number_to_sum > 0 ? number_to_sum + sum(number_to_sum - 1) : 0;
    }

    public static ArrayList<String> merge(String[] words, String[] more_words) {
        ArrayList<String> sentence = new ArrayList<>();
        sentence.addAll(Arrays.asList(words));
        sentence.addAll(Arrays.asList(more_words));
        return sentence;
    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] character_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);

            char char_val = str.charAt(i);
            System.out.println(val + " is the character code for " + "( " + char_val + " )");


            if (character_set[val]) {
                System.out.println("The string is not unique");
                return false;
            }

            character_set[val] = true;
        }

        System.out.println("The string is " + str);

        return true;
    }
}