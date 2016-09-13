package cn.zhaoyuening.model;

import java.sql.Date;

/**
 * 资讯
 * @author Zhao
 * @table t_news
 *
 */
public class News {
	private int id;
	private String title;
	private String content;
	//作者
	private String author;

	//发布的日期
	private Date date;
	//所属栏目
	private Column column;
	public News() {}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public Column getColumn() {
		return column;
	}
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", content=" + content
				+ ", author=" + author + ", date=" + date + ", column="
				+ column + "]";
	}
	
	
}
