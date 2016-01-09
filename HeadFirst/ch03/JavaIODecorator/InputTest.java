import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by yangge on 1/8/2016.
 */
public class InputTest {
    public static void main(String[] args) {
        int c;
        try {
            String curDir = System.getProperty("user.dir");
            System.out.println(curDir);
            InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));

            while ((c = in.read()) > 0) {
                System.out.print((char)c);
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
