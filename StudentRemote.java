import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface StudentRemote extends Remote {
    public ArrayList<Student> getStudent() throws RemoteException; 
}
