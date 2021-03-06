package timi.inpassing_android.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import timi.inpassing_android.config.Deployment;

public class WXPayEntryActivity extends Activity implements IWXAPIEventHandler {

	String APP_ID = Deployment.WEIXIN_APPID;

	private IWXAPI api;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.pay_result);

		api = WXAPIFactory.createWXAPI(this, APP_ID);
		api.handleIntent(getIntent(), this);
	}   

	@Override
	protected void onDestroy(){
		super.onDestroy();
		//Log.d("MT", "WXPayEntryActivity - onDestroy");
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
		api.handleIntent(intent, this);
	}

	@Override
	public void onReq(BaseReq req) {
		this.finish();
	}


	@Override
	public void onResp(BaseResp resp) {
//		WXPay.processResponse(resp);
		this.finish();
	}
}