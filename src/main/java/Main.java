import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        int check = ReadFile.getGameList(ReadFile.getList("23D2"));
        System.out.println(check);

    }
}
