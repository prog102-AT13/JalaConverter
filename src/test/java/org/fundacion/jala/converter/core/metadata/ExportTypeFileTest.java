package org.fundacion.jala.converter.core.metadata;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class ExportTypeFileTest {

    @Test
    public void ItShouldNameFileCompleteToExport() {
        ExportTypeFile exportTypeFile = Mockito.mock(ExportTypeFile.class);
        Mockito.when(exportTypeFile.getNameFileCompleteToExport()).thenReturn("fileName");
        String actual = exportTypeFile.getNameFileCompleteToExport();
        String expected = "fileName";
        assertEquals(expected, actual);
    }



    @Test
    public void ItShouldEmptyNameExportTypeFile() {
        ExportTypeFile exportTypeFile = new ExportTypeFile("","",TypeFileExport.TXT,new File("path"));
        String actual = exportTypeFile.getNameFileExport();
        String expected = "";
        assertEquals(expected, actual);
    }
}
