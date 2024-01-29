import java.io.*;
import java.util.*;


// This class implements "Runnable" interface in order to
// make object of "Thread" execute code in "run" method
public class Task1Runnable implements Runnable {
    // Field for storing command for this process
    private String command;
    
    public Task1Runnable (String cmmnd) {
        command = cmmnd;
    }
    
    @Override
    public void run() {
        List<String> input = Arrays.asList(command.split(" "));

        ProcessBuilder processBuilder = new ProcessBuilder(input);
        BufferedReader bufferReader = null;
        try {

            Process proc = processBuilder.start();
            InputStream inputStream = proc.getInputStream();
            InputStreamReader isr = new InputStreamReader(inputStream);
            bufferReader = new BufferedReader(isr);

            String line;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line );
            }
            bufferReader.close();
        } catch (java.io.IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        } finally {
            if (bufferReader != null) {
                try {
                    bufferReader.close();
                } catch (java.io.IOException ioe) {
                    System.err.println("Error: " + ioe.getMessage());
                }
            }
        }
     }
}