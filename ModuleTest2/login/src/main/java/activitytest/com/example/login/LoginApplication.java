package activitytest.com.example.login;

import android.app.Application;

import activitytest.com.example.baselibs.BaseApplication;
import activitytest.com.example.baselibs.ServiceFactory;

public class LoginApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        init(this);
        initover(this);
    }


    @Override
    public void init(Application application) {
        ServiceFactory.getInstance().setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));
    }

    @Override
    public void initover(Application application) {

    }
}
