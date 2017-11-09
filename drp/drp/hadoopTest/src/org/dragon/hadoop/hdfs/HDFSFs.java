package org.dragon.hadoop.hdfs;

import java.io.IOException;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.dragon.hadoop.hdfs.utils.HDFSUtils;
import org.junit.Test;

/**
 * 通过FileSystem API操作
 * @author Administrator
 *
 */
public class HDFSFs {
	@Test
	public void testRead() throws IOException{
		String pathString = "hdfs://hadoop-master.dragon.org:9000";  
        URI pathURI = URI.create(pathString);
		//获取配置文件信息
		Configuration conf=new Configuration();
//		conf.addResource("core-site.xml");
//		conf.addResource("hdfs-site.xml");
		FileSystem hdfs=FileSystem.get(pathURI,conf);
//		FileSystem hdfs=FileSystem.get(conf);
		//文件名称
		Path path=new Path("/opt/data/test/01.data");
		//打开文件输入流---open()
		FSDataInputStream inStream=hdfs.open(path);
		//读取文件内容到控制台显示---read()
		IOUtils.copyBytes(inStream, System.out, 4096,false);
		//关闭流---close()
		IOUtils.closeStream(inStream);
	}
}
