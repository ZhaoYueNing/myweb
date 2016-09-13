package cn.zhaoyuening.dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;
import cn.zhaoyuening.utils.JdbcUtils;
import cn.zhaoyuening.utils.ToolSet;

public class NewsDao {
	/**
	 * 通过栏目名 过的栏目下的所有资讯
	 * @param column
	 * @return 资讯集合
	 * @throws SQLException
	 */ 
	public List<News> getList(Column column) throws SQLException {
		List<News> newsList = new ArrayList<News>();
		// 数据库连接
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from t_news where columnName=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, column.getName());
		ResultSet set = ps.executeQuery();
		while (set.next()) {
			News news = ToolSet.resultSet2News(set);
			newsList.add(news);
		}
		conn.close();
		return newsList;
	}
	//通过咨询id从数据库获取并封装一个news对象
	public News get(int newsId) throws SQLException{
		// 数据库连接
		Connection conn = JdbcUtils.getConnection();
		String sql = "select * from t_news where id=?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, newsId);
		ResultSet set = ps.executeQuery();
		while(set.next()){
			News news = ToolSet.resultSet2News(set);
			return news;
		}
		conn.close();
		return null;
	}
	/**
	 * 像数据库添加一个news对象
	 * @param news
	 * @return 1 ：保存成功 <br/> 0 ：保存失败
	 * @throws SQLException 
	 */
	public int add(News news) throws SQLException{
		Connection conn = JdbcUtils.getConnection();
		String sql = "insert into t_news(title,content,date,author,columnName) values(?,?,?,?,?);";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, news.getTitle());
		ps.setString(2, news.getContent());
		//如果资讯未保存时间，使用当前时间
		Date date = news.getDate();
		if (date==null) {
			date = new Date(new java.util.Date().getTime());
		}
		ps.setDate(3, date);
		ps.setString(4, news.getAuthor());
		String columnName = null; 
		if (news.getColumn()==null||news.getColumn().getName()==null) {
			columnName="other";
		}else{
			columnName=news.getColumn().getName();
		}
		ps.setString(5 ,columnName);
		
		return ps.executeUpdate();
	}
	
	@Test
	public void testGet() throws Exception {
		News news = get(3);
		System.out.println(news);
	}
	
	@Test
	public void testSave() throws Exception {
		add(new News());
	}

}
