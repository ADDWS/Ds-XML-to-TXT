import javax.naming.NotContextException;
import javax.naming.directory.NoSuchAttributeException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class XMLParsing {

    public XMLParsing() {

    }

    public String parseFile(String file_path) throws IOException {

        String line;
        String all_lines = "";
        File file = new File(file_path);
        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            if (!file.getName().contains(".xml")) {
                if (isValid(line)) {
                    line += "\n";
                    all_lines += line;
                } else {
                    System.out.println("invalid");
                    return null;
                }
            } else {
                all_lines += line+"\n";
            }
        }

        return all_lines;
    }

    public boolean isValid(String line) {
        String[] pair = line.split(":", 2);
        if (pair[0].trim().equalsIgnoreCase("title")) {
            return pair.length == 2;
        } else if (pair[0].trim().equalsIgnoreCase("link")) {
            return pair.length == 2;
        } else if (pair[0].trim().equalsIgnoreCase("id")) {
            return pair.length == 2;
        } else {
            return true;
        }
    }

    public void createFeedXml(String file_path, String xmlFile)
            throws IOException, TransformerConfigurationException, SAXException, NoSuchAttributeException,
            NotContextException {

        String rawInfor = parseFile(file_path);
        System.out.println(rawInfor);

        if (rawInfor == null)
            throw new NoSuchAttributeException();

        SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        TransformerHandler handler = tff.newTransformerHandler();
        Transformer tr = handler.getTransformer();

        tr.setOutputProperty(OutputKeys.ENCODING, "ios-8859-1");
        tr.setOutputProperty(OutputKeys.INDENT, "yes");

        File f = new File(xmlFile);
        if (!f.exists()) {
            f.createNewFile();
        }

        Result result = new StreamResult(new FileOutputStream(f));
        handler.setResult(result);
        handler.startDocument();
        AttributesImpl attr = new AttributesImpl();
        handler.startElement("", "", "feed", attr);

        String[] lines = rawInfor.split("\n");
        int entry_num = 0;

        for (String line : lines) {
            attr.clear();
            char titlePos = ':';

            if (line.equalsIgnoreCase("entry")) {
                if (entry_num > 0)
                    handler.endElement("", "", "entry");

                handler.startElement("", "", "entry", attr);
                entry_num++;
            }

            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == titlePos) {
                    String title = line.substring(0, j);
                    String value = line.substring(j + 1);

                    if (title.equalsIgnoreCase("title") && value.equalsIgnoreCase(" "))
                        throw new NotContextException();
                    if (title.equalsIgnoreCase("id") && value.equalsIgnoreCase(" "))
                        throw new NotContextException();
                    if (title.equalsIgnoreCase("link") && value.equalsIgnoreCase(" "))
                        throw new NotContextException();

                    handler.startElement("", "", title, attr);
                    handler.characters(value.toCharArray(), 0, value.length());
                    handler.endElement("", "", title);
                    break;
                }
            }
        }

        if (entry_num > 0)
            handler.endElement("", "", "entry");

        handler.endElement("", "", "feed");
        handler.endDocument();

    }

    public void parsingXML(String xml) {
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {
            SAXParser saxP = spf.newSAXParser();
            InputStream is = getStringStream(xml);
            System.out.println(is);

            if (is == null)
                System.out.println("No Content");
            else {
                System.out.println("parsing in SAXHandler");
                saxP.parse(is, new SAXHandler());
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

    }

    public InputStream getStringStream(String xml) {
        if (xml != null && !xml.trim().equals("")) {
            try {
                return new ByteArrayInputStream(xml.getBytes());
            } catch (Exception ex) {
                System.out.println("something wrong happened.");
            }
        }
        return null;
    }

    public static void printXmlToString(String xml){
        String[] lines = xml.split("\n");
        for (String line : lines) {
            String[] unit = line.split("<|>");
            StringBuilder sb = new StringBuilder();
            if(unit.length>=3){
                sb.append(unit[0]).append(unit[2]);
//                sb.append(unit[0]).append("").append(unit[2]);
                System.out.println(sb.toString());
            }
        }
    }

}
