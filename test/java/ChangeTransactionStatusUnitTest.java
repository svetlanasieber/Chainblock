import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ChangeTransactionStatusUnitTest {

   

    @Test
    public void whenTransactionExist_changeStatus() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Vik", "Dani", 200.00);
        database.add(transactionA);

        database.changeTransactionStatus(1, TransactionStatus.FAILED);
        Assertions.assertEquals(TransactionStatus.FAILED, transactionA.getStatus());
    }

    @Test
    public void whenTransactionDoesNotExist_throwsException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.changeTransactionStatus(99, TransactionStatus.UNAUTHORIZED);
        });
    }
}
