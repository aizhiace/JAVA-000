package io.kimmking.rpcfx.api;

public class RpcfxRequest<T> {

    private String serviceClass;

    private Class<T> serviceKlass;

    private String method;

    private Object[] params;

    public String getServiceClass() {
        return serviceClass;
    }

    public void setServiceClass(String serviceClass) {
        this.serviceClass = serviceClass;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class<T> getServiceKlass() {
        return serviceKlass;
    }

    public void setServiceKlass(Class<T> serviceKlass) {
        this.serviceKlass = serviceKlass;
    }
}
