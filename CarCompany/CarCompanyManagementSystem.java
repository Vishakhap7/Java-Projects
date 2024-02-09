import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.sql.*;

class Car {
         static String make;
         static String model;
         static int year;
         static String regNumber;

        public Car(String make, String model, int year, String regNumber) {
            this.make = make;
            this.model = model;
            this.year = year;
            this.regNumber = regNumber;
        }

        public String getMake() {
            return make;
        }

        public String getModel() {
            return model;
        }

        

        public int getYear() {
            return year;
        }

        public String getRegNumber() {
            return regNumber;
        }

        @Override
        public String toString() {
            return "Car "+ "model="+model+" make"+make;
        }

        
    }
  class Employee {
        private String name;
        private int age;
        private String position;
        private String employeeID;

        public Employee(String name, int age, String position, String employeeID) {
            this.name = name;
            this.age = age;
            this.position = position;
            this.employeeID = employeeID;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getPosition() {
            return position;
        }

        public String getEmployeeID() {
            return employeeID;
        }
    }
    enum UserRole {
    ADMIN,
    EMPLOYEE
}

class User {
    private String username;
    private String password;
    private UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}
class Car1 {
    String brand;
    String model;
    double price;

    public Car1(String brand, String model, int bal) {
        this.brand = brand;
        this.model = model;
        this.price = bal;
    }

    public double getPrice() {
        return price;
    }
}

class Customer {
    String name;
    double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deductBalance(double amount) {
        balance -= amount;
    }
}

class Main{
    

    public static void main(String[] args) throws Exception {       
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Car Registration");
            System.out.println("2. Employee Management");
            System.out.println("3. Inventory Management");
            System.out.println("4. Sales Management");
            System.out.println("5. Reporting and Analytics");
            System.out.println("6. User Authentication and Authorization");
            System.out.println("7. View Employees");
            System.out.println("8. View Inventory");
            System.out.println("9. View Sales");
            System.out.println("10. List of Cars");
            System.out.println("11. Car Purchase (Cash, EMI, or Check)");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                registerCar(scanner);
                    System.out.println("Car Registration selected.");

                    break;
                case 2:
                 manageEmployee(scanner);
                    // Implement Employee Management functionality
                    System.out.println("Employee Management selected.");
                    break;
                case 3:
                 manageInventory(scanner);
                    // Implement Inventory Management functionality
                    System.out.println("Inventory Management selected.");
                    break;
                case 4:
                makeSale(scanner);
                    // Implement Sales Management functionality
                    System.out.println("Sales Management selected.");
                    break;
                case 5:
                   generateSalesReport();
                    // Implement Reporting and Analytics functionality
                    System.out.println("Reporting and Analytics selected.");
                    break;
                case 6:
               User loggedInUser = null;

        do {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            loggedInUser = authenticateUser(username, password);

            if (loggedInUser == null) {
                System.out.println("Invalid username or password. Please try again.");
            }
        } while (loggedInUser == null);

        System.out.println("Login successful! Welcome, " + loggedInUser.getUsername() + "!");
        
        // Based on the user's role, you can now perform different actions in your system.
        if (loggedInUser.getRole() == UserRole.ADMIN) {
            // Perform admin actions
            System.out.println("You have admin privileges. You can perform all actions.");
        } else {
            // Perform employee actions
            System.out.println("You have employee privileges. You can perform limited actions.");
        }
                    // Implement User Authentication and Authorization functionality
                    System.out.println("User Authentication and Authorization selected.");
                    break;
                case 7:
                viewEmployees();
                    // Implement Data Validation and Error Handling functionality
                    System.out.println("Data Validation and Error Handling selected.");
                    break;
                case 8:
                viewInventory();
                    // Implement Security Measures functionality
                    System.out.println("Security Measures selected.");
                    break;
                case 9:
                viewSales();
                    // Implement Logging and Auditing functionality
                    System.out.println("Logging and Auditing selected.");
                    break;
                case 10:
                    
                     System.out.println(carRegistry);
                    // Implement List of Cars functionality
                    System.out.println("List of Cars selected.");
                    break;
                case 11:
                 System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();
                    System.out.println("Enter car brand: ");
                    String brand=scanner.next();
                    System.out.println("Enter car model: ");
                    String model=scanner.next();
                    System.out.println("Enter YOur Balance: ");
                    int  bal=scanner.nextInt();
                     Car1 car1 = new Car1(brand, model, bal);
                     
                     String paymentMethod = scanner.next();

        Customer customer = new Customer(customerName, 500000.0); // Starting balance

        switch (paymentMethod.toLowerCase()) {
            case "cash":
                if (customer.getBalance() >= car1.getPrice()) {
                    customer.deductBalance(car1.getPrice());
                    System.out.println("Car purchased successfully with cash!");
                } else {
                    System.out.println("Insufficient balance for cash payment.");
                }
                break;
            case "check":
                System.out.print("Enter check amount: ");
                double checkAmount = scanner.nextDouble();
                if (checkAmount >= car1.getPrice()) {
                    System.out.println("Car purchased successfully with a check!");
                } else {
                    System.out.println("Check amount is insufficient.");
                }
                break;
            case "emi":
                System.out.print("Enter number of EMI months: ");
                int emiMonths = scanner.nextInt();
                double emiAmount = car1.getPrice() / emiMonths;
                if (customer.getBalance() >= emiAmount) {
                    customer.deductBalance(emiAmount);
                    System.out.println("Car purchased successfully with EMI!");
                } else {
                    System.out.println("Insufficient balance for EMI payment.");
                }
                break;
            default:
                System.out.println("Invalid payment method.");
                break;
            }
               
                case 0:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
        
    }
    private static final Map<String, Car> carRegistry = new HashMap<>();

    private static void registerCar(Scanner scanner) throws Exception {
       
         System.out.print("Enter car make: ");
        String make = scanner.next();
        System.out.print("Enter car model: ");
        String model = scanner.next();
        System.out.print("Enter car year: ");
        int year = scanner.nextInt();
        System.out.print("Enter car registration number: ");
        String regNumber = scanner.next();
        // Create a new Car object
        Car car = new Car(make, model, year, regNumber);
        // Register the car in the carRegistry
         carRegistry.put(regNumber, car);
        // System.out.println("Car registered successfully!");
         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_list", "root", "");
        String drivername="com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);
        
        PreparedStatement pst=con.prepareStatement("insert into cars(make,model,year,registration_number) values (?,?,?,?)");
        pst.setString(1, make);
        pst.setString(2, model);
        pst.setInt(3, year);
        pst.setString(4, regNumber);
        pst.execute();
        System.out.println();
    }

    private static void viewInventory() {
         System.out.println("Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            String regNumber = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Car Registration Number: " + regNumber + ", Quantity: " + quantity);
        }
    }
    private static void viewSales() {
        System.out.println("Sales Report:");
        for (Map.Entry<String, Integer> entry : sales.entrySet()) {
            String regNumber = entry.getKey();
            int quantitySold = entry.getValue();
            Car car = carRegistry.get(regNumber);
            if (car != null) {
                System.out.println("Car: " + car.getMake() + " " + car.getModel() +
                        ", Registration Number: " + regNumber +
                        ", Quantity Sold: " + quantitySold);
            }
        }
    }
    private static final Map<String, Employee> employeeRegistry = new HashMap<>();
    private static void manageEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.next();
        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        System.out.print("Enter employee position: ");
        String position = scanner.next();
        System.out.print("Enter employee ID: ");
        String employeeID = scanner.next();

        // Create a new Employee object
        Employee employee = new Employee(name, age, position, employeeID);

        // Register the employee in the employeeRegistry
        employeeRegistry.put(employeeID, employee);

        System.out.println("Employee added successfully!");
    }
    private static void viewEmployees() {
         System.out.println("List of Employees:");
        for (Employee employee : employeeRegistry.values()) {
            System.out.println("Name: " + employee.getName() +
                    ", Age: " + employee.getAge() +
                    ", Position: " + employee.getPosition() +
                    ", Employee ID: " + employee.getEmployeeID());
        }
    }
    private static final Map<String, Integer> inventory = new HashMap<>();
    private static void manageInventory(Scanner scanner) {
        System.out.println("1. Add Car to Inventory");
        System.out.println("2. Search Car in Inventory");
        System.out.print("Enter your choice: ");
        int inventoryChoice = scanner.nextInt();

        switch (inventoryChoice) {
            case 1:
                addCarToInventory(scanner);
                break;
            case 2:
                searchCarInInventory(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addCarToInventory(Scanner scanner) {
        System.out.print("Enter car registration number: ");
        String regNumber = scanner.next();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        Car car = carRegistry.get(regNumber);
        if (car != null) {
            inventory.put(regNumber, inventory.getOrDefault(regNumber, 0) + quantity);
            System.out.println("Car added to inventory successfully!");
        } else {
            System.out.println("Car not found in the registry. Please register the car first.");
        }
    }

    private static void searchCarInInventory(Scanner scanner) {
        System.out.print("Enter car registration number: ");
        String regNumber = scanner.next();

        if (inventory.containsKey(regNumber)) {
            int quantity = inventory.get(regNumber);
            System.out.println("Car found in inventory. Quantity: " + quantity);
        } else {
            System.out.println("Car not found in the inventory.");
        }
    }
    private static User authenticateUser(String username, String password) {
         User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
        
    }
    private static final Map<String, User> users = new HashMap<>();
    static {
        users.put("admin", new User("name", "password", UserRole.ADMIN));
        users.put("employee", new User("emp", "emp123", UserRole.EMPLOYEE));
    }

     private static void generateSalesReport() {
        int totalSales = calculateTotalSales();
        double averageSales = totalSales / (double) sales.size();

        System.out.println("------ Sales Report ------");
        System.out.println("Total Sales: " + totalSales);
        System.out.println("Average Sales per Car: " + averageSales);

        String bestSellingModel = findBestSellingModel();
        System.out.println("Best Selling Car Model: " + bestSellingModel);
        System.out.println("-------------------------");
    }
    private static final Map<String, Integer> sales = new HashMap<>(); 
    private static void makeSale(Scanner scanner) throws Exception {
         System.out.print("Enter car registration number for the sale: ");
        String regNumber = scanner.next();


         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/car_list", "root", "");
        String drivername="com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);
         PreparedStatement pst=con.prepareStatement("delete from cars where registration_number=?; ");
         pst.setString(1, regNumber);
         pst.execute();
        
        

        if (inventory.containsKey(regNumber) && inventory.get(regNumber) > 0) {
            inventory.put(regNumber, inventory.get(regNumber) - 1);

            // Record the sale
            sales.put(regNumber, sales.getOrDefault(regNumber, 0) + 1);

            System.out.println("Sale successful!");
        } else {
            System.out.println("Car not available in the inventory.");
        }
    }

    private static int calculateTotalSales() {
        int totalSales = 0;
        for (int quantity : sales.values()) {
            totalSales += quantity;
        }
        return totalSales;
    }

    private static String findBestSellingModel() {
        Map.Entry<String, Integer> bestEntry = sales.entrySet().stream()
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .orElse(null);

        if (bestEntry != null) {
            Car bestSellingCar = carRegistry.get(bestEntry.getKey());
            if (bestSellingCar != null) {
                return bestSellingCar.getMake() + " " + bestSellingCar.getModel();
            }
        }
        return "N/A";
    }

}
