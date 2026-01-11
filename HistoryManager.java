package tictactoe;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoryManager {

    private static final String FILE_NAME = "history.txt";

    public static void saveHistory(String p1, String p2, String winner) {
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {

            DateTimeFormatter fmt =
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            String time = LocalDateTime.now().format(fmt);

            fw.write(time + " | " + p1 + " vs " + p2 +
                    " | Winner: " + winner + "\n");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan history");
        }
    }

    public static ArrayList<String> readHistory() {
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            list.add("Belum ada history permainan.");
        }
        return list;
    }

    public static void clearHistory() {
        try (FileWriter fw = new FileWriter(FILE_NAME)) {
            fw.write("");
        } catch (IOException e) {
            System.out.println("Gagal menghapus history");
        }
    }
}
