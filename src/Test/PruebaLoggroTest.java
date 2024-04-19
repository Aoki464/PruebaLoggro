package Test;

import PruebaLoggroMain.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PruebaLoggroTest {

    @Test
    void canWriteWordTrue() throws Exception {

        assertTrue(Main.canWriteWord("a"));
        assertTrue(Main.canWriteWord("libro"));
        assertTrue(Main.canWriteWord("traje"));
        assertTrue(Main.canWriteWord("coMun"));
        assertTrue(Main.canWriteWord("ALMA"));
        assertTrue(Main.canWriteWord("DORITO"));
       // assertTrue(Main.canWriteWord("DORITO1"));
    }

    @Test
    void canWriteWordFalse() throws Exception {
        assertFalse(Main.canWriteWord("bozo"));
        assertFalse(Main.canWriteWord("CAMPANA"));
        assertFalse(Main.canWriteWord("arlequin"));
    }

}