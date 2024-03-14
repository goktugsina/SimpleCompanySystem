// Göktuğ Sina Bekçioğulları

import java.time.format.SignStyle;
import java.util.InputMismatchException;

public class Department {
    private int departmentId;
    private String departmentName = "Null";

    public Department(int departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        try {
            if (departmentId >= 0)
                this.departmentId = departmentId;
            else throw new IllegalArgumentException("Bonus must be greater than or equal to zero!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String toString() {
        return "Department " + "[departmentId=" + departmentId + ", " + "departmentName=" + departmentName + "]";
    }
}
