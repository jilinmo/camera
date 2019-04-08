package com.cgfay.caincamera;

import android.support.v4.app.Fragment;
import android.view.View;

public interface PxControl {
    void  initPx();
    boolean preOnClick(View v);
    void  closePx(Fragment ft);
    boolean preOnBackPressed();
}
