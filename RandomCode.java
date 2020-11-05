package Day16;

import Day12.OutstandingClass;
import javafx.scene.control.RadioMenuItem;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.GenericArrayType;
import java.util.Random;

/**
 * @ClassName RandomCode
 * @Description TODO
 * @Author 86139
 * @Date 2020/11/5
 **/

public class RandomCode {
    private static final int LENGTH=4;
    private static final int BOUNDS=15;

    public static void main(String[] args) throws IOException {
        Random random=new Random();//指定图片的大小与类型
        BufferedImage bufferedImage=new BufferedImage(120,40,BufferedImage.TYPE_INT_RGB);
        Graphics graphics =bufferedImage.getGraphics();//获取字体
        Font font=new Font("方正华隶简体",Font.BOLD,20);
        graphics.setFont(font);
        graphics.setColor(Color.WHITE);
        graphics.fillOval(0,0,120,40);//开始绘制
        String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        char[] chs=s.toCharArray();
        StringBuffer string=new StringBuffer();
        for(int i=0;i<LENGTH;i++){
            char ch =chs[random.nextInt(60)];
            string.append(ch);}
        graphics.setColor(Color.BLACK);//生成随机验证码
        graphics.drawString(string.toString(),40,28);
        for(int i=0;i<BOUNDS;i++) {//生成干扰线
            int redRandom = random.nextInt(256);
            int greenRandom = random.nextInt(256);
            int blueRandom = random.nextInt(256);
            //随机坐标
            int x1 = random.nextInt(120);
            int y1 = random.nextInt(40);
            int x2 = random.nextInt(120);
            int y2 = random.nextInt(40);
            Color color = new Color(redRandom, greenRandom, blueRandom);
            graphics.setColor(color);
            graphics.drawLine(x1, y1, x2, y2);
        }
        //输出图片，并且指定文件路径，自己注意修改
        File file =new File("C:/Users/86139/code.jpg");
        OutputStream outputStream= new FileOutputStream(file);
        ImageIO.write(bufferedImage,"jpg",outputStream);
        outputStream.close();
    }
}
