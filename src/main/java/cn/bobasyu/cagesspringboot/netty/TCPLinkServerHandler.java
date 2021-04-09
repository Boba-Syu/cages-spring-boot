package cn.bobasyu.cagesspringboot.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bobasyu
 */

public class TCPLinkServerHandler extends ChannelInboundHandlerAdapter {
    private static final List<Channel> channelList = new ArrayList<>();
    private static final Logger logger = LogManager.getLogger(TCPLinkServer.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf byteBuf = (ByteBuf) msg;
        logger.info("客户端" + ctx.channel().remoteAddress() + " : " + byteBuf.toString(StandardCharsets.UTF_8));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        Channel channel = ctx.channel();
        logger.info("客户端地址: " + channel.remoteAddress() + "已连接");
        channelList.add(channel);
        ctx.writeAndFlush(Unpooled.copiedBuffer("success linked.", StandardCharsets.UTF_8));
    }


    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        logger.info("客户端" + ctx.channel().remoteAddress() + "关闭");
        channelList.remove(ctx.channel());
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        logger.info("由于异常, 客户端" + ctx.channel().remoteAddress() + "关闭");
        channelList.remove(ctx.channel());
        ctx.close();
    }

    public static List<Channel> getChannelList() {
        return channelList;
    }
}
