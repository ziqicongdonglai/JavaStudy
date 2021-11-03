package io.github.ziqicongdonglai.netty.demo;

import io.github.ziqicongdonglai.netty.demo.client.NettyClient;
import io.github.ziqicongdonglai.netty.demo.domain.FileTransferProtocol;
import io.github.ziqicongdonglai.netty.demo.util.MsgUtil;
import io.netty.channel.ChannelFuture;

import java.io.File;

/**
 * @author ke_zhang
 * @create 2021-11-03 21:17
 * @description
 */
public class NettyClientTest {

    public static void main(String[] args) {
        //启动客户端
        ChannelFuture channelFuture = new NettyClient().connect("127.0.0.1", 7397);

        //文件信息{文件大于1024kb方便测试断点续传}
        File file = new File("/MySelf/电脑壁纸/f8d52c1fd21b0ef41667a91ecac451da80cb3efe.png");
        FileTransferProtocol fileTransferProtocol = MsgUtil.buildRequestTransferFile(file.getAbsolutePath(), file.getName(), file.length());
        //发送信息；请求传输文件
        channelFuture.channel().writeAndFlush(fileTransferProtocol);
    }

}
