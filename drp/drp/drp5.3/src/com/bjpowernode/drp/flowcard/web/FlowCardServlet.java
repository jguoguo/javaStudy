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
 * 物料维护servlet
 * @author Administrator
 *
 */
public class FlowCardServlet extends BaseServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//必须显示调用父类的service方法
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
	 * 完成添加
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//供方分销商代码
		String clientId=request.getParameter("clientInnerId");
		//需方分销商代码
		String[] aimIds=request.getParameterValues("aimInnerId");
		//物料代码
		String[] itemNos=request.getParameterValues("itemNo");
		//操作数量
		String[] qty=request.getParameterValues("qty");
		FlowCard flowCard=new FlowCard();
		//操作类型
		flowCard.setOptType("A");
		//正常情况下应该从session中取得
		FiscalYearPeriod fiscalYearPeriod=new FiscalYearPeriod();
		fiscalYearPeriod.setId(1);
		flowCard.setFiscalYearPeriod(fiscalYearPeriod);
		//设置分销商
		Client client=new Client();
		client.setId(Integer.parseInt(clientId));
		flowCard.setClient(client);
		//取得录入人
		flowCard.setRecoder(getCurrentUser());
		//操作日期
		flowCard.setOptDate(new Date());
		//单据状态
		flowCard.setVouSts("N");
		
		List<FlowCardDetail> flowCardDetailList=new ArrayList();
		for(int i=0;i<aimIds.length;i++){
			FlowCardDetail flowCardDetail=new FlowCardDetail();
			//需方客户
			AimClient aimclient=new AimClient();
			aimclient.setId(Integer.parseInt(aimIds[i]));
			flowCardDetail.setAimClient(aimclient);
			
			//物料
			Item item=new Item();
			item.setItemNo(itemNos[i]);
			flowCardDetail.setItem(item);
			
			//操作数量
			flowCardDetail.setOptQty(new BigDecimal(qty[i]));
			//调整标记
			flowCardDetail.setAdjustFlag("N");
			flowCardDetailList.add(flowCardDetail);
		}
		flowCard.setFlowCardDetail(flowCardDetailList);
		//通过工厂取得业务逻辑对象
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
	 * 显示添加页面
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
