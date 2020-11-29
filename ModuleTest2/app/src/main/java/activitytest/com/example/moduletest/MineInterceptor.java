package activitytest.com.example.moduletest;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

import activitytest.com.example.baselibs.ServiceFactory;
import activitytest.com.example.login.Login;

@Interceptor(priority = 8, name = "登录状态拦截器")
public class MineInterceptor implements IInterceptor {

    Context context;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        if(postcard.getPath().equals("/mine/mine1")){
            if(ServiceFactory.getInstance().getLoginService().isLogin()){
                //Log.d("666666666666","66666666666");
                callback.onContinue(postcard);
            }else{
                callback.onInterrupt(new RuntimeException("请先登录！"));
            }
        }else{
            callback.onContinue(postcard);
        }
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
