package com.lxk.MyTomcat.mytomcatV3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class Servlet {
    public abstract void init();
    public abstract void service(InputStream is, OutputStream os) throws IOException;
    public abstract doGet(MyReqest myrequest);
    public abstract void destory();
}
