import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;

public class Server {
    public static void main(String[] args) {
        try{
            Registry reg = LocateRegistry.createRegistry(1999);
            Stud_impl instance = new Stud_impl();
            reg.rebind("StudentList",instance);
            System.out.println("Server Running");
        } catch (AccessException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
