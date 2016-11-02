/*
    NetworkManager kütüphanesi

    Burada yazılan tüm kodlar içerisinde bulunduğu MQR Projesi
    için özel olarak tasarlanmıştır ve MQR Projesinin Android işletim
    sistemi kullanan cihazlarında MQR uygulamasının çalışmasını
    sağlayacak şekilde tasarlanıp kodlanmıştır.

    Kütüphanenin genel amacı sunucudaki apiye istekte bulunmak ve dönen değeri
    kullanılmak istenen sınıflara iletmektir.

    Copyright (C) 2016 Kemal Türk

    Bu kütüphane özgür yazılımdır:
    Özgür Yazılım Vakfı tarafından yayımlanan GNU Kütüphane Genel Kamu Lisansı’nın sürüm 3 ya da (
    isteğinize bağlı olarak) daha sonraki sürümlerinin hükümleri altında yeniden dağıtabilir ve/veya değiştirebilirsiniz.

    Bu kütüphane, yararlı olması umuduyla yazılmış olup, programın BİR TEMİNATI YOKTUR;
    TİCARETİNİN YAPILABİLİRLİĞİNE VE ÖZEL BİR AMAÇ İÇİN UYGUNLUĞUNA dair bir teminat da vermez.
    Ayrıntılar için GNU Kütüphane Genel Kamu Lisansı’na göz atınız.

    Bu kütüphaneyle birlikte GNU Kütüphane Genel Kamu Lisansı’nın bir kopyasını elde etmiş olmanız gerekir;
    eğer elinize ulaşmadıysa

    Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor,
    Boston, MA 02110-1301, ABD adresine yazın.

 */

package com.KT.networkmanager_library;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by KT on 2.11.2016.
 */

public class RequestManager {

    private Context context;

    public RequestManager(Context context) {
        this.context = context;
    }

    public void makeRequest(String url, final RequestCallBack requestCallBack){

        RequestQueue requestQueue = Volley.newRequestQueue(context);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                requestCallBack.onComplete(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                requestCallBack.onError(error);

            }
        });

        requestQueue.add(request);

    }

}
