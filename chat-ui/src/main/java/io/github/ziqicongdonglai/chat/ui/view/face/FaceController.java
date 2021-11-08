package io.github.ziqicongdonglai.chat.ui.view.face;

import io.github.ziqicongdonglai.chat.ui.view.UIObject;
import io.github.ziqicongdonglai.chat.ui.view.chat.ChatInit;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatEvent;
import io.github.ziqicongdonglai.chat.ui.view.chat.IChatMethod;

/**
 * @author ke_zhang
 * @create 2021-10-25 21:24
 * @description 设置表情框位置
 */
public class FaceController extends FaceInit implements IFaceMethod {

    private FaceView faceView;

    /**
     * 通过构造方法将控制器需要的值传入
     *
     * @param obj        抽象的父类窗体对象
     * @param chatInit   聊天框
     * @param chatEvent  聊天框事件
     * @param chatMethod 聊天框方法
     */
    public FaceController(UIObject obj, ChatInit chatInit, IChatEvent chatEvent, IChatMethod chatMethod) {
        super(obj);
        this.chatInit = chatInit;
        this.chatEvent = chatEvent;
        this.chatMethod = chatMethod;
    }


    @Override
    public void initView() {
        faceView = new FaceView(this);
    }

    @Override
    public void initEventDefine() {
        new FaceEventDefine(this);
    }

    @Override
    public void doShowFace(Double x, Double y) {
        // 设置位置 X
        setX(x + 230 * (1 - 0.618));
        // 设置位置 Y
        setY(y - 160);
        // 展示窗口
        show();
    }
}
