import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws RemoteException {
        DictionaryClient dictionary=new DictionaryClient();
        dictionary.main(args);
    }
}



