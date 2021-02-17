package com.codefriday.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TalkSend implements Runnable{
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private int fromPort;
    private String toIP;
    private int toPort;

    public TalkSend(int fromPort, String toIP, int toPort) {
        this.fromPort = fromPort;
        this.toIP = toIP;
        this.toPort = toPort;
        try{
            socket = new DatagramSocket(fromPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try{
            while(true){
                if(Window.flag==true){
                    String msg = Window.field4.getText();
                    Window.field4.setText("");
                    Window.flag = false;
                    Window.textArea.append("你说:"+":"+msg+'\n');
                    DatagramPacket packet = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length, InetAddress.getByName(toIP),toPort);
                    socket.send(packet);
                    if(msg.equals("bye")){
                        Window.IsConn = false;
                        break;
                    }
                }
            }
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}