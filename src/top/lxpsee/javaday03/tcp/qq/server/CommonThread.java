package top.lxpsee.javaday03.tcp.qq.server;

import top.lxpsee.javaday03.tcp.qq.common.MessageFactory;

import java.net.Socket;

/**
 * 努力常态化  2018/7/9 10:13 The world always makes way for the dreamer
 * <p>
 * 通信线程
 */
public class CommonThread extends Thread {
    private Socket socket;

    public CommonThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {
            while (true) {
//                InputStream inputStream = socket.getInputStream();
                /* 解析client发来的消息,转换成服务器消息 */
                byte[] bytes = MessageFactory.parseClientMessageAndSend(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
