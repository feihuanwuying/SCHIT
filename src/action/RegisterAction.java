package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import service.LoginService;
import vo.User;

/**
 * 注册
 * Created by ZouKaifa on 2016/10/13.
 */
public class RegisterAction extends ActionSupport implements ModelDriven<User>{
    private User user;  //用户
    
    @Override
    public User getModel() {
        return user == null ? new User() : user; 
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String execute() throws Exception {
        LoginService loginService = new LoginService();
        //// TODO: 2016/10/13  
        if (loginService.register(getUser())) {
            return SUCCESS;
        }
        return INPUT;
    }
}
