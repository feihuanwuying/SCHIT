package Data;

import java.util.Date;

/**
 * 对应数据表friend_apply
 * Created by ZouKaifa on 2016/10/10.
 */
public class FriendApply {
    private long id;
    private String username;  //用户名
    private String applierName;  //申请人
    private Date applyTime;  //申请时间
    private String message;  //附加信息
    private int result;  //0未处理,1通过,2拒绝,3忽略

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getApplierName() {
        return applierName;
    }

    public void setApplierName(String applierName) {
        this.applierName = applierName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
