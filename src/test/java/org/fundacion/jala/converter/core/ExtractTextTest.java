package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.TextExtractorException;
import org.fundacion.jala.converter.core.parameter.ExtractTextParameter;
import org.junit.Test;

public class ExtractTextTest {

    @Test(expected = TextExtractorException.class)
    public void itShouldExtractTextException() throws TextExtractorException {
        ExtractText extractText = new ExtractText("language", "newpath");
        extractText.extractText();
    }

    @Test(expected = TextExtractorException.class)
    public void itShouldExtractTextExceptionNull() throws TextExtractorException {
        ExtractText extractText = new ExtractText(null);
        extractText.extractText();
    }

    @Test
    public void itShouldExtractTextWithName() throws TextExtractorException {
        ExtractText extractText = new ExtractText(new ExtractTextParameter("src//test//resources//imagenText.png", "eng", "imagenTest"));
        extractText.extractText();
    }

    @Test
    public void itShouldExtractText() throws TextExtractorException {
        ExtractText extractText = new ExtractText(new ExtractTextParameter("src//test//resources//imagenText.png"));
        extractText.extractText();
    }

    @Test(expected = TextExtractorException.class)
    public void itShouldExtractTextExceptionNameOutputNull() throws TextExtractorException {
        ExtractText extractText = new ExtractText("language", "newpath", null);
        extractText.extractText();
    }

}