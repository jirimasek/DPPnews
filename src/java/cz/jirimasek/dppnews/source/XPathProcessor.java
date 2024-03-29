package cz.jirimasek.dppnews.source;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class XPathProcessor
{

    public NodeList evaluate(Document document, String xpath)
            throws XPathExpressionException
    {
        XPathFactory factory = XPathFactory.newInstance();

        // 2. Use the XPathFactory to create a new XPath object
        XPath query = factory.newXPath();

        // 3. Compile an XPath string into an XPathExpression
        XPathExpression expression = query.compile(xpath);

        // 4. Evaluate the XPath expression on an input document
        NodeList nodes = (NodeList) expression.evaluate(document,
                XPathConstants.NODESET);

        return nodes;
    }

}
