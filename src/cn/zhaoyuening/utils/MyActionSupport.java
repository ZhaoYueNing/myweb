package cn.zhaoyuening.utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 自定义Action父类
 * 监控用户行为
 * @author Zhao
 *
 */
public abstract class MyActionSupport extends ActionSupport{
	public MyActionSupport() {
		//输出访问者的信息
		//监控用户行为
		String userInfo = ServletActionContext.getRequest().getRemoteAddr() ;
		System.out.println(userInfo+" access "+this.getClass().getSimpleName());
	}
	/**
	 * 日志
	 * @param msg
	 */
	public void LOG(String msg){
		System.out.println(msg);
	}
}
