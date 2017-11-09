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
	private IDao dao;//dao������getter/setter����
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
		dao.removeTimeOutOnlineRecords();//���ó�ʱ���û�����
		String action=request.getParameter("action");
		if("listDetail".equals(action)){
			return listDetail(mapping,form,request,response);//�г�����ϸ��
		}
		if("listOnline".equals(action)){
			return listOnline(mapping,form,request,response);//�г������û�
		}
		return add(mapping,form,request,response);//����ִ��ͳ�Ʒ���
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VisitDetailForm visitDetailForm=(VisitDetailForm)form;
		VisitDetail v=visitDetailForm.getV();//ֱ��ʹ��v����
		String ip=request.getRemoteAddr();//��ȡIP��ַ��ֻ���ڷ������˻�ȡ
		if(StringUtil.isNull(v.getUrl())){//���URLΪ��
			v.setUrl(request.getHeader("Referer"));//���ڷ������˻�ȡURL
		}
		v.setIp(ip);
		v.setAddress(IPSeeker.getInstance().getAddress(ip));
		v.setUserAgent(request.getHeader("User-Agent"));//����UserAgent
		v.setDate(new Date());
		v.setKeyword(StringUtil.getParameter(v.getReffer()));//���������ؼ���
		
		dao.create(v);//��������ݿ�
		
		String userId=request.getParameter("userid");
		VisitOnline online=dao.findValidOnline(v.getIp(), userId);//��ȡ��ǰ������Ϣ
		if(online==null){//���������ϢΪnull
			online=new VisitOnline();//ʵ����һ���µĶ���
			online.setActiveTimes(1);//���÷��ʴ���Ϊ1
			online.setStartDate(new Date());//���ÿ�ʼ����ʱ��
			online.setLastActiveDate(new Date());//�������һ�η���ʱ��
			online.setIp(v.getIp());
			online.setAddress(v.getAddress());
			online.setOnline(true);
			online.setUrl(v.getUrl());//�������ڷ��ʵ���ҳURL
			online.setTitle(v.getTitle());//�������ڷ��ʵ���ҳ����
			online.setUserId(userId);
			online.setScreenHeight(v.getScreenHeight());
			online.setScreenWidth(v.getScreenWidth());
			online.setColorDepth(v.getColorDepth());
			online.setAppName(v.getAppName());//����������ں�
			online.setUserAgent(v.getUserAgent());//���������������ϵͳ����
			
			dao.create(online);//����������Ϣ
		}else{
			online.setActiveTimes(online.getActiveTimes()+1);
			online.setLastActiveDate(new Date());
			online.setTitle(v.getTitle());
			online.setUrl(v.getUrl());
			dao.save(online);//����������Ϣ
		}
		
		if(!StringUtil.isNull(visitDetailForm.getErr())){//����д�����Ϣ
			log.error("Error:"+visitDetailForm.getErr());
		}
		return mapping.findForward("logo");//����ͳ��ͼƬ
	}
	
	public ActionForward listDetail(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VisitDetailForm visitDetailForm=(VisitDetailForm)form;//FormBean����
		String sort=visitDetailForm.getSort();//��ȡ������
		String order=visitDetailForm.getOrder();//��ȡ����ʽ
		
		if(StringUtil.isNull(order)){
			sort="id";
		}
		if(StringUtil.isNull(order)){
			order="desc";
		}
		
		String hql=" from VisitDetail v";//�г�����VisitDetail
		hql+=" order by "+sort+" "+order;//��������
		
		int count=dao.getTotalCount("select count(v) "+ hql);//��ȡ��¼����
		
		Pagination pagination=new Pagination();//��ҳ��
		
		pagination.setRequest(request);//�Զ���ȡҳ����������
		pagination.setRecordCount(count);//���ü�¼����
		
		List detailList=dao.list(hql, pagination.getFirstResult(), pagination.getPageSize());
		request.setAttribute("url", StringUtil.getURL(request));//����URL
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);
		request.setAttribute("detailList", detailList);//��ǰҳ������
		return mapping.findForward("listDetail");
	}
	
	public ActionForward listOnline(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {//�г������û�
		VisitDetailForm visitDetailForm=(VisitDetailForm)form;
		String sort=visitDetailForm.getSort();//��ȡ������
		String order=visitDetailForm.getOrder();//��ȡ����ʽ
		
		if(StringUtil.isNull(order)){
			sort="id";
		}
		if(StringUtil.isNull(order)){
			order="desc";
		}
		
		String hql=" from VisitOnline v order by "+sort+" "+order;//HQL���
		int count=dao.getTotalCount("select count(v) "+ hql);
		
		Pagination pagination=new Pagination();//��ҳ��
		
		pagination.setRequest(request);//�Զ���ȡҳ����������
		pagination.setRecordCount(count);//���ü�¼����
		List onlineList=dao.list(hql, pagination.getFirstResult(), pagination.getPageSize());
		request.setAttribute("url", StringUtil.getURL(request));//����URL
		request.setAttribute("sort", sort);
		request.setAttribute("order", order);
		request.setAttribute("pagination", pagination);
		request.setAttribute("onlineList", onlineList);//��ǰҳ������
		return mapping.findForward("listOnline");
	}
}
