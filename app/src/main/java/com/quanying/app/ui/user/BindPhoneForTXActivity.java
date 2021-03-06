package com.quanying.app.ui.user;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.quanying.app.R;
import com.quanying.app.app.MyApplication;
import com.quanying.app.event.MessageEvent;
import com.quanying.app.ui.base.BaseActivity;
import com.quanying.app.ui.fragment.HomeActivity;
import com.quanying.app.utils.AppSharePreferenceMgr;
import com.quanying.app.utils.AppUtils;
import com.quanying.app.utils.ButtonUtils;
import com.quanying.app.weburl.WebUri;
import com.wuhenzhizao.titlebar.widget.CommonTitleBar;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;

public class BindPhoneForTXActivity extends BaseActivity {


    @BindView(R.id.titlebar)
    CommonTitleBar titlebar;

    @BindView(R.id.finish_btn)
    LinearLayout finish_btn;
    @BindView(R.id.getcode_btn)
    LinearLayout getcode_btn;
    @BindView(R.id.forget_tel)
    EditText forget_tel;
    @BindView(R.id.forget_code)
    EditText forget_code;
    @BindView(R.id.forget_password_getcodetext)
    TextView forget_password_getcodetext;
    private String openid;
    private String unionid;
    private String c_id;




    @Override
    protected int getLayoutResId() {
        return R.layout.activity_bind_phone_for_tx;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

        Bundle b = getIntent().getExtras();
        if(b!=null){
            openid = b.getString("openid");
            unionid = b.getString("unionid");
        }


        titlebar.setListener(new CommonTitleBar.OnTitleBarListener() {
            @Override
            public void onClicked(View v, int action, String extra) {
                if (action == CommonTitleBar.ACTION_LEFT_TEXT) {
                    finish();
                }
            }
        });
    }

    @OnClick(R.id.getcode_btn)
    public void doGetCode(){

        if (!ButtonUtils.isFastDoubleClick(R.id.getcode_btn)) {
            final String phoneNub = getEdit(forget_tel);
            if(phoneNub.length()>5){
                AppUtils.startCountdown(forget_password_getcodetext,getcode_btn);
                OkHttpUtils
                        .post()
                        .url(WebUri.SENDCODEFORTX)
                        .addParams("token", MyApplication.getToken())
                        .addParams("mobile", phoneNub)
                        .build()
                        .execute(new StringCallback(){
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {

                                Log.e("bindphone",response);

                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = new JSONObject(response);
                                    String errCode = jsonObject.getString("errcode");
                                    if(errCode.equals("200")){

                                        showBaseDialog(jsonObject.getString("errmsg"),"好");

                                        c_id = jsonObject.getString("codeid");


                                    }else{
                                        AppUtils.stopTimer();
                                        showBaseDialog(jsonObject.getString("errmsg"),"好");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }
                        });

            }else{
                showBaseDialog("请填写正确的手机号码!","好");
            }
        }
    }


    @OnClick(R.id.finish_btn)
    public void submitMsg(){
//        BINDPHONEMSG
        if (!ButtonUtils.isFastDoubleClick(R.id.finish_btn)) {

            final String phoneNub = getEdit(forget_tel);
            final String code = getEdit(forget_code);


            if(TextUtils.isEmpty(phoneNub)){

                showBaseDialog("绑定手机号码不能为空", "好");
                return;
            }

            if(TextUtils.isEmpty(code)){

                showBaseDialog("验证码不能为空", "好");
                return;
            }

            if(phoneNub.length()>5) {

                OkHttpUtils
                        .post()
                        .url(WebUri.BINDTXPHONE)
                        .addParams("mobile", phoneNub)
                        .addParams("codeid", c_id)
                        .addParams("code", code)
                        .addParams("openid", openid)
                        .addParams("unionid", unionid)
                        .build()
                        .execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {

                            }

                            @Override
                            public void onResponse(String response, int id) {

                                Log.e("bindphone", response);

                                JSONObject jsonObject = null;
                                try {
                                    jsonObject = new JSONObject(response);
                                    String errCode = jsonObject.getString("errcode");
                                    if (errCode.equals("200")) {
//                                        showBaseDialog("绑定成功", "好");
//                                        doLogin(phoneNub,password);
                                        String token = jsonObject.getString("access_token");
                                        AppSharePreferenceMgr.put(context,"token",token);

                                        setIntentClass(HomeActivity.class);
                                        EventBus.getDefault().post(new MessageEvent("","5"));
                                        finish();

                                    } else {
                                        AppUtils.stopTimer();
                                        showBaseDialog(jsonObject.getString("errmsg"), "好");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        });
            }else{

                showBaseDialog("手机号不能为空、请输入手机号", "好");
                return;

            }
        }

    }

}
