package com.lxk.MyTomcat.mytomcatV3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract class MyServlet {
    public abstract void init();
    public abstract void service(InputStream is, OutputStream os) throws IOException;
    public abstract void doGet(MyRequest myrequest);
    public abstract void destory();
}