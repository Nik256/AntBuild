package com.epam.parser.parser;

import java.io.File;

public interface ParserService {
    
    boolean validate(File xml, File xsd);
}
