import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Data {

    String getRandomData(String path, Boolean isMale) throws IOException {
        ArrayList<String> fileData = getFileData(path);
        if (isMale || path.contains("Женские имена.txt")) {
            return fileData.get((int) (Math.random() * fileData.size()));
        } else if (path.contains("Отчества.txt")){
            return fileData.get((int) (Math.random() * fileData.size())).replace("вич", "вна");
        } else {
            return fileData.get((int) (Math.random() * fileData.size())) + "а";
        }
    }

    String getRandomData(String path) throws IOException {
        ArrayList<String> fileData = getFileData(path);
        return fileData.get((int) (Math.random() * fileData.size()));
    }

    private ArrayList<String> getFileData(String path) throws IOException {
        FileReader file = new FileReader(path);
        Scanner scan = new Scanner(file);
        ArrayList<String> fileData = new ArrayList<String>();
        while (scan.hasNextLine()) {
            fileData.add(scan.nextLine());
        }
        file.close();
        return fileData;
    }
}