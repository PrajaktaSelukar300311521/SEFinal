package springMVC;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class StudentServiceTest<ConnectionClass> {


    @Mock
    private Connection connection;


    @InjectMocks
    private StudentService ss;

    @Mock
    private PreparedStatement prepareStatement;

    @Mock
    private ConnectionClass con;

    StudentData sd = new StudentData("1", "Prajakta", (double) 3.3);
    @BeforeEach
    public void Setup() throws SQLException, ClassNotFoundException {
        MockitoAnnotations.openMocks(this);
        PreparedStatement preparedStatement;
        when(connection.prepareStatement(anyString())).thenReturn(prepareStatement);
        //when(con.connect()).thenReturn(connection);
    }


    @Test
    void add() throws SQLException, ClassNotFoundException {
        when(connection.prepareStatement("INSERT INTO studentrecords VALUES ( ?, ?, ? )")).thenReturn(prepareStatement);
        ss.add(sd);
        //verify(prepareStatement).executeUpdate();
    }

    private void verify(PreparedStatement preparedStatement) {
    }

    @Test
    void edit() {
        sd=new StudentData("1","Prajakta", (double) 3.0);
        assertEquals("Tanvi", sd.getSname());
    }

    @Test
    void update() {
    }

    @Test
    void delete() throws SQLException {
        when(connection.prepareStatement("Delete from studentrecords where snumber = ?")).thenReturn(prepareStatement);
        ss.delete("1");
        //verify(prepareStatement).executeUpdate();
    }

    @Test
    void display() {
    }
}