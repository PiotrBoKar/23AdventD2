import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println(ReadFile.getGameList(ReadFile.getList("23D2")));
        System.out.println(ReadFile.getLargestList(ReadFile.getList("23D2")));

    }
}
