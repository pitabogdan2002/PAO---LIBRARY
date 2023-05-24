package service;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class AuditService {
    FileWriter writer;

    public AuditService() {
        try {

            String dir_path = "src/files";
            String file_path = "src/files/actiuni.csv";
            File dir = new File(dir_path);
            File file = new File(file_path);
            this.writer = new FileWriter(file_path,true);
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }

    public void addAction(String action) throws IOException {
        String file_path = "src/files/actiuni.csv";

        try (FileWriter writer = new FileWriter(file_path, true))
        {
            long current_date = System.currentTimeMillis();
            writer.write(action + ',' +  new Timestamp(current_date) + '\n');
        }
    }
}
