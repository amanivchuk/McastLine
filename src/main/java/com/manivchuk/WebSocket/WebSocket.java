package com.manivchuk.WebSocket;

import com.manivchuk.beans.StatusConnect;
import com.manivchuk.statusLine.LineQueueStatus;
import org.json.JSONObject;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by Lenovo on 11.03.2017.
 */
@ServerEndpoint(value = "/websocket")
public class WebSocket {
    @OnOpen
    public void eventOpen(Session session) {
        System.out.println("Connection created!");
    }

    @OnClose
    public void eventClose(){
        System.out.println("Connection close!");
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException, InterruptedException, EncodeException {
        while(true) {
            if (LineQueueStatus.size() == 0) {
                Thread.sleep(2000);
            } else {
                StatusConnect status = LineQueueStatus.getLine();
                //session.getBasicRemote().sendText(status.getHostname() + " : " + status.isStatus());

                //Json---------------!!!
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("hostname", status.getHostname());
                jsonObject.put("status" , status.isStatus());
                System.out.println("===========================>>>>>>>>>>>>>>>>>>> " + jsonObject.toString());
                session.getBasicRemote().sendText(jsonObject.toString());

                Thread.sleep(1000);
            }
        }
    }

        @OnError
    public void eventError(Throwable t){
        System.err.println("Error WebSocket");
    }
}
