package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import service.UserService;
import vo.User;

/**
 * Created by ZouKaifa on 2016/11/12.
 */
public class ShowHomeAction extends ActionSupport{
    private User user = new User();
    private int id = -1;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String execute() throws Exception {
        UserService userService = new UserService();
        user = userService.getUser(id);
        if (user == null) {
            return ERROR;
        }
        return SUCCESS;
    }
}
