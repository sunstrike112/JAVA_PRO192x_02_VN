
package humanresources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;



public class HumanResources {
    public static ArrayList<Department> departments = new ArrayList<>();
    public static ArrayList<Staff> staffList = new ArrayList<>();

    public static void main(String[] args) {
        addIntialData(); //
        addDepartments();
        UI.greeting();
        UI.displayMenu();
        process();
    }

    private static void addDepartments() {
    }

    /**
     * Adds data to test
     */
    private static void addIntialData() {
        Department dept1 = new Department("dept1", "Sale");
        departments.add(dept1);
        Department dept2 = new Department("dept2", "Tech");
        departments.add(dept2);
        Department dept3 = new Department("dept3", "Security");
        departments.add(dept3);

    }
    private static void process() {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        boolean isContinue = true;
        if (isContinue) {
            while (true) {

                System.out.print("Your choice (0-7): ");
                userChoice = scanner.next();
                if (!CheckValidity.isMainMenuInputValid(userChoice)) {
                    UI.printInvalidMessage();
                    continue;
                }

                switch (userChoice) {
                    case "1" -> {
                        displayStaffList();
                        UI.printSeparatedLine(130);
                    }
                    case "2" -> {
                        displayDepartmentList();
                        UI.printSeparatedLine(130);
                    }
                    case "3" -> {
                        displayStaffByDepartment();
                        UI.printSeparatedLine(130);
                    }
                    case "4" -> {
                        addNewStaff();
                        UI.printSeparatedLine(50);
                    }
                    case "5" -> {
                        searchStaff();
                        UI.printSeparatedLine(130);
                    }
                    case "6" -> {
                        displaySalaryDescendingOrder();
                        UI.printSeparatedLine(130);
                    }
                    case "7" -> {
                        displaySalaryAscendingOrder();
                        UI.printSeparatedLine(130);
                    }
                    case "0" -> {
                        System.out.println("Thank you, good bye!");
                        UI.printSeparatedLine(50);
                        System.exit(0);
                    }
                }
                System.out.print("Do you want to continue (Y/N): ");
                boolean answer = decideContinue();
                if (answer) {
                    UI.displayMenu();
                    continue;
                }
                System.out.println("Thank you, good bye!");
                UI.printSeparatedLine(50);
                System.exit(0);
            }
        }
    }

    //Hỏi user có muốn tiếp tục chương trình sau mỗi lần thực hiện 1 chức năng
    private static boolean decideContinue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("y")) {
                return true;
            } else if (answer.equalsIgnoreCase("n")) {
                return false;
            } else {
                UI.printInvalidMessage();
                System.out.print("Do you want to continue (Y/N)? ");
                continue;
            }
        }

    }

    //Hiển thị toàn bộ thông tin nhân viên
    private static void displayStaffList() {
        System.out.println("Display all staff list");
        UI.printTitle();
        for (Staff f : staffList) {
            System.out.println(f.toString());
        }
    }

    //Hiển thị toàn bộ thông tin các bộ phận
    static void displayDepartmentList() {
        System.out.println("Display all departments");
        System.out.printf("%-10s%-20s%-20s", "ID", "Department Name", "Number of staff");
        System.out.println();
        for (Department d : departments
        ) {
            System.out.println(d.toString());
        }
    }

    //Hiển thị thông tin nhân viên theo bộ phận làm việc
    //1. Clone 1 list mới từ list nhân viên chính
    //2. Thực hiện sắp xếp trên list clone
    //3. Hiển thị list đã được sắp xếp 
    private static void displayStaffByDepartment() {
        ArrayList<Staff> sortedList = (ArrayList) staffList.clone(); //clone 1 mới ArrayList của staffList 
        //Sort danh sách mới với sort & Comparator.
        sortedList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (o1.getDepartment().getName().compareToIgnoreCase(o2.getDepartment().getName()));
            }
        });
        System.out.println("Display staff by departments");
        UI.printTitle();

        int arrSize = sortedList.size();
        for (int i = 0; i < arrSize; i++) {
            if (i == 0) {
                System.out.println(sortedList.get(i));
            } else if (0 < i && i < arrSize - 1) {
                if (!sortedList.get(i - 1).getDepartment().getName().equalsIgnoreCase(sortedList.get(i).getDepartment().getName())) {
                    UI.printSeparatedLine(130);
                }
                System.out.println(sortedList.get(i));
            } else {
                System.out.println(sortedList.get(i));
            }
        }

    }

    //Lựa chọn thêm 1 nhân viên thường hoặc quản lý
    private static void addNewStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add new staff");
        String userChoice;
        while (true) {
            System.out.print("Do you want to add a new employee (E) or manager (M)? Input E/M: ");
            userChoice = scanner.next();
            if (CheckValidity.addNewStaffValid(userChoice)) {
                if (userChoice.equalsIgnoreCase("E")) {
                    addNewEmployee();
                    break;
                }
                addNewManager();
                break;
            }
            System.out.println("Invalid input. Please try again.");
        }
    }

    //Nhập thông tin cho quản lý mới
    private static void addNewManager() {
        String id;
        String name;
        int age;
        String position;
        double payRate;
        LocalDate startDate;
        Department department;
        int numDayOff;

        System.out.println("Add new Manager");
        UI.printSeparatedLine(16);

        /* ID */
        id = UI.inputID();

        /* NAME */
        name = UI.inputName();

        /* POSITION */
        position = UI.inputPosition();

        /* AGE */
        age = UI.inputAge();

        /* PAY RATE */
        payRate = UI.inputPayRate();

        /* START DATE */
        startDate = UI.inputStartDate();

        /* DEPARTMENTS */
        department = UI.inputDepartment();

        /* NUMBER OF DAY-OFF */
        numDayOff = UI.inputNumDayOff();

        /*ADD NEW MANAGER TO ARRAY LIST */
        Manager newManager = new Manager(id, name, position, age, payRate, startDate, department, numDayOff, 0);
        newManager.setSalary(); //tính lương
        staffList.add(newManager);
        System.out.println("New manager has been added successfully.");
    }

    //Nhập thông tin cho nhân viên thường
    private static void addNewEmployee() {
        String id;
        String name;
        int age;
        double payRate;
        LocalDate startDate;
        Department department;
        int numDayOff;
        double overtimeHour;

        System.out.println("Add new Employee");
        UI.printSeparatedLine(16);

        /* ID */
        id = UI.inputID();

        /* NAME */
        name = UI.inputName();

        /* AGE */
        age = UI.inputAge();

        /* PAY RATE */
        payRate = UI.inputPayRate();
        /* START DATE */
        startDate = UI.inputStartDate();
        /* DEPARTMENTS */
        department = UI.inputDepartment();
        /* NUMBER OF DAY-OFF */
        numDayOff = UI.inputNumDayOff();
        /* OVERTIME HOUR */
        overtimeHour = UI.inputOverTimeHour();

        /*ADD NEW MANAGER TO ARRAY LIST */
        Employee newEmployee = new Employee(id, name, age, payRate, startDate, department, numDayOff, overtimeHour, 0);
        newEmployee.setSalary(); //tính lương
        staffList.add(newEmployee);
        System.out.println("New employee has been added successfully.");
    }


    //Tìm kiếm nhân viền bằng ID
    private static void searchStaff() {
        Scanner scanner = new Scanner(System.in);
        String searchKey;
        ArrayList<Staff> searchStaff = new ArrayList<>();

        while (true) {
            System.out.println("Search staff information by staff ID or staff name:");
            System.out.print("Please enter staff ID or staff name: ");
            searchKey = scanner.nextLine();
            for (Staff s : staffList) {
                if (s.getId().toLowerCase().contains(searchKey.toLowerCase()) || s.getName().toLowerCase().contains(searchKey.toLowerCase())) {
                    searchStaff.add(s);
                }
            }
            if (searchStaff.isEmpty()) {
                System.out.println("There is no Staff matched your search information.");

            } else { 
                UI.printTitle();
                for (Staff s : searchStaff) {
                    System.out.println(s.toString());
                }
            }
            break;
        }
    }

    /**
     * Display staff list sorted by descending order of salary.
     * <ul>This method do following steps:
     *      <li>1. Clone staffList arrayList to a new list called sorted List.</li>
     *      <li>2. Sort the new arrayList by descending order of salary .</li>
     * </ul>
     */
    //Hiển thị thông tin nhân viên theo lương giảm dần/tăng dần
    //Clone danh sách staffList sau đó sắp xếp và hiển thị danh sách này
    private static void displaySalaryDescendingOrder() {
        ArrayList<Staff> sortedList = (ArrayList) staffList.clone();
        sortedList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o2.calculateSalary() - o1.calculateSalary());
            }
        });

        System.out.println("Display salary of all staff in sorted descending order");
        UI.printTitle();
        System.out.println();
        for (Staff s :
                sortedList) {
            System.out.println(s.toString());
        }
    }

    private static void displaySalaryAscendingOrder() {
        ArrayList<Staff> sortedList = (ArrayList) staffList.clone();
        sortedList.sort(new Comparator<Staff>() {
            @Override
            public int compare(Staff o1, Staff o2) {
                return (int) (o1.calculateSalary() - o2.calculateSalary());
            }
        });

        System.out.println("Display salary of all staff sorted ascending order");
        UI.printTitle();
        System.out.println();
        for (Staff s :
                sortedList) {
            System.out.println(s.toString());
        }
    }
}

