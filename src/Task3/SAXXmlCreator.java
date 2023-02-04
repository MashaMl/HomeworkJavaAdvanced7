package Task3;

import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

// SAX Parser предназначен только для чтения файлов, не для записи,
// поэтому выполнила задачу при помощи SAXTransformerFactory

public class SAXXmlCreator {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Artur\\IdeaProjects25.10.2022\\homeworkAdvanced7\\src\\Task3\\task3.xml");
        if(!file.exists())
            file.createNewFile();

        TransformerFactory tf = TransformerFactory.newInstance();
        SAXTransformerFactory stf = (SAXTransformerFactory)tf;
        TransformerHandler th = stf.newTransformerHandler();

        th.setResult(new StreamResult(file));
        th.startDocument();
        AttributesImpl attribute = new AttributesImpl();
        attribute.addAttribute("", "", "size", "", "big");

        th.startElement("", "", "Adress", null);

        th.startElement("", "", "City", attribute);
        th.characters(("Kyiv").toCharArray(), 0, ("Kyiv").length());
        th.endElement("", "", "City");

        th.startElement("", "", "Street", null);
        th.characters(("Great Street").toCharArray(), 0, ("Great Street").length());
        th.endElement("", "", "Street");

        th.startElement("", "", "House", null);
        th.characters(("3B").toCharArray(), 0, "3B".length());
        th.endElement("", "", "House");


        th.endElement("", "", "Adress");
        th.endDocument();

    }
}
