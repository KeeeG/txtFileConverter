import org.json.JSONObject;
import org.json.XML;

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
            List<String> typesList = Arrays.asList(types);

            File file = new File( args[0] );
            Scanner sc = new Scanner(file);


            if (  args[1] != null && args[1].toString().toUpperCase().equals("JSON")){

                JSONObject results = new JSONObject();

                List<JSONObject> healthyLine  = new ArrayList();
                List<JSONObject> unhealthyLine  = new ArrayList();
                List<String> line  = new ArrayList();

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

                results.put("inputFile" ,  args[0]);
                results.put("references" , healthyLine);
                results.put("errors" , unhealthyLine);

                try (FileWriter filer = new FileWriter( args[2] )) {

                    filer.write(results.toString());
                    filer.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (args[1].toString().toUpperCase().equals("XML")){
               // String xml = XML.toString(results);
                System.out.println("XML");
            }























        }
}


