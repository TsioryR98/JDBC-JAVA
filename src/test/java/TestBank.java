import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestBank {
    @Test
    public void testBank1(){
        Customers customers1 = new Customers("max","tsiory","000000000", "222           22222@gmail.com");
        Account account1 = new Account(10000,customers1,1500.00f);

        Assertions.assertEquals(3000.00,account1.credit(1500.00), "test ok");
    }
}


