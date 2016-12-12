package action.user;

import com.opensymphony.xwork2.ActionSupport;
import dao.FeedbackDao;
import org.apache.struts2.ServletActionContext;

/**
 * Created by ZouKaifa on 2016/12/12.
 */
public class AddFeedbackAction extends ActionSupport {
    private String info;
    private String ip;
    private String url;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String execute() throws Exception {
        url = ServletActionContext.getRequest().getHeader("referer");
        ip = ServletActionContext.getRequest().getRemoteAddr();
        FeedbackDao feedbackDao = new FeedbackDao();
        feedbackDao.addFeedback(ip, info);
        feedbackDao.close();
        return SUCCESS;
    }
}
