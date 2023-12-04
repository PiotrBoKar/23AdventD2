import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int checkPt1 = ReadFile.getGameList(ReadFile.getList("23D2"));
        int checkPt2 = ReadFile.getLargestList(ReadFile.getList("23D2"));
        System.out.println(checkPt1);
        System.out.println(checkPt2);

    }
}
