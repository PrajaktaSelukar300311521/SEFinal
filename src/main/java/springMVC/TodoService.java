package springMVC;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class TodoService {


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

    public void addTodo(String snumber, String sname,Double gpa, Date targetDate, boolean isDone) {
        todos.add(new StudentData(snumber, sname,gpa));
    }


    public void addTodo1(String snumber, String sname,Double gpa, Date targetDate, boolean isDone) {
        todos.add(new StudentData(snumber, sname,gpa));
    }

    public void deleteTodo(int id) {
        Iterator<StudentData> iterator = todos.iterator();
        while (iterator.hasNext()) {
            StudentData todo = iterator.next();
            if (todo.getSnumber().equals(todo.getSnumber())) {
                iterator.remove();
            }
        }
    }

    public StudentData retrieve(int id){

        for(StudentData todo: todos){
            if(todo.getGpa()==id){
                return todo;
            }
        }
        return null;

    }

    public void update(StudentData todo){
        todos.remove(todo);
        todos.add(todo);
    }


}
