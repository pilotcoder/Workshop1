import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};
    static String [][] temp;

    public static void main(String[] args)  {
        temp = readFile(FILE_NAME);



        while (true) {
            System.out.print(ConsoleColors.BLUE);
            System.out.println("Please select an option:");
            System.out.print(ConsoleColors.RESET);
            for (String option :
                    OPTIONS) {
                System.out.println(option);
            }
            Scanner scanner = new Scanner(System.in);
            String str = scanner.next();
            switch (str){
                case "add":
                    System.out.println("add");
                    break;
                case "list":
                    list(temp);
                    break;
                case "remove":
                    removeTask(temp);
                    System.out.println(Arrays.toString(temp));
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Źle");




            }

        }
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

    public static void list (String[][] tab){
        for (int i = 0; i < tab.length; i++) {
            System.out.print( (i+1) + ": ");
            for (int j = 0; j < tab[i].length; j++) {
                System.out.print(tab[i][j] + " ");

            }
            System.out.println();

        }
    }

    public static void removeTask(String[][] tab){
        System.out.println("Enter Task number to remove");
        Scanner scan = new Scanner(System.in);

        int parse ;
        while (true){String row = scan.next();
        try {
            parse = Integer.parseInt(row);
            if (parse > tab.length) {
                System.out.println("Enter value between 0 and " + tab.length);

            } else {
                System.out.println("Selected " + parse + "to delete");
                break;
            }
        }catch (NumberFormatException e) {
            System.out.println("Enter number between 0 and " + tab.length);

        }

        }
        parse = parse-1;
        temp = ArrayUtils.remove(tab, parse);
    }



}
