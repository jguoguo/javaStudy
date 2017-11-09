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
 * HDFS API URL方式操作
 * @author Administrator
 *
 */
public class HDFSUrlTest {
	//让JAVA程序识别HDFS的URL
	static{
		URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
	}
	//读取文件内容
	
	@Test
	public void testRead() throws IOException{

		InputStream in=null;
		//文件路径			
		String fileurl="hdfs://hadoop-master.dragon.org:9000/opt/data/test/01.data";
		try{
			//获取文件输入流
			in=new URL(fileurl).openStream();
			//将文件内容读取出来，打印控制台
			IOUtils.copyBytes(in, System.out, 4096,false);
		}finally{
			IOUtils.closeStream(in);
		}
	}
}
