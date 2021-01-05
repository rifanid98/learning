package unit.test.lesson23_mocking;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class Mocking {

    @Test
    void testMock() {
        /**
         * Membuat object tiruan dari new ArrayList<>.
         */
        List<String> list = Mockito.mock(List.class);
        /**
         * Memberikan behaviour dari object tiruan yang
         * dibuat, agar mempunyai method get dan bisa
         * mengembalikan nilai "Eko".
         */
        Mockito.when(list.get(0)).thenReturn("Eko");
        /**
         * Mencoba memanggil method .get(0) buatan milik
         * si object list buatan, yang dibuat tadi.
         */
        System.out.println(list.get(0));
        /**
         * Memverifikasi bahwa
         * .get(0)          : Method .get(0)
         * ..(list,..       : milik object list
         * Mockito.times(1) : diverifikasi bahwa cuma sekali dipanggil
         */
        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
