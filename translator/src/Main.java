import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        DictionaryServer server1=new DictionaryServer();
        server1.main(args);
    }
}



