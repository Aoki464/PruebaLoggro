package Test;

import PruebaLoggroMain.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PruebaLoggroTest {

    @Test
    void canWriteWordTrue() {

        assertTrue(Main.canWriteWord("a"));
        assertTrue(Main.canWriteWord("libro"));
        assertTrue(Main.canWriteWord("traje"));
        assertTrue(Main.canWriteWord("coMun"));
        assertTrue(Main.canWriteWord("ALMA"));
        assertTrue(Main.canWriteWord("DORITO"));

    }

    @Test
    void canWriteWordFalse() {
        assertFalse(Main.canWriteWord("bozo"));
        assertFalse(Main.canWriteWord("CAMPANA"));
        assertFalse(Main.canWriteWord("arlequin"));
    }

}