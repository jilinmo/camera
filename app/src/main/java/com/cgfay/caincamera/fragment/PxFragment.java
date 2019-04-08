package com.cgfay.caincamera.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.cgfay.caincamera.PxControl;
import com.cgfay.caincamera.R;
import com.cgfay.caincamera.model.PxModel;
import com.cgfay.utilslibrary.utils.DensityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PxFragment extends BasePxFragment {

    @BindView(R.id.px)
    RelativeLayout px;
    public static PxFragment newInstance(PxModel pxModel) {
        PxFragment fragment = new PxFragment();
        setPxModel(pxModel);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        PxModel model = getPxModel();
        View view = inflater.inflate(R.layout.fragment_px1, container, false);

        //绑定 ButterKnife
        ButterKnife.bind(this, view);
        switch (model.getType()){
            case 1:{
            }
            break;
            case 2:{
            }
            break;
            case 3:{
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) px.getLayoutParams();
                layoutParams.width = DensityUtils.dp2px(getContext(), px.getWidth());
                layoutParams.height = DensityUtils.dp2px(getContext(), px.getHeight());
                px.setLayoutParams(layoutParams);
            }
            break;
            case 4:{
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) px.getLayoutParams();
                layoutParams.height = DensityUtils.dp2px(getContext(), px.getHeight());
                layoutParams.leftMargin = DensityUtils.dp2px(getContext(), px.getX());
                layoutParams.rightMargin = DensityUtils.dp2px(getContext(), px.getX());
                layoutParams.topMargin = DensityUtils.dp2px(getContext(), px.getY());
                px.setLayoutParams(layoutParams);
            }
            break;
            default:
                view = inflater.inflate(R.layout.fragment_px1, container, false);
        }
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity()instanceof PxControl){
                    ((PxControl)getActivity()).closePx(PxFragment.this);
                }
            }
        });
        String url = this.getPxModel().getUrl();
        webViewPx.setWebViewClient(new WebViewClient());
        webViewPx.loadUrl(url);
        return view;
    }
}
