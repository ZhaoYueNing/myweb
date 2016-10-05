package cn.zhaoyuening.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by buynow on 16-10-5.
 * 访客评论
 */
@Entity(name = "t_comment")
public class Comment  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private String content;
    @ManyToOne(targetEntity = News.class,cascade = {CascadeType.MERGE})
    private News news;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", news=" + news.getTitle() +
                '}';
    }
}
