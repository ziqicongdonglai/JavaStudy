package io.github.ziqicongdonglai.chat.infrastructure.common;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:18
 * @description 分页
 */
@Data
public class PageReq {

    private int pageStart = 0;
    private int pageEnd = 0;

    private int page;
    private int rows;

    public PageReq() {
    }

    public PageReq(String page, String rows) {
        this.page = StringUtils.isEmpty(page) ? 1 : Integer.parseInt(page);
        this.rows = StringUtils.isEmpty(page) ? 10 : Integer.parseInt(rows);
        if (0 == this.page) {
            this.page = 1;
        }
        this.pageStart = (this.page - 1) * this.rows;
        this.pageEnd = this.rows;
    }

    public void setPage(String page, String rows) {
        this.page = StringUtils.isEmpty(page) ? 1 : Integer.parseInt(page);
        this.rows = StringUtils.isEmpty(page) ? 10 : Integer.parseInt(rows);
        if (0 == this.page) {
            this.page = 1;
        }
        this.pageStart = (this.page - 1) * this.rows;
        this.pageEnd = this.rows;
    }

}
