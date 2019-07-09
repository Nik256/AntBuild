package com.epam.parser.parser;

import com.epam.parser.service.ValidatorXML;

import java.io.File;

public class XmlJsonParserService implements ParserService {

    @Override
    public boolean validate(File xml, File xsd) {
        return ValidatorXML.validate(xml, xsd);
    }
}
