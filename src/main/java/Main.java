import java.io.File;
import java.util.Scanner;

public class Main {

        public static void main(String[] args) throws Exception {

            File file = new File("/Users/keeg/workspace/txtFileConverter/src/main/resources/input.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine())
                System.out.println(sc.nextLine());
        }

}


