public class MovieTicket {
    private String ticketId;
    private String movieName;
    private String customerName;
    private String seatNumber;
    private double price;
    private boolean isBooked = false;
    private double discountPercentage = 0;
   public MovieTicket(String ticketId, String movieName, String customerName, String seatNumber, double price) {
        this.ticketId = ticketId;
        this.movieName = movieName;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public boolean isBooked() {
        return isBooked;
    }
    public String getMovieName() {
        return movieName;
    }
    public double getPrice() {
        return price;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public String getTicketId() {
        return ticketId;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setSeatNumber(String seatNumber) {
        if (this.isBooked==false) {
            this.seatNumber = seatNumber;
        }

    }
   public boolean bookTicket(){
        if (this.isBooked==true || this.price== 0) {
            return false;
        }
        else {
            this.isBooked = true;
            return true;
        }
    }
   public boolean cancelBooking(){
        if (this.isBooked==true) {
            this.isBooked = false;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean applyDiscount(double discountPercentage) {
        if (discountPercentage <= 100 && discountPercentage >= 0) {
            this.discountPercentage = discountPercentage;
            return true;
        } else {
            return false;
        }
    }
    public double calculateFinalPrice() {
       double discount_amount =(this.price * this.discountPercentage / 100.0);//will calu the price we will take it from the original price
        double discountedPrice = this.price - discount_amount;
        // if it booked we will add this  otherwich this fu to know the price after discount
        if (this.isBooked==true) {
            double bookingFee = discountedPrice * 0.10;
            return discountedPrice + bookingFee;
        }
        return discountedPrice;
    }
    @Override
    public String toString() {
        return "MovieTicket {" +
                "ID = '" + ticketId + '\'' +
                ", Movie = '" + movieName + '\'' +
                ", Customer = '" + customerName + '\'' +
                ", Seat = '" + seatNumber + '\'' +
                ", Price = " + price +
                ", Discount = " + discountPercentage + "%" +
                ", Booked = " + isBooked +
                '}';
    }
}
