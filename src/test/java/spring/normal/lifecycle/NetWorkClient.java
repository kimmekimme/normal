package spring.normal.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetWorkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetWorkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메세지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void call(String message) {
        System.out.println("콜 = " + url + ", 메세지 = " + message);

    }

    public void connect() {
        System.out.println("연결 = " + url);
    }

    public void disconnect() {
        System.out.println("연결 해제 = " + url);
    }

    @Override
    public void destroy() throws Exception {
        disconnect();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
        call("초기화 연결 메시지");
    }
}

class Test {
    public static void main(String[] args) {
        NetWorkClient netWorkClient = new NetWorkClient();
        netWorkClient.setUrl("김예성");
        netWorkClient.connect();
        netWorkClient.call("호출해본다");
        netWorkClient.disconnect();
    }
}
