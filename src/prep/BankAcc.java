package prep;

public class BankAcc{
    private double balance;
    
    public BankAcc(int b){
        this.balance = b;
    }
    
    public double deposit(double amount){
        return balance += amount;
    }
    
    public void withdraw(double amount){
        if(amount > balance) { 
            System.out.println("Қаражат жеткіліксіз"); 
        }
        else {
           balance -= amount;
        }
    }
    
    public double getBalance(){
        return balance;
    }
}
