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
			//��ȡ�ļ���/WEB-INF/classes
			File classes=new File(getClass().getClassLoader().getResource("").getFile());
			//��ȡ�ļ���/WEB-INF/upload
			File uploadFolder =new File(classes.getParentFile().getParentFile(),"upload");
			
			//�����ȴӴ���Ŀ¼
			uploadFolder.mkdirs();
			//���浽/upload����
			File file=new File(uploadFolder,uploadForm.getFile().getFileName());
			
			OutputStream ous=null;//�ļ������
			InputStream ins=null;//�ϴ��ļ�������
			try{
				byte[] b=new byte[1024];
				int len=0;
				ins=uploadForm.getFile().getInputStream();//�ϴ��ļ�������
				ous=new FileOutputStream(file);//�ļ������
				while((len=ins.read(b))!=-1){//ѭ��д���ļ���
					ous.write(b,0,len);
				}
			}finally{
				ins.close();
				ous.close();
			}
			buffer.append("�ļ���<a href=upload/"+file.getName()+" target=_blank>"+file.getName()+"</a><br/>");
		}else{
			buffer.append("�ļ���û��ѡ���ļ�<br/>");
		}
		buffer.append("��ע:"+uploadForm.getText()+"<br/>");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(buffer.toString());//ֱ��������ݵ��ͻ���
		return null;
	}
}
