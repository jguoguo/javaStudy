package com.bjpowernode.drp.flowcard.web;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.bjpowernode.drp.util.filter.BaseServlet;

/**
 * ����ά��servlet
 * @author Administrator
 *
 */
public class FlowCardServlet extends BaseServlet {

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
		
		if(Constants.ADD.equals(getCommand())){
			add(request,response);
		}else if(Constants.DEL.equals(getCommand())){
			
		}else if(Constants.MODIFY.equals(getCommand())){
			
		}else if(Constants.SHOW_ADD.equals(getCommand())){
			showAdd(request,response);
		}else{
			
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
		flowCard.setRecoder(getCurrentUser());
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
		FlowCardManager flowCardManager=(FlowCardManager) getBeanFactory().getServiceObject(FlowCardManager.class);
		flowCardManager.addFlowCard(flowCard);
		response.sendRedirect(request.getContextPath()+"/flowcard/flow_card_maint.jsp");
	}
	
	private void del(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
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
}
