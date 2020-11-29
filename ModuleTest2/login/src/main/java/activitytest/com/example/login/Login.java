package activitytest.com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import org.greenrobot.eventbus.EventBus;

import activitytest.com.example.baselibs.ServiceFactory;
import eventbus.EventMessage;

@Route(path = "/login/login1")
public class Login extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = (Button)findViewById(R.id.login_text);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUtil.isLogin = true;
                LoginUtil.password = "admin";
                ServiceFactory.getInstance().setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));

                EventBus.getDefault().postSticky(new EventMessage(LoginUtil.password));           //发送EventBus
            }
        });
    }
}