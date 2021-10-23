package io.github.ziqicongdonglai.chat.ui.util;

/**
 * @author ke_zhang
 * @create 2021-10-23 23:53
 * @description 组件ID统一定义维护
 */
public class Ids {

    /**
     * 对话框元素，好友对话列表框元素
     */
    public static class ElementTalkId {
        public static String createTalkPaneId(String id) {
            return "ElementTalkId_createTalkPaneId_" + id;
        }

        public static String analysisTalkPaneId(String id) {
            return id.split("_")[2];
        }

        public static String createInfoBoxListId(String id) {
            return "ElementTalkId_createInfoBoxListId_" + id;
        }

        public static String analysisInfoBoxListId(String id) {
            return id.split("_")[2];
        }

        public static String createMsgDataId(String id) {
            return "ElementTalkId_createMsgDataId_" + id;
        }

        public static String analysisMsgDataId(String id) {
            return id.split("_")[2];
        }

        public static String createMsgSketchId(String id) {
            return "ElementTalkId_createMsgSketchId_" + id;
        }

        public static String analysisMsgSketchId(String id) {
            return id.split("_")[2];
        }

        public static String createFriendGroupId(String id) {
            return "ElementTalkId_createFriendGroupId_" + id;
        }

    }

}

