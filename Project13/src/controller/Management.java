package controller;

import Common.CommonConstant;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class Management {
    Helpers helpers = new Helpers();
    List<Employee> employeeList = new ArrayList<>();

    public void displayMenu() {
        generateData();


        while (true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println(employeeList.size());
            for (Employee e : employeeList
            ) {

                e.showInfor();
                e.showMe();
            }
            System.out.println("------------------------------------------------------------------");
            System.out.println("1. Add employee");
            System.out.println("2. Update employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Show list Intern");
            System.out.println("5. Show list Fresher");
            System.out.println("6. Show list Experience");
            System.out.println("7. Exit");
            int choice = helpers.checkInt("Enter your choice : ", 1, 7);
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    update();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    showAllEmployee(CommonConstant.typeIntern);
                    break;
                case 5:
                    showAllEmployee(CommonConstant.typeFresher);
                    break;
                case 6:
                    showAllEmployee(CommonConstant.typeExperience);
                    break;
                case 7:
                    return;
            }

        }
    }
    public void generateData(){
        List<Certificate> listC = new ArrayList<>();
        listC.add(new Certificate(1,"Ielts" , "good" , "01-01-2020"));
//        List<Certificate> listC1 = new ArrayList<>();
//        listC1.add(new Certificate(5,"Ielts" , "good" , "01-01-2020"));
//        List<Certificate> listC2 = new ArrayList<>();
//        listC2.add(new Certificate(2,"Ielts" , "good" , "01-01-2020"));

        Employee ex1 = new Experience(1,"John" , "01-01-2020","01324569871" , "johon@gmail.com" , CommonConstant.typeExperience , listC,1.5,"Java");
        System.out.println(ex1.getListCertificate().hashCode());
        Employee ex2 = new Experience(2,"Jerry", "01-01-1998","0132229871" , "jerry@gmail.com" , CommonConstant.typeExperience , listC,1.9,".Net");
        System.out.println(ex2.getListCertificate().hashCode());
        Employee fr1 = new Fresher(3,"Nicolas","05-06-1996","3333332221","nicoteen@gmail.com",CommonConstant.typeFresher,listC,"03-03-2023","Good" , "FPT");
        Employee fr2 = new Fresher(4,"David","04-06-1994","4444332211","david@gmail.com",CommonConstant.typeFresher,listC,"04-04-2020","Semi-Good" , "NEU");
        Employee iter1 = new Intern(5,"Rahim" , "05-05-1995","5555556644","rahim@yahoo.com" , CommonConstant.typeIntern,listC,"SE","Spring 2020","FPT");
        Employee iter2 = new Intern(6,"Steve" , "06-06-1996","6666663215","steve@yahoo.com" , CommonConstant.typeIntern,listC,"SE","Spring 2021","HAV");
        employeeList.add(ex1);
        employeeList.add(ex2);
        employeeList.add(fr1);
//        employeeList.add(fr2);
//        employeeList.add(iter1);
//        employeeList.add(iter2);

    }

    public void add() {
        System.out.println("Enter FullName : ");
        String fullName = helpers.checkInputString();
        System.out.println("Enter Birthday : ");
        String birthDay = helpers.checkDate();
        System.out.println("Enter Phone : ");
        String phone = helpers.checkPhone();
        System.out.println("Enter Email : ");
        String email = helpers.checkEmail();
        System.out.println("0-Experience , 1 - Fresher, 2-Intern");
        int type = helpers.checkInt("Choose employee type", 0, 2);
        List<Certificate> certificateList = new ArrayList<>();
        if (type == CommonConstant.typeExperience) {
            System.out.println("Enter ExplnYear : ");
            double explnYear = helpers.checkInputDouble();
            System.out.println("Enter Pro Skill : ");
            String proSkill = helpers.checkInputString();
            addCertificate(certificateList);
            Employee e = new Experience(employeeList.size() + 1, fullName, birthDay, phone, email, type, certificateList, explnYear, proSkill);
            employeeList.add(e);

        }
        if (type == CommonConstant.typeFresher) {
            System.out.println("Enter Graduation Date : ");
            String graduationDate = helpers.checkDate();
            System.out.println("Enter Graduation Rank : ");
            String graduationRank = helpers.checkInputString();
            System.out.println("Enter Education : ");
            String education = helpers.checkInputString();
            addCertificate(certificateList);
            Employee e = new Fresher(employeeList.size() + 1, fullName, birthDay, phone, email, type, certificateList, graduationDate, graduationRank, education);
            employeeList.add(e);

        }
        if (type == CommonConstant.typeIntern) {
            System.out.println("Enter Majors : ");
            String majors = helpers.checkInputString();
            System.out.println("Enter Semester : ");
            String semester = helpers.checkInputString();
            System.out.println("Enter University Name : ");
            String universityName = helpers.checkInputString();
            addCertificate(certificateList);
            Employee e = new Intern(employeeList.size() + 1, fullName, birthDay, phone, email, type, certificateList, majors, semester, universityName);
            employeeList.add(e);

        }

    }

    public List<Certificate> addCertificate(List<Certificate> certificateList) {

        boolean flag = true;

        System.out.println("Add ceritificate : ");
        while (flag) {

            System.out.println("Enter Certificate Name  : ");
            String certificateName = helpers.checkInputString();
            System.out.println("Enter Certificate Rank  : ");
            String certificateRank = helpers.checkInputString();
            System.out.println("Enter Certificate Date  : ");
            String certificateDate = helpers.checkDate();
            Certificate c = new Certificate(certificateList.size() + 1, certificateName, certificateRank, certificateDate);
            certificateList.add(c);
            System.out.println("Do you want to add more certificate (Y/N): ");
            String choice = helpers.checkInputString();
            flag = choice.equalsIgnoreCase("y");
        }
        return certificateList;
    }


    public void update() {
        int id = helpers.checkInt("Enter employee ID : ", 1, employeeList.size());
        for (Employee e : employeeList) {
            if (e.getID() == id) {
                e.showInfor();
                e.showMe();
                int choice = helpers.checkInt("choose attribute you want to update : 1-Name , 2-BirthDay , 3 -Phone ,4 - Email ,5-Update Certificate", 1, 5);
                if (choice == 1) {
                    System.out.println("Enter Name : ");
                    String updateName = helpers.checkInputString();
                    e.setFullName(updateName);
                }
                if (choice == 2) {
                    System.out.println("Enter Birth Day : ");
                    String updateBirthDay = helpers.checkDate();
                    e.setFullName(updateBirthDay);
                }
                if (choice == 3) {
                    System.out.println("Enter Phone : ");
                    String updatePhone = helpers.checkInputString();
                    e.setFullName(updatePhone);
                }
                if (choice == 4) {
                    System.out.println("Enter Email : ");
                    String updateEmail = helpers.checkInputString();
                    e.setFullName(updateEmail);
                }
                if (choice == 5) {
                    int choices = helpers.checkInt("1.Add Certificate , 2-Update Certificate", 1, 2);
                    if (choices == 1) {
                        addCertificate(e.getListCertificate());
                    }
                    if (choices == 2) {
                        showListCertificate(e.getListCertificate());
                        int idCertificate = helpers.checkInt("Enter Certificate ID", 1,99);
                        for (Certificate c : e.getListCertificate()) {
                            if(c.getCertificatedID() == idCertificate){
                                System.out.println(e.getFullName());
                                System.out.println("Enter Certificate Name  : ");
                                String certificateName = helpers.checkInputString();
                                System.out.println("Enter Certificate Rank  : ");
                                String certificateRank = helpers.checkInputString();
                                System.out.println("Enter Certificate Date  : ");
                                String certificateDate = helpers.checkDate();
                                c.setCertificatedDate(certificateDate);
                                c.setCertificateName(certificateName);
                                c.setCertificateRank(certificateRank);
                                break;
                            }
                        }
                    }
                }
            }
        }

    }

    public void showListCertificate(List<Certificate> certificateList) {
        for (Certificate c : certificateList
        ) {
            System.out.println(c);
        }
    }

    public void delete(){
        int id = helpers.checkInt("Enter employee ID : ", 1, employeeList.size());
        for (int i = 0; i < employeeList.size(); i++) {
            if(employeeList.get(i).getID()==id){
                employeeList.remove(i);
            }
        }
    }
    public void displayListEmployee(List<Employee> listE){
        for(Employee e: listE){
            e.showInfor();
            e.showMe();
        }
    }
    public void showAllEmployee(int type){
        List<Employee> listE = new ArrayList<>();
        if(type== CommonConstant.typeExperience){
            for(Employee e: employeeList){
                if( e instanceof Experience){
                    listE.add(e);
                }
            }
        }
        if(type== CommonConstant.typeIntern){
            for(Employee e: employeeList){
                if( e instanceof Intern){
                    listE.add(e);
                }
            }
        }
        if(type== CommonConstant.typeFresher){
            for(Employee e: employeeList){
                if( e instanceof Fresher){
                    listE.add(e);
                }
            }
        }

        displayListEmployee(listE);
    }
}
