package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Helpers {

    Scanner scanner = new Scanner(System.in);

    public int checkInt(String message, int min, int max) {
        int number;
        do {
            System.out.println(message);
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.err.println("Please enter in range [" + min + ", " + max + "]");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
        return number;
    }
    public double checkInputDouble() {
        double number;
        do {
            try {
                number = Double.parseDouble(scanner.nextLine());
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Please enter number more than 0");
                }
            } catch (Exception e) {
                System.out.println("Please enter number more than 0");
            }
        } while (true);
        return number;
    }

    public String checkEmail() {
        String regex = "^[0-9A-Za-z+._%]{5,10}@[0-9A-Za-z-]{3,10}[\\.[A-Za-z]{2,4}]+$";
        while (true) {
            String result = scanner.nextLine();
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Enter again");
            }
        }
    }

    public String checkPhone() {
        String regex = "^\\d{10,11}$";
        while (true) {
            String result = scanner.nextLine();
            if (result.matches(regex)) {
                return result;
            } else {
                System.err.println("Enter again");
            }
        }

    }

    public String formatName(String name) {
        String st = name.trim().toLowerCase();
        String[] temp = st.split("\\s+");
        st = "";
        for (int i = 0; i < temp.length; i++) {
            st += Character.toUpperCase(temp[i].charAt(0)) + temp[i].substring(1);
            if (i < temp.length - 1) {
                st += " ";
            }
        }
        return st;
    }

    public String checkInputString() {
        while (true) {
            String result = scanner.nextLine();
            if (result.length() == 0) {
                System.err.println("Enter again : ");
            } else {
                result = formatName(result);
                return result;
            }
        }
    }

    public String checkDate() {
        SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
        while (true) {
            try {
                String dat = checkInputString();
                Date dt = date.parse(dat);
                return dat;
            } catch (Exception e) {
                System.err.println("Enter again: ");
            }
        }
    }

}
