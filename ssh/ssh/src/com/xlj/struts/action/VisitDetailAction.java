package com.xlj.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.struts.bean.VisitDetail;
import com.xlj.struts.bean.VisitOnline;
import com.xlj.struts.dao.IDao;
import com.xlj.struts.form.VisitDetailForm;
import com.xlj.struts.util.Pagination;
import com.xlj.struts.util.StringUtil;
import com.xlj.struts.util.ip.IPSeeker;

public class VisitDetailAction extends Action {
	protected Log log=LogFactory.getLog(getClass());
	private IDao dao;//dao对象，有getter/setter方法
	public IDao getDao() {
		return dao;
	}

	public void setDao(IDao dao) {
		this.dao = dao;
	}

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		dao.removeTimeOutOnlineRecords();//设置超时的用户离线
		String action=request.getParameter("action");
		if("listDetail".equals(action)){
			return listDetail(mapping,form,request,response);//列出访问细节
		}
		if("listOnline".equals(action)){
			return listOnline(mapping,form,request,response);//列出在线用户
		}
		return add(mapping,form,request,response);//否则，执行统计方法
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VisitDetailForm visitDetailForm=(VisitDetailForm)form;
		VisitDetail v=visitDetailForm.getV();//直接使用v对象
		String ip=request.getRemoteAddr();//获取IP地址，只能在服务器端获取
		if(StringUtil.isNull(v.getUrl())){//如果URL为空
			v.setUrl(request.getHeader("Referer"));//则在服务器端获取URL
		}
		v.setIp(ip);
		v.setAddress(IPSeeker.getInstance().getAddress(ip));
		v.setUserAgent(request.getHeader("User-Agent"));//设置UserAgent
		v.setDate(new Date());
		v.setKeyword(StringUtil.getParameter(v.getReffer()));//计算搜索关键字
		
		dao.create(v);//保存进数据库
		
		String userId=request.getParameter("userid");
		VisitOnline online=dao.findValidOnline(v.getIp(), userId);//获取当前在线信息
		if(online==null){//如果在线信息为null
			online=new VisitOnline();//实例化一个新的对象
			online.setActiveTimes(1);//设置访问次数为1
			online.setStartDate(new Date());//设置开始访问时间
			online.setLastActiveDate(new Date());//设置最后一次访问时间
			online.setIp(v.getIp());
			online.setAddress(v.getAddress());
			online.setOnline(true);
			online.setUrl(v.getUrl());//设置正在访问的网页URL
			online.setTitle(v.getTitle());//设置正在访问的网页标题
			online.setUserId(userId);
			online.setScreenHeight(v.getScreenHeight());
			online.setScreenWidth(v.getScreenWidth());
			online.setColorDepth(v.getColorDepth());
			online.setAppName(v.getAppName());//设置浏览器内核
			online.setUserAgent(v.getUserAgent());//设置浏览器、操作系统详情
			
			dao.create(online);//创建在线信息
		}else{
			online.setActiveTimes(online.getActiveTimes()+1);
			online.setLastActiveDate(new Date());
			online.setTitle(v.getTitle());
			online.setUrl(v.getUrl());
			dao.save(online);//更新在线信息
		}
		
		if(!StringUtil.isNull(visitDetailForm.getErr())){//如果有错误信息
			log.error("Error:"+visitDetailForm.getErr());
		}
		return mapping.findForward("logo");//返回统计图片
	}
	
	public ActionForward listDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VisitDetailForm visitDetailForm=(VisitDetailForm)form;//FormBean对象
		String sort=visitDetailForm.getSort();//获取排序列
		String order=visitDetailForm.getOrder();//获取排序方式
		
		if(StringUtil.isNull(order)){
			sort="id";
		}
		if(StringUtil.isNull(order)){
			order="desc";
		}
		
		String hql=" from VisitDetail v";//列出所有VisitDetail
		hql+=" order by "+sort+" "+order;//设置排序
		
		int count=dao.getTotalCount("select count(v) "+ hql);//获取记录总数
		
		Pagination pagination=new Pagination();//分页器
		
		pagination.setRequest(request);//自动获取页数、参数等
		pagination.setRecordCount(count);//设置记录总数
		
		List detailList=dao.list(hql, pagination.getFirstResult(), pagination.getPageSize());
		request.setAttribute("url", StringUtil.getURL(request));//设置URL
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);
		request.setAttribute("detailList", detailList);//当前页的数据
		return mapping.findForward("listDetail");
	}
	
	public ActionForward listOnline(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//列出在线用户
		VisitDetailForm visitDetailForm=(VisitDetailForm)form;
		String sort=visitDetailForm.getSort();//获取排序列
		String order=visitDetailForm.getOrder();//获取排序方式
		
		if(StringUtil.isNull(order)){
			sort="id";
		}
		if(StringUtil.isNull(order)){
			order="desc";
		}
		
		String hql=" from VisitOnline v order by "+sort+" "+order;//HQL语句
		int count=dao.getTotalCount("select count(v) "+ hql);
		
		Pagination pagination=new Pagination();//分页器
		
		pagination.setRequest(request);//自动获取页数、参数等
		pagination.setRecordCount(count);//设置记录总数
		List onlineList=dao.list(hql, pagination.getFirstResult(), pagination.getPageSize());
		request.setAttribute("url", StringUtil.getURL(request));//设置URL
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);
		request.setAttribute("onlineList", onlineList);//当前页的数据
		return mapping.findForward("listOnline");
	}
}
