import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
            
            int n = Integer.parseInt(reader.readLine());
            for (int i=0;i<n;i++){
                String[] parts = reader.readLine().split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                writer.write(Integer.toString(a+b));
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}