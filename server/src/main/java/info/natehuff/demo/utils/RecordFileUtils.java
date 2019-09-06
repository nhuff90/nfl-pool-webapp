package info.natehuff.demo.utils;

import com.sun.org.apache.regexp.internal.RE;
import info.natehuff.demo.dto.Pick;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RecordFileUtils {

    private static String RECORD_FILE = "src/main/resources/data/record.dat";

    public static String returnOverallRecord() throws IOException {

        FileReader fileReader = new FileReader(new File(RECORD_FILE));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuffer.append(line);
            stringBuffer.append("\n");
        }
        fileReader.close();
        System.out.println("Contents of file:");
        System.out.println(stringBuffer.toString());

        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        try {
            returnOverallRecord();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeWeeklyRecord(String ret, int week) {
        List<String> lines = new ArrayList<>();
        String line = "";

        try (BufferedReader br = new BufferedReader(new FileReader(new File(RECORD_FILE)))) {

            String st;
            while ((st = br.readLine()) != null)
                lines.add(st);


            lines.set(week-1, ret);
            Files.write(Paths.get(RECORD_FILE), lines, Charset.forName("UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
