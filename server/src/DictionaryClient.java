import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

public class DictionaryClient {

    public static void main(String[] args) {
        try {
            translator translator = (translator) Naming.lookup("rmi://localhost:5555/DictionaryService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("请输入要查询的单词：");
                String word = scanner.next();
                if ("exit".equals(word)) {
                    break;
                }
                String result = translator.translate(word);
                System.out.println(result);
            }
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


