/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 *
 * @author Jorge Rodrigo Caceres Velasco
 */
package org.fundacion.jala.converter.core;

import org.fundacion.jala.converter.core.exceptions.CompilerException;
import org.junit.Test;

/**
 * This class executes test for nodeJs.
 */
public class NodeJsCompilerTest {

    @Test(expected = NullPointerException.class)
    public void nodeJsTest() throws CompilerException {
        NodeJsCompiler nodeJsCompiler = new NodeJsCompiler();
        nodeJsCompiler.nodeCompiler(null);
    }

}
