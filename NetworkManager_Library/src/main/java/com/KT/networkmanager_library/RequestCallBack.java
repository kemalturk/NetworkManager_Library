package com.KT.networkmanager_library;

import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * Created by KT on 2.11.2016.
 */

public interface RequestCallBack {

    void onComplete(JSONObject response);
    void onError(VolleyError error);

}
