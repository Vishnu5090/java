import java.util.*;

class Bus {
    int busNo;
    boolean ac;
    int capacity;

    Bus(int no, boolean ac, int cap) {
        this.busNo = no;
        this.ac = ac;
        this.capacity = cap;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean isAC() {
        return ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + " | AC: " + ac + " | Capacity: " + capacity);
    }
}

class Booking {
    String passengerName;
    int busNo;
    int seatNo;
    String date;

    Booking(String name, int busNo, int seatNo, String date) {
        this.passengerName = name;
        this.busNo = busNo;
        this.seatNo = seatNo;
        this.date = date;
    }

    public boolean isAvailable(ArrayList<Booking> bookings, int capacity) {
        int bookedSeats = 0;
        for (Booking b : bookings) {
            if (b.busNo == this.busNo && b.date.equals(this.date)) {
                if (b.seatNo == this.seatNo) return false;
                bookedSeats++;
            }
        }
        return bookedSeats < capacity;
    }
}

public class BusReservationSystem {
    static ArrayList<Bus> buses = new ArrayList<>();
    static ArrayList<Booking> bookings = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        buses.add(new Bus(101, true, 40));
        buses.add(new Bus(102, false, 45));
        buses.add(new Bus(103, true, 35));

        int choice;
        do {
            System.out.println("\n======= BUS RESERVATION SYSTEM =======");
            System.out.println("1. View Available Buses");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View Bookings");
            System.out.println("5. Add Bus (Admin)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> viewBuses();
                case 2 -> bookTicket();
                case 3 -> cancelTicket();
                case 4 -> viewBookings();
                case 5 -> addBus();
                case 6 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    public static void viewBuses() {
        System.out.println("\n--- Available Buses ---");
        for (Bus b : buses) {
            b.displayBusInfo();
        }
    }

    public static void bookTicket() {
        System.out.println("\n--- Ticket Booking ---");
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter bus number: ");
        int busNo = sc.nextInt();

        Bus selectedBus = getBusByNumber(busNo);
        if (selectedBus == null) {
            System.out.println("Bus not found!");
            return;
        }

        System.out.print("Enter seat number (1 to " + selectedBus.getCapacity() + "): ");
        int seatNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter date (dd-mm-yyyy): ");
        String date = sc.nextLine();

        Booking booking = new Booking(name, busNo, seatNo, date);
        if (seatNo <= 0 || seatNo > selectedBus.getCapacity()) {
            System.out.println("Invalid seat number.");
        } else if (booking.isAvailable(bookings, selectedBus.getCapacity())) {
            bookings.add(booking);
            System.out.println("Booking successful!");
        } else {
            System.out.println("Seat already booked or bus full!");
        }
    }

    public static void cancelTicket() {
        System.out.println("\n--- Cancel Ticket ---");
        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();
        System.out.print("Enter bus number: ");
        int busNo = sc.nextInt();
        System.out.print("Enter seat number: ");
        int seatNo = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        Iterator<Booking> iterator = bookings.iterator();
        while (iterator.hasNext()) {
            Booking b = iterator.next();
            if (b.passengerName.equalsIgnoreCase(name) && b.busNo == busNo && b.seatNo == seatNo) {
                iterator.remove();
                found = true;
                System.out.println("Booking cancelled successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Booking not found.");
        }
    }

    public static void viewBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            for (Booking b : bookings) {
                System.out.println("Name: " + b.passengerName + ", Bus No: " + b.busNo + ", Seat: " + b.seatNo + ", Date: " + b.date);
            }
        }
    }

    public static void addBus() {
        System.out.print("Enter admin password: ");
        String pass = sc.nextLine();
        if (!pass.equals("admin123")) {
            System.out.println("Access Denied!");
            return;
        }

        System.out.print("Enter new bus number: ");
        int no = sc.nextInt();
        System.out.print("Is it AC (true/false): ");
        boolean ac = sc.nextBoolean();
        System.out.print("Enter capacity: ");
        int cap = sc.nextInt();
        sc.nextLine();

        buses.add(new Bus(no, ac, cap));
        System.out.println("Bus added successfully.");
    }

    public static Bus getBusByNumber(int no) {
        for (Bus b : buses) {
            if (b.getBusNo() == no) return b;
        }
        return null;
    }
}
