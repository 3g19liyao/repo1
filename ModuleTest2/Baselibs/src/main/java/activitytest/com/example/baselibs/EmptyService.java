package activitytest.com.example.baselibs;

public class EmptyService implements LoginService{
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
