import java.util.*;

class RailwayReservation {
    private static final int TOTAL_SEATS = 5;

    Queue<String> reservedSeats = new LinkedList<>();
    Queue<String> waitinglist = new LinkedList<>();

    private static final int WAITING_LIST = 3;

    // BOOK TICKET 

    public void bookTicket(String name) {

        if(reservedSeats.size() < TOTAL_SEATS) {
            reservedSeats.add(name);
            System.out.println(" Ticket confirmed for: " + name);

        } else if(waitinglist.size() < WAITING_LIST) {
            waitinglist.add(name);
            System.out.println(" setas full added to waiting list: " + name);


        } else {
            System.out.println(" Sorry, no seats available for: " + name);
        }    
}

// CANCEL TICKET

public void cancelTicket(String name){

    if(reservedSeats.remove(name)){
       System.out.println("Ticket Cancelled for:" + name);


       if(!waitinglist.isEmpty()){
        String next = waitinglist.remove();
        reservedSeats.add(next);
        System.out.println(" > " + next + " moved  from waiting  to confirmrd ");
       }

    }else if(waitinglist.remove(name)){
        System.out.println("removed from waititng list:"+ name);

    }else {
        System.out.println("no ticket founr for: "+ name);
    }
}

// show status 

public void showStatus() { 
    System.out.println("\n====== reservedSeats list ======= ");
    System.out.println(reservedSeats);



    System.out.println("\n======waitinglist ========= ");
    System.out.println(waitinglist);
    }
}

// MAIN CLASS

public class Main {
     public static void main(String[] args){
         RailwayReservation rr = new RailwayReservation();

         rr.bookTicket("rohit");
         rr.bookTicket("pranjal");
         rr.bookTicket("pankaj");
         rr.bookTicket("vaishanvi");
         rr.bookTicket("sanu");


         // goes to waiting list
         rr.bookTicket("dhiraj");
         rr.bookTicket(" harshal");

         rr.showStatus();

         System.out.println("\n=== canceling ticket for pankaj ===");
          rr.cancelTicket("pankaj");

            rr.showStatus();
     }
}