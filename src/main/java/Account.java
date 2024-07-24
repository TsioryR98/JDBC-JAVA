import lombok.Getter;
import lombok.Setter;

public class Account {
    private int numeroCompte;
    private Customers owner;
    protected double solde = 0.0;

    public Account(int numeroCompte, Customers owner, double solde) {
        this.numeroCompte = numeroCompte;
        this.owner = owner;
        this.solde = solde;
    }
        public int getNumeroCompte() {
            return numeroCompte;
        }

        public void setNumeroCompte(int numeroCompte) {
            this.numeroCompte = numeroCompte;
        }

        public Customers getOwner() {
            return owner;
        }

        public void setOwner(Customers owner) {
            this.owner = owner;
        }

        public double getSolde() {
            return solde;
        }

        public void setSolde(double solde) {
            this.solde = solde;
        }

        public double credit(double amount){
        return this.solde += amount;
    }
        public void debit(double amount){
        this.solde -= amount;
    }

        public void transfertAccount(Account target, double amount){
        this.debit(amount);
        target.credit(amount);
    }
}
