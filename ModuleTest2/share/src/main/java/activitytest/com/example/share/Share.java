package activitytest.com.example.share;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

import activitytest.com.example.baselibs.ServiceFactory;

@Route(path = "/share/share1")
public class Share extends AppCompatActivity {

    Button share ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);

        share = (Button)findViewById(R.id.share_text);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ServiceFactory.getInstance().getLoginService().isLogin()){
                    Toast.makeText(Share.this,"分享成功！",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Share.this,"分享失败，请先登录！",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}