public class DigitalWallet {
    private String walletid;
    private String ownername;
    private double balance;
    private int transactionscount;//primitive datatypes will be zero
    public DigitalWallet(String walletid, String ownername, double balance) {
        this.walletid = walletid;
        this.ownername = ownername;
        if (balance >= 0) {//Invalid data must not create an invalid object state so i donnot use try_catch
            this.balance = balance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnername() {
        return ownername;
    }

    public int getTransactionscount() {
        return transactionscount;
    }

    public String getWalletid() {
        return walletid;
    }
    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            this.transactionscount += 1;
            return true;
        }
        else  return false;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && this.balance >= amount) {
            this.balance -= amount;
            this.transactionscount += 1;
            return true;
        }
        else  return false;
    }
    private double calculateTransactionFee(double amount) {
        if (amount ==0) {
            return 0;
        }
        else if(amount <500 ) {
            return 5;
        }
        else if (amount >= 500&& amount < 1000) {
            return 10;
        }
        else if (amount >= 1000 ) {
            return 15;
        }
        return 0;
    }
    public boolean transfer(DigitalWallet secondWallet, double amount) {
        if (secondWallet == null || secondWallet == this || amount <= 0) {
            return false;
        }

        double fees = calculateTransactionFee(amount);

        if (this.balance < amount + fees) {
            return false;
        }

        this.balance -= amount + fees;
        secondWallet.balance += amount;

        this.transactionscount++;
        secondWallet.transactionscount++;

        return true;
    }




}
