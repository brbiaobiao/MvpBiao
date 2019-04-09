package com.biaobiao.prijectLibrary.net;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;

import io.reactivex.annotations.Nullable;
import retrofit2.HttpException;

/**
 * @author: biao
 * @create: 2019/4/8
 * @Describe: 异常处理类
 */
public class ExceptionHandler {
    //    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;

    public static ExceptionHandler instance;

    public static void init(ExceptionHandler handler) {
        instance = handler;
    }

    public static ExceptionHandler getHandler() {
        return instance;
    }

    public static void showToast(RespondThrowable throwable) {
        getHandler().showT(throwable);
    }

    /**
     * 调用处理
     *
     * @param e
     * @return
     */
    public static @Nullable
    RespondThrowable handle(Throwable e) {
        return getHandler().handleException(e);
    }

    protected void showT(RespondThrowable e) {
    }


    protected @Nullable
    RespondThrowable handleException(Throwable e) {

        RespondThrowable ex;
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new RespondThrowable(e, ERROR.HTTP_ERROR,null);
            switch (httpException.code()) {
//                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.message = "网络错误";
                    break;
            }
            return ex;

        } else if (e instanceof java.net.UnknownHostException){
            ex = new RespondThrowable(e, ERROR.HTTP_ERROR,"网络异常");
            return ex;
        }else if (e instanceof ServerException) {
            ServerException resultException = (ServerException) e;
            ex = new RespondThrowable(resultException, resultException.code,resultException.message);
            return ex;

        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof RespondThrowable) {
            ex = new RespondThrowable(e, ERROR.PARSE_ERROR,"解析错误");
            return ex;

        } else if (e instanceof ConnectException) {
            ex = new RespondThrowable(e, ERROR.NETWORD_ERROR,"连接失败");
            return ex;

        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            ex = new RespondThrowable(e, ERROR.SSL_ERROR,"证书验证失败");
            return ex;

        } else if (e instanceof LoginException) {
            ex = new RespondThrowable(e, ERROR.LOGIN_ERROR,"登录异常");
            return ex;

        } else if (e instanceof TimeOutException) {
            ex = new RespondThrowable(e, ERROR.TIME_OUT,"超时");
            return ex;

        } else if (e instanceof IllegalStateException) {
            ex = new RespondThrowable(e, 0,"解析异常");
            return ex;

        } else {
            ex = new RespondThrowable(e, ERROR.UNKNOWN,"未知异常");
            return ex;
        }
    }

    /**
     * 约定异常
     */
    public static class ERROR {
        /**
         * 没有权限
         */
        public static final int NO_AUTH = 403;
        /**
         * 登录异常
         */
        public static final int LOGIN_ERROR = 401;
        /**
         * 未知错误
         */
        public static final int UNKNOWN = 1000;
        /**
         * 解析错误
         */
        public static final int PARSE_ERROR = 1001;
        /**
         * 网络错误
         */
        public static final int NETWORD_ERROR = 1002;
        /**
         * 协议出错
         */
        public static final int HTTP_ERROR = 1003;

        /**
         * 证书出错
         */
        public static final int SSL_ERROR = 1005;
        /**
         * 超时
         */
        public static final int TIME_OUT = 999998;
        /**
         * 请求参数异常
         */
        public static final int QUEST_ERROR=4268;
        /**
         * 消声
         */
        public static final int NOISE_ELIMINATION=80086;

    }

    public static class RespondThrowable extends Exception {
        public int code;
        public String message;

        public RespondThrowable(Throwable throwable, int code,String msg) {
            super(throwable);
            this.code = code;
            message = msg;
        }

        public void show() {
            showToast(this);
        }
    }

    public class ServerException extends RuntimeException {
        public int code;
        public String message;
    }

    /**
     * 登录异常
     */
    public class LoginException extends Exception {

    }

    /**
     * 超时异常
     */
    public class TimeOutException extends Exception {

    }


    public static class APIErrorException extends IOException {
        public int code;

        public APIErrorException(String message, int code) {
            super(message);
            this.code = code;
        }
    }
}
