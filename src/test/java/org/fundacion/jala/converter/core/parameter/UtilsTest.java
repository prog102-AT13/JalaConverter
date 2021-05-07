package org.fundacion.jala.converter.core.parameter;

import org.fundacion.jala.converter.core.RunCommand;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    @Before
    public void itShouldCreateFile() {
        RunCommand runCommand = new RunCommand();
        runCommand.run("cd archive && dir > emptyFile.txt");
    }

    @After
    public void itShouldDeleteFile() {
        RunCommand runCommand = new RunCommand();
        runCommand.run("cd archive && del emptyFile2.txt");
    }

    @Test
    public void itShouldCleanFileNameParameter() {
        assertEquals("cleanFileName.txt", Utils.cleanFileNameParameter("cleanFileName.txt"));
    }

    @Test
    public void itShouldCleanFileNameParameterWithSpace() {
        assertEquals("cleanFileName.txt", Utils.cleanFileNameParameter("cleanFile Name.txt"));
    }

    @Test
    public void itShouldChangeNameFile() {
        Utils.changeNameFile("emptyFile.txt", "emptyFile2.txt");
    }
}
