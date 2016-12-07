import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Day7 {

    public static void main(String[] args) throws IOException {
        ArrayList<String> outside = new ArrayList<>();
        ArrayList<String> inside = new ArrayList<>();
        int count = 0;
        int lineNumber = 0;

        for (String line : Files.readAllLines(Paths.get("C:/d7.txt"))) {
            StringBuilder currentString = new StringBuilder(),
                    currentOutside = new StringBuilder(),
                    currentInside = new StringBuilder();
            int i = 0;
            for (char c : line.toCharArray()) {
                if (c == '[') {
                    currentOutside.append(currentString.toString());
                    currentString = new StringBuilder();
                } else if (c == ']') {
                    currentInside.append(currentString.toString());
                    currentString = new StringBuilder();
                } else {
                    currentString.append(c);
                }
                if (i == line.length()-1) {
                    currentOutside.append(currentString.toString());
                }
                i++;
            }
            outside.add(currentOutside.toString());
            inside.add(currentInside.toString());

            ArrayList<String> existingABAs = getABAsAsBABs(inside.get(lineNumber));

            for (String ABA : existingABAs) {
                if (outside.get(lineNumber).contains(ABA)) {
                    count++;
                    break;
                }
            }
            lineNumber++;
        }
        System.out.println(count + " valid IPs");
    }

    private static ArrayList<String> getABAsAsBABs (String insideString) {
        ArrayList<String> ABAs = new ArrayList<>();
        for (int i = 0; i < insideString.length()-2; i++) {
            if (insideString.charAt(i) == insideString.charAt(i+2) && insideString.charAt(i) !=  insideString.charAt(i+1)) {
                ABAs.add(new StringBuilder().append(insideString.charAt(i+1)).append(insideString.charAt(i)).append(insideString.charAt(i+1)).toString());
            }
        }
        return ABAs;
    }
}
