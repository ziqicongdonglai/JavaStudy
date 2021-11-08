/**
 * @author ke_zhang
 * @create 2021-11-08 17:16
 * @description
 */
module io.github.ziqicongdonglai.chat.client {
    requires io.github.ziqicongdonglai.chatui;
    requires javafx.controls;
    requires javafx.fxml;
    requires org.slf4j;
    requires lombok;
    requires chat.server.agreement;
    requires io.netty.all;
    requires fastjson;

    opens io.github.ziqicongdonglai.chat.client to javafx.fxml;
    exports io.github.ziqicongdonglai.chat.client;
}