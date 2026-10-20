public class DeliveryOrder {
    private String orderId;
    private String customerName;
    private String deliveryAddress;
    private int itemCount;
    private double subtotal;
    private boolean isPaid = false;
    private boolean isDelivered = false;
    private String paymentMethod;
    private DigitalWallet digitalWallet;

    public DeliveryOrder(String orderId,
                         String customerName,
                         String deliveryAddress,
                         int itemCount,
                         double subtotal) {
        this.orderId = orderId;
        if (customerName != null ) {
            this.customerName = customerName;}
        if (deliveryAddress != null ) {
            this.deliveryAddress = deliveryAddress;
        }
        if (itemCount > 0) {
            this.itemCount = itemCount;
        }
        else this.itemCount = 0;
        if (subtotal >= 0) {
            this.subtotal = subtotal;
        }
        else this.subtotal = 0.0;
        this.isPaid = false;
        this.isDelivered = false;
        this.paymentMethod = "CASH";
        this.digitalWallet = null;
    }
    public DeliveryOrder(String orderId,
                         String customerName,
                         String deliveryAddress,
                         int itemCount,
                         double subtotal,
                         DigitalWallet wallet) {
        this.orderId = orderId;
        if (customerName != null ) {
            this.customerName = customerName;}
        if (deliveryAddress != null ) {
            this.deliveryAddress = deliveryAddress;
        }
        if (itemCount > 0) {
            this.itemCount = itemCount;
        }
        else this.itemCount = 0;
        if (subtotal >= 0) {
            this.subtotal = subtotal;
        }
        else this.subtotal = 0.0;
        this.isPaid = false;
        this.isDelivered = false;
        this.paymentMethod = "WALLET";// this is the diff
        this.digitalWallet = wallet;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public DigitalWallet getDigitalWallet() {
        return digitalWallet;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getSubtotal() {
        return subtotal;
    }
    public void setCustomerName(String customerName) {
        if (customerName != null ) {
        this.customerName = customerName;}
    }
    public void setDeliveryAddress(String deliveryAddress) {
        if (deliveryAddress != null ) {
            this.deliveryAddress = deliveryAddress;
        }
    }
    public void setItemCount(int itemCount) {
        if (itemCount > 0) {
            this.itemCount = itemCount;
        }
    }
    private double calculateDeliveryCost( ) {
        if (this.subtotal < 500) {
            return 50.0;
        } else if (this.subtotal < 1000) {
            return 30.0;
        } else {
            return 10.0;
        }

    }

   public double calculateTotalCost(  ) {
    double fees= calculateDeliveryCost();
    double total = fees + subtotal;
    return total;
   }
   private boolean paycash(){
        if  (isPaid){
            return false;
        }
        else {
            isPaid = true;
            return true;
        }
   }
   private boolean paywellet() {
       if (this.digitalWallet == null || this.isPaid == true) {
           return false;
       }
       else {
           double fees = calculateTotalCost();
           if (digitalWallet.withdraw(fees)) {
               isPaid = true;
               return true;
           } else {
               return false;
           }
       }
   }
    public boolean payOrder(){
        if(paymentMethod.equalsIgnoreCase("CASH")) {
         return  paycash();
        }
        else {
           return paywellet();
        }
    }

   public boolean deliverOrder(){
        if (isPaid==false||isDelivered==true){
            return false;
        }
        isDelivered = true;
        return true;
   }
   public  boolean isordercompleted(){
        if (isPaid==true&&isDelivered==true){
            return true;
        }
        return false;
   }








}