package io.github.ziqicongdonglai.chat.interfaces;

import com.alibaba.fastjson.JSON;
import io.github.ziqicongdonglai.chat.application.InetService;
import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserInfo;
import io.github.ziqicongdonglai.chat.domain.inet.model.ChannelUserReq;
import io.github.ziqicongdonglai.chat.domain.inet.model.InetServerInfo;
import io.github.ziqicongdonglai.chat.infrastructure.common.EasyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ke_zhang
 * @create 2021-11-08 0:35
 * @description
 */
@Controller
public class InetController {

    private final Logger logger = LoggerFactory.getLogger(InetController.class);

    @Resource
    private InetService inetService;

    @RequestMapping("api/queryNettyServerInfo")
    @ResponseBody
    public EasyResult queryNettyServerInfo() {
        try {
            return EasyResult.buildEasyResultSuccess(new ArrayList<InetServerInfo>() {{
                add(inetService.queryNettyServerInfo());
            }});
        } catch (Exception e) {
            logger.info("查询NettyServer失败。", e);
            return EasyResult.buildEasyResultError(e);
        }
    }

    @RequestMapping("api/queryChannelUserList")
    @ResponseBody
    public EasyResult queryChannelUserList(String json, String page, String limit) {
        try {
            logger.info("查询通信管道用户信息列表开始。req：{}", json);
            ChannelUserReq req = JSON.parseObject(json, ChannelUserReq.class);
            if (null == req) {
                req = new ChannelUserReq();
            }
            req.setPage(page, limit);
            Long count = inetService.queryChannelUserCount(req);
            List<ChannelUserInfo> list = inetService.queryChannelUserList(req);
            logger.info("查询通信管道用户信息列表完成。list：{}", JSON.toJSONString(list));
            return EasyResult.buildEasyResultSuccess(count, list);
        } catch (Exception e) {
            logger.info("查询通信管道用户信息列表失败。req：{}", json, e);
            return EasyResult.buildEasyResultError(e);
        }
    }

}
