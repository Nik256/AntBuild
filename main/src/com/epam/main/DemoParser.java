package com.epam.main;

import com.epam.parser.parser.ParserService;
import com.epam.parser.parser.XmlJsonParserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DemoParser {
    private static final Logger logger = LogManager.getLogger(DemoParser.class.getName());
    public static void main(String[] args) {
        logger.info("Parser running...");
        ParserService parserService = new XmlJsonParserService();
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = loader.getResourceAsStream("resources/config.properties")) {
            properties.load(inputStream);
            File xmlFile = new File(properties.getProperty("xml"));
            File xsdFile = new File(properties.getProperty("xsd"));
            logger.info(parserService.validate(xmlFile, xsdFile));
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
