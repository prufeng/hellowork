package pan.rufeng.pattern.refactor.ifelsefactory;

public class IfElseOrigin {
    private String aChannel;
    private String bChannel;
    private String cChannel;

    private String xLoad;
    private String userInfo;
    private Response response;

    public void execute(boolean ba, boolean bb, boolean bc) {
        if (ba && bb && bc) {
            response = callApiByChannelName(getChannelNameForThree(aChannel, bChannel, cChannel), xLoad, userInfo);
        } else if (ba && bb && !bc) {
            response = callApiByChannelName(getChannelNameForTwo(aChannel, bChannel), xLoad, userInfo);
        } else if (ba && !bb && bc) {
            response = callApiByChannelName(getChannelNameForTwo(aChannel, cChannel), xLoad, userInfo);
        } else if (!ba && bb && bc) {
            response = callApiByChannelName(getChannelNameForTwo(bChannel, cChannel), xLoad, userInfo);
        } else if (ba && !bb && !bc) {
            response = callApiOfChannelA(aChannel, xLoad, userInfo);
        } else if (!ba && bb && !bc) {
            response = callApiOfChannelB(bChannel, xLoad, userInfo);
        } else if (!ba && !bb && bc) {
            response = callApiOfChannelC(cChannel, xLoad, userInfo);
        }
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

    private Response callApiByChannelName(String channelName, String xLoad, String userInfo) {
        //call api of channelName
        Response r = new Response();
        return r;
    }

    private String getChannelNameForThree(String aChannel, String bChannel, String cChannel) {
        //query channel and pick up the best one
        return aChannel;
    }

    private String getChannelNameForTwo(String aChannel, String bChannel) {
        //query channel and pick up the best one
        return aChannel;
    }
}

