package org.dragon.hadoop.hdfs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.dragon.hadoop.hdfs.utils.HDFSUtils;
import org.junit.Test;


/**
 * HDFS API URL��ʽ����
 * @author Administrator
 *
 */
public class HDFSUrlTest {
	//��JAVA����ʶ��HDFS��URL
	static{
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	//��ȡ�ļ�����
	
	@Test
	public void testRead() throws IOException{

		InputStream in=null;
		//�ļ�·��			
		String fileurl="hdfs://hadoop-master.dragon.org:9000/opt/data/test/01.data";
		try{
			//��ȡ�ļ�������
			in=new URL(fileurl).openStream();
			//���ļ����ݶ�ȡ��������ӡ����̨
			IOUtils.copyBytes(in, System.out, 4096,false);
		}finally{
			IOUtils.closeStream(in);
		}
	}
}
