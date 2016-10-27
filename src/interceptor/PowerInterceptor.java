package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import service.UserService;
import vo.User;

import java.util.Map;

/**
 * 对用户权限进行拦截
 * Created by ZouKaifa on 2016/10/27.
 */
public class PowerInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (!session.containsKey("username") || !session.containsKey("nickname")) {
            return Action.LOGIN;  //未登录
        }
        UserService userService = new UserService();
        User user = userService.getUser((String)session.get("username"));
        if (user == null || !user.getNickname().equals((String)session.get("nickname"))) {
            return Action.LOGIN;
        }
        if (user.getPower() != 1) {  //普通用户
            return Action.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
