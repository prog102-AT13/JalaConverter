package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.metadata.TypeFileExport;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.File;

import static org.junit.Assert.assertEquals;

public class ObjectMetadataTest {

    ObjectMetadata objectMetadata;
    ObjectMetadata objeto;

    @Before
    public void setUp() {
        objectMetadata = Mockito.mock(ObjectMetadata.class);
        objeto = new ObjectMetadata();
        objeto.setFileToExport(new File("ruta"));
        objeto.setFileToExtract(new File("ruta"));
        objeto.setNameExport("nameExport");
        objeto.setTypeFileExport(TypeFileExport.XMP);
        objeto.setMoreInfo(true);
    }

    @Test
    public void getFileToExtract() {
        Mockito.when(objectMetadata.getFileToExtract()).thenReturn(new File("ruta"));
        File actual = objectMetadata.getFileToExtract();
        File expected = objeto.getFileToExtract();
        assertEquals(expected, actual);
    }

    @Test
    public void getFileToExport() {
        Mockito.when(objectMetadata.getFileToExport()).thenReturn(new File("ruta"));
        File actual = objectMetadata.getFileToExport();
        File expected = objeto.getFileToExport();
        assertEquals(expected, actual);

    }

    @Test
    public void getNameExport() {
        Mockito.when(objectMetadata.getNameExport()).thenReturn("nameExport");
        String expected = objeto.getNameExport();
        assertEquals(expected, objectMetadata.getNameExport());
    }

    @Test
    public void ItShouldTypeFileExport() {
        Mockito.when(objectMetadata.getTypeFileExport()).thenReturn(TypeFileExport.XMP);
        TypeFileExport expected = objeto.getTypeFileExport();
        assertEquals(expected, objectMetadata.getTypeFileExport());
    }

    @Test
    public void ItShouldMoreInfo() {
        Mockito.when(objectMetadata.getMoreInfo()).thenReturn(true);
        boolean expected = objeto.getMoreInfo();
        assertEquals(expected, objectMetadata.getMoreInfo());
    }
}
