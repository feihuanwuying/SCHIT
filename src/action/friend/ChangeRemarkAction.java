package action.friend;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.FriendService;

/**
 * Created by ZouKaifa on 2016/11/5.
 */
public class ChangeRemarkAction extends ActionSupport {
    private String remark = "";
    private int friendId;
    private String url;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        FriendService friendService = new FriendService();
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        int userId = (int) ActionContext.getContext().getSession().get("id");
        if (! friendService.updateRemark(userId, friendId, remark)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
