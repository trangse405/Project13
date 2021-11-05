package model;

import java.util.List;

public class Experience extends Employee {
    private double explnYear;
    private String proSkill;

    public Experience() {
    }



    public Experience(int ID, String fullName, String birthDay, String phone, String email, int employeeType, List<Certificate> listCertificate, double explnYear, String proSkill) {
        super(ID, fullName, birthDay, phone, email, employeeType, listCertificate);
        this.explnYear = explnYear;
        this.proSkill = proSkill;
    }

    public double getExplnYear() {
        return explnYear;
    }


    public void setExplnYear(double explnYear) {
        this.explnYear = explnYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }



    @Override
    public void showMe() {
        System.out.println("Experience{" +
                "explnYear=" + explnYear +
                ", proSkill='" + proSkill + '\'' +
                '}');
    }
}
