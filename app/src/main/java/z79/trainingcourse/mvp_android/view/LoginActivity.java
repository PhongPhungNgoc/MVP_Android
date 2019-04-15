package z79.trainingcourse.mvp_android.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import z79.trainingcourse.mvp_android.R;
import z79.trainingcourse.mvp_android.model.User;
import z79.trainingcourse.mvp_android.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity implements ViewControl {

    private EditText mEdtUsername;

    private EditText mEdtPassword;

    private Button mBtnOk;

    private LoginPresenterImpl mLoginPresenterImp;

    private View.OnClickListener mBtnOkClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String username = mEdtUsername.getText().toString().trim();
            String password = mEdtPassword.getText().toString().trim();

            User user = new User(username, password);

            mLoginPresenterImp.checkLogin(user);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLoginPresenterImp = new LoginPresenterImpl();
        mLoginPresenterImp.setViewControl(this);

        initView();
    }

    private void initView() {
        mEdtUsername = this.findViewById(R.id.edt_username);
        mEdtPassword = this.findViewById(R.id.edt_password);
        mBtnOk = this.findViewById(R.id.btn_ok);
        mBtnOk.setOnClickListener(mBtnOkClick);
    }


    @Override
    public void loginSuccess(String username) {
        Toast.makeText(this, "Success " + username, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
    }
}
