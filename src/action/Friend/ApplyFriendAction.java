package action.Friend;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.FriendService;

/**
 * Created by ZouKaifa on 2016/12/6.
 */
public class ApplyFriendAction extends ActionSupport {
    private int friendId;
    private String message = "";  //附加信息
    private String remark = "";  //备注
    private String url;

    public int getFriendId() {
        return friendId;
    }

    public void setFriendId(int friendId) {
        this.friendId = friendId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
        url = ServletActionContext.getRequest().getHeader("referer");
        if (! friendService.applyFriend(friendId, message, remark)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
