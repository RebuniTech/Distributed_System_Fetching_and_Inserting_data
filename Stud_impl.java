import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
public class Stud_impl extends UnicastRemoteObject implements StudentRemote{

    protected Stud_impl() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Student> getStudent() throws RemoteException {
        ArrayList<Student> list = new ArrayList<>();

        try{
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL="jdbc:mysql://localhost:3306/Asher";
            String USER = "root";
            String PASS = "";
            Connection conn = null;
            Statement stmt = null;
            Class.forName(JDBC_DRIVER);
            System.out.println("connecting");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connected");
            stmt  = conn.createStatement();
            String sql = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                String dept = rs.getString("dept");

                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setDept(dept);
                list.add(student);
            }
            rs.close();
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
