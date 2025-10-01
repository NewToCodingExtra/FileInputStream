import java.io.*;
import javax.swing.JOptionPane;

public class ReadBookDetails extends Book implements Readable {

    private File file;
    private String summary = "";
    private String description;
    public ReadBookDetails(String t, String a, String[] g, int pn, double p) {
        super(t, a, g, pn, p);
    }
    public ReadBookDetails(File f) {
        super("", "", null, 0, 0.0);
        file = f;   
    }
    @Override
    public void read() {
        try {
            if(!file.exists()) throw new IOException("File \""+file.getPath()+"\" don't exist!");
                try (FileInputStream fis = new FileInputStream(file)) {
                    buildSummary(fis);
                }
        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"[ERROR] "+ e.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    @Override
    public void buildSummary(FileInputStream fis) throws IOException{
        StringBuilder sm = new StringBuilder();
        int b;
        while((b = fis.read()) != -1) {
            char c = (char) b;
            if(c == '\n') {
                String line = sm.toString();
                sm.setLength(0);
                processLine(line);
            } else  {
                sm.append(c);
            }
        }
    }
    public void processLine(String l) {
        l = l.replace("[", "").replace("]", "");
        String[] parts = l.split("\\|");
        String title = parts[0];
        String name = parts[1];
        String[] genres = parts[2].split(",");
        int pageNum = Integer.parseInt(parts[3]);
        double price = Double.parseDouble(parts[4]);
        description = parts[5] + "\n";

        Book rb = new ReadBookDetails(title, name, genres, pageNum, price);
        summary += "=================================\n";
        summary += rb.bookToString() + "\n";
        summary += "Description: " + description;

    }
    @Override
    public String getDescription() {
        return description;
    }
    @Override
    public String toString() {
        return summary;
    }

}
