/**
 * Copyright (c) 2021 Fundacion Jala.
 *
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */
package org.fundacion.jala.converter;

import org.fundacion.jala.converter.service.ExtractMetadata;
import org.fundacion.jala.converter.service.ObjectMetadata;
import org.fundacion.jala.converter.service.metadata.TypeFileExport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.io.File;

@SpringBootApplication
public class ConverterApplication {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
//        logger.info("start");
//        SpringApplication.run(ConverterApplication.class, args);
//        logger.info("finish");
        System.out.println("asdas");

//        File file=new File("images/img7.jpg");
//        ObjectMetadata objectMetadata=new ObjectMetadata();
//        objectMetadata.setFile(file);
//        objectMetadata.setMoreInfo(true);
//        objectMetadata.setNameExport("ImangenTest");
//        objectMetadata.setTypeFileExport(TypeFileExport.TXT);
//        ExtractMetadata extractMetadata = new ExtractMetadata(objectMetadata);
//        extractMetadata.extractMetadata();

        File file=new File("images/img7.jpg");
        ExtractMetadata extractMetadata = new ExtractMetadata(file);
        extractMetadata.extractMetadata();
    }

}
