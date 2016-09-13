package cn.zhaoyuening.utils;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;

public class ToolSet {
	public static News resultSet2News(ResultSet rs) throws SQLException {
		News news = new News();
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String content = rs.getString("content");
		String column = rs.getString("columnName");
		String author = rs.getString("author");
		Date date = rs.getDate("date");

		news.setId(id);
		news.setColumn(new Column(column));
		news.setAuthor(author);
		news.setDate(date);
		news.setContent(content);
		news.setTitle(title);
		return news;
	}
	/**
	 * 判断字符串是否为null或者空字符串
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str){
		if (str==null) {
			return true;
		}
		if (str.trim().equals("")) {
			return true;
		}
		
		return false;
	}
}
