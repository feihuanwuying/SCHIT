package action;

import com.opensymphony.xwork2.ActionSupport;
import service.LoginService;

/**
 * 登录
 * Created by ZouKaifa on 2016/10/13.
 */
public class LoginAction extends ActionSupport {
    private String username;  //用户名
    private String password;  //密码

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

    @Override
    public String execute() throws Exception {
        LoginService loginService = new LoginService();
        if (loginService.login(username, password)) {
            return SUCCESS;
        }
        return LOGIN;
    }
}
