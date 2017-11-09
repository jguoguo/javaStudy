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
 * ͨ��FileSystem API����
 * @author Administrator
 *
 */
public class HDFSFs {
	@Test
	public void testRead() throws IOException{
		String pathString = "hdfs://hadoop-master.dragon.org:9000";  
        URI pathURI = URI.create(pathString);
		//��ȡ�����ļ���Ϣ
		Configuration conf=new Configuration();
//		conf.addResource("core-site.xml");
//		conf.addResource("hdfs-site.xml");
		FileSystem hdfs=FileSystem.get(pathURI,conf);
//		FileSystem hdfs=FileSystem.get(conf);
		//�ļ�����
		Path path=new Path("/opt/data/test/01.data");
		//���ļ�������---open()
		FSDataInputStream inStream=hdfs.open(path);
		//��ȡ�ļ����ݵ�����̨��ʾ---read()
		IOUtils.copyBytes(inStream, System.out, 4096,false);
		//�ر���---close()
		IOUtils.closeStream(inStream);
	}
}
