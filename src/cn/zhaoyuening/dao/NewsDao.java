package cn.zhaoyuening.dao;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.model.News;
import cn.zhaoyuening.utils.JdbcUtils;
import cn.zhaoyuening.utils.SessionManager;
import cn.zhaoyuening.utils.ToolSet;

public class NewsDao {
	
	private SessionManager sessionManager;
	public NewsDao(){
		sessionManager = new SessionManager();
	}
	/**
	 * 通过栏目名 过的栏目下的所有资讯
	 * @param column
	 * @return 资讯集合
	 * @throws SQLException
	 */ 
	public List<News> getList(Column column) throws SQLException {
		List<News> newsList = new ArrayList<News>();
		String sql = "from "+News.class.getName()+" where column_name='"+column.getName()+"'";
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sql);
		newsList = query.list();
		transaction.commit();
		return newsList;
		
	}
	
	//通过咨询id从数据库获取并封装一个news对象
	public News get(int newsId) throws SQLException{
		List<News> newsList = new ArrayList<News>();
		String sql = "from "+News.class.getName()+" where id='"+newsId+"'";
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery(sql);
		newsList = query.list();
		transaction.commit();
		if (newsList.size()<=0) {
			//查询失败
			return null;
		}
		//查询成功，返回第一个
		return newsList.get(0);
	}
	/**
	 * 像数据库添加一个news对象
	 * @param news
	 * @return 1 ：保存成功 <br/> 0 ：保存失败
	 * @throws SQLException 
	 */
	public int add(News news) throws SQLException{
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		Serializable save = session.save(news);
		transaction.commit();
		if (save==null) {
			return 0;
		}
		return 1;
	}
	


}
