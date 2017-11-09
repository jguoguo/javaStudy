package com.xlj.forum.struts.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.forum.bean.Board;
import com.xlj.forum.bean.Category;
import com.xlj.forum.bean.Person;
import com.xlj.forum.service.IBoardService;
import com.xlj.forum.service.ICategoryService;
import com.xlj.forum.service.IPersonService;
import com.xlj.forum.service.IThreadService;
import com.xlj.forum.struts.form.BoardForm;
import com.xlj.forum.struts.util.Pagination;

public class BoardAction extends ForumAction {

	private ICategoryService<Category> categoryService;
	private IBoardService<Board> boardService;
	private IThreadService<Thread> threadService;
	private IPersonService<Person> personService;
	@Override
	@SuppressWarnings("all")
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BoardForm boardForm=(BoardForm)form;
		Board board=boardService.find(Board.class, boardForm.getBoard().getId());//����
		boardForm.setBoard(board);//���õ�ǰ����
		
		int totalCount=threadService.getTotalCount("select count(t) from Thread t " +
				"where t.deleted=false and t.board.id="+board.getId(), null); //��ѯ������
		
		Pagination pagination=new Pagination(request,response);
		
		//��������
		pagination.setRecordCount(totalCount);
		
		List<Thread> threadList=threadService.list(" select t from Thread t " +
				" where t.deleted=false and t.board.id="+board.getId()
				+" order by t.dateLastReplied desc ",pagination.getFirstResult(),pagination.getPageSize(),null);
		
		request.setAttribute("board", board);
		request.setAttribute("pagination", pagination);
		request.setAttribute("threadList", threadList);
		
		boardForm.setTitle("�����б�-���棺"+board.getName());//���ñ���
		return new ActionForward("list","/form/thread/listThread.jsp",false);
	}
	
	public ActionForward initAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BoardForm boardForm=(BoardForm)form;
		boardForm.setTitle("������");//���ñ���
		List<Category> categoryList=categoryService.list("from Category c where c.deleted=false");//��ѯ�������
		request.setAttribute("categoryList", categoryList);//����request
		return new ActionForward("add","form/board/addBoard.jsp",false);
		
	}
	
	/**
	 * ��Ӱ���
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BoardForm boardForm=(BoardForm)form;
		boardForm.setTitle("��Ӱ���");
		Category category=categoryService.find(Category.class, boardForm.getCatetory().getId());
		Board board=boardForm.getBoard();//��ǰ����
		board.setCategory(category);//�������
		board.setDateCreated(new Date());//����ʱ��
		
		boardService.create(board);//��������ݿ�
		request.setAttribute("category", category);//�Ž�request
		return new ActionForward("success","/form/board/success.jsp",false);
		
	}

}
