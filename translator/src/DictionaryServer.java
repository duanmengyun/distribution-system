import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class DictionaryServer extends UnicastRemoteObject implements translator {

    private static final long serialVersionUID = 1L;
    private Map<String, String> dictionary;

    public DictionaryServer() throws RemoteException {
        super();
        dictionary = new HashMap<String, String>();
        dictionary.put("hello", "你好");
        dictionary.put("world", "世界");
        dictionary.put("apple", "苹果");
        dictionary.put("orange", "橙子");
        dictionary.put("computer", "计算机");
        dictionary.put("yes", "是");
        dictionary.put("science", "科学");
        dictionary.put("grape", "葡萄");
        dictionary.put("friend", "朋友");
        dictionary.put("company", "公司");
    }

    public String translate(String word) throws RemoteException {
        return dictionary.getOrDefault(word, "未找到该单词！");
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(5555);
            DictionaryServer server = new DictionaryServer();
            Naming.bind("rmi://127.0.0.1:5555/DictionaryService",server);
            //Naming.rebind("DictionaryService", server);
            System.out.println("服务器已启动！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
