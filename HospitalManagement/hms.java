import java.util.*;
class Hospital
{
    static
    {
        System.out.println("\n=====================================================================");
        System.out.println("\t       Welcome to the portal of XYZ Hospital");
        System.out.println("======================================================================");
    }
}
class Doctor
{
    String Doctor_name;
    int Doctor_id;
    String Doctor_gender;
    String Doctor_speciality;
    int Doctor_salary;
    Scanner inp=new Scanner(System.in);
    //constructor(with arguments) for creating array
    public Doctor(String Doctor_name, int Doctor_id, String Doctor_gender, String Doctor_speciality, int Doctor_salary)      
    {
        this.Doctor_name=Doctor_name;
        this.Doctor_id=Doctor_id;
        this.Doctor_gender=Doctor_gender;
        this.Doctor_speciality=Doctor_speciality;
        this.Doctor_salary=Doctor_salary;
    }
    //display doctor method(with argument)
    public void display()
    {
        System.out.println(Doctor_name+"\t\t\t"+Doctor_id+"\t\t"+Doctor_gender+"\t\t"+Doctor_speciality+"\t\t"+Doctor_salary);
        System.out.println("------------------------------------------------------------------------------------------------");
    }
    //sort method(with argument) for doctor
    public void sortBySalary(Doctor[] d)
    {
        for(int i=0;i<d.length;i++)
        {
            for(int j=0;j<d.length;j++)
            {
                Doctor temp;
                if(d[i].Doctor_salary>d[j].Doctor_salary)
                {
                    temp=d[i];
                    d[i]=d[j];
                    d[j]=temp;
                }
            }
        }
    }
    //search methods(with argument) for doctor
    void searchByGender(String gen)
    {
        if (gen.equalsIgnoreCase(Doctor_gender))
        {
            display();
        }
    }
    void searchById(int id)
    {
        if (id == Doctor_id)
        {
            display();
        }
    }
    void searchBySpeciality(String spec)
    {
        if (spec.equalsIgnoreCase(Doctor_speciality))
        {
            display();
        }
    }

    void searchByName(String nm){
        if (nm.equalsIgnoreCase(Doctor_name))
        {
            display();
        }
    }
}

class Patient
{
    Scanner sc=new Scanner(System.in);
    String Patient_name;
    int Patient_age;
    int Patient_id;
    String Patient_gender;
    String Patient_disease;
    String Patient_status;
    // constructor(with arguments) for creating patient array
    public Patient(String Patient_name,int Patient_age,int Patient_id,String Patient_gender,String Patient_disease,String Patient_status)
    {
        this.Patient_name=Patient_name;
        this.Patient_age=Patient_age;
        this.Patient_id=Patient_id;
        this.Patient_gender=Patient_gender;
        this.Patient_disease=Patient_disease;
        this.Patient_status=Patient_status;
    }
    //display method(with argument) of patient
    public void display()
    {
        System.out.println(Patient_name+"\t\t    "+Patient_age+"\t\t\t"+Patient_id+"\t\t    "+Patient_disease+"\t\t"+Patient_status);
        System.out.println("------------------------------------------------------------------------------------------------");
    }
    //sort methods of patient
    public void sortByAge(Patient[] p)
    {
        for(int i=0;i<p.length;i++)
        {
            for (int j = 0; j < p.length; j++) {
                Patient temp;
                if (p[i].Patient_age < p[j].Patient_age) {
                    temp = p[i];
                    p[i] = p[j];
                    p[j] = temp;
                }
            }
        }
    }
    public void sortById(Patient[] p)
    {
        for(int i=0;i<p.length;i++)
        {
            for(int j=0;j<p.length;j++)
            {
                Patient temp;
                if(p[i].Patient_id<p[j].Patient_id)
                {
                    temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                }
            }
        }
    }
    void sortByName(Patient[] p)
    {
        for(int i=0;i<p.length;i++)
        {
            for(int j=0;j<p.length;j++)
            {
                Patient temp;
                if(p[i].Patient_name.charAt(0)<p[j].Patient_name.charAt(0))
                {
                    temp=p[i];
                    p[i]=p[j];
                    p[j]=temp;
                }
            }
        }
    }
    // search method(with argument) for patient
    void searchByStatus(String status)
    {
        if (status.equalsIgnoreCase(Patient_status))
            display();
    }
}
class HospitalManagementSystem
{
    public static void main(String[] args) {
        Scanner sin = new Scanner(System.in);
        //creating object for class Hospital
        Hospital h = new Hospital();

        System.out.println("\nContents:");
        System.out.println("\n[1] Doctor");
        System.out.println("[2] Patient");
        int n = sin.nextInt();
        switch (n) {
            case 1:
            //creating doctor array
                int d_index=10;
                Doctor[] d = {
                        new Doctor("Darsh", 1101, "Male", "Dermatologist", 50000),
                        new Doctor("Ansh", 1106, "Male", "Neurosurgeon", 150000),
                        new Doctor("Riddhi", 1103, "Female", "Dermatologist", 100000),
                        new Doctor("Rudra", 1105, "Male", "Cardiologist", 120000),
                        new Doctor("Akshat", 1102, "Male", "Pediatrician", 50000),
                        new Doctor("Janvi", 1107, "Female", "Gynecologist", 50000),
                        new Doctor("Prutha", 1104, "Female", "Cardiologist", 115000),
                        new Doctor("Avani", 1109, "Female", "Neonatologist", 50000),
                        new Doctor("Pratham", 1108, "Male", "Plastic surgeon", 175000)};
                boolean flag1 = true;
                while (flag1) {
                    System.out.println("\nEnter the number to perform the function");
                    System.out.println("\nPress 1: to view the details of all the Doctors.");
                    System.out.println("Press 2: to sort and display the data by salary");
                    System.out.println("Press 3: to search any Doctor");
                    System.out.println("press 4: to update the details of Doctor");
                    System.out.println("press 5: to Exit");
                    int num1 = sin.nextInt();
                    switch (num1)
                    {
                        case 1:
                            System.out.println("\nDoctor_name \t\tDoctor_id \tDoctor_gender \tDoctor_speciality \tDoctor_salary");
                            System.out.println("------------------------------------------------------------------------------------------------");
                            for(int i=0;i<d.length;i++)
                            {
                                d[i].display();
                            }
                            break;
                        case 2:
                            for(int i=0;i<d.length;i++)
                            {
                                d[i].sortBySalary(d);
                            }
                            System.out.println("\nDoctor_name \t\tDoctor_id \tDoctor_gender \tDoctor_speciality \tDoctor_salary");
                            System.out.println("------------------------------------------------------------------------------------------------");
                            for(int i=0;i<d.length;i++)
                            {
                                d[i].display();
                            }
                            break;
                        case 3:
                            System.out.println("\nPress 1: to search by Gender");
                            System.out.println("Press 2: to search by id");
                            System.out.println("Press 3: to search by speciality");
                            System.out.println("Press 4: to search by name");
                            sin.nextLine();
                            int choice = sin.nextInt();
                            //switch case inside another switch case
                            switch (choice) {
                                case 1:
                                    System.out.println("\nEnter the Gender you want to search for: ");
                                    sin.nextLine();
                                    String gen = sin.nextLine();
                                    System.out.println("\nDoctor_name \t\tDoctor_id \tDoctor_gender \tDoctor_speciality \tDoctor_salary");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for (int i = 0; i < d.length; i++) {
                                        d[i].searchByGender(gen);
                                    }
                                    break;
                                case 2:
                                    System.out.println("\nEnter the id you want to search for: ");
                                    int id = sin.nextInt();
                                    System.out.println("\nDoctor_name \t\tDoctor_id \tDoctor_gender \tDoctor_speciality \tDoctor_salary");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for (int i = 0; i < d.length; i++) {
                                        d[i].searchById(id);
                                    }
                                    break;
                                case 3:
                                    System.out.println("\nEnter the speciality you want to search for: ");
                                    sin.nextLine();
                                    String spec = sin.nextLine();
                                    System.out.println("\nDoctor_name \t\tDoctor_id \tDoctor_gender \tDoctor_speciality \tDoctor_salary");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for (int i = 0; i < d.length; i++) {
                                        d[i].searchBySpeciality(spec);
                                    }
                                    break;
                                case 4:
                                    System.out.println("\nEnter the name you want to search for: ");
                                    sin.nextLine();
                                    String nm = sin.nextLine();
                                    System.out.println("\nDoctor_name \t\tDoctor_id \tDoctor_gender \tDoctor_speciality \tDoctor_salary");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for (int i = 0; i < d.length; i++) {
                                        d[i].searchByName(nm);
                                    }
                                    break;
                                default:
                                    System.out.println("\nEnter valid number!");
                                    break;
                            }
                            break;
                        case 4:
                            System.out.println("\nEnter Doctor' name: ");
                            sin.nextLine();
                            String Doctor_name=sin.nextLine();
                            System.out.println("Enter Doctor's id: ");
                            int Doctor_id=sin.nextInt();
                            System.out.println("Enter Doctor's Gender: ");
                            sin.nextLine();
                            String Doctor_gender=sin.nextLine();
                            System.out.println("Enter Doctor's Speciality:' ");
                            String Doctor_speciality=sin.nextLine();
                            System.out.println("Enter Doctor's salary: ");
                            int Doctor_salary=sin.nextInt();
                            d_index++;
                            Doctor[] d1={new Doctor(Doctor_name, Doctor_id, Doctor_gender, Doctor_speciality, Doctor_salary)};
                            Doctor[] dn=new Doctor[d.length+d1.length];
                            for(int i=0;i<d.length;i++)
                            {
                                dn[i]=d[i];
                            }
                            for(int i=0;i<d1.length;i++)
                            {
                                dn[d.length+i]=d1[i];
                            }
                            d=dn;
                            System.out.println("\nDoctor details added Successfully!!");
                            break;
                        case 5:
                            flag1 = false;
                            break;
                        default:
                            System.out.println("\nEnter valid number!");
                    }
                }
                break;
                case 2:
                    //creating patient array
                        int p_index=0;
                        Patient[] p = {
                                new Patient("Vatsal", 24, 2203, "Male", "Tooth decay", "Admitted"),
                                new Patient("Shakti", 9, 2209, "Male", "Monkeypox", "Admitted"),
                                new Patient("Jensi", 81, 2204, "Female", "Braincancer", "Discharged"),
                                new Patient("Heva", 36, 2201, "Female", "Jaundice", "Admitted"),
                                new Patient("Vedant", 18, 2205, "Male", "Chickenpox", "Discharged"),
                                new Patient("Nishita", 27, 2206, "Female", "diarrhea", "Discharged"),
                                new Patient("Jayant", 72, 2208, "Male", "pneumonia", "Admitted"),
                                new Patient("Jash", 54, 2202, "Male", "Chickenpox", "Discharged"),
                                new Patient("Jiya", 45, 2207, "Female", "Covid-19", "Admitted")};
                        boolean flag2 = true;
                        while (flag2)
                        {
                            System.out.println("\nEnter the number to perform the function");
                            System.out.println("\nPress 1: to view the details of all the patients.");
                            System.out.println("Press 2: to sort and display the data by age");
                            System.out.println("Press 3: to sort and display the data by id");
                            System.out.println("press 4: to sort and display the data by name");
                            System.out.println("press 5: to search by status");
                            System.out.println("press 6: to update the details of patients");
                            System.out.println("press 7: to Exit");
                            int num2 = sin.nextInt();
                            switch (num2) {
                                case 1:
                                    System.out.println("\nPatient_name\t    Patient_age \tPatient_id \t    Patient_disease \tPatient_status");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].display();
                                    }
                                    break;
                                case 2:
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].sortByAge(p);
                                    }
                                    System.out.println("\nPatient_name\t    Patient_age \tPatient_id \t    Patient_disease \tPatient_status");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].display();
                                    }
                                    break;
                                case 3:
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].sortById(p);
                                    }
                                    System.out.println("\nPatient_name\t    Patient_age \tPatient_id \t    Patient_disease \tPatient_status");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].display();
                                    }
                                    break;
                                case 4:
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].sortByName(p);
                                    }
                                    System.out.println("\nPatient_name\t    Patient_age \tPatient_id \t    Patient_disease \tPatient_status");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for(int i=0;i<p.length;i++)
                                    {
                                        p[i].display();
                                    }
                                    break;
                                case 5:
                                    System.out.println("\nEnter the status you want to search for: ");
                                    sin.nextLine();
                                    String status = sin.nextLine();
                                    System.out.println("\nPatient_name\t    Patient_age \tPatient_id \t    Patient_disease \tPatient_status");
                                    System.out.println("------------------------------------------------------------------------------------------------");
                                    for (int i=0;i<p.length;i++)
                                    {
                                        p[i].searchByStatus(status);
                                    }
                                    break;
                                case 6:
                                    System.out.println("\nEnter Patient's name:");
                                    sin.nextLine();
                                    String Patient_name=sin.nextLine();
                                    System.out.println("Enter Patient's age");
                                    int Patient_age=sin.nextInt();
                                    System.out.println("Enter Patient's id:");
                                    int Patient_id=sin.nextInt();
                                    System.out.println("Enter Patient's gender:");
                                    sin.nextLine();
                                    String Patient_gender=sin.nextLine();
                                    System.out.println("Enter Patient's disease:");
                                    String Patient_disease=sin.nextLine();
                                    System.out.println("Enter Patient's status:");
                                    String Patient_status=sin.nextLine();
                                    p_index++;
                                    Patient[] p1 ={new Patient(Patient_name, Patient_age, Patient_id, Patient_gender, Patient_disease, Patient_status)};
                                    Patient[] pn =new Patient[p.length+p1.length];
                                    for(int i=0;i<p.length;i++)
                                    {
                                        pn[i]=p[i];
                                    }
                                    for(int i=0;i<p1.length;i++)
                                    {
                                        pn[p.length+i]=p1[i];
                                    }
                                    p=pn;
                                    System.out.println("\nPatient's details added successfully!");
                                    break;
                                case 7:
                                    flag2 = false;
                                    break;
                                default:
                                    System.out.println("\nEnter valid number!");
                                    break;
                            }
                        }
                        break;
                }
        }
    }
