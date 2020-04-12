package pan.rufeng.pattern.refactor.ifelsefactory;

import java.util.Map;

public class ChannelSimpleFactory {

    Map<Integer, Channel> channelMap;
    ChannelStrategy strategy;

    void setStrategy(ChannelStrategy strategy){
        this.strategy = strategy;
    }

    void setChannelMap(Map map) {
        this.channelMap = map;
    }

    Channel newChannel() {
        int i = this.strategy.getTheRightChannel();
        return this.channelMap.get(i);
    }

    Channel newChannel(int i) {
        return this.channelMap.get(i);
    }

    Channel createChannel(int i) {
        Channel channel;
        if (i == 1) {
            channel = new ChannelA();
        } else if (i == 2) {
            channel = new ChannelB();
        } else {
            channel = new ChannelC();
        }
        return channel;
    }
}