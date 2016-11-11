package vo;

import java.util.Date;

/**
 * 对应于数据表user
 * Created by ZouKaifa on 2016/10/10.
 */
public class User {
    private String username = "";  //用户名
    private String password = "";  //密码
    private String nickname = "";  //昵称
    private String email = "";  //邮件
    private int power;  //权限，1为管理员，2为普通用户
    private String head = "";  //为空表明无头像，否则为图片类型（jpg等)
    private Date birthday = null;  //生日
    private String realName;  //真实名字
    private int sex = 0;  //0保密，1男2女
    private String qq = "";  //qq号
    private String tel = "";  //11位手机号
    private String selfIntro = "";  //自我介绍

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public void setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
    }
}
