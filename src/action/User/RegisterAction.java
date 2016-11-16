package action.User;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import service.UserService;
import vo.User;

/**
 * 注册
 * Created by ZouKaifa on 2016/10/13.
 */
public class RegisterAction extends ActionSupport implements ModelDriven<User>{
    private User user = new User();  //用户
    private String url;
    private int errCode;  //4表示无动作，3表示错误，2成功
    
    @Override
    public User getModel() {
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        UserService userService = new UserService();
        if (user.getUsername() == "") {  //未提交
            if (getUrl() == null) {
                setUrl(ServletActionContext.getRequest().getHeader("referer"));
            }
            setErrCode(4);
        } else if (userService.register(getUser())) {
            setErrCode(2);
            return SUCCESS;
        } else {
            setErrCode(3);
        }
        return INPUT;
    }
}
