package com.cgfay.cameralibrary.activity;

import android.support.v4.app.Fragment;
import android.widget.Button;


import com.cgfay.cameralibrary.R;



public class BasePxFragment extends Fragment /*implements View.OnClickListener,PxControl*/ {

//    @BindView(R.id.btn_close1)
    Button btnClose;

//    private PxsModel pxs;
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        /*=====start====*/
//        initPx();
//        /*======end=====*/
//    }
//
//    @Override
//    public void onClick(View v) {
//        /*=====start====*/
//        if (preOnClick(v) == true) {
//            return;
//        }
//        initPx();
//        /*======end=====*/
//
//
//        switch (v.getId()) {
//            case R.id.btn_camera: {
//                closePx(this);
//                break;
//            }
//
//
//        }
//    }
//
//    /*=====start====*/
//    @Override
//    public void initPx() {
//        pxs = PxApplication.getInstance().getPxs();
//    }
//
//    //弹出px
//    @Override
//    public boolean preOnClick(View v)
//    {
//        if(pxs.getGenable()==0) {
//            return false;
//        }
//
//        switch (v.getId()) {
//            case R.id.btn_camera: {
//
//                for (PxModel model:pxs.getPxs()) {
//                    if (model.getEnable() == 0 || !model.getTargetId().equals("1002")) {
//                        continue;
//                    }
//                    if (model.getStart() == 0) {
//                        PxApplication app = PxApplication.getInstance();
//                        app.showFragment((AppCompatActivity)getActivity(), model);
//                        return true;
//                    }
//                }
//                break;
//            }
//
//
//        }
//        return false;
//
//    }
//
//    @Override
//    public void closePx(Fragment fragment) {
//        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//        ft.remove(fragment);
//        ft.commit();
//    }
//    /*======end=====*/
}
