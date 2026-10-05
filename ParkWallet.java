/*
 ParkWallet: for tracking tickets.
 */
public class ParkWallet {

    private int tickets;
    private static boolean holiday = false;

    public ParkWallet(){
        tickets = 0;
    }
    public ParkWallet(int tickets){
        this.tickets = tickets;
    }

    //getters
    public int getTicket(){return tickets;}
    public static boolean getHoliday(){return holiday;
    }

    //setters 
    public void setTickets(int tickets){
        if(tickets >= 0 ){
            this.tickets = tickets;
        }
        else{
            System.out.println("A positive number is needed.");
        }
    }

    public static void setHoliday(){
        holiday = !holiday;
    }

    public void addTickets(int increment){
        if(increment >= 0){
            tickets += increment;
        }
    }

    public boolean removeTickets(int removal){
        if(removal >= 0 && tickets >= removal ){ //check input and balance
            tickets -= removal;
            return true;
        }
        else{
            return false;
        }
    }
}   