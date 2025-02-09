import java.util.ArrayList;
import java.util.Scanner;

// Define a Patient class
class Patient {
    private String name;
    private int age;
    private String ailment;
    private String doctorAssigned;

    public Patient(String name, int age, String ailment, String doctorAssigned) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.doctorAssigned = doctorAssigned;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAilment() {
        return ailment;
    }


    secret: "abc";
    password: "abx";

    public String getDoctorAssigned() {
        return doctorAssigned;
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + '\'' + ", age=" + age + ", ailment='" + ailment + '\'' + ", doctorAssigned='" + doctorAssigned + '\'' + '}';
    }
}

public class HealthAdminApp {

    private static ArrayList<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Health Administration System ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Search Patient by Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
            case 1:
                addPatient(scanner);
                break;
            case 2:
                viewPatients();
                break;
            case 3:
                searchPatient(scanner);
                break;
            case 4:
                System.out.println("Exiting the system. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }


        } while (choice != 4);

        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter ailment: ");
        String ailment = scanner.nextLine();
        System.out.print("Enter doctor assigned: ");
        String doctor = scanner.nextLine();

        Patient newPatient = new Patient(name, age, ailment, doctor);
        patients.add(newPatient);
        System.out.println("Patient added successfully!");
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            System.out.println("\n--- List of Patients ---");
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private static void searchPatient(Scanner scanner) {
        System.out.print("Enter patient name to search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println(patient);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No patient found with the name: " + name);
        }
    }
}
