package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import service.InformService;
import service.UserService;
import vo.Inform;

import java.util.Map;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class LoginInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (!session.containsKey("username")
                || !new UserService().exist((String)session.get("username"))) {
            return Action.LOGIN;
        }
        String result = actionInvocation.invoke();
        if (session.containsKey("username")) {
            UserService.updateInform();
        }
        return result;
    }
}
