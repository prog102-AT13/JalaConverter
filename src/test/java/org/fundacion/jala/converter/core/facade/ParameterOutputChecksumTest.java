package org.fundacion.jala.converter.core.facade;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.assertEquals;

public class ParameterOutputChecksumTest {
    private static ParameterOutputChecksum parameterOutputChecksum;

    @BeforeAll
    public static void setParameterOutputChecksum() {
        parameterOutputChecksum = new ParameterOutputChecksum("83a59b9445c3b9c58e2ca8611ad8fec9",
                "G:\\jalaConverter", 0, "aguinaldo.mp4");
    }

    @Test
    public void ItShouldGetChecksumLocal() {
        String actual = parameterOutputChecksum.getChecksumLocal();
        String expected = "83a59b9445c3b9c58e2ca8611ad8fec9";
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldGetOutputFilename() {
        String actual = parameterOutputChecksum.getOutputFilename();
        String expected = "G:\\jalaConverter";
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldGetResultTitleSize() {
        int actual = parameterOutputChecksum.getResultTitleSize();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void ItShouldGetFileName() {
        String actual = parameterOutputChecksum.getFileName();
        String expected = "aguinaldo.mp4";
        assertEquals(expected, actual);
    }
}