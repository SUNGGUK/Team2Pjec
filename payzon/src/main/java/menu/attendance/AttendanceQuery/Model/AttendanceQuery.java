package menu.attendance.AttendanceQuery.Model;

import java.util.Date;

public class AttendanceQuery {

    private int employeeId;
    private String employeeName;
    private String department;
    private String position;
    private Date attendanceDate;
    private int attendanceType;
    private int amount;
    private int hours;
    private Date inputDate;
    private String category;
    private String attendanceItem;
    private String attendancePeriod;
    private int attendanceDays;
    private String bikou;

    // Getter와 Setter
    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    public int getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(int attendanceDays) {
        this.attendanceDays = attendanceDays;
    }

    public String getAttendancePeriod() {
        return attendancePeriod;
    }

    public void setAttendancePeriod(String attendancePeriod) {
        this.attendancePeriod = attendancePeriod;
    }

    public String getAttendanceItem() {
        return attendanceItem;
    }

    public void setAttendanceItem(String attendanceItem) {
        this.attendanceItem = attendanceItem;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public int getAttendanceType() {
        return attendanceType;
    }

    public void setAttendanceType(int attendanceType) {
        this.attendanceType = attendanceType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "AttendanceQuery{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", attendanceDate=" + attendanceDate +
                ", attendanceType=" + attendanceType +
                ", amount=" + amount +
                ", hours=" + hours +
                ", inputDate=" + inputDate +
                ", category='" + category + '\'' +
                ", attendanceItem='" + attendanceItem + '\'' +
                ", attendancePeriod='" + attendancePeriod + '\'' +
                ", attendanceDays=" + attendanceDays +
                ", bikou='" + bikou + '\'' +
                '}';
    }
}
