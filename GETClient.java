//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class GETClient {


    public static void main(String[] args) {


            /*****************************************************************
                System.out.println("Client Log : connecting to the server");
                gettingTime++;
                getClient.sendGET();

                if (xml !=null){
                    break;
                }

             *****************************************************************/



        }
    }

    private void sendGET() throws IOException{

        /*****************************************************************

        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());

        String req = "serverId: GETClient\n";
        String logicTime = logicLock + "\n";
        String requestCommand = "GET /atom.xml HTTP/1.1\n";
        String message = req+logicTime+requestCommand;
        System.out.println("Client log : time - "+logicTime+" message : "+message);
        dos.writeUTF(message);
        lamport();
         *****************************************************************/

        /*****************************************************************
        client.setSoTimeout(5000);
        String recipe = dis.readUTF();
        String[] time_xml = recipe.split("\n",2);
        lamport(time_xml[0]);
        xml = time_xml[1];
        System.out.println("Client log : receive time - "+logicLock);
        System.out.println("Client log : content xml - "+ xml);
        fileParsing.printXmlToString(xml);
         *****************************************************************/

    }




}
