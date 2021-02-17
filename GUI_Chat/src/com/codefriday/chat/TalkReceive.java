package com.codefriday.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable{
    private String msgFrom;
    private int toPort;
    DatagramSocket socket = null;
    byte[] buffer = null;

    public TalkReceive(int toPort,String msgFrom) {
        this.msgFrom = msgFrom;
        this.toPort = toPort;
        buffer = new byte[1024];
        try {
            socket = new DatagramSocket(toPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while(true){
                DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
                socket.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data,0,data.length);
                Window.textArea.append(msgFrom+":"+msg+'\n');
                if(msg.equals("bye")){
                    Window.IsConn = false;
                    break;
                }
            }
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}