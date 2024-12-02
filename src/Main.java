import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        int counterSafe = 0;
        int counterUnSafe = 0;
        String fileNameTwo = "src/data.txt";
        ArrayList <Integer[]> levels = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameTwo))){

            String line;

            while ((line = reader.readLine()) != null){

                line = line.trim();

                if (line.isEmpty()) continue;

                String[] stringNumbers = line.split(" ");

                ArrayList <Integer> testList = new ArrayList<>();
                for(String number: stringNumbers){
                    testList.add(Integer.parseInt(number));
                }

                int j = 1;
                for (int i = 0; i < testList.size()-1; i++){
                    if (Objects.equals(testList.get(i), testList.get(j))){
                        counter++;

                    }
                    else if (testList.get(i) > testList.get(j)) {
                        if (testList.get(i) - testList.get(j) > 3){
                            counter++;

                        }
                    }
                    else if (testList.get(i) < testList.get(j)) {
                        if (testList.get(j) - testList.get(i) > 3){
                            counter++;

                        }
                    }
                    j++;
                }
                if (counter == 0){
                    j = 1;

                    if (testList.get(0) < testList.get(1)){
                        for (int i = 0; i < testList.size()-1; i++){
                            if (testList.get(i) > testList.get(j)){
                                counter++;
                            }
                            j++;
                        }
                    }
                    else if (testList.get(0) > testList.get(1)){
                        for (int i = 0; i < testList.size()-1; i++){
                            if (testList.get(i) < testList.get(j)){
                                counter++;
                            }
                            j++;
                        }
                    }
                }
                if (counter == 0){
                    counterSafe += 1;
                }
                else {
                    counterUnSafe += 1;
                }
                counter = 0;
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found!" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading the data" + e.getMessage());
        }

        System.out.println("Safe levels: " + counterSafe);
        System.out.println("Unsafe levels: " + counterUnSafe);

    }
}