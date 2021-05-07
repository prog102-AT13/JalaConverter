package org.fundacion.jala.converter.core.parameter;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class PythonEnumTest {

    @Test
    public void getVersion() {
        String path = "\"" + System.getProperty("user.dir") + "/thirdparty/python3/python.exe" + "\"";
        assertThat(PythonEnum.V3.getVersion(), is(path));
    }
}
