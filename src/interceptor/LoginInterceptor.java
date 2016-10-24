package interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import java.util.Map;

/**
 * Created by ZouKaifa on 2016/10/24.
 */
public class LoginInterceptor extends AbstractInterceptor {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (! session.containsKey("username")) {
            setUrl(ServletActionContext.getRequest().getHeader("referer"));
            return Action.LOGIN;
        }
        return actionInvocation.invoke();
    }
}
