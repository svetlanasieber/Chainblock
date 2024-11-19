import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveTransactionByIdUnitTest {

 

    @Test
    public void whenTransactionExist_thenRemoveIt() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 200.00);
        database.add(transactionA);

        Assertions.assertEquals(1, database.getCount());
      
        database.removeTransactionById(1);
      
        Assertions.assertEquals(0, database.getCount());
    }

    @Test
    public void whenTransactionDoesNotExist_thenThrowsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.removeTransactionById(99);
        });
    }
}
