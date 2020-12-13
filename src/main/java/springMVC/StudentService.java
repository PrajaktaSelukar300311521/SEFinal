package springMVC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentService implements StudentInterface
{

    public Connection con;
    public Connection getCon3() {
        return con;
    }
    public void setCon3(Connection con3) {
        this.con = con3;
    }

    public StudentService(Connection con3) throws SQLException{
        this.con = con3;
    }


    private static List<StudentData> todos = new ArrayList<StudentData>();
    private static int todoCount = 3;

    static {
        todos.add(new StudentData("10006", "Johnny Jacobi", 3.0));
        todos.add(new StudentData("10007", "Joseph Phil", 3.6));
        todos.add(new StudentData("1008", "Jammer Diaz", 3.2));
    }

    public List<StudentData> retrieveTodos(String user) {
        List<StudentData> filteredTodos = new ArrayList<StudentData>();
        for (StudentData todo : todos) {
            if (todo.getSname().equals(user))
                filteredTodos.add(todo);
        }
        return filteredTodos;
    }

    public void addTodo(String snumber, String sname, Double gpa, Date targetDate, boolean isDone) {
        todos.add(new StudentData(snumber, sname,gpa));
    }

    @Override
    public void add(StudentData studentData) throws ClassNotFoundException, SQLException
    {

    }

    public StudentData getStudentObject(String number) throws SQLException, ClassNotFoundException {
        String getObjectQuery = "Select * from studentrecord where snumber = ?";
        PreparedStatement query = con.prepareStatement(getObjectQuery);
        query.setString(1, number);

        ResultSet rs = query.executeQuery();
        if (!rs.first()) {
            System.out.println("Record not existing");
            return null;
        }
        return new StudentData(rs.getString("snumber"), rs.getString("sname"), rs.getDouble("gpa"));
    }

    public StudentData retrieve(int id) {

        for (StudentData todo : todos) {
            if (todo.getGpa() == id) {
                return todo;
            }
        }
        return null;
    }

        @Override
    public StudentData edit(StudentData studentData, String number) throws SQLException, ClassNotFoundException
    {
        PreparedStatement query;
        query = con.prepareStatement("Update studentrecord set snumber=?, sname=?, gpa=? where snumber = ?");
        query.setString(1, studentData.getSnumber());
        query.setString(2, studentData.getSname());
        query.setDouble(3, studentData.getGpa());
        query.setString(4, studentData.getSnumber());
        query.executeUpdate();
        System.out.println("One record edited");
        return studentData;
    }

    @Override
    public void update(StudentData studentData, String number) throws SQLException, ClassNotFoundException
    {
        String insertQuery = "INSERT INTO studentrecord VALUES ( ?, ?,? )";
        PreparedStatement query = con.prepareStatement(insertQuery);

        query.setString(1, studentData.getSnumber());
        query.setString(2, studentData.getSname());
        query.setDouble(3, studentData.getGpa());

        query.executeUpdate();

        System.out.println("One record added");
    }

    @Override
    public void delete(String number) throws SQLException
    {
        String quer1 = "Delete from studentrecord where snumber = ?";
        PreparedStatement query = con.prepareStatement(quer1);
        query.setString(1, number);
        query.executeUpdate();
        System.out.println("One record Deleted");
    }

    @Override
    public void display() throws ClassNotFoundException, SQLException {
        String quer1 = "Select * from studentrecord";
        PreparedStatement query = con.prepareStatement(quer1);
        ResultSet rs = query.executeQuery();
        ArrayList<StudentData> studentDataArrayList = new ArrayList<>();
        while (rs.next()) {
            studentDataArrayList.add(new StudentData(rs.getString("snumber"), rs.getString("sname"), rs.getDouble("gpa")));
        }
    }
}
