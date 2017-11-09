package dangdang.struts2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import com.opensymphony.xwork2.ActionSupport;

public class StreamAction extends BaseAction	{
	private String num;
	
	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String execute() {
		return SUCCESS;
	}
	
	public InputStream getImage() throws Exception {
		BufferedImage img = 
			new BufferedImage(
					100, 20, BufferedImage.TYPE_INT_RGB);

		Graphics g = img.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 100, 20);
		
		//
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++) {
			int n = random.nextInt(10);
			num+=n+"";
			sb.append(n);
			int x = (i*25+4);
			int y = 18;
			int red = random.nextInt(256);
			int green = random.nextInt(256);
			int blue = random.nextInt(256);
			Color c = new Color(red,green,blue);
			g.setColor(c);
			g.setFont(new Font("宋体", 0, 16));
			g.drawString(String.valueOf(n), x, y);
		}
		
		//
		for(int i=0;i<4;i++) {
			int red = random.nextInt(256);
			int green = random.nextInt(256);
			int blue = random.nextInt(256);
			int x1 = random.nextInt(101);
			int y1 = random.nextInt(21);
			int x2 = random.nextInt(101);
			int y2 = random.nextInt(21);
			g.setColor(new Color(red,green,blue));
			g.drawLine(x1, y1, x2, y2);
		}
		
		//
		ByteArrayOutputStream bout = 
			new ByteArrayOutputStream();
		ImageIO.write(img, "GIF", bout);
		byte[] arr = bout.toByteArray();
		sessionMap.put("VerifyCode", sb);
		return new ByteArrayInputStream(arr);
	}
	
	public String getFileName() {
		return ""+Math.random()+".gif";
		
	}
}
