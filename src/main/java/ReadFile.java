import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {

    public static ArrayList<String> getList(String dName) throws IOException {
        String line;
        ArrayList<String> listOfCommands = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader("C:\\AdventOfCode\\" + dName + ".txt"));
        while ((line = text.readLine()) != null) listOfCommands.add(line.replaceAll(" ", ""));

        return listOfCommands;
    }

    //P1
    public static int getGameList(ArrayList<String> list) {
        int count = 0;
        ArrayList<Integer> blueCount = ReadFile.isPossible("blue", list);
        ArrayList<Integer> redCount = ReadFile.isPossible("red", list);
        ArrayList<Integer> greenCount = ReadFile.isPossible("green", list);
        int colorSize = Math.max(greenCount.size(), (Math.max(blueCount.size(), redCount.size())));
        for (int i = 0; i < colorSize; i++) {
            try {
                if (blueCount.get(i) == 0 && redCount.get(i) == 0 && greenCount.get(i) == 0) {
                    count += i + 1;

                }
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
        return count;
    }

    //P1
    public static ArrayList<Integer> isPossible(String color, ArrayList<String> game) {
        ArrayList<String> cubesCount = new ArrayList<>();
        ArrayList<Integer> possibleGame = new ArrayList<>();
        boolean isNumeric = false;
        int colorInt = 0;
        switch (color) {
            case "red":
                colorInt = 12;
                break;
            case "green":
                colorInt = 13;
                break;
            case "blue":
                colorInt = 14;
                break;
        }
        int colorCounter;
        int start;
        int index;
        for (String s : game) {
            colorCounter = 0;
            index = 0;
            cubesCount.clear();
            while (index != -1) {
                index = s.indexOf(color, index);
                try {
                    isNumeric = s.substring(index - 2, index - 1).chars().allMatch(Character::isDigit);
                } catch (IndexOutOfBoundsException ignored) {
                }
                if (isNumeric) {
                    start = 2;
                } else {
                    start = 1;
                }
                if (index != -1) {
                    cubesCount.add(s.substring(index - start, index));
                    index++;
                }
            }

            for (String value : cubesCount) {
                if (Integer.parseInt(value) > colorInt) {
                    colorCounter += 1;
                }
            }
            if (colorCounter == 0) {
                possibleGame.add(0);
            } else {
                possibleGame.add(1);
            }
        }
        return possibleGame;
    }
    //P2
    public static ArrayList<Integer> determineMinimum(String color, ArrayList<String> game) {
        ArrayList<Integer> cubesCount = new ArrayList<>();
        ArrayList<Integer> possibleMin = new ArrayList<>();
        boolean isNumeric = false;
        int start;
        int index;
        for (String s : game) {
            index = 0;
            cubesCount.clear();
            while (index != -1) {
                index = s.indexOf(color, index);
                try {
                    isNumeric = s.substring(index - 2, index - 1).chars().allMatch(Character::isDigit);
                } catch (IndexOutOfBoundsException ignored) {
                }
                if (isNumeric) {
                    start = 2;
                } else {
                    start = 1;
                }
                if (index != -1) {
                    cubesCount.add(Integer.parseInt(s.substring(index - start, index)));
                    index++;
                }
            }
            int max = cubesCount.get(0);
            for (int i = 1; i < cubesCount.size(); i++) {
                if (max < cubesCount.get(i)) {
                    max = cubesCount.get(i);
                }

            }
            possibleMin.add(max);
        }
        return possibleMin;

    }


    //P2
    public static int getLargestList(ArrayList<String> list) {
        int count = 0;
        ArrayList<Integer> blueCount = ReadFile.determineMinimum("blue", list);
        ArrayList<Integer> redCount = ReadFile.determineMinimum("red", list);
        ArrayList<Integer> greenCount = ReadFile.determineMinimum("green", list);
        int colorSize = Math.max(greenCount.size(), (Math.max(blueCount.size(), redCount.size())));
        for (int i = 0; i < colorSize; i++) {
            try {
                count += blueCount.get(i)*redCount.get(i)*greenCount.get(i);
            } catch (IndexOutOfBoundsException ignored) {

            }
        }
        return count;
    }
}