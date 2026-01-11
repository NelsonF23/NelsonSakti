package tictactoe;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveResult(String data) {
        try (FileWriter fw = new FileWriter("score.txt", true)) {
            fw.write(data + "\n");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data!");
        }
    }
}
