package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;
import service.UserService;

import java.util.Map;

/**
 * Created by ZouKaifa on 2016/11/10.
 */
public class HasLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (session.containsKey("username")) {
            return Action.ERROR;
        }
        return actionInvocation.invoke();
    }
}
