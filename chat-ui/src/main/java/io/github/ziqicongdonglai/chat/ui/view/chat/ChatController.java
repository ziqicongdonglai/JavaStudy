package io.github.ziqicongdonglai.chat.ui.view.chat;

/**
 * @author ke_zhang
 * @create 2021-10-23 1:25
 * @description 窗体控制器
 */
public class ChatController extends ChatInit implements IChatMethod{

    private ChatEventDefine chatEventDefine;

    @Override
    public void initView() {

    }

    @Override
    public void initEventDefine() {
        chatEventDefine = new ChatEventDefine(this);
    }

    @Override
    public void doShow() {
        super.show();
    }

}
