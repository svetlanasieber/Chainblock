import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetByIdUnitTest {

 

    @Test
    public void whenTransactionExists_thenReturnIt() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 200.00);
        database.add(transactionA);

    
        Transaction result = database.getById(1);
        Assertions.assertEquals(transactionA, result);

       
        Assertions.assertDoesNotThrow(() -> {
            database.getById(1);
        });
    }

    @Test
    public void whenTransactionDoesNotExists_thenThrowsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getById(99);
        });
    }
}
