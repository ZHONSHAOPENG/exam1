package com.example.admin.exam.bean;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {

    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String content;
    private String htmls;
    private String img;
    @Generated(hash = 139676935)
    public DbBean(Long id, String title, String content, String htmls, String img) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.htmls = htmls;
        this.img = img;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getHtmls() {
        return this.htmls;
    }
    public void setHtmls(String htmls) {
        this.htmls = htmls;
    }
    public String getImg() {
        return this.img;
    }
    public void setImg(String img) {
        this.img = img;
    }

}
