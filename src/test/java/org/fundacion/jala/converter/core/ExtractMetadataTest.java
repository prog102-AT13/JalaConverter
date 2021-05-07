package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.MetadataException;
import org.fundacion.jala.converter.core.metadata.TypeFileExport;
import org.junit.Test;
import java.io.File;

public class ExtractMetadataTest {

    ExtractMetadata extractMetadata;
    ObjectMetadata objeto;

    @Test
    public void ItShouldExtractMetadata() throws MetadataException {
        objeto = new ObjectMetadata();
        objeto.setFileToExport(new File("ruta"));
        objeto.setFileToExtract(new File("ruta"));
        objeto.setNameExport("nameExport");
        objeto.setTypeFileExport(TypeFileExport.TXT);
        objeto.setMoreInfo(true);
        extractMetadata = new ExtractMetadata(objeto);
    }

    @Test(expected = MetadataException.class)
    public void ItShouldExtractMetadataException() throws MetadataException {
        extractMetadata = new ExtractMetadata(null,null);
    }

    @Test
    public void ItShouldExtractMetadataWithFiles() throws MetadataException {
        File file = new File("archive//archive.txt");
        extractMetadata = new ExtractMetadata(file,file);
    }
}
