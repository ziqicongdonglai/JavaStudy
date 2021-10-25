package io.github.ziqicongdonglai.chat.ui.view.face;

/**
 * @author ke_zhang
 * @create 2021-10-25 21:25
 * @description 自定义表情隐藏事件
 */
public class FaceEventDefine {

    private  FaceInit faceInit;

    public FaceEventDefine(FaceInit faceInit) {
        this.faceInit = faceInit;
        hideFace();
    }

    private void hideFace() {
        faceInit.root().setOnMouseExited(event -> faceInit.hide());
    }
}
