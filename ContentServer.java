import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.*;
import java.net.SocketTimeoutException;

import javax.naming.NotContextException;
import org.xml.sax.SAXException;
// import javax.naming.NoSuchAttributeException;
import javax.naming.directory.NoSuchAttributeException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.*;

public class ContentServer implements Runnable, Serializable {

    private static int logic_clock = 0;
    private static final int Max_send_time = 5;
    private static final int waitingBeforeRetry = 2000;
    private static String ip = "";
    private static int    port;
    private static String newsSource = "";
    private static String feed = "";
    private static String file = "atom.xml";
    private static String recipe = null;
    private static XMLParsing fileParsing = new XMLParsing();


    @Override
    public synchronized void run() {


        /**************************************************************************************************
         * bdos.writeUTF(feed);
         *             bdos.flush();
         *             content.setSoTimeout(1000);
         *             recipe = bdis.readUTF();
         *             System.out.println("Cont_LOG ----> finish receiving recipe");
         ***************************************************************************************************/



    }

    public static void main(String[] args) {
        /**************************************************************************************************
         *  ContentServer cont = new ContentServer();
         *         cont.parsingArg(args);
         *         cont.buildXML();
         *************************************************************************************************/

    }

    public void PUTxml() {

        /*****************************************************************************
         *  bdos.writeUTF(feed);
         *         lamport();
         *         bdos.flush();
         *         content.setSoTimeout(1000);
         *
         *         System.out.println("Cont_LOG :: Try to connect the server...." + sending_time + " time(s)");
         *         recipe = bdis.readUTF();
         *         System.out.println("Cont_LOG ----> finish run");
         *
         ****************************************************************************/



    }

    public void buildXML() throws NotContextException, NoSuchAttributeException {
        /***********************************************************************************
         * fileParsing.createFeedXml(newsSource, file);
         *             feed += fileParsing.parseFile(file);
         *             feed = "ServerID:content" + (int) (3 * Math.random()) + "\n" +
         *                     "time:" + logic_clock + "\n" +
         *                     "PUT /atom.xml HTTP/1.1\n" +
         *                     "User-Agent: ATHMClient/1/0\n" +
         *                     "Content-Type: xml\n" +
         *                     "Content-Length:" +
         *                     feed.length() + "\n\n" + feed;
         ****************************************************************************/


    }

    private void parsingArg(String[] args) throws NumberFormatException {

        /**********************************************************************************************
         * String[] address = args[0].split(":");
         *             ip = address[0];
         *             port = Integer.parseInt(address[1]);
         *             newsSource = args[1];
         *
         *
         *             System.out.println("Cont_LOG ----> Error Message :: illegal");
         *             ip = "0.0.0.0";
         *             port = 8052;
         ****************************************************************************/

    }



}
