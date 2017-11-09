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
		Board board=boardService.find(Board.class, boardForm.getBoard().getId());//版面
		boardForm.setBoard(board);//设置当前版面
		
		int totalCount=threadService.getTotalCount("select count(t) from Thread t " +
				"where t.deleted=false and t.board.id="+board.getId(), null); //查询帖子数
		
		Pagination pagination=new Pagination(request,response);
		
		//设置总数
		pagination.setRecordCount(totalCount);
		
		List<Thread> threadList=threadService.list(" select t from Thread t " +
				" where t.deleted=false and t.board.id="+board.getId()
				+" order by t.dateLastReplied desc ",pagination.getFirstResult(),pagination.getPageSize(),null);
		
		request.setAttribute("board", board);
		request.setAttribute("pagination", pagination);
		request.setAttribute("threadList", threadList);
		
		boardForm.setTitle("帖子列表-版面："+board.getName());//设置标题
		return new ActionForward("list","/form/thread/listThread.jsp",false);
	}
	
	public ActionForward initAdd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BoardForm boardForm=(BoardForm)form;
		boardForm.setTitle("添加面板");//设置标题
		List<Category> categoryList=categoryService.list("from Category c where c.deleted=false");//查询所有类别
		request.setAttribute("categoryList", categoryList);//放入request
		return new ActionForward("add","form/board/addBoard.jsp",false);
		
	}
	
	/**
	 * 添加版面
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
		boardForm.setTitle("添加版面");
		Category category=categoryService.find(Category.class, boardForm.getCatetory().getId());
		Board board=boardForm.getBoard();//当前版面
		board.setCategory(category);//设置类别
		board.setDateCreated(new Date());//创建时间
		
		boardService.create(board);//保存进数据库
		request.setAttribute("category", category);//放进request
		return new ActionForward("success","/form/board/success.jsp",false);
		
	}

}
