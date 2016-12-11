package action.friend;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import service.FriendService;

/**
 * Created by ZouKaifa on 2016/12/10.
 */
public class AgreeFriendAction extends ActionSupport {
    private String url;
    private String remark;
    private int informId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getInformId() {
        return informId;
    }

    public void setInformId(int informId) {
        this.informId = informId;
    }

    @Override
    public String execute() throws Exception {
        setUrl(ServletActionContext.getRequest().getHeader("referer"));
        FriendService friendService = new FriendService();
        if (! friendService.agreeFriend(informId, remark)) {
            return ERROR;
        }
        return SUCCESS;
    }
}
