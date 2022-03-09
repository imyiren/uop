package com.imyiren.uop.client.web.session;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONValidator;
import com.imyiren.uop.client.common.UserContext;
import com.imyiren.uop.client.common.UserInfo;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static com.imyiren.uop.client.common.Constants.USER_INFO;

/**
 * @author yiren
 */
public class UopSessionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            UserInfo userInfoObj = null;
            if (servletRequest instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) servletRequest;
                String userInfo = request.getHeader(USER_INFO);
                if (!StringUtils.isEmpty(userInfo)) {
                    userInfo = URLDecoder.decode(userInfo, StandardCharsets.UTF_8.toString());
                }
                if (!StringUtils.isEmpty(userInfo) && JSONValidator.from(userInfo).validate()) {
                    userInfoObj = JSON.parseObject(userInfo, UserInfo.class);
                }
            }
            UserContext.init(userInfoObj);
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.remove();
        }
    }
}
