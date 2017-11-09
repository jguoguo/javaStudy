package com.bjpowernode.drp.flowcard.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.drp.basedata.domain.AimClient;
import com.bjpowernode.drp.basedata.domain.Client;
import com.bjpowernode.drp.basedata.domain.FiscalYearPeriod;
import com.bjpowernode.drp.basedata.domain.Item;
import com.bjpowernode.drp.flowcard.domain.FlowCard;
import com.bjpowernode.drp.flowcard.domain.FlowCardDetail;
import com.bjpowernode.drp.flowcard.manager.FlowCardManager;
import com.bjpowernode.drp.util.ApplicationException;
import com.bjpowernode.drp.util.BeanFactory;
import com.bjpowernode.drp.util.Constants;
import com.bjpowernode.drp.util.PageModel;
import com.bjpowernode.drp.util.TransactionHandle;
import com.bjpowernode.drp.util.filter.BaseServlet;

/**
 * ����ά��servlet
 * @author Administrator
 *
 */
public class FlowCardServlet extends BaseServlet {
	FlowCardManager flowCardManager=null;
	@Override
	public void init() throws ServletException {
		flowCardManager=(FlowCardManager) getBeanFactory().getServiceObject(FlowCardManager.class);
//		TransactionHandle transactionHandler=new TransactionHandle();
//		//��Ŀ�����ɴ������
//		flowCardManager=(FlowCardManager)transactionHandler.newProxyInstance(flowCardManager);
		
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������ʾ���ø����service����
		super.service(request, response);
//		if("add".equals(getCommand())){
//			add(request,response);
//		}else if("del".equals(getCommand())){
//			
//		}else if("modify".equals(getCommand())){
//			
//		}else if("showAdd".equals(getCommand())){
//			showAdd(request,response);
//		}else{
//			
//		}
		String command=getCommand();
		if(Constants.ADD.equals(getCommand())){
			add(request,response);
		}else if(Constants.DEL.equals(getCommand())){
			del(request,response);
		}else if(Constants.MODIFY.equals(getCommand())){
			
		}else if(Constants.SHOW_ADD.equals(getCommand())){
			showAdd(request,response);
		}else if(Constants.QUERY.equals(getCommand())){
			search(request,response);
		}else if(Constants.AUDIT.equals(getCommand())){
			audit(request,response);
		}else if(Constants.DETAIL.equals(getCommand())){
			detail(request,response);
		}
	}
	/**
	 * ������
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//���������̴���
		String clientId=request.getParameter("clientInnerId");
		//�跽�����̴���
		String[] aimIds=request.getParameterValues("aimInnerId");
		//���ϴ���
		String[] itemNos=request.getParameterValues("itemNo");
		//��������
		String[] qty=request.getParameterValues("qty");
		FlowCard flowCard=new FlowCard();
		//��������
		flowCard.setOptType("A");
		//���������Ӧ�ô�session��ȡ��
		FiscalYearPeriod fiscalYearPeriod=new FiscalYearPeriod();
		fiscalYearPeriod.setId(1);
		flowCard.setFiscalYearPeriod(fiscalYearPeriod);
		//���÷�����
		Client client=new Client();
		client.setId(Integer.parseInt(clientId));
		flowCard.setClient(client);
		//ȡ��¼����
		flowCard.setRecorder(getCurrentUser());
		//��������
		flowCard.setOptDate(new Date());
		//����״̬
		flowCard.setVouSts("N");
		
		List<FlowCardDetail> flowCardDetailList=new ArrayList();
		for(int i=0;i<aimIds.length;i++){
			FlowCardDetail flowCardDetail=new FlowCardDetail();
			//�跽�ͻ�
			AimClient aimclient=new AimClient();
			aimclient.setId(Integer.parseInt(aimIds[i]));
			flowCardDetail.setAimClient(aimclient);
			
			//����
			Item item=new Item();
			item.setItemNo(itemNos[i]);
			flowCardDetail.setItem(item);
			
			//��������
			flowCardDetail.setOptQty(new BigDecimal(qty[i]));
			//�������
			flowCardDetail.setAdjustFlag("N");
			flowCardDetailList.add(flowCardDetail);
		}
		flowCard.setFlowCardDetail(flowCardDetailList);
		//ͨ������ȡ��ҵ���߼�����
		
		flowCardManager.addFlowCard(flowCard);
		response.sendRedirect(request.getContextPath()+"/servlet/flowCard/FlowCardServlet?command="+Constants.QUERY);
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String[] flowCardVouNos=request.getParameterValues("selectFlag");
		flowCardManager.delFlowCard(flowCardVouNos);
		response.sendRedirect(request.getContextPath()+"/servlet/flowCard/FlowCardServlet?command="+Constants.QUERY);
	}
	
	private void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
	}
	/**
	 * ��ʾ���ҳ��
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void showAdd(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getRequestDispatcher("/flowcard/flow_card_add.jsp").forward(request, response);
	}
	
	private void search (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//String clientInnerId=request.getParameter("clientInnerId");
		String clientId=request.getParameter("clientId");
		String beginDate=request.getParameter("beginDate");
		String endDate=request.getParameter("endDate");
		int pageNo=1;
		if(request.getParameter("pageNo")!=null && !"".equals(request.getParameter("pageNo"))){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		int pageSize=Integer.parseInt(this.getServletContext().getInitParameter("page-size"));
		Date dBeginDate=new Date();
		Date dEndDate=new Date();
		
		try {
			if (beginDate != null && !"".equals(beginDate)) {
				dBeginDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(beginDate+" 00:00:00");
			}else{
				dBeginDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 00:00:00");
			}
			if (endDate != null && !"".equals(endDate)) {
				dEndDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate+" 23:59:59");
			}else{
				dEndDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(new SimpleDateFormat("yyyy-MM-dd").format(new Date())+" 23:59:59");
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ApplicationException("��ҳ��ѯʧ��");
		}
		PageModel<FlowCard> pageModel=flowCardManager.findFlowCardList(pageNo, pageSize, clientId, dBeginDate, dEndDate);
		request.setAttribute("dBeginDate", dBeginDate);
		request.setAttribute("dEndDate", dEndDate);
		request.setAttribute("pageModel", pageModel);
		//ת��
		request.getRequestDispatcher("/flowcard/flow_card_maint.jsp").forward(request, response);
		
	}
	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void audit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String[] flowCardVouNos=request.getParameterValues("selectFlag");
		flowCardManager.auditFlowCard(flowCardVouNos);
		response.sendRedirect(request.getContextPath()+"/servlet/flowCard/FlowCardServlet?command="+Constants.QUERY);
	}
	
	/**
	 * ����
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void detail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.getRequestDispatcher("/flowcard/flow_card_detail.jsp").forward(request, response);
	}
}
