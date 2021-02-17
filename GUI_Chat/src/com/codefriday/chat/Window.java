package com.codefriday.chat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window {
    private static TextField field = null;//对方IP
    private static TextField field1 = null;//对方端口
    private static TextField field2 = null;//自己端口，跑这个程序的端口
    private static TextField field3 = null;//自己名字
    public static JTextField field4 = null;//发送的消息内容
    private static TextField field5 = null;//接收消息的端口
    private static JButton btn1 = null;//连接按钮
    private static JButton btn2 = null;//发送按钮
    public static JTextArea textArea = null;//消息文本域
    static boolean flag = false;//全局状态，表示是否点了发送信息，处理完之后标志位翻转
    static boolean IsConn = false;//全局状态，是否连接中
    public static void addComponents(JFrame frame){
        //ip地址
        Label ToIP = new Label("To IP：");
        ToIP.setBounds(10,10,65,25);
        ToIP.setBackground(Color.cyan);
        field = new TextField("127.0.0.1",20);
        field.setBounds(80,10,80,25);
        frame.add(ToIP);
        frame.add(field);

        //对方端口
        Label ToPort = new Label("To Port：");
        ToPort.setBounds(170,10,65,25);
        ToPort.setBackground(Color.cyan);
        field1 = new TextField("9999",20);
        field1.setBounds(245,10,80,25);
        frame.add(ToPort);
        frame.add(field1);

        //自己端口
        Label FromPort = new Label("From Port：");
        FromPort.setBounds(335,10,65,25);
        FromPort.setBackground(Color.cyan);
        field2 = new TextField("6666");
        field2.setBounds(410,10,80,25);
        frame.add(FromPort);
        frame.add(field2);

        //连接名字
        Label YourName = new Label("YourName：");
        YourName.setBounds(10,45,65,25);
        YourName.setBackground(Color.cyan);
        field3 = new TextField("Bob",20);
        field3.setBounds(80,45,80,25);
        frame.add(YourName);
        frame.add(field3);

        //自己的接收端口
        Label YourPort = new Label("YourPort：");
        YourPort.setBounds(170,45,65,25);
        YourPort.setBackground(Color.cyan);
        field5 = new TextField("5555",20);
        field5.setBounds(245,45,80,25);
        frame.add(YourPort);
        frame.add(field5);


        //连接按钮
        btn1 = new JButton("连接");
        btn1.setBounds(400,45,100,25);
        frame.add(btn1);

        //消息记录
        Label Message = new Label("Message:");
        Message.setBounds(10,80,65,25);
        Message.setBackground(Color.cyan);
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        JScrollPane jp = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea.setBounds(85,80,410,200);
        jp.setBounds(85,80,410,200);
        frame.add(Message);
        frame.add(jp);

        //消息内容
        field4 = new JTextField();
        field4.setBounds(85,290,300,25);
        frame.add(field4);
        //消息发送按钮
        btn2 = new JButton("发送消息");
        btn2.setBounds(400,290,100,25);
        frame.add(btn2);

        Label author = new Label("by:codefriday  QQ:853851430");
        author.setFont(new Font("楷体",Font.BOLD,16));
        author.setBounds(10,325,400,25);
        frame.add(author);

        btn1.addActionListener(new ActionListener() {//相应连接/断开连接按钮
            public void actionPerformed(ActionEvent e) {
                if(IsConn == false){
                    String ToIP = field.getText();
                    int ToPort = Integer.parseInt(field1.getText());
                    int FromPort = Integer.parseInt(field2.getText());
                    String name = field3.getText();
                    int YourPort = Integer.parseInt(field5.getText());
                    new Thread(new TalkSend(FromPort,ToIP,ToPort)).start();
                    new Thread(new TalkReceive(YourPort,name)).start();

                    IsConn = true;
                    field.setEditable(false);
                    field1.setEditable(false);
                    field2.setEditable(false);
                    field3.setEditable(false);
                    field5.setEditable(false);
                    btn1.setText("断开连接");
                }else{
                    textArea.setText("");
                    IsConn = false;
                    field.setEditable(true);
                    field1.setEditable(true);
                    field2.setEditable(true);
                    field3.setEditable(true);
                    field5.setEditable(true);
                    btn1.setText("连接");
                }

            }
        });
        btn2.addActionListener(new ActionListener() {//发送消息
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
            }
        });
    }
}
