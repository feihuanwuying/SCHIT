package action.User;

import com.opensymphony.xwork2.ActionSupport;
import service.UserService;
import vo.User;

import java.util.List;

/**
 * Created by ZouKaifa on 2016/11/29.
 */
public class SearchUserAction extends ActionSupport {
    private List<User> userList;
    private String nickname;
    private long pageNumber;
    private long pageCount;
    private int pageSize;

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getPageCount() {
        return pageCount;
    }

    public void setPageCount(long pageCount) {
        this.pageCount = pageCount;
    }

    @Override
    public String execute() throws Exception {
        if (nickname != null && !nickname.equals("")) {
            UserService userService = new UserService();
            pageCount = userService.getUserPageCount(nickname);
            pageNumber = userService.getPageNumber(pageNumber);
            userList = userService.getUserList(nickname);
        }
        return SUCCESS;
    }
}
