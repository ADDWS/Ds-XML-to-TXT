
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

// import javax.print.DocFlavor.STRING;
// import javax.swing.text.AbstractDocument.Content;

public class AggregationServer implements Runnable {

    private static final int maxContentAmount = 20;
    private static final String temp = "feed.txt";
    private static String serverName = "";
    private static LinkedList<Content> content;
    private static volatile int logicClock = 50;
    private static final LinkedList<String> serverList = new LinkedList<>();
    private static Socket clientSocket;
    private static String addr = "";
    private static int port;
    private static final String xmlSplit = "Feed End \n";

    private static XMLParsing fileParsing = new XMLParsing();

    public AggregationServer() {
        addr = "LocalHost";
        port = 8052;
    }

    public AggregationServer(String addr, int port) {
        AggregationServer.addr = addr;
        AggregationServer.port = port;

        try {


            /**************************************************************************************************
             * new Thread() {
             *                 @Override
             *                 public synchronized void run() {
             *                     try {
             *                         recoverDataStructure();
             *                     } catch (IOException e) {
             *                         e.printStackTrace();
             *                     }
             *                 }
             *             }.start();
             ***************************************************************************************************/


            /**************************************************************************************************
             *     Thread working = new Thread(this);
             *         working.start();
             ********************************************************************/



    public static void main(String[] args) {


        addr = "LocalHost";
        port = 8052;
        AggregationServer atom = new AggregationServer();


                /**************************************************************************************************
                 * public synchronized void run() {
                 *                     try {
                 *                         atom.recoverDataStructure();
                 *                     } catch (IOException e) {
                 *                         e.printStackTrace();
                 *                     }
                 ***************************************************************************************************/


                /**************************************************************************************************
                 * atom.clearDataStructure();
                 *
                 *
                 *     Thread working = new Thread(atom);
                 *         working.start();
                 ***************************************************************************************************/

      \


    }

    @Override
    public synchronized void run() {


                /**************************************************************************************************
                 * String allHeader = allInformation[0];
                 *                 TempContent = "<" + allInformation[1];
                 *                 String[] leadingInfor = allHeader.split("\n", 3);
                 *                 serverName = leadingInfor[0].split(":")[1];
                 *                 String receivingTime = leadingInfor[1].split(":")[1];
                 *                 String header = leadingInfor[2];
                 *                 PutOrGet = header.substring(0, 3);
                 ***************************************************************************************************/



                /**************************************************************************************************
                 *  if (TempContent.substring(TempContent.length() - 7).equalsIgnoreCase("</feed>")) {
                 *                         output.writeUTF("500 - Internal server error." + logicClock);
                 *                         return;
                 *                     }
                 *
                 *                     addFeedToDataStructure(TempContent, serverName);
                 *                     lamport(receivingTime);
                 *                     deal_request(output);
                 ***************************************************************************************************/




                /**************************************************************************************************
                 *  String[] idTimeCommand = TempContent.split("\n");
                 *                 String serverId = idTimeCommand[0];
                 *                 String receivingTime = idTimeCommand[1];
                 *                 PutOrGet = idTimeCommand[2].substring(0, 3);
                 *                 System.out.println(PutOrGet);
                 *
                 *                 if (PutOrGet.equalsIgnoreCase("get")) {
                 *                     lamport(receivingTime);
                 *                     System.out.println("ATOM_LOG -----> going into get");
                 *                     String xml = logicClock + "\n";
                 *                     for (Content feed : content) {
                 *                         xml += feed.getXml();
                 *                     }
                 *                     xml += "</feeds>";
                 *                     output.writeUTF(xml);
                 *                 } else {
                 ***************************************************************************************************/




    private void addFeedToDataStructure(String xml, String serverId) {



                    /**************************************************************************************************
                     *   content.add(new Content(xml, serverId, id));
                     *         if (content.size() > maxContentAmount)
                     *             content.removeFirst();
                     *
                     *         updateDataStructure(xml, serverId);
                     *         System.out.println(content.get(0).getXml());
                     ***************************************************************************************************/



    }





    private void updateDataStructure(String xml, String id) {
        /**************************************************************************************************
         *    for (int i = 0; i < content.size(); i++) {
         *             Content tmp = content.get(i);
         *
         *             if (tmp.getServerId().equalsIgnoreCase(id)) {
         *                 tmp.setTimer(0);
         *                 tmp.setXml(xml);
         *             }
         *         }
         ***************************************************************************************************/


    }

    private void clearDataStructure() throws InterruptedException, IOException {

        /**************************************************
                }
        while (true) {

            System.out.println("keep checking the feeds and clearing DataStructure, server is standby");
            Thread.sleep(1000);

            for (int i = 0; i < content.size(); i++) {
                Content tmp = content.get(i);
                tmp.setTimer(tmp.getTimer() + 1);

                System.out.println("Feeds data will be erased after "+ (12-tmp.getTimer()) +" second");
                if (tmp.getTimer() == 12) {
                    content.remove(i);
                    System.out.println("**************** Aggregation has removed the feed at " + logicClock + " in the linkedlist ****************");

                }
            }

         **********************************************************************************/
        }
    }

    private void respondNoThisRequest(DataOutputStream output) throws IOException {
        output.writeUTF("400 - ILLEGAL REQUEST:" + logicClock);
        lamport();
    }

    private void deal_request(DataOutputStream output) throws IOException {
        boolean known = false;


        /*******************************************************************************

        System.out.println("ATOM_LOG -----> server_list =  " + serverList.size());
        for (String s : serverList) {
            System.out.println("ATOM_LOG -----> server_name =  " + s);
            if (s.equalsIgnoreCase(serverName))
                known = true;
        }

        if (known)
            output.writeUTF("200 - HTTP_RECEIVED:" + logicClock);
        else {
            output.writeUTF("201 - HTTP_CREATED:" + logicClock);
            serverList.add(serverName);
        }

         *******************************************************************************/

    }

    private void recoverDataStructure() throws IOException {

        /*******************************************************************************
        if (!backup.exists()) {
            System.out.println("ATOM_LOG -----> There is not back-up file.");
        } else {
            if (backup.isFile() && backup.canRead()) {
                new XMLParsing();
                String backUpContent = fileParsing.parseFile(temp);
                if (backUpContent == null || backUpContent.equalsIgnoreCase("")) {
                    System.out.println("ATOM_LOG -----> this file is invalid.");
                    return;
                }
                String[] contentArr = backUpContent.split(xmlSplit);
                refillDataStructure(contentArr);
            } else
                System.out.println("ATOM_LOG -----> this file is invalid.");
        }

         *******************************************************************************/
    }

    private void refillDataStructure(String[] contentArr) {

            }
        /*******************************************************************************
            String[] oneDatail = x.split("\n", 3);
            String id = oneDatail[0].split(":")[1];
            int timer = Integer.parseInt(oneDatail[1].split(":")[1]);
            String xml = oneDatail[2];
            String feedId = xml.split("<id>")[1];
            feedId = feedId.split("</id>")[0];

            content.add(new Content(xml, timer, id, feedId));
            serverList.add(id);
        }
         *******************************************************************************/
    }

}
