package springMVC;

import java.sql.SQLException;


public interface StudentInterface
{
    public void add(StudentData studentData) throws ClassNotFoundException, SQLException;
    public StudentData edit(StudentData studentData, String number) throws SQLException, ClassNotFoundException;
    public void update(StudentData studentData, String number) throws SQLException, ClassNotFoundException;
    public void delete(String number) throws SQLException;
    public void display() throws ClassNotFoundException, SQLException;
}
