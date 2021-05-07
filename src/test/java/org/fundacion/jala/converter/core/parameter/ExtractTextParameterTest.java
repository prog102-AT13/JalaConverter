package org.fundacion.jala.converter.core.parameter;

import static org.junit.Assert.*;
import org.junit.Test;

public class ExtractTextParameterTest {
    @Test
    public void itShouldReturnFilePath() {
        ExtractTextParameter extractTextParameter = new ExtractTextParameter("filepath", "english", "result file name");
        String actual = extractTextParameter.getFilePath();
        String expected = "filepath";
        assertEquals(actual, expected);
    }

    @Test
    public void itShouldReturnLanguage() {
        ExtractTextParameter extractTextParameter = new ExtractTextParameter("filepath", "english", "result file name");
        String actual = extractTextParameter.getLanguage();
        String expected = "english";
        assertEquals(actual, expected);
    }

    @Test
    public void itShouldReturnResultFileName() {
        ExtractTextParameter extractTextParameter = new ExtractTextParameter("filepath", "english", "result file name");
        String actual = extractTextParameter.getResultFile();
        String expected = "result file name";
        assertEquals(actual, expected);
    }

    @Test
    public void itShouldSetLanguage() {
        ExtractTextParameter extractTextParameter = new ExtractTextParameter();
        extractTextParameter.setLanguage("spanish");
        String actual = extractTextParameter.getLanguage();
        String expected = "spanish";
        assertEquals(actual, expected);
    }

    @Test
    public void itShouldSetResultFileName() {
        ExtractTextParameter extractTextParameter = new ExtractTextParameter("filepath");
        extractTextParameter.setResultFile("result file name");
        String actual = extractTextParameter.getResultFile();
        String expected = "result file name";
        assertEquals(actual, expected);
    }
}