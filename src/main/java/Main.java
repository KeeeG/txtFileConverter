import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

        public static void main(String[] args) throws Exception {

            String[] types = new String[] { "R", "G", "B" };

            // Convert String Array to List
            List<String> typesList = Arrays.asList(types);
            JSONObject results = new JSONObject();

            List<JSONObject> healthyLine  = new ArrayList();
            List<JSONObject> unhealthyLine  = new ArrayList();
            List<String> line  = new ArrayList();

            File file = new File("/Users/keeg/workspace/txtFileConverter/src/main/resources/input.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()){
                line = Arrays.asList(sc.nextLine().split(";"));
                JSONObject obj = new JSONObject();
                obj.put("numReference", line.get(0));
                obj.put("type", line.get(1));
                obj.put("price", line.get(2));
                obj.put("size", line.get(3));

                if ( !typesList.contains(line.get(1)) || (line.get(0).length() != 10) ){
                    unhealthyLine.add(obj);
                }
                else {
                    healthyLine.add(obj);
                }
            }

            results.put("inputFile" , "EEEEEEEEEEEe");
            results.put("references" , healthyLine);
            results.put("errors" , unhealthyLine);



            try (FileWriter filer = new FileWriter("/Users/keeg/workspace/txtFileConverter/src/main/resources/output.json")) {

                filer.write(results.toString());
                filer.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
}


