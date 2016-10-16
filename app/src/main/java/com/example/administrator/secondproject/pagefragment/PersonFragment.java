package com.example.administrator.secondproject.pagefragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.secondproject.Main2Activity;
import com.example.administrator.secondproject.Main5ActivityForgetworld;
import com.example.administrator.secondproject.Main6Activitycollect;
import com.example.administrator.secondproject.MainActivity;
import com.example.administrator.secondproject.R;
import com.example.administrator.secondproject.login.MySharePrefarse;
import com.squareup.picasso.Picasso;
import com.tencent.connect.UserInfo;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/9/26.
 */
public class PersonFragment extends Fragment implements View.OnClickListener {
    EditText username, usepass;
    Tencent tencent;
    IUiListener iUiListener;
    TextView usernichene, M_xinshourenwu, M_shuruyaoqiangma, M_weixinbangding, M_renwuxitong, M_shourumingxi, M_shourupaihang,
            M_jingpinyouxi, M_tixian, M_ruhezhuanqian, M_quxuetang, M_lishijilu, M_wodeshoucang, M_shezhi;
    ImageView userImageview, otherload;
    private int action = TECENT_LOGIN;
    Button userLoad, userforget, userinfo;
    MySharePrefarse preparse;
    private static final int TECENT_LOGIN = 444;
    private static final int TECENT_USERINFO = 709;
    private static final int TECENT_SHARE_QQ = 533;
    private static final String regProtocol = "http://h5ssl.1sapp.com/qukan/protocol.html";
    private static final String invite = "http://h5ssl.1sapp.com/qukan/yq3.html?r=24";
    private static final String mission = "http://h5ssl.1sapp.com/qukan/qd.html?r=43";
    private static final String registerInviteCode = "http://h5ssl.1sapp.com/qukan/yqcode.html";
    private static final String mall = "http://h5ssl.1sapp.com/qukan/mall.html?r=4";
    private static final String about = "http://h5ssl.1sapp.com/qukan/about.html?r=4";
    private static final String howToRich = "http://h5ssl.1sapp.com/qukan/how_2.html";
    private static final String help = "http://h5ssl.1sapp.com/qukan/help.html";
    private static final String feedback = "http://h5ssl.1sapp.com/qukan/feedback.html?r=3";
    private static final String message = "http://h5ssl.1sapp.com/qukan/message.html?clientPage=message&r=13";
    private static final String report = "http://h5ssl.1sapp.com/qukan/ts.html?r=1";
    private static final  String shuruqingqiuma="https://h5ssl.1sapp.com/qukan/yqcode.html";
    private static final  String xinshourenwu="https://h5ssl.1sapp.com/qukan/qd.html?scroll=guide&r=43";
    View view1;
    View view2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_pager, null);
        view2 = view.findViewById(R.id.user_linerlayout2Id);
        view1 = view.findViewById(R.id.user_Linerlaout1Id);
        username = (EditText) view.findViewById(R.id.user_nameText);
        usepass = (EditText) view.findViewById(R.id.user_passwardText);
        userLoad = (Button) view.findViewById(R.id.user_loadId);
        userforget = (Button) view.findViewById(R.id.user_forgetpassworld);
        otherload = (ImageView) view.findViewById(R.id.user_otherloadId);
        usernichene = (TextView) view.findViewById(R.id.user_nichengId);
        userinfo = (Button) view.findViewById(R.id.user_InitInfo);
        userImageview = (ImageView) view.findViewById(R.id.user_image);
        M_xinshourenwu = (TextView) view.findViewById(R.id.user_newPersonId);
        M_wodeshoucang = (TextView) view.findViewById(R.id.user_WodeShoucahngId);
        M_weixinbangding = (TextView) view.findViewById(R.id.user_BadingWeixinId);
        M_tixian = (TextView) view.findViewById(R.id.user_DuihuantixianaId);
        M_shuruyaoqiangma = (TextView) view.findViewById(R.id.user_newYaoQIngMaId);
        M_jingpinyouxi = (TextView) view.findViewById(R.id.user_jingpingyouxiId);
        M_renwuxitong = (TextView) view.findViewById(R.id.user_RenwuxitongId);
        M_lishijilu = (TextView) view.findViewById(R.id.user_LishijiluId);
        M_quxuetang = (TextView) view.findViewById(R.id.user_QuxuetangId);
        M_ruhezhuanqian = (TextView) view.findViewById(R.id.user_RuhrtixianId);
        M_shezhi = (TextView) view.findViewById(R.id.user_ShezhiId);
        M_shourumingxi = (TextView) view.findViewById(R.id.user_ShouroumingxiId);
        M_shourupaihang = (TextView) view.findViewById(R.id.user_ShouruPaihangId);
        M_shezhi.setOnClickListener(this);
        M_shourumingxi.setOnClickListener(this);
        M_quxuetang.setOnClickListener(this);
        M_renwuxitong.setOnClickListener(this);
        M_jingpinyouxi.setOnClickListener(this);
        M_ruhezhuanqian.setOnClickListener(this);
        M_shourupaihang.setOnClickListener(this);
        M_shuruyaoqiangma.setOnClickListener(this);
        M_tixian.setOnClickListener(this);
        M_weixinbangding.setOnClickListener(this);
        M_wodeshoucang.setOnClickListener(this);
        M_xinshourenwu.setOnClickListener(this);
        M_lishijilu.setOnClickListener(this);


        tencent = Tencent.createInstance("1105726356", getContext());
        userforget.setOnClickListener(this);
        userLoad.setOnClickListener(this);
        userinfo.setOnClickListener(this);
        otherload.setOnClickListener(this);
        preparse = new MySharePrefarse(getContext());
        return view;
    }

    @Override
    public void onClick(View v) {
        String name = username.getText().toString();
        String pass = usepass.getText().toString();
        switch (v.getId()) {
            case R.id.user_InitInfo:
                preparse.getUserInfo(name, pass, view1);
                break;
            case R.id.user_loadId:
                preparse.checkuser(name, pass, view1);
                break;
            case R.id.user_forgetpassworld:
                Intent intent = new Intent(getContext(), Main5ActivityForgetworld.class);
                startActivity(intent);
                break;
            case R.id.user_BadingWeixinId:
               Toast.makeText(getContext(),"无法获取绑定权限",Toast.LENGTH_LONG).show();
                break;
            case R.id.user_DuihuantixianaId:
                Intent intent3 = new Intent(getContext(), Main2Activity.class);
                intent3.putExtra("ma",mall);
                startActivity(intent3);
                break;
            case R.id.user_RuhrtixianId:
                Intent intent4 = new Intent(getContext(), Main2Activity.class);
                intent4.putExtra("ma", howToRich);
                startActivity(intent4);
                break;
            case R.id.user_ShouroumingxiId:
                Intent intent5 = new Intent(getContext(), Main2Activity.class);
                intent5.putExtra("ma", report);
                startActivity(intent5);
                break;
            case R.id.user_WodeShoucahngId:
                Intent intentcollect=new Intent(getActivity(), Main6Activitycollect.class);
                startActivity(intentcollect);
                break;
            case R.id.user_LishijiluId:
                Intent intent6 = new Intent(getContext(), Main2Activity.class);
                intent6.putExtra("ma", about);
                startActivity(intent6);
                break;
            case R.id.user_ShouruPaihangId:
                Intent intent7 = new Intent(getContext(), Main2Activity.class);
                intent7.putExtra("ma", registerInviteCode);
                startActivity(intent7);
                break;
            case R.id.user_jingpingyouxiId:
                Intent intent8 = new Intent(getContext(), Main2Activity.class);
                intent8.putExtra("ma", help);
                startActivity(intent8);
                break;
            case R.id.user_RenwuxitongId:
                Intent intent9 = new Intent(getContext(), Main2Activity.class);
                intent9.putExtra("ma", xinshourenwu);
                startActivity(intent9);
                break;
            case R.id.user_QuxuetangId:
                Intent intent10 = new Intent(getContext(), Main2Activity.class);
                intent10.putExtra("ma", message);
                startActivity(intent10);

                break;
            case R.id.user_ShezhiId:

                break;
            case R.id.user_newYaoQIngMaId:
                Intent intent11 = new Intent(getContext(), Main2Activity.class);
                intent11.putExtra("ma", invite);
                startActivity(intent11);
                break;
            case R.id.user_otherloadId:
                if (tencent.isSessionValid()) {
                    Toast.makeText(getContext(), "您已登录", Toast.LENGTH_SHORT).show();
                    return;
                }

                //QQ登录
                iUiListener = new IUiListener() {
                    @Override
                    public void onComplete(Object o) {
                        JSONObject object = (JSONObject) o;
                        switch (action) {
                            case TECENT_LOGIN:
                                try {
                                    String openid = object.getString("openid");
                                    String access_token = object.getString("access_token");
                                    String expires_in = object.getString("expires_in"); //token的有效时间
                                    tencent.setOpenId(openid);
                                    tencent.setAccessToken(access_token, expires_in);
                                    final UserInfo userInfo = new UserInfo(getContext(), tencent.getQQToken());
                                    action = TECENT_USERINFO;
                                    userInfo.getUserInfo(iUiListener);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Intent intent = new Intent(getContext(), MainActivity.class);
                                startActivity(intent);
                                break;
                            case TECENT_USERINFO:

                                try {
                                    String nickname = object.getString("nickname");
                                    String qqicon = object.getString("figureurl_qq_2");
                                    usernichene.setText(nickname);
                                    Picasso.with(getContext()).load(qqicon).into(userImageview);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case TECENT_SHARE_QQ:

                                break;
                        }
                    }

                    @Override
                    public void onError(UiError uiError) {

                    }

                    @Override
                    public void onCancel() {

                    }
                };
                tencent.login(this, "all", iUiListener);

                break;

        }
    }
}
