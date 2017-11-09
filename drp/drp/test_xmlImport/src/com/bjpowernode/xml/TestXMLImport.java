package com.bjpowernode.xml;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestXMLImport {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sql="insert into T_XML(NUMERO,REPOSICION,NOMBER,TURNOS) values (?,?,?,?)";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=DbUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			//获取数据
			Document doc=new SAXReader().read(new File("E:/course/JavaProjects/drp/drp/test_xmlImport/xml/test01.XML"));
			List list=doc.selectNodes("/ACCESOS/item/SOCIO");
			//遍历
			for(Iterator iter=list.iterator();iter.hasNext();){
				Element el=(Element)iter.next();
				String numero=el.elementText("NUMERO");
				String reposicion=el.elementText("REPOSICION");
				String nombre=el.elementText("NOMBRE");
				List turnosList=el.elements("TURNOS");
				StringBuffer sbString=new StringBuffer();
				for(Iterator iter1=turnosList.iterator();iter1.hasNext();){
					Element turnosElt=(Element)iter1.next();
					String lu=turnosElt.elementText("LU");
					String ma=turnosElt.elementText("MA");
					String mi=turnosElt.elementText("MI");
					String ju=turnosElt.elementText("JU");
					String vi=turnosElt.elementText("VI");
					String sa=turnosElt.elementText("SA");
					String doo=turnosElt.elementText("DO");
					sbString.append(lu+","+ma+","+mi+","+ju+","+vi+","+sa+","+doo);
				}
				pstmt.setString(1, numero);
				pstmt.setString(2, reposicion);
				pstmt.setString(3, nombre);
				pstmt.setString(4, sbString.toString());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
			System.out.println("将xml导入数据库成功！");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtil.close(pstmt);
			DbUtil.close(conn);
		}
	}

}
