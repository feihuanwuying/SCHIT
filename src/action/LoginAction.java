package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;

/**
 * 登录
 * Created by ZouKaifa on 2016/10/13.
 */
public class LoginAction extends ActionSupport {
    private String username;  //用户名
    private String password;  //密码
    private String url;  //登录前地址
    private int errCode;  //0表示无动作，1表示错误，2成功

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    @Override
    public String execute() throws Exception {
        LoginService loginService = new LoginService();
        if (username == null && password == null) {
            setUrl(ServletActionContext.getRequest().getHeader("referer"));
            setErrCode(0);
        } else if (loginService.login(username, password)) {
            setErrCode(1);
            return SUCCESS;
        } else {
            setErrCode(2);
        }
        return LOGIN;
    }
}
