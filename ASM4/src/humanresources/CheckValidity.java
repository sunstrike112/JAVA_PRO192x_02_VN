package humanresources;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//Class check giá trị input nhập vào có hợp lệ hay không
public class CheckValidity {
    //Kiểm tra user nhập vào giá trị các chức năng từ 0-7
    public static boolean isMainMenuInputValid(String userChoice) {
        switch (userChoice) {
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "0":
                return true;
        }
        return false;
    }
    //Kiểm tra tên phòng ban người dùng nhập có khớp hay không
    public static boolean isInputDepartmentValid(String departmentStr) {
        int validNumber = 0;
        for (Department d : HumanResources.departments
        ) {
            if (d.getName().equalsIgnoreCase(departmentStr)) {
                validNumber++;
            }
        }
        return validNumber > 0;
    }

    //Kiểm tra ngày nhập vào
    public static boolean isDateInputValid(String inputString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-d");
        try {
            LocalDate.parse(inputString, formatter);
        } catch (DateTimeParseException e) {
            return false;
        }
        return true;
    }

    //Kiểm tra input có phải là kiểu double or int
    public static boolean isDouble(String inputString) {
        try {
            Double.parseDouble(inputString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isNumeric(String numberString) {
        try {
            Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    //Kiểm tra vị trí bộ phận mà nhân viên mới vào làm 1 or 2 or 3
    public static boolean isPositionInputValid(String positionChoice) {
        return positionChoice.equals("1") || positionChoice.equals("2") || positionChoice.equals("3");
    }

    //Kiểm tra lựa chọn nhập nhân viên bình thường E hoặc quản lý M
    public static boolean addNewStaffValid(String userChoice) {
        return userChoice.equalsIgnoreCase("E")
                || userChoice.equalsIgnoreCase("M");
    }
}
