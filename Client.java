import java.rmi.Naming;
import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        try{
            StudentRemote studlistref = (StudentRemote) Naming.lookup("rmi://localhost:1999/StudentList");
            ArrayList<Student>  studlist = (ArrayList)studlistref.getStudent();
            System.out.println("id"+"    name "+"     department");

            for(Student s : studlist){
                // System.out.println("id" + " " + s.getId());
                // System.out.println("name" + " " + s.getName());
                // System.out.println("dept" + "  "+ s.getDept());


        System.out.println(s.getId()+"    "+s.getName()+"    "+s.getDept());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
