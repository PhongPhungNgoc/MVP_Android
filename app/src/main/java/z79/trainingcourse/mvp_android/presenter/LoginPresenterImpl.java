package z79.trainingcourse.mvp_android.presenter;

import android.util.Log;

import z79.trainingcourse.mvp_android.model.User;
import z79.trainingcourse.mvp_android.view.ViewControl;

public class LoginPresenterImpl implements LoginPresenter{

    private ViewControl mViewControl;

    public LoginPresenterImpl() {
    }

    public void setViewControl(ViewControl viewControl) {
        mViewControl = viewControl;
    }

    @Override
    public void checkLogin(User user) {
        if(user.getUsername().equals("phong") && user.getPassword().equals("phung")){
            mViewControl.loginSuccess(user.getUsername());
        }else {
            mViewControl.loginFail();
        }
    }
}
