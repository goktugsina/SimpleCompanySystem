// Göktuğ Sina Bekçioğulları
// 150122039

import java.util.Calendar;

public class Project {
    private String projectName = "Null";
    private Calendar startDate;
    private boolean state;

    public Project(String pName, Calendar startDate, String state) {
        projectName = pName;
        this.startDate = startDate;

        state = state.toLowerCase();
        if (state.equals("true") || state.equals("open")) {
            this.state = true;
        } else if (state.equals("false") || state.equals("close")) {
            this.state = false;
        } else this.state = false;
    }

    public boolean isState() {
        return state;
    }

    public void setState(String state) {
        if (state.equals("true") || state.equals("open")) {
            this.state = true;
        } else if (state.equals("false") || state.equals("close")) {
            this.state = false;
        } else this.state = false;
    }

    public String getState() {
        if (state)
            return "Open";
        else return "Close";
    }

    public void close() {
        if (this.state)
            this.state = false;
        else System.out.println("The project is already closed!");
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        if (projectName != null)
            this.projectName = projectName;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public String toString() {
        int day = getStartDate().get(Calendar.DAY_OF_MONTH);
        int month = getStartDate().get(Calendar.MONTH) + 1;
        int year = getStartDate().get(Calendar.YEAR);
        String formattedDate = String.format("%d/%d/%d", day, month, year);
        return "Project [projectName=" + this.getProjectName() + ", startDate=" + formattedDate + ", state=" + this.getState() + "]";
    }
}
