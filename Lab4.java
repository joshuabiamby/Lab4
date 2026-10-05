import java.util.Scanner;
public class Lab4 {
    public static void main(String[] args){
    Scanner scanner = new Scanner(System.in);
    ParkWallet wallet = new ParkWallet(100);

    while(true){
        System.out.println("Your wallet has " + wallet.getTicket() + " tickets");
            System.out.println("1. Add tickets");
            System.out.println("2. Set tickets");
            System.out.println("3. Buy prize");
            System.out.println("4. Set holiday");
            System.out.println("5. Quit");
            System.out.print("Enter option: ");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Add how many tickets? ");
                int amountToAdd = scanner.nextInt();
                wallet.addTickets(amountToAdd);
            } else if (choice == 2) {
                System.out.print("Set ticket amount to: ");
                int amountToSet = scanner.nextInt();
                wallet.setTickets(amountToSet);
            } else if (choice == 3) {
                int priceTShirt = 150;
                int priceSunHat = 350;
                int priceSneakers = 600;

                boolean isHoliday = ParkWallet.getHoliday();
                String menuHeader = "Buy prize";

                if (isHoliday) {
                    menuHeader = "Buy prize at holiday prices!";
                    // Using standard division as requested
                    priceTShirt = priceTShirt / 2;
                    priceSunHat = priceSunHat / 2;
                    priceSneakers = priceSneakers / 2;
                }

                System.out.println(menuHeader);
                System.out.println("1. T-shirt (" + priceTShirt + " tickets)");
                System.out.println("2. Sun hat (" + priceSunHat + " tickets)");
                System.out.println("3. Sneakers (" + priceSneakers + " tickets)");
                System.out.print("Buy which prize? ");

                int prizeChoice = scanner.nextInt();

                if (prizeChoice == 1) {
                    if (wallet.getTicket() >= priceTShirt) {
                        if (wallet.removeTickets(priceTShirt)) {
                            System.out.println("Bought a t-shirt for " + priceTShirt + " tickets");
                        }
                    } else {
                        System.out.println("Not enough tickets to buy a t-shirt");
                    }
                } else if (prizeChoice == 2) {
                    if (wallet.getTicket() >= priceSunHat) {
                        if (wallet.removeTickets(priceSunHat)) {
                            System.out.println("Bought a sun hat for " + priceSunHat + " tickets");
                        }
                    } else {
                        System.out.println("Not enough tickets to buy a sun hat");
                    }
                } else if (prizeChoice == 3) {
                    if (wallet.getTicket() >= priceSneakers) {
                        if (wallet.removeTickets(priceSneakers)) {
                            System.out.println("Bought sneakers for " + priceSneakers + " tickets");
                        }
                    } else {
                        System.out.println("Not enough tickets to buy sneakers");
                    }
                }

            } else if (choice == 4) {
                ParkWallet.setHoliday();
                if (ParkWallet.getHoliday()) {
                    System.out.println("It is now a holiday.");
                } else {
                    System.out.println("It is no longer a holiday.");
                }
            } else if (choice == 5) {
                System.out.println("Shutting off...");
                break;
    }
    }
}

}
