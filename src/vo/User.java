package vo;

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
}
