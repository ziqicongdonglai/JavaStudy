package io.github.ziqicongdonglai.netty.demo.domain;

/**
 * @author ke_zhang
 * @create 2021-11-03 20:45
 * @description 文件分片指令
 */
public class FileBurstInstruct {
    /**
     * Constants.FileStatus 0开始、1中间、2结尾、3完成
     */
    private Integer status;
    /**
     * 客户端文件URL
     */
    private String clientFileUrl;
    /**
     * 读取位置
     */
    private Integer readPosition;

    public FileBurstInstruct() {
    }

    public FileBurstInstruct(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getClientFileUrl() {
        return clientFileUrl;
    }

    public void setClientFileUrl(String clientFileUrl) {
        this.clientFileUrl = clientFileUrl;
    }

    public Integer getReadPosition() {
        return readPosition;
    }

    public void setReadPosition(Integer readPosition) {
        this.readPosition = readPosition;
    }
}