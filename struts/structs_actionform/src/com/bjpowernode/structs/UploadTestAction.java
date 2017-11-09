package com.bjpowernode.structs;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UploadTestAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		UploadActionForm uaf=(UploadActionForm)form;
		System.out.println("title="+uaf.getTitle());
		System.out.println("filename="+uaf.getMyfile());
		
		FileOutputStream fos=new FileOutputStream("c:\\"+uaf.getMyfile().getFileName());
		fos.write(uaf.getMyfile().getFileData());
		fos.flush();
		fos.close();
		return mapping.findForward("success");

	}

}
