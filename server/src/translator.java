
import java.rmi.Remote;
import java.rmi.RemoteException;

    public interface translator extends Remote {
        String translate(String word) throws RemoteException;
    }


