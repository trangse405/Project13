package model;

import java.util.List;

public class Fresher extends Employee{
    private String graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(int ID, String fullName, String birthDay, String phone, String email, int employeeType, List<Certificate> listCertificate, String graduationDate, String graduationRank, String education) {
        super(ID, fullName, birthDay, phone, email, employeeType, listCertificate);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public String getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(String graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    @Override
    public void showMe() {
        System.out.println(graduationDate + "     " + graduationRank + "    " + education);

    }
}
