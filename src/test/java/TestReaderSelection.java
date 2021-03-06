import apdu4j.HexUtils;
import apdu4j.TerminalManager;
import jnasmartcardio.Smartcardio;
import org.junit.Test;

import javax.smartcardio.CardException;
import javax.smartcardio.CardTerminal;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class TestReaderSelection {
    @Test
    public void testReaderSelectionATR() {
        try {
            CardTerminal t = TerminalManager.getByATRBytes(Arrays.asList(new byte[][]{
                    HexUtils.hex2bin("3BFA1800008031FE45FE654944202F20504B4903")
            }));
            if (t != null) {
                System.out.println(t.getName());
            }
        } catch (CardException | NoSuchAlgorithmException | Smartcardio.EstablishContextException e) {
            System.out.println("N/A");
        }
    }

    @Test
    public void testReaderSelectionAID() {
        try {
            CardTerminal t = TerminalManager.getByAID(Arrays.asList(new byte[][]{
                    HexUtils.hex2bin("D23300000045737445494420763335")
            }));
            if (t != null) {
                System.out.println(t.getName());
            }
        } catch (CardException | NoSuchAlgorithmException | Smartcardio.EstablishContextException e) {
            System.out.println("N/A");
        }
    }
}
