package model;

import java.util.List;

public abstract class Employee {
    private int ID;
    private String fullName;
    private String birthDay;
    private String phone;
    private String email;
    private int employeeType;
    private int employeeCount;
    private List<Certificate> listCertificate;
    public Employee() {
    }

    public Employee(int ID, String fullName, String birthDay, String phone, String email, int employeeType, List<Certificate> listCertificate) {
        this.ID = ID;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.listCertificate = listCertificate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public List<Certificate> getListCertificate() {
        return listCertificate;
    }

    public void setListCertificate(List<Certificate> listCertificate) {
        this.listCertificate = listCertificate;
    }

    public void showInfor(){
        System.out.println("Employee{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", employeeType=" + employeeType +
                ", employeeCount=" + employeeCount +
                ", listCertificate=" + listCertificate +
                '}');
    }



    public abstract void showMe();
}
