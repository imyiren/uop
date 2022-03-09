package com.imyiren.uop.client.common;

import com.imyiren.result.BizStateCodes;
import com.imyiren.result.error.BizRuntimeException;

import java.util.Objects;

/**
 * @author yiren
 */
public final class UserContext {
    private static ThreadLocal<UserInfo> userInfoThreadLocal = new ThreadLocal<>();

    /**
     * 登录初始化
     * @param userInfo 用户信息
     */
    public static void init(UserInfo userInfo) {
        if (Objects.isNull(userInfo)) {
            return;
        }
        userInfoThreadLocal.set(userInfo);
    }

    public static void remove() {
        if (Objects.nonNull(userInfoThreadLocal.get())) {
            userInfoThreadLocal.remove();
        }
    }

    public static UserInfo get() {
        UserInfo userInfo = userInfoThreadLocal.get();
        if (Objects.isNull(userInfo)) {
            throw new BizRuntimeException(BizStateCodes.UNAUTHORIZED_ERROR, "用户未登录，请登录后重试！");
        }
        return userInfo;
    }

    public static String getUserCode() {
        return get().getUserCode();
    }

    public static Long getUserId() {
        return get().getUserId();
    }

    public static Long getOrgId() {
        return get().getCurrentOrgId();
    }

    public static boolean containRole(String roleCode) {
        return get().getRoleCodeList().contains(roleCode);
    }

}
