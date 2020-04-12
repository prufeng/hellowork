package pan.rufeng.pattern.refactor.ifelsefactory;

import java.util.HashMap;
import java.util.Map;

public class IfElseRefactor {
    private String aChannel;
    private String bChannel;
    private String cChannel;

    private String xLoad;
    private String userInfo;
    private Response response;

    public void step1() {
        int i = getTheRightChannel();
        if (i == 1) {
            response = callApiOfChannelA(aChannel, xLoad, userInfo);
        } else if (i == 2) {
            response = callApiOfChannelB(bChannel, xLoad, userInfo);
        } else {
            response = callApiOfChannelC(cChannel, xLoad, userInfo);
        }
    }

    public void step2() {
        int i = getTheRightChannel();
        Channel channel;
        if (i == 1) {
            channel = new ChannelA();
        } else if (i == 2) {
            channel = new ChannelB();
        } else {
            channel = new ChannelC();
        }
        response = channel.callApi(xLoad, userInfo);
    }

    public void step3() {
        int i = getTheRightChannel();
        ChannelSimpleFactory channelSimpleFactory = new ChannelSimpleFactory();
        Channel channel = channelSimpleFactory.createChannel(i);
        response = channel.callApi(xLoad, userInfo);
    }

    public void step4() {
        int i = getTheRightChannel();
        ChannelSimpleFactory channelSimpleFactory = new ChannelSimpleFactory();
        // should be in the configure
        Map map = new HashMap<Integer, Channel>();
        map.put(1, new ChannelA());
        map.put(2, new ChannelB());
        map.put(3, new ChannelC());
        channelSimpleFactory.setChannelMap(map);
        //
        Channel channel = channelSimpleFactory.newChannel(i);
        response = channel.callApi(xLoad, userInfo);
    }

    public void step5() {
        ChannelSimpleFactory channelFactory = new ChannelSimpleFactory();
        ChannelStrategy strategy = new ChannelWeightStrategy();
        channelFactory.setStrategy(strategy);
        Channel channel = channelFactory.newChannel();
        response = channel.callApi(xLoad, userInfo);
    }

    private int getTheRightChannel() {
        return 1;
    }

    private Response callApiOfChannelA(String aChannel, String xLoad, String userInfo) {
        //call api of channelName
        Response r = new Response();
        return r;
    }

    private Response callApiOfChannelB(String aChannel, String xLoad, String userInfo) {
        //call api of channelName
        Response r = new Response();
        return r;
    }

    private Response callApiOfChannelC(String aChannel, String xLoad, String userInfo) {
        //call api of channelName
        Response r = new Response();
        return r;
    }
}

