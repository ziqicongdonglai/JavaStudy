package io.github.ziqicongdonglai.chat.codec;

import io.github.ziqicongdonglai.chat.protocol.Packet;
import io.github.ziqicongdonglai.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:25
 * @description 编码器
 */
public class ObjEncoder extends MessageToByteEncoder<Packet> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Packet in, ByteBuf out) {
        byte[] data = SerializationUtil.serialize(in);
        out.writeInt(data.length + 1);
        //添加指令
        out.writeByte(in.getCommand());
        out.writeBytes(data);
    }

}
