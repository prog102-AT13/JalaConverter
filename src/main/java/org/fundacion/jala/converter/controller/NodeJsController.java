package org.fundacion.jala.converter.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacion.jala.converter.core.facade.CompilerFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NodeJsController {
    private static final Logger LOGGER = LogManager.getLogger();
    @PostMapping("/compileNode")
    @ApiOperation(value = "Compiles node code", notes = "Provide the node code to compile",
            authorizations = {@Authorization(value = "JWT")})
    public String compileNode(final @RequestParam("code") String code) throws IllegalStateException {
        return CompilerFacade.facadeNodejsCompile(code);
    }
}
