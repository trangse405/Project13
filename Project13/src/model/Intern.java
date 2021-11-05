package model;

import java.util.List;

public class Intern extends Employee{
    private String majors;
    private String semester;
    private String universityName;

    public Intern() {
    }

    public Intern(int ID, String fullName, String birthDay, String phone, String email, int employeeType, List<Certificate> listCertificate, String majors, String semester, String universityName) {
        super(ID, fullName, birthDay, phone, email, employeeType, listCertificate);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public void showMe() {
        System.out.println(majors + "     " + semester + "    " + universityName);
    }
}
