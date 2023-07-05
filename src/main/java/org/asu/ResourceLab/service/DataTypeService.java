package org.asu.ResourceLab.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import org.springframework.stereotype.Service;


@Service
public class DataTypeService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String getDataType(String data) {
        // Try parsing as JSON
        try {
            new ObjectMapper().readTree(data);
            return "json";
        } catch (IOException e) {
            // Not JSON
        }

        // Try parsing as XML
        try {
            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(data)));
            return "xml";
        } catch (Exception e) {
            // Not XML
        }

        // If not JSON or XML, it's plain text
        return "plaintext";
    }

    private boolean isJson(String data) {
        try {
            objectMapper.readTree(data);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private boolean isXML(String data) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(data)));
            return true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            return false;
        }
    }
}
