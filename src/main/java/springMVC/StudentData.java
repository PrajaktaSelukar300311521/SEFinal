package springMVC;

import java.util.Date;
import java.util.Objects;

public class StudentData
{
    private String snumber;
    private String sname;
    private double gpa;

    StudentData(String snumber, String sname, Double gpa)
    {
        this.snumber = snumber;
        this.sname = sname;
        this.gpa = gpa;
    }


    public String getSnumber() {
        return snumber;
    }

    public void setSnumber(String snumber) {
        this.snumber = snumber;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + snumber +
                ", user='" + sname + '\'' +
                ", gpa='" + gpa + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentData todo = (StudentData) o;
        return snumber == todo.snumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(snumber);
    }

}
