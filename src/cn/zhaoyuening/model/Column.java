package cn.zhaoyuening.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * 栏目
 * 
 * @author Zhao
 * @table t_column type: 个人资讯、个人信息、体育
 */
@Entity
@Table(name="t_column")
public class Column{
	//定义默认栏目
	private static Column defalultColumn;
	@Id
	@javax.persistence.Column(name="name")
	private String name;
	//别名-显示在jsp页面上
	@javax.persistence.Column(name="otherName")
	private String otherName;
	public Column() {}

	public Column(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Column [name=" + name + ", otherName=" + otherName + "]";
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	
	public static Column getDefalultColumn() {
		if (defalultColumn==null) {
			defalultColumn = new Column();
			defalultColumn.setName("default");
		}
		return defalultColumn;
	}
}
