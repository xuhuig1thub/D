package com.a.artifact;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-10-02 20:57
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

/**
 * NIO服务端
 */
@Slf4j
public class NIOServer {
    // 通道管理器
    private Selector selector;

    /**
     * 获得一个ServerSocket通道，并对该通道做一些初始化的工作
     *
     * @param port 绑定的端口号
     * @throws IOException
     */
    public void initServer(int port) throws IOException {
        // 获得一个ServerSocketChannel通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 设置通道为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 将该通道对应的ServerSocket绑定到port端口
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1",port));
        // 获得一个通道管理器
        this.selector = Selector.open();
        // 将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_ACCEPT事件,注册该事件后，
        // 当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    /**
     * 采用轮询的方式监听selector上是否有需要处理的事件，如果有，则进行处理
     *
     * @throws IOException
     */
    public void listen() throws IOException {
        System.out.println("服务端启动成功！");
        // 轮询访问selector
        while (true) {
            log.debug("-----Server1");
            // 当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            int keyNums=selector.select();
            // 获得selector中选中的项的迭代器，选中的项为注册的事件
            log.debug("-----Server2  "+this.selector.selectedKeys().size()+"--"+keyNums);
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = (SelectionKey) iterator.next();
                // 删除已选的key,以防重复处理
                iterator.remove();

                if (selectionKey.isAcceptable()) {// 客户端请求连接事件
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                    // 获得和客户端连接的通道
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    log.debug("---Ser"+socketChannel.toString()
                            +"\n"+((Object)socketChannel).toString());
                    // 设置成非阻塞
                    socketChannel.configureBlocking(false);
                    log.debug("------Server4");
                    // 在这里可以给客户端发送信息哦
                    socketChannel.write(ByteBuffer.wrap(new String("向客户端发送了一条信息")
                            .getBytes("utf-8")));
                    // 在和客户端连接成功之后，为了可以接收到客户端的信息，需要给通道设置读的权限。
                    socketChannel.register(this.selector, SelectionKey.OP_READ);

                } else if (selectionKey.isReadable()) {// 获得了可读的事件
                    log.debug("------Server3    "+selectionKey.channel().toString());
                    read(selectionKey);
                }

            }

        }
    }

    /**
     * 处理读取客户端发来的信息 的事件
     *
     * @param key
     * @throws IOException
     */
    public void read(SelectionKey key) throws IOException {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(512);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("Server收到信息：" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes("utf-8"));
        channel.write(outBuffer);// 将消息回送给客户端
    }
}