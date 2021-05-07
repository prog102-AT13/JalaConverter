package org.fundacion.jala.converter.core.parameter;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PythonParameterTest {

    @Test
    public void getPythonEnum() {
        PythonParameter pythonParameter = new PythonParameter("filepath", PythonEnum.V2);
        PythonEnum pythonEnum = PythonEnum.V2;
        assertTrue(pythonEnum.getVersion().equals(pythonParameter.getPythonEnum().getVersion()));
    }
}