import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GetAllSendersWithTransactionStatusUnitTest {

 

    @Test
    public void whenTransactionExistWithThisStatus_thenReturnThem() {

        ChainblockImpl database = new ChainblockImpl();

        Transaction transactionA = new TransactionImpl(1, TransactionStatus.SUCCESSFUL, "Svetlio", "Dani", 20.00);
        Transaction transactionB = new TransactionImpl(2, TransactionStatus.SUCCESSFUL, "Dani", "Dani", 100.00);
        Transaction transactionC = new TransactionImpl(3, TransactionStatus.SUCCESSFUL, "Niki", "Dani", 200.00);
        Transaction transactionD = new TransactionImpl(4, TransactionStatus.ABORTED, "Vik", "Dani", 200.00);
        database.add(transactionA);
        database.add(transactionB);
        database.add(transactionC);
        database.add(transactionD);

        Iterable<String> result = database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<String> names = new ArrayList<>();
        result.forEach(names::add);

       
        Assertions.assertEquals(3, names.size());

    
        String nameNiki = names.get(0); 
        String nameDani = names.get(1);
        String nameSvetlio = names.get(2); 
        Assertions.assertEquals("Niki", nameNiki);
        Assertions.assertEquals("Dani", nameDani);
        Assertions.assertEquals("Svetlio", nameSvetlio);
    }

    @Test
    public void whenTransactionDoesNotExistWithThisStatus_thenThrownException() {

        ChainblockImpl database = new ChainblockImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            database.getAllSendersWithTransactionStatus(TransactionStatus.FAILED);
        });
    }
}
