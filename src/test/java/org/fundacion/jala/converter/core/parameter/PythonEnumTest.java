package org.fundacion.jala.converter.core.parameter;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PythonEnumTest {

    @Test
    public void getVersion() {
        assertThat(PythonEnum.V3.getVersion(), is("\"" + System.getProperty("user.dir") + "/thirdparty/python3/python.exe" + "\""));
    }
}