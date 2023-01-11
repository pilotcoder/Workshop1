import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args)  {
        String[][] tab = readFile(FILE_NAME);

        menuList(OPTIONS);

    }
    public static String[][] readFile (String FILE_NAME){
        Path path1 = Paths.get(FILE_NAME);  //Tworzymy ścieżkę Path
        String [][] tab = null;
        try {
            List<String> list = Files.readAllLines(path1);
            tab = new String[list.size()][list.get(0).split(",").length];
            tab = new String[list.size()][list.get(0).split(",").length];
            System.out.println(list);

            for (int i = 0; i < list.size(); i++) {
                String[] split = list.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd odczytu pliku");;
        }return tab;
    }

    public static void menuList (String[] tab){
       System.out.println(ConsoleColors.BLUE);
        System.out.println("Please select an option:");
        System.out.println(ConsoleColors.RESET);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String str = scanner.next();
            if (str.equalsIgnoreCase(OPTIONS[0])) {
                System.out.println("wybrałeś add");
                break;
            }
            if (str.equalsIgnoreCase(OPTIONS[1])) {
                System.out.println("wybrałeś remove");
                break;
            }
            if (str.equalsIgnoreCase(OPTIONS[2])) {
                System.out.println("wybrałeś list");
                break;
            }if (str.equalsIgnoreCase(OPTIONS[3])) {
                System.out.println("wybrałeś exit");
                break;
            } else {
                System.out.println("źle wybrałeś");
            }

        }
    }
    public static class addTask{}
}
