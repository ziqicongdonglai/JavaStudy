package io.github.ziqicongdonglai.chat.infrastructure.common;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:17
 * @description
 */
public class Constants {

    public enum ResponseCode {
        /**
         * 成功
         */
        SUCCESS("0000", "成功"),
        /**
         * 未知失败
         */
        UN_ERROR("0001", "未知失败"),
        /**
         * 非法参数
         */
        ILLEGAL_PARAMETER("0002", "非法参数"),
        /**
         * 主键冲突
         */
        INDEX_DUP("0003", "主键冲突");

        private final String code;
        private final String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }

    public enum TalkType {
        Friend(0, "好友"),
        Group(1, "群组");

        private Integer code;
        private String info;

        TalkType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }

    }

    public enum MsgType {

        Myself(0, "自己"),
        Friend(1, "好友");

        private Integer code;
        private String info;

        MsgType(Integer code, String info) {
            this.code = code;
            this.info = info;
        }

        public Integer getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

}
