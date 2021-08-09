import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() {
        ClassLoader classLoader = getClass().getClassLoader();
        //String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        File file = new File(classLoader.getResource("RawData.txt").getFile());
        //return result;
        StringBuilder result = new StringBuilder("");

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    public static void main(String[] args) {
        String output = (new Main()).readRawDataToString();
        System.out.println(output);

    }

    public String findAlphaCharacters()  {
        String result = "";
        String jerkTest = readRawDataToString();
        Pattern pattern = Pattern.compile("[A-Z]", Pattern.CASE_INSENSITIVE); //did it this way because the text has Hamlet and HAMLET but not hamlet
        Matcher matcher = pattern.matcher(jerkTest);
        String alpha = "";
        while (matcher.find()) {
            alpha = matcher.group();
            result += alpha;
        }

        return result;
    }

    public String getList() {
        //String result = "";
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("##");
        Matcher matcher = pattern.matcher(jerkText);

        return matcher.replaceAll("\n");
    }

    public int countCheapMilk() { //Milk for 1.23
        String jerkText = readRawDataToString();
        Pattern pattern = Pattern.compile("milk", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(jerkText);

        return 0;
    }
}
