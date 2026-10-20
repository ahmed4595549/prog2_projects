import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("1", "movie1", "ahmed", "13", 200);
        System.out.println(" ticket :" + ticket.toString());
        System.out.println("\n");

        // negative price
        System.out.println("negative price");
        MovieTicket ticket1 = new MovieTicket("1", "movie1", "ahmed", "13", -200);
        System.out.println(" ticket1 :" + ticket1.toString());
        System.out.println("\n");

        // zero price
        System.out.println("zero price");
        MovieTicket ticket2 = new MovieTicket("1", "movie1", "ahmed", "13", 0);
        System.out.println(" ticket2 :" + ticket2.toString());
        System.out.println("\n");

        // check if the ticket2 with 0 price will be booked
        System.out.println("check if the ticket2 with 0 price will be booked");
        System.out.println(" check if the ticket2 with 0 price will be booked (should be false) " + ticket2.bookTicket());
        System.out.println("\n");

        // normal discount
        System.out.println("normal");
        System.out.println(" normal discount is applied " + ticket.applyDiscount(10));
        System.out.println("\n");

        // discount above 100
        System.out.println("above 100");
        System.out.println(" invalid discount is applied " + ticket.applyDiscount(150));
        System.out.println("\n");

        // test final price before booking (200 - 10% = 180)
        System.out.println("calculate final price before booking");
        System.out.println(" final price before booking: " + ticket.calculateFinalPrice());
        System.out.println("\n");

        // booking valid ticket & final price with fee (180 + 10% fee = 198)
        System.out.println("booking valid ticket");
        System.out.println(" booking success: " + ticket.bookTicket());
        System.out.println(" final price after booking (with 10% fee): " + ticket.calculateFinalPrice());
        System.out.println("\n");

        // repeat booking test (on already booked ticket)
        System.out.println("repeat booking");
        System.out.println(" will return false because it is already booked " + ticket.bookTicket());
        System.out.println("\n");

        // cancel booking
        System.out.println("cancel booking");
        System.out.println(" cancelling " + ticket.cancelBooking());
        System.out.println("\n");

        // trying to change a seat to a ticket if it is already booked
        System.out.println("trying to change a seat to a ticket if it is already booked");
        ticket.bookTicket();
        ticket.setSeatNumber("15");
        System.out.println(" will be 13 " + ticket.getSeatNumber());
        System.out.println("\n");

        // opposite case
        System.out.println("opposite case");
        ticket.cancelBooking();
        ticket.setSeatNumber("15");
        System.out.println(" will be 15 " + ticket.getSeatNumber());

        System.out.println("******************************************************************************************");
        System.out.println(" Create wallet with balance 1000");
        DigitalWallet wallet1 = new DigitalWallet("W1", "Ahmed", 1000);
        System.out.println(" Balance  " + wallet1.getBalance() + " | TransactionCount  " + wallet1.getTransactionscount());
        // balance will be 1000
        System.out.println("\n");
        System.out.println(" Deposit 100  success");
        System.out.println(" deposit : " + wallet1.deposit(100));
        System.out.println(" Balance " + wallet1.getBalance() + " | TransactionCount: " + wallet1.getTransactionscount());
        System.out.println("\n");

        System.out.println("3. Deposit 0  and  negative amount  the information will be same  balance =1100 ");
        System.out.println(" deposit 0 : " + wallet1.deposit(0));
        System.out.println(" deposit -50 : " + wallet1.deposit(-50));
        System.out.println(" Balance: " + wallet1.getBalance() + " | TransactionCount: " + wallet1.getTransactionscount());
        System.out.println("\n");

        System.out.println("4. Withdraw 200 from wallet with balance 1100 will be 900");
        System.out.println(" withdraw 200 success: " + wallet1.withdraw(200));
        System.out.println(" Balance: " + wallet1.getBalance() + " | TransactionCount: " + wallet1.getTransactionscount());
        System.out.println("\n");

        System.out.println("6. Transfer 400 (Fee is 5 EGP)");
        DigitalWallet w1 = new DigitalWallet("W10", "Sender1", 3000);
        DigitalWallet w2 = new DigitalWallet("W20", "Receiver1", 200);
        System.out.println(" transfer 400 success: " + w1.transfer(w2, 400));
        System.out.println(" Sender Balance (3000 - 405 = 2595): " + w1.getBalance());
        System.out.println(" Receiver Balance (200 + 400 = 600): " + w2.getBalance());
        System.out.println("\n");

        System.out.println("6. Transfer 999.99 (Fee is 10 EGP)");

        System.out.println(" transfer 999.99 success: " + w1.transfer(w2, 999.99));
        System.out.println(" Sender Balance (2595 - (999.9+10)=1585.01  ): " + w1.getBalance());
        System.out.println(" Receiver Balance (600+ 999.99 =1599.99 ): " + w2.getBalance());
        System.out.println("\n");
        System.out.println("6. Transfer 1000(Fee is 15 EGP)");

        System.out.println(" transfer 1000  success: " + w1.transfer(w2, 1000));
        System.out.println(" Sender Balance ((1585.01)-(1000+15) = 570.01  ): " + w1.getBalance());
        System.out.println(" Receiver Balance ((600+ 999.99)+1000 = 2599.99): " + w2.getBalance());
        System.out.println("\n");

        System.out.println("12. Balance covers amount but NOT amount + fee");

        System.out.println(" transfer 10000 success (should be false): " + w1.transfer(w2, 10000));
        System.out.println(" Sender Balance ( remains ): 570 " + w1.getBalance());
        System.out.println("  resevier Balance ( remains ): 2599.99"+w2.getBalance());
        System.out.println("\n");

        System.out.println("10. Transfer to null");
        System.out.println(" transfer to null success (should be false): " + w1.transfer(null, 100));
        System.out.println("\n");

        System.out.println("11. Transfer to the same wallet");
        System.out.println(" transfer to self success (should be false): " + w1.transfer(w1, 100));
        System.out.println("\n");
        System.out.println("******************************************************************************************");
        System.out.println("1. Create cash order with subtotal 600");
        DeliveryOrder order = new DeliveryOrder("O1", "Ahmed", "Alexandria", 2, 600.0);
        System.out.println(" isPaid: " + order.isPaid() + " | isDelivered: " + order.isDelivered());

        System.out.println("\n");
        System.out.println("2. Calculate delivery cost for subtotal 499.99 (expected 50)");
        DeliveryOrder order1 = new DeliveryOrder("O2", "Ali", "Alexandria", 1, 499.99);
        System.out.println(" Subtotal: " + order1.getSubtotal() + " | Delivery fee: " + (order1.calculateTotalCost() - order1.getSubtotal()));
        System.out.println("\n");
        System.out.println("3. Calculate delivery cost for subtotal 500 (expected 30)");
        DeliveryOrder order2 = new DeliveryOrder("O3", "Ali", "Alexandria", 1, 500.0);
        System.out.println(" Subtotal: " + order2.getSubtotal() + " | Delivery fee: " + (order2.calculateTotalCost() - order2.getSubtotal()));
        System.out.println("\n");
        System.out.println("4. Calculate delivery cost for subtotal 999.99 (expected 30)");
        DeliveryOrder order3 = new DeliveryOrder("O4", "Ali", "Alexandria", 1, 999.99);
        System.out.println(" Subtotal: " + order3.getSubtotal() + " | Delivery fee: " + (order3.calculateTotalCost() - order3.getSubtotal()));
        System.out.println("\n");
        System.out.println("5. Calculate delivery cost for subtotal 1000 (expected 10)");
        DeliveryOrder order4 = new DeliveryOrder("O5", "Ali", "Alexandria", 1, 1000.0);
        System.out.println(" Subtotal: " + order4.getSubtotal() + " | Delivery fee: " + (order4.calculateTotalCost() - order4.getSubtotal()));
        System.out.println("\n");

        // using the frist order with subtotal 600
        System.out.println("6. Order with subtotal 600 (Total expected 630)");
        System.out.println(" Subtotal: " + order.getSubtotal() + " | Total cost: " + order.calculateTotalCost());
        System.out.println("\n");

        System.out.println("7. Pay cash frist  time");
        System.out.println(" payOrder success: " + order1.payOrder());
        System.out.println(" isPaid: " + order1.isPaid());
        System.out.println("\n");
        System.out.println("8. Pay cash 2nd time");
        System.out.println(" payOrder secound  time success (should be false): " + order1.payOrder());
        System.out.println("\n");


        System.out.println("9. Pay from wallet with sufficient balance");
        DigitalWallet Wallet = new DigitalWallet("W1", "Sami", 1000.0);
        DeliveryOrder walletOrder1 = new DeliveryOrder("O6", "Sami", "Alexandria", 2, 600.0, Wallet);
        System.out.println(" payOrder success: " + walletOrder1.payOrder());
        System.out.println(" Order isPaid: " + walletOrder1.isPaid());
        System.out.println(" Wallet Remaining Balance (1000 - 630 = 370): " + Wallet.getBalance());
        System.out.println("\n");
        System.out.println("9. Pay from wallet with insufficient balance");

        DeliveryOrder walletOrder3 = new DeliveryOrder("O6", "Sami", "Alexandria", 2, 600.0, Wallet);
        System.out.println(" payOrder is not susess : " + walletOrder3.payOrder());
        System.out.println(" Order  is not paid : " + walletOrder3.isPaid());
        System.out.println(" Wallet Remaining Balance same as pervies : " + Wallet.getBalance());
        System.out.println("\n");

        System.out.println("11. Pay without valid wallet (null wallet)");
        DeliveryOrder nullWalletOrder = new DeliveryOrder("O8", "Mona", "Alexandria", 2, 600.0, null);
        System.out.println(" payOrder success (should be false): " + nullWalletOrder.payOrder());
        System.out.println("\n");

        System.out.println("12. Deliver unpaid order");
        System.out.println(" deliverOrder success (should be false): " + order2.deliverOrder());
        System.out.println("\n");
        System.out.println("13. Deliver paid order");
        System.out.println(" deliverOrder success: " + order1.deliverOrder());
        System.out.println(" isDelivered: will be true " + order1.isDelivered());
        System.out.println("\n");
        System.out.println("14. Deliver same order 2nd time");
        System.out.println(" deliverOrder 2nd time success (should be false): " + order1.deliverOrder());
        System.out.println("\n");
        System.out.println("15. Check order completed (paid but undelivered)");
        System.out.println(" walletOrder1 isOrderCompleted (should be false): " + walletOrder1.isordercompleted());
        System.out.println("\n");

        System.out.println("16. Check order completed (paid and delivered)");
        System.out.println(" order1 isOrderCompleted (should be true): " + order1.isordercompleted());
        System.out.println("\n");
        System.out.println(" CustomerName remains unchanged: " + order1.getCustomerName());
        System.out.println(" Address remains unchanged: " + order1.getDeliveryAddress());
        System.out.println("\n");

        System.out.println("18. Invalid itemCount or negative subtotal in constructor");
        DeliveryOrder invalidOrder = new DeliveryOrder("O9", "Hassan", "Alexandria", -5, -100.0);
        System.out.println(" ItemCount (stored as 0): " + invalidOrder.getItemCount());
        System.out.println(" Subtotal (stored as 0.0): " + invalidOrder.getSubtotal());
        System.out.println("\n");














    }
}