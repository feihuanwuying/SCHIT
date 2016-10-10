package Dao;

/**
 * 对应数据表favorite_post
 * Created by ZouKaifa on 2016/10/10.
 */
public class FavoritePost {
    private long id;
    private String username;  //收藏人
    private long favoriteId;  //收藏帖子id

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

    public long getFavoriteId() {
        return favoriteId;
    }

    public void setFavoriteId(long favoriteId) {
        this.favoriteId = favoriteId;
    }
}
