import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

interface TimeTracker {
    void showDashboard();
}

abstract class DunkinEmployee implements TimeTracker {
    private String name;
    private String role;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");

    public DunkinEmployee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    
    public void showDashboard() {
        LocalTime clockIn = LocalTime.of(17, 0);          
        LocalTime breakStart = LocalTime.of(20, 30);      
        LocalTime breakEnd = LocalTime.of(21, 0);         
        LocalTime clockOut = LocalTime.of(22, 0);         

        System.out.println("==========================================");
        System.out.println("   DUNKIN' STAFF DASHBOARD - " + name.toUpperCase());
        System.out.println("==========================================");
        System.out.println(" ROLE          : " + role);
        System.out.println(" STATUS        : SHIFT COMPLETED");
        System.out.println("------------------------------------------");
        System.out.println(" [START] Clocked In    @ " + clockIn.format(dtf));
        System.out.println(" [BREAK] Started       @ " + breakStart.format(dtf));
        System.out.println(" [BREAK] Finished      @ " + breakEnd.format(dtf));
        System.out.println(" [END]   Clocked Out   @ " + clockOut.format(dtf));
        System.out.println("------------------------------------------");
        System.out.println(" TOTAL WORK    : 5 Hours");
        System.out.println(" TOTAL BREAK   : 30 Minutes");
        performDuty();
        System.out.println("==========================================\n");
    }

    public abstract void performDuty();
    public String getName() { return name; }
}

class CrewMember extends DunkinEmployee {
    public CrewMember(String name) { super(name, "Crew Member"); }
    public void performDuty() {
        System.out.println(" WORK LOG      : Prepped donuts & served coffee.");
    }
}

class Manager extends DunkinEmployee {
    public Manager(String name) { super(name, "Store Manager"); }
    public void performDuty() {
        System.out.println(" WORK LOG      : Managed staff & closed registers.");
    }
}

class DunkinApp {
    public static void main(String[] args) {
        List<DunkinEmployee> staff = new ArrayList<>();
        
        staff.add(new CrewMember("Roy Akash"));
        staff.add(new Manager("Roy Siya"));

        for (DunkinEmployee emp : staff) {
            emp.showDashboard();
        }
    }
}
