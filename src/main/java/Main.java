import org.json.JSONObject;
import org.json.XML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class Main {

    final static String[] types = new String[] { "R", "G", "B" };
    final static List<String> typesList = Arrays.asList(types);

        public static void main(String[] args) throws Exception {

            Map<String, List<List<String>>> fileContent = new HashMap<>();

            // Checking if first argument ( input file path is not null
            if (args[0]!= null){
                fileContent = parseTextFile(args[0]);
                JSONObject results = new JSONObject();

                // Checking if the output will be JSON or not
                if (  args[1] != null && args[1].toString().toUpperCase().equals("JSON")){
                    results = buildJSON(fileContent, args[0], args[2]);

                    try (FileWriter filer = new FileWriter( args[2] )) {

                        filer.write(results.toString());
                        filer.flush();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }


        private static JSONObject buildJSON (Map<String, List<List<String>>> file, String inputPath, String outputPath)throws Exception{

            JSONObject results = new JSONObject();

            results.put("inputFile", inputPath);
            List<JSONObject> healthyLine  = new ArrayList();
            List<JSONObject> unhealthyLine  = new ArrayList();

            for (int i = 0; i < file.get("references").size(); i++){

                JSONObject obj = new JSONObject();

                obj.put("numReference", file.get("references").get(i).get(0));
                obj.put("type", file.get("references").get(i).get(1));
                obj.put("price", file.get("references").get(i).get(2));
                obj.put("size", file.get("references").get(i).get(3));

                healthyLine.add(obj);

            }
            results.put("references" , healthyLine);

            for (int i = 0; i < file.get("errors").size(); i++){

                JSONObject obj = new JSONObject();

                obj.put("numReference", file.get("errors").get(i).get(0));
                obj.put("type", file.get("errors").get(i).get(1));
                obj.put("price", file.get("errors").get(i).get(2));
                obj.put("size", file.get("errors").get(i).get(3));

                unhealthyLine.add(obj);
            }
            results.put("errors" , unhealthyLine);

            return results;
        }

        private static Map<String, List<List<String>>> parseTextFile (String inputFile) throws Exception{

            Map<String, List<List<String>>> results = new HashMap<>();
            List<List<String>> healthyLines = new ArrayList<>();
            List<List<String>> unhealthyLines = new ArrayList<>();

            if ( ! inputFile.isEmpty()) {

                File file = new File( inputFile );
                Scanner sc = new Scanner(file);

                while (sc.hasNextLine()){
                    List<String> line = new ArrayList<>();
                    line = Arrays.asList(sc.nextLine().split(";"));

                    if ( !typesList.contains(line.get(1)) || (line.get(0).length() != 10) ){
                        unhealthyLines.add(line);
                    }
                    else {
                        healthyLines.add(line);
                    }
                }
                results.put("references", healthyLines);
                results.put("errors", unhealthyLines);
            }
            return results;
        }

}


