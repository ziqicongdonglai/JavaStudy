package io.github.ziqicongdonglai.chat.codec;

import io.github.ziqicongdonglai.chat.protocol.Packet;
import io.github.ziqicongdonglai.chat.util.SerializationUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-06 23:24
 * @description 解码器
 */
public class ObjDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
            return;
        }
        //读取指令
        byte command = in.readByte();
        //指令占了一位，剔除掉
        byte[] data = new byte[dataLength - 1];
        in.readBytes(data);
        out.add(SerializationUtil.deserialize(data, Packet.get(command)));
    }
}
