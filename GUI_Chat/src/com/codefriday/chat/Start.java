package com.codefriday.chat;

import javax.swing.*;

public class Start {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UDP多线程聊天程序");
        //frame.add(new JPanel());
        frame.setLayout(null);
        Window.addComponents(frame);
        frame.setBounds(10,10,520,400);//窗口大小
        frame.setResizable(false);//不可拉伸
        frame.setVisible(true);//设置可见性
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//默认关闭事件
    }
}
