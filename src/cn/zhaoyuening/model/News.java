package cn.zhaoyuening.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

/**
 * 资讯
 * @author Zhao
 * @table t_news
 *
 */
@Entity
@Table(name="t_news")
public class News {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	@Type(type="text")  
	private String content;
	//作者
	private String author;

	//发布的日期
	private Date date;
	//所属栏目
	@ManyToOne(targetEntity=Column.class)
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
	/*
	@javax.persistence.Column(name="columnName")
	public String getColumnName(){
		if (column==null) {
			return null;
		}
		return this;
	}
	
	public void setColumnName(String name){
		if (column==null) {
			column = new Column();
		}
		column.setName(name);
	}
	*/
}
