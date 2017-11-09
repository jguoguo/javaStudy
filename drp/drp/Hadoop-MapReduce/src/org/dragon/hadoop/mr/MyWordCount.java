package org.dragon.hadoop.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.GenericOptionsParser;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * MapReduce ����������wordCount����
 * Created by Administrator on 2016/3/4.
 */
public class MyWordCount {

    //Mapper����

    /**
     * KEYIN,      VALUEIN,     KEYOUT,     VALUEOUT
     *   |             |           |            |
     * ����key���� ����value���� ���key���� ���value����
     */

    /**
     * WordCount ����Map��
     * �������ı�
     */
    static class MyMapper extends Mapper<LongWritable,Text,Text,IntWritable>{
        private final static IntWritable one=new IntWritable(1);
        private Text word=new Text();

        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

            //��ȡÿ�����ݵ�ֵ
            String lineValue=value.toString();
            //���зָ�
            StringTokenizer stringTokenizer=new StringTokenizer(lineValue);
            //����
            while (stringTokenizer.hasMoreTokens()){
                //��ȡÿ��ֵ
                String wordValue=stringTokenizer.nextToken();

                //����map�����keyֵ
                word.set(wordValue);
                //���������map��key��value
                context.write(word,one);
            }
        }
    }

    //Reducer����

    /**
     * KEYIN,      VALUEIN,     KEYOUT,     VALUEOUT
     *   |             |           |            |
     * ����key���� ����value���� ���key���� ���value����
     */
    /**
     * WordCount ����reduce��
     */
    static class MyReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
        private IntWritable result=new IntWritable();
        @Override
        protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {

            //�����ۼ�
            int sum=0;
            //ѭ������InWritable
            for(IntWritable value:values){
                //�ۼ�
                sum+=value.get();
            }

            //�����ܴ���
            result.set(sum);
            context.write(key,result);
        }
    }

    //Client����
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        //��ȡ������Ϣ
        Configuration configuration=new Configuration();
        
        String[] otherArgs=new GenericOptionsParser(configuration,args).getRemainingArgs();
        if(otherArgs.length!=2){
        	System.err.println("Usage: wordcount<in><out>");
        	System.exit(2);
        }
        
        //����job,�������ú�Job����
        Job job=new Job(configuration,"wc");

        //1������Job���е���
        job.setJarByClass(MyWordCount.class);

        //2������Mapper��Reducer��
        job.setMapperClass(MyMapper.class);
        job.setReducerClass(MyReducer.class);

        //3�����������ļ���Ŀ¼������ļ���Ŀ¼

        FileInputFormat.addInputPath(job,new Path(otherArgs[0]));
        FileOutputFormat.setOutputPath(job,new Path(otherArgs[1]));
        //4��������������key��value����
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        //5���ύJob,�ȴ����н�������ڿͻ�����ʾ������Ϣ
        boolean isSuccess=job.waitForCompletion(true);
        //���� ����
        System.exit(isSuccess?0:1);
    }

}
