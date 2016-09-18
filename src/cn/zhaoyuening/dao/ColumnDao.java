package cn.zhaoyuening.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.zhaoyuening.model.Column;
import cn.zhaoyuening.utils.SessionManager;

public class ColumnDao {
	SessionManager sessionManager = new SessionManager();
	public ColumnDao(){}
	/**
	 * 获取所有栏目
	 * @return 所有栏目
	 */
	public List<Column> getColumns(){
		List<Column> columns = new ArrayList<Column>();
		Session session = sessionManager.getSession();
		Transaction transaction = session.beginTransaction();
		Criteria criteria = session.createCriteria(Column.class);
		columns = criteria.list();
		transaction.commit();
		return columns;
	}
}
