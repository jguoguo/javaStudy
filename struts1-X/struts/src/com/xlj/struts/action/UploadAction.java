package com.xlj.struts.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xlj.struts.form.UploadForm;

public class UploadAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadForm uploadForm=(UploadForm)form;
		if("upload".equals(uploadForm.getAction())){
			return upload(mapping,form,request,response);
		}
		return mapping.getInputForward();
	}
	public ActionForward upload(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		UploadForm uploadForm=(UploadForm)form;
		StringBuffer buffer=new StringBuffer();
		buffer.append("<style>body{font-size:12px;}</style>");
		if(uploadForm.getFile()!=null && uploadForm.getFile().getFileSize() > 0){
			//获取文件夹/WEB-INF/classes
			File classes=new File(getClass().getClassLoader().getResource("").getFile());
			//获取文件夹/WEB-INF/upload
			File uploadFolder =new File(classes.getParentFile().getParentFile(),"upload");
			
			//必须先从创建目录
			uploadFolder.mkdirs();
			//保存到/upload下面
			File file=new File(uploadFolder,uploadForm.getFile().getFileName());
			
			OutputStream ous=null;//文件输出流
			InputStream ins=null;//上传文件输入流
			try{
				byte[] b=new byte[1024];
				int len=0;
				ins=uploadForm.getFile().getInputStream();//上传文件输入流
				ous=new FileOutputStream(file);//文件输出流
				while((len=ins.read(b))!=-1){//循环写到文件中
					ous.write(b,0,len);
				}
			}finally{
				ins.close();
				ous.close();
			}
			buffer.append("文件：<a href=upload/"+file.getName()+" target=_blank>"+file.getName()+"</a><br/>");
		}else{
			buffer.append("文件：没有选择文件<br/>");
		}
		buffer.append("备注:"+uploadForm.getText()+"<br/>");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(buffer.toString());//直接输出内容到客户端
		return null;
	}
}
